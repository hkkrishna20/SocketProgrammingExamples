package name.abhijitsarkar.lucene.mavenrepo;

import java.io.IOException;

import name.abhijitsarkar.lucene.util.SearchOptionsParser;
import name.abhijitsarkar.lucene.util.SearchUtil;

import org.apache.commons.cli.ParseException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.AtomicReaderContext;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queries.CustomScoreProvider;
import org.apache.lucene.queries.CustomScoreQuery;
import org.apache.lucene.queryparser.flexible.core.QueryNodeException;
import org.apache.lucene.queryparser.flexible.standard.StandardQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;

/**
 * This class, as the name suggests, searches the Lucene index. It uses utility
 * classes from the lucene common project. It also uses a CustomScoreQuery to
 * boost results at query time.
 * 
 */
public class SearcherUsingBoost {
    public static final void main(String[] args) throws ParseException,
            IOException, org.apache.lucene.queryparser.classic.ParseException,
            QueryNodeException {
        new SearcherUsingBoost().search(args);
    }

    private void search(String[] args) throws ParseException, IOException,
            org.apache.lucene.queryparser.classic.ParseException,
            QueryNodeException {
        final SearchOptionsParser parser = new SearchOptionsParser(args);
        final String indexDir = parser.getIndexDir();
        /* The default search field is 'content' */
        final String field = (parser.getField() != null ? parser.getField()
                : "content");
        final String queryStr = parser.getQueryStr();

        final IndexReader reader = SearchUtil.getFSIndexReader(indexDir);
        final IndexSearcher searcher = new IndexSearcher(reader);

        /* Using the new, recommended parser */
        StandardQueryParser qpHelper = new StandardQueryParser(
                new StandardAnalyzer(Version.LUCENE_40));
        // config.setAllowLeadingWildcard(true);
        Query query = qpHelper.parse(queryStr, field);

        Query customQuery = new CustomScoreQuery(query) {
            @Override
            protected CustomScoreProvider getCustomScoreProvider(
                    AtomicReaderContext context) throws IOException {
                return new PathBooster(context, "path", queryStr);
            }
        };

        SearchUtil.searchDocs(searcher, null, customQuery, 10);
        reader.close();
    }
}

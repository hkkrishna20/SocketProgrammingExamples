package name.javacode.java.java8impatient.webutil;

import static java.util.stream.Collectors.toList;
import static name.javacode.java.java8impatient.webutil.SimpleHttpServer.PORT;
import static name.javacode.java.java8impatient.webutil.SimpleHttpServer.newInstance;
import static name.javacode.java.java8impatient.webutil.URLContentReader.getContent;
import static name.javacode.java.java8impatient.webutil.URLContentReader.openConnection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class URLContentReaderTest {
    private static final String BASE_URL = "http://localhost:" + PORT;
    private static final HttpServer SERVER = newInstance();

    @BeforeClass
    public static void startServer() {
	SERVER.start();

	System.out.println("Server started on port: " + PORT);
    }

    @AfterClass
    public static void stopServer() {
	SERVER.stop(0);

	System.out.println("Server stopped.");
    }

    @Test
    public void testGetUnprotectedContent() throws MalformedURLException {
	URLConnection conn = openConnection(new URL(BASE_URL + "/info"), false);

	List<String> lines = getContent(conn).collect(toList());

	assertNotNull(lines);
	assertEquals(1, lines.size());
	assertEquals("Use /get to authenticate", lines.get(0));
    }

    @Test(expected = UncheckedIOException.class)
    public void testGetProtectedContentWithoutAuth()
	    throws MalformedURLException {
	URLConnection conn = openConnection(new URL(BASE_URL + "/get"), false);

	getContent(conn);
    }

    @Test
    public void testGetProtectedContent() throws MalformedURLException {
	URLConnection conn = openConnection(new URL(BASE_URL + "/get"), true);

	List<String> lines = getContent(conn).collect(toList());

	assertNotNull(lines);
	assertEquals(1, lines.size());
	assertEquals("Hello ch8", lines.get(0));
    }
}

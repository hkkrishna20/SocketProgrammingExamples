package name.javacode.moviemanager.delegate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.Logger;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import name.javacode.moviemanager.domain.GenreSummary;
import name.javacode.moviemanager.domain.Movie;
import name.javacode.moviemanager.domain.Summary;
import name.javacode.moviemanager.service.MovieService;
import name.javacode.moviemanager.service.impl.MovieComparator;
import name.javacode.moviemanager.service.impl.MovieServiceImpl;
import name.javacode.moviemanager.util.logging.MovieManagerLogger;

public class MovieManager {

	private MovieService movieService;
	private static String inputDirPath;
	private static File outputFile;
	final static NumberFormat formatter = NumberFormat.getInstance();
	static Logger logger = MovieManagerLogger.getInstance(MovieManager.class);
	public static final String EMPTY = "";

	public MovieManager() {
		this.movieService = new MovieServiceImpl();
	}

	public MovieManager(File inputDir, File outputFile) throws FileNotFoundException {
		if (outputFile != null) {
			validateFile(inputDir, outputFile);
		} else {
			validateFile(inputDir);
		}

		this.movieService = new MovieServiceImpl();
		if (inputDir != null) {
			MovieManager.inputDirPath = inputDir.getAbsolutePath();
		}

		MovieManager.outputFile = outputFile;

		if (MovieManager.outputFile != null && MovieManager.outputFile.exists()) {
			MovieManager.outputFile.delete();
		}
	}

	public static void validateFile(File... files) throws FileNotFoundException {
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Microsoft Excel", "xls", "xlsx");

		for (File file : files) {
			if (file == null) {
				logger.error("File not found.");
				throw new FileNotFoundException("File not found.");
			} else if (!file.isDirectory() && !extensionFilter.accept(file)) {
				logger.error("File extension is not acceptable: " + file.getAbsolutePath());
				throw new IllegalArgumentException("File extension is not acceptable.");
			} else if (file.isDirectory() && (!file.canRead() || !file.canExecute())) {
				logger.error("Directory not found or is not readable: " + file.getAbsolutePath());
				throw new IllegalArgumentException("Directory not found or is not readable.");
			}
		}
	}

	public static GenreSummary getSummaryByGenre(String genre) throws Exception {
		GenreSummary genreSummary = null;

		MovieManager movieManager = new MovieManager();
		genreSummary = movieManager.movieService.getSummaryByGenre(movieManager.movieService
				.filterMovieSetByGenre(movieManager.movieService.getMovieSet(inputDirPath), genre), genre);
		logger.info("Genre summary: " + genreSummary);

		return genreSummary;
	}

	public static Summary getSummary() throws Exception {
		new MovieManager();

		Summary summary = getSummary(getMovieSetGroupedByGenre());
		List<GenreSummary> genreSummaryList = summary.getGenreSummary();

		logger.info("Movie count: " + summary.getMovieTitleCount());
		logger.info("Soap count: " + summary.getSoapTitleCount());

		for (GenreSummary genreSummary : genreSummaryList) {
			logger.info("Genre summary: " + genreSummary);
		}

		return summary;
	}

	public static Map<String, Set<Movie>> getMovieSetGroupedByGenre() throws Exception {
		MovieManager movieManager = new MovieManager();
		Set<Movie> movieSet = movieManager.movieService.getMovieSet(inputDirPath);

		return movieManager.movieService.groupMovieSetByGenre(movieSet);
	}

	public static void createSummarySheet(Summary summary) throws Exception {
		final String SUMMARY = "Summary";
		final String MOVIE_COUNT = "Movie Count";
		final String SOAP_COUNT = "Soap Count";
		final String SIZE = "Size";
		final String GENRE_SUMMARY = "Genre Summary";

		Workbook wb = createWorkbook(outputFile);

		List<GenreSummary> genreSummaryList = summary.getGenreSummary();
		Sheet summarySheet = null;
		Row row = null;
		CellStyle headerCellStyle = createHeaderCellStyle(wb.createCellStyle(), wb.createFont());
		CellStyle bodyCellStyle = createBodyCellStyle(wb.createCellStyle(), wb.createFont());

		summarySheet = createNewSheet(wb, SUMMARY);

		row = summarySheet.createRow(0);
		summarySheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		createCell(row, 0, headerCellStyle, SUMMARY, CellType.STRING);

		row = summarySheet.createRow(1);
		createCell(row, 0, headerCellStyle, MOVIE_COUNT, CellType.STRING);
		createCell(row, 1, headerCellStyle, SOAP_COUNT, CellType.STRING);
		createCell(row, 2, headerCellStyle, SIZE, CellType.STRING);

		row = summarySheet.createRow(2);
		createCell(row, 0, bodyCellStyle, summary.getMovieTitleCount(), CellType.NUMERIC);
		createCell(row, 1, bodyCellStyle, summary.getSoapTitleCount(), CellType.NUMERIC);
		createCell(row, 2, bodyCellStyle, formatter.format(summary.getSumOfSizeOfAllTitles()), CellType.NUMERIC);

		for (GenreSummary genreSummary : genreSummaryList) {
			row = summarySheet.createRow(summarySheet.getLastRowNum() + 2);

			summarySheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 2));
			createCell(row, 0, headerCellStyle, GENRE_SUMMARY + " (" + genreSummary.getGenre() + ")", CellType.STRING);

			row = summarySheet.createRow(summarySheet.getLastRowNum() + 1);
			createCell(row, 0, headerCellStyle, MOVIE_COUNT, CellType.STRING);
			createCell(row, 1, headerCellStyle, SOAP_COUNT, CellType.STRING);
			createCell(row, 2, headerCellStyle, SIZE, CellType.STRING);

			row = summarySheet.createRow(summarySheet.getLastRowNum() + 1);
			createCell(row, 0, bodyCellStyle, genreSummary.getMovieTitleCount(), CellType.NUMERIC);
			createCell(row, 1, bodyCellStyle, genreSummary.getSoapTitleCount(), CellType.NUMERIC);
			createCell(row, 2, bodyCellStyle, formatter.format(genreSummary.getSumOfSizeOfAllTitlesInThisGenre()),
					CellType.STRING);

			autoSizeColumns(summarySheet);
		}

		writeToDisk(wb);
	}

	public static void createGenreSheet(Set<Movie> filteredMovieSetByGenre, String genre) throws Exception {
		final String MOVIE_NAME = "Movie Name";
		final String RELEASE_YEAR = "Release Year";
		final String FILESIZE = "Filesize";
		final String PARENT = "Parent";

		Workbook wb = createWorkbook(outputFile);

		Sheet worksheet = null;
		Row row = null;
		CellStyle headerCellStyle = createHeaderCellStyle(wb.createCellStyle(), wb.createFont());
		CellStyle bodyCellStyle = createBodyCellStyle(wb.createCellStyle(), wb.createFont());

		Iterator<Movie> it = null;
		Movie movie = null;

		worksheet = createNewSheet(wb, genre.toString());

		List<Movie> movies = new ArrayList<Movie>();
		movies.addAll(filteredMovieSetByGenre);
		Collections.sort(movies, new MovieComparator<Movie>());

		it = movies.iterator();

		row = worksheet.createRow(0);
		createCell(row, 0, headerCellStyle, MOVIE_NAME, CellType.STRING);
		createCell(row, 1, headerCellStyle, RELEASE_YEAR, CellType.STRING);
		createCell(row, 2, headerCellStyle, FILESIZE, CellType.STRING);
		createCell(row, 3, headerCellStyle, PARENT, CellType.STRING);

		for (int i = 0; it.hasNext(); i++) {
			row = worksheet.createRow(i + 1);
			movie = it.next();

			createCell(row, 0, bodyCellStyle, movie.getName() + movie.getFileExtension(), CellType.STRING);
			createCell(row, 1, bodyCellStyle, movie.getYear(), CellType.NUMERIC);
			createCell(row, 2, bodyCellStyle, formatter.format(movie.getFilesize()), CellType.STRING);
			createCell(row, 3, bodyCellStyle, movie.getParent(), CellType.STRING);

			Cell cell = row.getCell(1);

			if (((short) cell.getNumericCellValue()) == Movie.UNKNOWN_RELEASE_YEAR) {
				cell.setCellValue(EMPTY);
			}
		}

		autoSizeColumns(worksheet);

		writeToDisk(wb);
	}

	private static void autoSizeColumns(Sheet name) {
		int lastRowNum = name.getLastRowNum();

		for (int rowNum = 0; rowNum <= lastRowNum; rowNum++) {
			name.autoSizeColumn(rowNum);
		}
	}

	private static void writeToDisk(Workbook wb) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(outputFile);

		wb.write(fileOut);

		fileOut.close();
	}

	private static Workbook createWorkbook(File opFile) throws Exception {
		Workbook wb = null;

		if (opFile.canRead()) {
			wb = WorkbookFactory.create(new FileInputStream(opFile));
		} else {
			wb = new XSSFWorkbook();
		}

		return wb;
	}

	private static Sheet createNewSheet(Workbook wb, String name) {
		int sheetIndex = wb.getSheetIndex(name);

		if (sheetIndex >= 0) {
			wb.removeSheetAt(sheetIndex);
		}

		return wb.createSheet(name);
	}

	private static CellStyle createHeaderCellStyle(CellStyle headerCellStyle, Font font) {
		/* border */
		headerCellStyle.setBorderLeft(BorderStyle.MEDIUM);
		headerCellStyle.setBorderTop(BorderStyle.MEDIUM);
		headerCellStyle.setBorderRight(BorderStyle.MEDIUM);
		headerCellStyle.setBorderBottom(BorderStyle.MEDIUM);

		/* pattern */
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		/* foreground color */
		headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());

		/* alignment */
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);

		/* font */
		font.setBold(true);
		headerCellStyle.setFont(font);

		/* wrap */
		headerCellStyle.setWrapText(true);

		return headerCellStyle;
	}

	private static CellStyle createBodyCellStyle(CellStyle bodyCellStyle, Font font) {
		/* border */
		bodyCellStyle.setBorderLeft(BorderStyle.DASHED);
		bodyCellStyle.setBorderTop(BorderStyle.DASHED);
		bodyCellStyle.setBorderRight(BorderStyle.DASHED);
		bodyCellStyle.setBorderBottom(BorderStyle.DASHED);

		/* alignment */
		bodyCellStyle.setAlignment(HorizontalAlignment.LEFT);
		bodyCellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);

		/* font */
		bodyCellStyle.setFont(font);

		/* wrap */
		bodyCellStyle.setWrapText(true);

		return bodyCellStyle;
	}

	private static void createCell(Row row, int column, CellStyle cellStyle, Object cellValue, CellType cellType) {
		Cell cell = row.createCell(column);
		cell.setCellStyle(cellStyle);

		switch (cellType) {
		case NUMERIC:
			if (cellValue != null) {
				cell.setCellValue(Long.parseLong(cellValue.toString()));
			}
			break;
		case STRING:
		default:
			if (cellValue != null) {
				cell.setCellValue(cellValue.toString());
			}
			break;
		}
	}

	public static Summary getSummary(Map<String, Set<Movie>> movieSetGroupedByGenre) {
		return new MovieManager().movieService.getSummary(movieSetGroupedByGenre);
	}
}

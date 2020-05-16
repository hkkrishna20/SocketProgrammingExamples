package com.compare.component;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.glassfish.jersey.client.ClientResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.xml.XmlException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * @author harikrishna.manupadi
 *
 */
/**
 * @author harikrishna.manupadi
 *
 */
@Component
public class ContentExtract {
	public static final String PREFIX = "stream2file";
	public static final String SUFFIX = ".tmp";
	public static String ExcelPath = "C:\\Users\\Public\\POC Files\\BaseDir\\Report\\";

	/**
	 * Description: This method will prepare CompareInfo object.
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws Exception
	 */
	public static List<ParaType> paraExtract(MultipartFile file) throws Exception {
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		if (extension.equalsIgnoreCase("docx")) {
			return paraExtractWordDocx(file);
		} else if (extension.equalsIgnoreCase("doc")) {
			return paraExtractWordDoc(file);
		} else if (extension.equalsIgnoreCase("pdf")) {
			return readPDF(file);
		} else if (extension.equalsIgnoreCase("pptx")) {
			return readPPTX(file);
		} else if (extension.equalsIgnoreCase("ppt")) {
			return readPPT(file);
		}
		return null;

	}

	/*
	 * public static List<ParaType> paraExtractWordDocx(MultipartFile file) throws
	 * IOException, InvalidFormatException { List<ParaType> paraTypeList = new
	 * ArrayList<ParaType>(); FileInfoType fileInfo = new FileInfoType(); String
	 * filenameWoExt = file.getOriginalFilename(); String[] fileName =
	 * StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")),
	 * "_"); fileInfo.setFormId(fileName[0]); fileInfo.setFormTitle(fileName[1]);
	 * fileInfo.setVersionNo(fileName[2]);
	 * 
	 * InputStream inputStream = new BufferedInputStream(file.getInputStream());
	 * XWPFDocument doc = new XWPFDocument(OPCPackage.open(inputStream));
	 * List<XWPFParagraph> paraList = doc.getParagraphs(); for (int i = 0; i <
	 * paraList.size(); i++) { if
	 * (StringUtils.isNotBlank(paraList.get(i).getParagraphText())) { ParaType
	 * paraType = new ParaType(); paraType.setContent(paraList.get(i).getText());
	 * paraType.setParaseq(i); paraType.setFileInfoType(fileInfo);
	 * paraTypeList.add(paraType); } } for (int i = 0; i < paraTypeList.size(); i++)
	 * { // postClient(paraTypeList.get(i)); } return paraTypeList; }
	 */

	public static List<ParaType> paraExtractWordDocx(MultipartFile file) throws IOException, InvalidFormatException {
		List<ParaType> paraTypeList = new ArrayList<ParaType>();
		FileInfoType fileInfo = new FileInfoType();
		String filenameWoExt = file.getOriginalFilename();
		String[] fileName = StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")), "_");
		fileInfo.setFormId(fileName[0]);
		fileInfo.setFormTitle(fileName[1]);
		fileInfo.setVersionNo(fileName[2]);
		List<String> list = new ArrayList<String>();
		InputStream inputStream = new BufferedInputStream(file.getInputStream());
		// XWPFDocument doc = new XWPFDocument(OPCPackage.open(inputStream));
		XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(inputStream));
		XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
		System.out.println(extractor.getText());
		String text = extractor.getText().toString();

		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\" + file.getOriginalFilename() + ".txt";
		Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
		List<String> test = Arrays.asList(text.split("\\s+\n\\s+"));
		System.out.println(test);
		list = FileUtils.readLines(new File(path), "utf-8");
		list = new ArrayList<String>(new LinkedHashSet<String>(list));
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		List<String> result = new ArrayList<String>();

		for (String str : list) {
			if (str != null && !(str.trim().isEmpty())) {
				str = str.replace("\n", "");
				str = str.replace(System.getProperty("line.separator"), "");
				str = str.replaceAll("\\r|\\n", "");
				str = str.replaceAll("[\\\r\\\n]+", "");
				if (str.trim().length() > 0)
					result.add(str.trim());
			}
		}

		System.out.println(result);
		list = result;
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		for (int i = 0; i < list.size(); i++) {
			if (StringUtils.isNotBlank(list.get(i))) {
				ParaType paraType = new ParaType();
				paraType.setContent(list.get(i));
				paraType.setParaseq(i);
				paraType.setFileInfoType(fileInfo);
				paraTypeList.add(paraType);
			}
		}
		for (int i = 0; i < paraTypeList.size(); i++) {
			// postClient(paraTypeList.get(i));
		}
		extractor.close();
		return paraTypeList;
	}

	public static List<ParaType> paraExtractWordDoc(MultipartFile file) throws IOException, InvalidFormatException {
		List<String> list = new ArrayList<String>();
		List<ParaType> paraTypeList = new ArrayList<ParaType>();
		WordExtractor extractor = null;
		FileInfoType fileInfo = new FileInfoType();
		String filenameWoExt = file.getOriginalFilename();
		String[] fileName = StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")), "_");
		fileInfo.setFormId(fileName[0]);
		fileInfo.setFormTitle(fileName[1]);
		fileInfo.setVersionNo(fileName[2]);

		InputStream inputStream = new BufferedInputStream(file.getInputStream());

		HWPFDocument document = new HWPFDocument(inputStream);
		extractor = new WordExtractor(document);
		System.out.println("Length of docment is :" + document.characterLength());
		System.out.println(document.getText());
		System.out.println(document.getDocumentText());
		String text = document.getText().toString();

		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\" + file.getOriginalFilename() + ".txt";
		Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
		List<String> test = Arrays.asList(text.split("\\s+\n\\s+"));
		System.out.println(test);
		list = FileUtils.readLines(new File(path), "utf-8");
		list = new ArrayList<String>(new LinkedHashSet<String>(list));
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		List<String> result = new ArrayList<String>();

		for (String str : list) {
			if (str != null && !(str.trim().isEmpty())) {
				str = str.replace("\n", "");
				str = str.replace(System.getProperty("line.separator"), "");
				str = str.replaceAll("\\r|\\n", "");
				str = str.replaceAll("[\\\r\\\n]+", "");
				if (str.trim().length() > 0)
					result.add(str.trim());
			}
		}

		System.out.println(result);
		list = result;
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		for (int i = 0; i < list.size(); i++) {
			if (StringUtils.isNotBlank(list.get(i))) {
				ParaType paraType = new ParaType();
				paraType.setContent(list.get(i));
				paraType.setParaseq(i);
				paraType.setFileInfoType(fileInfo);
				paraTypeList.add(paraType);
			}
		}
		for (int i = 0; i < paraTypeList.size(); i++) {
			// postClient(paraTypeList.get(i));
		}
		extractor.close();
		return paraTypeList;
	}

	// Reading PDF files
	public static List<ParaType> readPDF(MultipartFile file) throws Exception {
		List<ParaType> paraTypeList = new ArrayList<ParaType>();
		List<String> list = new ArrayList<String>();
		FileInfoType fileInfo = new FileInfoType();
		String filenameWoExt = file.getOriginalFilename();
		String[] fileName = StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")), "_");
		fileInfo.setFormId(fileName[0]);
		fileInfo.setFormTitle(fileName[1]);
		fileInfo.setVersionNo(fileName[2]);

		InputStream inputStream = new BufferedInputStream(file.getInputStream());
		File tempFile = stream2file(inputStream);
		String string = null;
		String[] loggers = { "org.apache.pdfbox.util.PDFStreamEngine", "org.apache.pdfbox.pdmodel.font.PDSimpleFont",
				"org.apache.pdfbox.pdmodel.font.PDFont", "org.apache.pdfbox.pdmodel.font.FontManager",
				"org.apache.pdfbox.pdfparser.PDFObjectStreamParser",
				"org.apache.fontbox.util.autodetect.FontFileFinder", "org.apache.pdfbox.io.ScratchFileBuffer",
				"org.apache.pdfbox.pdmodel.font.FileSystemFontProvider",
				"org.apache.pdfbox.pdmodel.font.FileSystemFontProvider",
				"org.apache.fontbox.util.autodetect.FontFileFinder" };
		for (String logger : loggers) {
			org.apache.log4j.Logger logpdfengine = org.apache.log4j.Logger.getLogger(logger);
			logpdfengine.setLevel(org.apache.log4j.Level.OFF);
		}
		try {
			PDFParser pdfParser = new PDFParser((RandomAccessRead) new RandomAccessFile(tempFile, "r"));
			pdfParser.parse();
			PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
			PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
			string = pdfTextStripper.getText(pdDocument);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\" + file.getOriginalFilename() + ".txt";
		Files.write(Paths.get(path), string.getBytes(), StandardOpenOption.CREATE);

		List<String> test = Arrays.asList(string.split("\\s+\n\\s+"));
		System.out.println(test);
		list = FileUtils.readLines(new File(path), "utf-8");
		list = new ArrayList<String>(new LinkedHashSet<String>(list));
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		List<String> result = new ArrayList<String>();

		for (String str : list) {
			if (str != null && !(str.trim().isEmpty())) {
				str = str.replace("\n", "");
				str = str.replace(System.getProperty("line.separator"), "");
				str = str.replaceAll("\\r|\\n", "");
				str = str.replaceAll("[\\\r\\\n]+", "");
				if (str.trim().length() > 0)
					result.add(str.trim());
			}
		}

		System.out.println(result);
		list = result;
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		for (int i = 0; i < list.size(); i++) {
			if (StringUtils.isNotBlank(list.get(i))) {
				ParaType paraType = new ParaType();
				paraType.setContent(list.get(i));
				paraType.setParaseq(i);
				paraType.setFileInfoType(fileInfo);
				paraTypeList.add(paraType);
			}
		}
		for (int i = 0; i < paraTypeList.size(); i++) {
			// postClient(paraTypeList.get(i));
		}
		return paraTypeList;
	}

	// reading pptx files
	public static List<ParaType> readPPTX(MultipartFile file)
			throws IOException, XmlException, OpenXML4JException, org.apache.xmlbeans.XmlException {
		InputStream inputStream = new BufferedInputStream(file.getInputStream());

		OPCPackage d = OPCPackage.open(inputStream);

		List<ParaType> paraTypeList = new ArrayList<ParaType>();
		List<String> list = new ArrayList<String>();
		FileInfoType fileInfo = new FileInfoType();
		String filenameWoExt = file.getOriginalFilename();
		String[] fileName = StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")), "_");
		fileInfo.setFormId(fileName[0]);
		fileInfo.setFormTitle(fileName[1]);
		fileInfo.setVersionNo(fileName[2]);
		String text = "";
		/*
		 * for (XSLFSlide slide : pptxshow.getSlides()) { List<XSLFShape> shapes =
		 * slide.getShapes(); for (XSLFShape shape : shapes) { if (shape instanceof
		 * XSLFTextShape) { XSLFTextShape textShape = (XSLFTextShape) shape; text = text
		 * + textShape.getText() + "\n";
		 * 
		 * } } }
		 */

		XSLFPowerPointExtractor xp = new XSLFPowerPointExtractor(d);
		text = xp.getText();

		List<String> test = Arrays.asList(text.split("\\s+\n\\s+"));
		System.out.println(test);
		System.out.println(".......................................");
		System.out.println(".......................................");
		System.out.println("Power Point Content Displaying.......................................");
		System.out.println(text);
		System.out.println(".......................................");
		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\" + file.getOriginalFilename() + ".txt";
		Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
		list = FileUtils.readLines(new File(path), "utf-8");
		list = new ArrayList<String>(new LinkedHashSet<String>(list));
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		List<String> result = new ArrayList<String>();
		int counter = 0;
		for (String str : list) {
			if (str != null && !(str.trim().isEmpty())) {
				str = str.replace("\n", "");
				str = str.replace(System.getProperty("line.separator"), "");
				str = str.replace("\\r|\\n", "");
				str = str.replace("[\\\r\\\n]+", "");
				str = str.replace("\t", "  ");
				str = str.replace(" ", "  ");
				str = str.trim();
				System.out.println(counter + " ->" + str.trim() + "<-");
				if ((str.trim().length() > 0) || (!(str.trim().isEmpty()))) {
					result.add(str.trim());
				}
			}
			counter++;
		}

		System.out.println(result);
		list = result;
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		for (int i = 0; i < list.size(); i++) {
			if (StringUtils.isNotBlank(list.get(i))) {
				ParaType paraType = new ParaType();
				paraType.setContent(list.get(i));
				paraType.setParaseq(i);
				paraType.setFileInfoType(fileInfo);
				paraTypeList.add(paraType);
			}
		}
		for (int i = 0; i < paraTypeList.size(); i++) {
			// postClient(paraTypeList.get(i));
		}
		return paraTypeList;
	}

	public static List<ParaType> readPPT(MultipartFile file) throws IOException {
		InputStream inputStream = new BufferedInputStream(file.getInputStream());
		List<ParaType> paraTypeList = new ArrayList<ParaType>();
		List<String> list = new ArrayList<String>();
		FileInfoType fileInfo = new FileInfoType();
		String filenameWoExt = file.getOriginalFilename();
		String[] fileName = StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")), "_");
		fileInfo.setFormId(fileName[0]);
		fileInfo.setFormTitle(fileName[1]);
		fileInfo.setVersionNo(fileName[2]);
		PowerPointExtractor extractor = new PowerPointExtractor(inputStream);
		String text = extractor.getText(true, true);

		System.out.println(".......................................");
		System.out.println(".......................................");
		System.out.println("Power Point Content Displaying.......................................");
		System.out.println(text);
		System.out.println(".......................................");
		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\" + file.getOriginalFilename() + ".txt";
		Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
		list = FileUtils.readLines(new File(path), "utf-8");
		list = new ArrayList<String>(new LinkedHashSet<String>(list));

		List<String> result = new ArrayList<String>();

		for (String str : list) {
			if (str != null && !(str.trim().isEmpty())) {
				str = str.replace("\n", "");
				str = str.replace(System.getProperty("line.separator"), "");
				str = str.replaceAll("\\r|\\n", "");
				str = str.replaceAll("[\\\r\\\n]+", "");
				if (str.trim().length() > 0)
					result.add(str.trim());
			}
		}

		System.out.println(result);
		list = result;
		list.removeAll(Arrays.asList("", null));
		list.removeAll(Collections.singleton(null));
		list.removeAll(Collections.singleton(""));
		for (int i = 0; i < list.size(); i++) {
			if (StringUtils.isNotBlank(list.get(i))) {
				ParaType paraType = new ParaType();
				paraType.setContent(list.get(i));
				paraType.setParaseq(i);
				paraType.setFileInfoType(fileInfo);
				paraTypeList.add(paraType);
			}
		}
		for (int i = 0; i < paraTypeList.size(); i++) {
			// postClient(paraTypeList.get(i));
		}
		return paraTypeList;
	}

	/*
	 * public static void prepareReport(List<List<ParaType>> paraTypeList,
	 * List<String> masterList) {
	 * 
	 * XSSFRow row = null; XSSFCell cell = null; XSSFCell cell1 = null;
	 * FileOutputStream fileOut = null; XSSFWorkbook workbook = null;
	 * 
	 * try {
	 * 
	 * fileOut = new
	 * FileOutputStream(ExcelPath+paraTypeList.get(0).get(0).getFileInfoType().
	 * getFormTitle()+ "_Report.xlsx"); workbook = new XSSFWorkbook(); XSSFSheet
	 * worksheet = workbook.createSheet("POI Worksheet");
	 * 
	 * XSSFRow row1 = worksheet.createRow(0); XSSFCellStyle cellStyle =
	 * workbook.createCellStyle(); cellStyle.setWrapText(true);
	 * 
	 * XSSFFont font = workbook.createFont(); font.setBold(true);
	 * font.setFontName("Calibri"); cellStyle.setFont(font);
	 * 
	 * cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 * cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	 * cellStyle.setBorderBottom(BorderStyle.THIN);
	 * cellStyle.setBorderLeft(BorderStyle.THIN);
	 * cellStyle.setBorderRight(BorderStyle.THIN);
	 * cellStyle.setBorderTop(BorderStyle.THIN);
	 * cellStyle.setAlignment(HorizontalAlignment.CENTER);
	 * 
	 * XSSFCell cellA1 = row1.createCell(0); cellA1.setCellValue("Master Items");
	 * cellA1.setCellStyle(cellStyle);
	 * 
	 * XSSFCellStyle cellStyle1 = workbook.createCellStyle();
	 * cellStyle1.setWrapText(true);
	 * 
	 * XSSFFont font1 = workbook.createFont(); font1.setFontName("Calibri");
	 * cellStyle1.setFont(font1);
	 * 
	 * cellStyle1.setBorderBottom(BorderStyle.THIN);
	 * cellStyle1.setBorderLeft(BorderStyle.THIN);
	 * cellStyle1.setBorderRight(BorderStyle.THIN);
	 * cellStyle1.setBorderTop(BorderStyle.THIN);
	 * 
	 * worksheet.setColumnWidth(0, 15000);
	 * 
	 * int s=1; for(int i=0; i < paraTypeList.size(); i++){
	 * worksheet.setColumnWidth(s, 15000); XSSFCell cellA2 = row1.createCell(s);
	 * XSSFCell cellA = row1.createCell(s+1); //worksheet.addMergedRegion(new
	 * CellRangeAddress(0,0,s,s+1));
	 * cellA2.setCellValue(paraTypeList.get(i).get(0).getFileInfoType().getFormTitle
	 * ()); cellA.setCellValue("% Match"); cellA2.setCellStyle(cellStyle);
	 * cellA.setCellStyle(cellStyle); s = s+2; } List<String> masterList = new
	 * ArrayList<String>(); int x = 1; for(int i=0; i< paraTypeList.size(); i++) {
	 * if(i != 0) x = (i*2)+1; List<ParaType> prList = paraTypeList.get(i);
	 * if(masterList == null || masterList.size() == 0) { for (int j=0; j<
	 * prList.size(); j++) { masterList.add(prList.get(j).getContent()); } } for(int
	 * j=0; j< prList.size(); j++) { for(int k=0; k< masterList.size(); k++) {
	 * //master list cell if(worksheet.getRow(k+1) == null) { row =
	 * worksheet.createRow(k+1); } else { row = worksheet.getRow(k+1); } XSSFCell
	 * mcell = row.createCell(0); mcell.setCellValue(masterList.get(k));
	 * mcell.setCellStyle(cellStyle1); if(null == row.getCell(x) && null ==
	 * row.getCell(x+1)){ cell = row.createCell(x); cell1 = row.createCell(x+1);
	 * if(prList.get(j).getContent().trim().equals(masterList.get(k).trim())) {
	 * cell.setCellValue(""); cell1.setCellValue("100%");
	 * cell.setCellStyle(cellStyle1); cell1.setCellStyle(cellStyle1); break; } else
	 * { WordAccuracy wa = new WordAccuracy(); //row = worksheet.getRow(k+1); int
	 * accuracy = wa.getAccuracy(prList.get(j).getContent(),masterList.get(k));
	 * if(accuracy < 75 && accuracy > 25) {
	 * cell.setCellValue(prList.get(j).getContent());
	 * cell1.setCellValue(accuracy+"%"); }else if(accuracy >= 75) {
	 * cell.setCellValue(prList.get(j).getContent());
	 * cell1.setCellValue(accuracy+"%"); } else { cell.setCellValue("");
	 * cell1.setCellValue("0%"); } cell.setCellStyle(cellStyle1);
	 * cell1.setCellStyle(cellStyle1); } } else if(null !=row.getCell(x+1) &&
	 * !row.getCell(x+1).getStringCellValue().contains("100%")){
	 * if(prList.get(j).getContent().trim().equals(masterList.get(k).trim())) {
	 * //row = worksheet.getRow(k+1); cell = row.createCell(x);
	 * cell.setCellValue(""); cell.setCellStyle(cellStyle1);
	 * 
	 * cell1 = row.createCell(x+1); cell1.setCellValue("100%");
	 * cell1.setCellStyle(cellStyle1); break; } else { WordAccuracy wa = new
	 * WordAccuracy(); int accuracy =
	 * wa.getAccuracy(prList.get(j).getContent(),masterList.get(k)); String value =
	 * row.getCell(x+1).getStringCellValue(); System.out.println("Initial: "+value);
	 * value = value.replace("%", ""); System.out.println("% later: "+value);
	 * if(value.contains("<")) { value = value.replace("< ", ""); }
	 * System.out.println("% later1111: "+value); int previous =
	 * Integer.parseInt(value); if(accuracy >= 75 && accuracy > previous){ cell =
	 * row.createCell(x); cell1 = row.createCell(x+1);
	 * cell.setCellValue(prList.get(j).getContent());
	 * cell1.setCellValue(accuracy+"%"); } else if(accuracy < 75 && previous < 75 &&
	 * accuracy > 25){ cell = row.createCell(x); cell1 = row.createCell(x+1);
	 * cell.setCellValue(prList.get(j).getContent());
	 * cell1.setCellValue(accuracy+"%"); } else if(accuracy <= 25){ cell =
	 * row.createCell(x); cell1 = row.createCell(x+1); cell.setCellValue("");
	 * cell1.setCellValue("0%"); } cell.setCellStyle(cellStyle1);
	 * cell1.setCellStyle(cellStyle1); } } } } } workbook.write(fileOut);
	 * fileOut.flush(); fileOut.close(); workbook.close();
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	public ContentInfo extractConsolidateList(File file) throws Exception {
		// InputStream inputStream = new BufferedInputStream(file.getInputStream());
		XWPFDocument doc = new XWPFDocument(OPCPackage.open(file.getPath()));
		List<XWPFParagraph> paraList = doc.getParagraphs();
		ContentInfo contentInfo = new ContentInfo();
		List<String> list = new ArrayList<String>();
		for (XWPFParagraph para : paraList) {
			list.add(para.getText());
		}
		contentInfo.setContent(list);

		return contentInfo;
	}

	public static List<String> prepareMasterInfo(List<List<ParaType>> paraTypeList) {
		List<String> masterList = new ArrayList<String>();
		List<ParaType> pataType1 = paraTypeList.get(0);
		List<String> tmp = new ArrayList<String>();
		for (int i = 1; i < paraTypeList.size(); i++) {
			List<ParaType> pataType2 = paraTypeList.get(i);
			if (masterList.size() == 0 || masterList == null)
				for (ParaType paraType : pataType1) {
					masterList.add(paraType.getContent());
				}

			for (int j = 0; j < pataType2.size(); j++) {
				int maxAccuracy = 0;
				int length = masterList.size();
				for (int k = 0; k < length; k++) {
					if (!masterList.get(k).equals(pataType2.get(j).getContent())) {
						WordAccuracy wa = new WordAccuracy();
						int accuracy = 0;// wa.getAccuracy(masterList.get(k), pataType2.get(j).getContent());
						if (maxAccuracy < accuracy) {
							maxAccuracy = accuracy;
						}

					}
				}

				if (maxAccuracy < 40) {
					masterList.add(pataType2.get(j).getContent());
				}
			}

		}
		return masterList;
	}

	public String landPage(MultipartFile[] files) throws Exception {
		List<List<ParaType>> paraTypeList = new ArrayList<List<ParaType>>();
		for (int i = 0; i < files.length; i++) {
			String extension = FilenameUtils.getExtension(files[i].getOriginalFilename());
			// if (extension.contains("docx")) {
			paraTypeList.add(paraExtract(files[i]));
			// } else if (extension.contains("pdf")) {
			// paraTypeList.add(pdfExtract(files[i]));
			// }
		}
		// prepare mster para List

		CompareInfo master = new CompareInfo();
		String filenameWoExt = files[0].getOriginalFilename();
		String[] fileName = StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")), "_");
		master.setFormTitle(fileName[0]);
		master.setVersionNo("M1");// need to change
		List<String> masterParaList = prepareMasterInfo(paraTypeList);
		List<Integer> paraSeq = new ArrayList<Integer>();
		List<String> content = new ArrayList<String>();
		for (int i = 0; i < masterParaList.size(); i++) {
			paraSeq.add(i);
			content.add(masterParaList.get(i));
		}

		String masterFileName = fileName[0] + "_" + fileName[1];

		/*
		 * String urlS =
		 * "http://localhost:2018/IntegrationRest/deleteFileAndContentlist/"+
		 * masterFileName; getClient(urlS, "application/xml");
		 */
		String paraList = "";
		for (int i = 0; i < masterParaList.size(); i++) {
			String paraT = "" + masterParaList.get(i);
			if (paraT.contains("&")) {

				paraT = paraT.replaceAll("&", "~");
			}
			paraList = paraList + "<ParaType><paraSeq>" + (i) + "</paraSeq><content>" + paraT + "</content></ParaType>";
		}

		String testString = "<fileTable><formId>" + fileName[0] + "</formId><formTitle>" + masterFileName
				+ "</formTitle><versionNo>" + 0 + "</versionNo>" + paraList + "</fileTable>";

		System.out.println(testString);
		String urlSave = "http://localhost:2018/IntegrationRest/encomm/save";
		postClient(urlSave, testString, "application/xml");
		paraList = "";
		/*
		 * masterFileName = masterFileName + "~"+ 0.0; String urlFileID =
		 * "http://localhost:2018/IntegrationRest/genFile/"+masterFileName; String msg =
		 * getClient(urlFileID, "application/xml");
		 */

		// System.out.println(msg);
		String para = "";
		for (int i = 0; i < paraTypeList.size(); i++) {
			for (int j = 0; j < paraTypeList.get(i).size(); j++) {
				System.out.println();
				String paraT = "" + paraTypeList.get(i).get(j).getContent();
				if (paraT.contains("&")) {

					paraT = paraT.replaceAll("&", "~");
				}
				para = para + "<ParaType><paraSeq>" + (j) + "</paraSeq><content>" + paraT + "</content></ParaType>";
			}

			testString = "<fileTable><formId>" + fileName[0] + "</formId><formTitle>" + masterFileName
					+ "</formTitle><versionNo>" + 1 + "." + i + "</versionNo>" + para + "</fileTable>";

			System.out.println(testString);
			urlSave = "http://localhost:2018/IntegrationRest/encomm/save";
			postClient(urlSave, testString, "application/xml");
			para = "";

		}

		/*
		 * testString = "<fileTable><formId>" + fileName[0] + "</formId><formTitle>" +
		 * masterFileName + "</formTitle><versionNo>" + 0 + "</versionNo>" + paraList +
		 * "</fileTable>";
		 */

		XWPFDocument document = new XWPFDocument();
		for (String text : masterParaList) {
			XWPFParagraph tmpParagraph = document.createParagraph();
			XWPFRun tmpRun = tmpParagraph.createRun();
			tmpRun.setText(text);
			tmpRun.setFontFamily("TIMES_ROMAN");
			tmpRun.setFontSize(14);
			tmpRun.addCarriageReturn();
		}

		String masterPath = "C:\\Users\\Public\\POC Files\\BaseDir\\BaselineDoc\\" + masterFileName + ".docx";
		FileOutputStream fos = new FileOutputStream(masterPath);
		document.write(fos);
		fos.close();

		master.setParaSeq(paraSeq);
		master.setContent(content);
		// comparaInfoList.add(master);

		// prepareReport(paraTypeList, masterParaList);
		PrepareReport pr = new PrepareReport();
		String reportName = pr.excel(paraTypeList, masterParaList);

		CompareReport cr = new CompareReport();
		cr.setReportPath(masterFileName);
		cr.setMasterPath(masterPath);
		return masterFileName;
	}

	public static File stream2file(InputStream in) throws IOException {
		final File tempFile = File.createTempFile(PREFIX, SUFFIX);
		tempFile.deleteOnExit();
		try (FileOutputStream out = new FileOutputStream(tempFile)) {
			IOUtils.copy(in, out);
		}
		return tempFile;
	}

	public static String postClient(String url, String o, String type) {
		/*
		 * String testString = "<fileTable><formId>" + formId + "</formId><formTitle>" +
		 * fileName + "</formTitle><versionNo>" + version + "</versionNo>" + paraList +
		 * "</fileTable>"; String urlSave =
		 * "http://localhost:2018/IntegrationRest/encomm/save"; postClient(urlSave,
		 * testString, "application/xml");
		 */
		Client restClient = Client.create();
		com.sun.jersey.api.client.WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.type(type).post(ClientResponse.class, o);
		String output = "";// resp.getEntity(String.class);
		return output;
	}

	public static String getClient(String url, String type) {
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.get(ClientResponse.class);
		String output = "";// resp.getEntity(String.class);
		// return output;
		return output;
	}

	/*
	 * public List<XWPFParagraph> readDocFile(String fileName) { WordExtractor we;
	 * XSSFWorkbook workbook; XWPFDocument document; XWPFDocument docx; try { File
	 * file = new File(fileName); FileInputStream fis = new
	 * FileInputStream(file.getAbsolutePath()); HWPFDocument doc = new
	 * HWPFDocument(fis); we = new WordExtractor(doc); String[] paragraph =
	 * we.getParagraphText(); docx = new XWPFDocument(); List<XWPFParagraph>
	 * paragraphs = new ArrayList<XWPFParagraph>(); for (String para : paragraph) {
	 * // System.out.println(para.toString()); XWPFParagraph pa =
	 * docx.createParagraph(); // create paragraph in the document XWPFRun run =
	 * pa.createRun(); run.setText(para); run.addBreak(); paragraphs.add(pa);// add
	 * break
	 * 
	 * } fis.close(); return paragraphs; } catch (Exception e) {
	 * e.printStackTrace(); } return null; }
	 */
	public static List<ParaType> pdfExtract(MultipartFile file) throws Exception {

		PdfReader reader;
		List<String> pages = new ArrayList<String>();
		List<ParaType> paraTypeList = new ArrayList<ParaType>();
		FileInfoType fileInfo = new FileInfoType();
		String filenameWoExt = file.getOriginalFilename();
		String[] fileName = StringUtils.split(filenameWoExt.substring(0, filenameWoExt.lastIndexOf(".")), "_");
		fileInfo.setFormId(fileName[0]);
		fileInfo.setFormTitle(fileName[1]);
		fileInfo.setVersionNo(fileName[2]);
		try {
			reader = new PdfReader("f:/itext.pdf");
			int noOfPages = reader.getNumberOfPages();
			for (int i = 0; i < noOfPages; i++) {
				pages.add(PdfTextExtractor.getTextFromPage(reader, i));
				if (StringUtils.isNotBlank(pages.get(i))) {
					ParaType paraType = new ParaType();
					paraType.setContent(pages.get(i));
					paraType.setParaseq(i);
					paraType.setFileInfoType(fileInfo);
					paraTypeList.add(paraType);
				}
			}
			// System.out.println(textFromPage);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return paraTypeList;

	}

}

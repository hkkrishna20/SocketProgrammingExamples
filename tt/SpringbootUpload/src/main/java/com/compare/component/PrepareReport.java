package com.compare.component;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrepareReport {

	public static String ExcelPath = "C:\\Users\\Public\\POC Files\\BaseDir\\Report\\";

	public String excel(List<List<ParaType>> paraTypeList, List<String> masterList) {

		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFCell cell1 = null;
		FileOutputStream fileOut = null;
		XSSFWorkbook workbook = null;

		String reportName = new String();

		try {
			reportName = ExcelPath + paraTypeList.get(0).get(0).getFileInfoType().getFormTitle() + "_Report.xlsx";
			fileOut = new FileOutputStream(reportName);
			workbook = new XSSFWorkbook();
			XSSFSheet worksheet = workbook.createSheet("POI Worksheet");

			XSSFRow row1 = worksheet.createRow(0);
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setWrapText(true);

			XSSFFont font = workbook.createFont();
			font.setBold(true);
			font.setFontName("Calibri");
			cellStyle.setFont(font);

			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);

			XSSFCell cellA1 = row1.createCell(0);
			cellA1.setCellValue("Master Items");
			cellA1.setCellStyle(cellStyle);

			XSSFCellStyle cellStyle1 = workbook.createCellStyle();
			cellStyle1.setWrapText(true);

			XSSFFont font1 = workbook.createFont();
			font1.setFontName("Calibri");
			cellStyle1.setFont(font1);

			cellStyle1.setBorderBottom(BorderStyle.THIN);
			cellStyle1.setBorderLeft(BorderStyle.THIN);
			cellStyle1.setBorderRight(BorderStyle.THIN);
			cellStyle1.setBorderTop(BorderStyle.THIN);

			worksheet.setColumnWidth(0, 15000);

			int s = 1;
			for (int i = 0; i < paraTypeList.size(); i++) {
				worksheet.setColumnWidth(s, 15000);
				XSSFCell cellA2 = row1.createCell(s);
				XSSFCell cellA = row1.createCell(s + 1);
				// worksheet.addMergedRegion(new CellRangeAddress(0,0,s,s+1));
				String fileName = paraTypeList.get(i).get(0).getFileInfoType().getFormTitle()
						+ paraTypeList.get(i).get(0).getFileInfoType().getVersionNo();
				cellA2.setCellValue(fileName);
				cellA.setCellValue("% Match");
				cellA2.setCellStyle(cellStyle);
				cellA.setCellStyle(cellStyle);
				s = s + 2;
			}
			// List<String> masterList = new ArrayList<String>();
			int x = 1;
			for (int i = 0; i < paraTypeList.size(); i++) {
				if (i != 0)
					x = (i * 2) + 1;
				List<ParaType> prList = paraTypeList.get(i);
				/*
				 * if(masterList == null || masterList.size() == 0) { for (int j=0; j<
				 * prList.size(); j++) { masterList.add(prList.get(j).getContent()); } }
				 */

				for (int j = 0; j < prList.size(); j++) {
					// ListIterator<String> li = masterList.listIterator();
					int length = masterList.size();
					for (int k = 0; k < length; k++) {
						// master list cell
						if (worksheet.getRow(k + 1) == null) {
							row = worksheet.createRow(k + 1);
						} else {
							row = worksheet.getRow(k + 1);
						}
						XSSFCell mcell = row.createCell(0);
						mcell.setCellValue(masterList.get(k));
						mcell.setCellStyle(cellStyle1);
						if (null == row.getCell(x) && null == row.getCell(x + 1)) {
							cell = row.createCell(x);
							cell1 = row.createCell(x + 1);
							if (prList.get(j).getContent().trim().equals(masterList.get(k).trim())) {
								cell.setCellValue("");
								cell1.setCellValue("100%");
								cell.setCellStyle(cellStyle1);
								cell1.setCellStyle(cellStyle1);
								break;
							} else {
//								WordAccuracy wa = new WordAccuracy();
								// row = worksheet.getRow(k+1);
								// int accuracy = wa.getAccuracy(prList.get(j).getContent(), masterList.get(k));
								int accuracy = 0;
								if (accuracy < 75 && accuracy > 40) {
									cell.setCellValue(prList.get(j).getContent());
									cell1.setCellValue(accuracy + "%");
								} else if (accuracy >= 75) {
									cell.setCellValue(prList.get(j).getContent());
									cell1.setCellValue(accuracy + "%");
								} else if (accuracy <= 40) {
									cell.setCellValue("");
									cell1.setCellValue("0%");
								}

								cell.setCellStyle(cellStyle1);
								cell1.setCellStyle(cellStyle1);
							}
						} else if (null != row.getCell(x + 1)
								&& !row.getCell(x + 1).getStringCellValue().contains("100%")) {
							if (prList.get(j).getContent().trim().equals(masterList.get(k).trim())) {
								// row = worksheet.getRow(k+1);
								cell = row.createCell(x);
								cell.setCellValue("");
								cell.setCellStyle(cellStyle1);

								cell1 = row.createCell(x + 1);
								cell1.setCellValue("100%");
								cell1.setCellStyle(cellStyle1);
								break;
							} else {
								// WordAccuracy wa = new WordAccuracy();
								// int accuracy = wa.getAccuracy(prList.get(j).getContent(), masterList.get(k));

								int accuracy = 0;
								String value = row.getCell(x + 1).getStringCellValue();
								System.out.println("Initial: " + value);
								value = value.replace("%", "");
								System.out.println("% later: " + value);
								if (value.contains("<")) {
									value = value.replace("< ", "");
								}
								System.out.println("% later1111: " + value);
								int previous = Integer.parseInt(value);
								if (accuracy >= 75 && accuracy > previous) {
									cell = row.createCell(x);
									cell1 = row.createCell(x + 1);
									cell.setCellValue(prList.get(j).getContent());
									cell1.setCellValue(accuracy + "%");
								} else if (accuracy < 75 && previous < 75 && accuracy > 40) {
									cell = row.createCell(x);
									cell1 = row.createCell(x + 1);
									cell.setCellValue(prList.get(j).getContent());
									cell1.setCellValue(accuracy + "%");
								} else if (accuracy <= 40 && accuracy > previous) {
									cell = row.createCell(x);
									cell1 = row.createCell(x + 1);
									cell.setCellValue("");
									cell1.setCellValue("0%");
									/*
									 * if(!masterList.contains(prList.get(j).getContent())) {
									 * masterList.add(prList.get(j).getContent()); length = masterList.size(); }
									 */
								}

								/*
								 * if(accuracy <= 40 && previous <= 40) {
								 * if(!masterList.contains(prList.get(j).getContent())) {
								 * masterList.add(prList.get(j).getContent()); length = masterList.size(); }
								 * 
								 * }
								 */

								cell.setCellStyle(cellStyle1);
								cell1.setCellStyle(cellStyle1);
							}
						}
					}
				}
			}
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			// workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportName;

	}

}

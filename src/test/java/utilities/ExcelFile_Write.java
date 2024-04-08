package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile_Write {
	public static void writePopularModels(ArrayList<String> arr) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		CellStyle style = workbook.createCellStyle(); 
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		XSSFRow row0 = sheet.createRow(0);
		XSSFCell cell0 = row0.createCell(0);
		cell0.setCellValue("Popular Models In Chennai");
		cell0.setCellStyle(style);
		
		for(int i=0; i<arr.size(); i++) {
			XSSFRow row = sheet.createRow(i+1);

			int colnum = 0;
			XSSFCell cell = row.createCell(colnum);
			cell.setCellValue(arr.get(i));
			sheet.autoSizeColumn(colnum);
		}
		
		try {
			File file = new File("./Excel_output/UsedCarsPopularModels.xlsx");
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			workbook.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public static void writeBikesDetails(ArrayList<String> bikesDetails) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		CellStyle style = workbook.createCellStyle(); 
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		XSSFRow row0 = sheet.createRow(0);
		XSSFCell cell0 = row0.createCell(0);
		cell0.setCellValue("Bike Details");
		cell0.setCellStyle(style);
		
		for(int i=0; i<bikesDetails.size(); i++) {
			XSSFRow row = sheet.createRow(i+1);

			int colnum = 0;
			XSSFCell cell = row.createCell(colnum);
			cell.setCellValue(bikesDetails.get(i));
			sheet.autoSizeColumn(colnum);
		}
		
		try {
			File file = new File("./Excel_output/UpcomingHondaBikesDetails.xlsx");
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			workbook.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

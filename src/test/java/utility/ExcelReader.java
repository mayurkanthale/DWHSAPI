package utility;

import java.io.File;
import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelReader {
	
	public static int getTotalRowCount(String filePath, String sheetName){	
		int totalRows=0;
		try {
			File file = new File(filePath);
			FileInputStream fs;
			fs = new FileInputStream(file);
			Workbook workbook = Workbook.getWorkbook(fs);
			Sheet sheet = workbook.getSheet(sheetName);
			totalRows = sheet.getRows();
		} catch (Exception e) {		
			System.out.println("Failed to get total rows : " +e.getMessage());
		}	
		return totalRows;
	}
	
	
	public static String[][] getExcelData(String filePath, String sheetName) {
		String[][] excelArrayData = null;
		try {
			File file = new File(filePath);
			FileInputStream fs = new FileInputStream(file);
			Workbook workbook = Workbook.getWorkbook(fs);
			Sheet sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getRows();
			int totalCol = sheet.getColumns();
			excelArrayData = new String[totalRows-1][totalCol];
			for (int i = 1; i < totalRows; i++) {
				for (int j = 0; j < totalCol; j++) {
					excelArrayData[i-1][j] = sheet.getCell(j, i).getContents().trim();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return excelArrayData;
	}

}

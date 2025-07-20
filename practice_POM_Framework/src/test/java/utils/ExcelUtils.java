package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	public static String getURLfromExcel(String enivronmentName) {
		
		String filePath = "src/test/resoures/test-environment.xlsx";
		
		try(FileInputStream fis = new FileInputStream(filePath);
				 Workbook workbook = new XSSFWorkbook(fis)) {
			
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				
				Row row = sheet.getRow(i);
				
				Cell envCell = row.getCell(0);
				Cell urlCell = row.getCell(1);
				
				if(envCell != null && envCell.getStringCellValue().equalsIgnoreCase(enivronmentName)) {
					return urlCell.getStringCellValue();
				}
					
			}
			   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}

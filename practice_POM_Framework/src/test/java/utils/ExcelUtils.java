package utils;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    public static String getURLFromExcel(String environmentName) throws IOException {
        InputStream is = ExcelUtils.class.getClassLoader().getResourceAsStream("test-environment.xlsx");

        if (is == null) {
            throw new FileNotFoundException("Could not load file using ClassLoader.");
        }

        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            Cell envCell = row.getCell(0);
            Cell urlCell = row.getCell(1);

            if (envCell.getStringCellValue().equalsIgnoreCase(environmentName)) {
                return urlCell.getStringCellValue();
            }
        }

        return null; // or throw if env not found
    }
}

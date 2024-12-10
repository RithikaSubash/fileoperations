package fileoperations1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public static void main(String[] args) {
        
        Workbook workbook = new XSSFWorkbook();
        
       
        Sheet sheet = workbook.createSheet("Sheet1");
        
       
        String[][] data = {
            {"Name", "Age", "Email"},
            {"John Doe", "30", "john@test.com"},
            {"Jane Doe", "28", "jane@test.com"},
            {"Bob Smith", "35", "bob@example.com"},
            {"Swapnil", "37", "swapnil@example.com"}
        };
        
       
        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }
        
        
        try (FileOutputStream fileOut = new FileOutputStream("Data.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing Excel file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.out.println("Error closing workbook: " + e.getMessage());
            }
        }
    }
}

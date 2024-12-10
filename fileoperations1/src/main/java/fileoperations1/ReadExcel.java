package fileoperations1;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) {
        String filePath = "Data.xlsx";

        try (FileInputStream fileIn = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fileIn)) {
            
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through rows
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown\t");
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        }
    }
}

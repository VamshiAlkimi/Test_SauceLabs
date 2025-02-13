package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
    
    private FileInputStream fi;
    private FileOutputStream fo;
    private XSSFWorkbook workbook;
    private String path;

    // Constructor to initialize the file path
    public ExcelUtility(String path) throws IOException {
        this.path = path;
        fi = new FileInputStream(path);  // Open file stream once
        workbook = new XSSFWorkbook(fi);  // Initialize the workbook
        fi.close();  // Close the FileInputStream as it's no longer needed
    }

    // Get the row count of the sheet
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return 0;
        return sheet.getPhysicalNumberOfRows();
    }

    // Get the number of cells in a row
    public int getCellCount(String sheetName, int rownum) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return 0;
        Row row = sheet.getRow(rownum);
        if (row == null) return 0;
        return row.getPhysicalNumberOfCells();
    }

    // Get the data of a specific cell
    public String getCellData(String sheetName, int rownum, int colnum) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return "";
        Row row = sheet.getRow(rownum);
        if (row == null) return "";
        Cell cell = row.getCell(colnum);
        if (cell == null) return "";
        
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    // Set data into a specific cell
    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) sheet = workbook.createSheet(sheetName);  // Create sheet if it doesn't exist

        Row row = sheet.getRow(rownum);
        if (row == null) row = sheet.createRow(rownum);  // Create row if it doesn't exist

        Cell cell = row.createCell(colnum);
        cell.setCellValue(data);

        // Save the changes to the file
        saveChanges();
    }

    // Fill a cell with a green color
    public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return;

        Row row = sheet.getRow(rownum);
        if (row == null) return;

        Cell cell = row.getCell(colnum);
        if (cell == null) return;

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        saveChanges();
    }

    // Fill a cell with a red color
    public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return;

        Row row = sheet.getRow(rownum);
        if (row == null) return;

        Cell cell = row.getCell(colnum);
        if (cell == null) return;

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        saveChanges();
    }

    // Save changes to the file
    private void saveChanges() throws IOException {
        fo = new FileOutputStream(path);
        workbook.write(fo);
        fo.close();
    }

    // Close the workbook and file output stream
    public void close() throws IOException {
        if (workbook != null) workbook.close();
        if (fi != null) fi.close();
        if (fo != null) fo.close();
    }
}

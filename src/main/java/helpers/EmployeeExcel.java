package helpers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeExcel extends CommonExcel {

    public class TableRow {
        public int cityId;
        public int employeeId;
        public int installCount;
        public String employeeName;

        public TableRow(int cityId, int employeeId, int installCount, String employeeName) {
            this.cityId = cityId;
            this.employeeId = employeeId;
            this.installCount = installCount;
            this.employeeName = employeeName;
        }

        @Override
        public boolean equals(Object obj) {
            TableRow r = (TableRow)obj;
            return this.employeeId == r.employeeId &&
                    this.cityId == r.cityId;
        }
    }

    public ArrayList<TableRow> excelRows = new ArrayList<>();


    public EmployeeExcel(String pathToExcel) {

        try {
            FileInputStream file = new FileInputStream(pathToExcel);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum(); //all rows

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);

                int cityId = getIntCellValue(row.getCell(0));
                int employeeId = getIntCellValue(row.getCell(2));
                int unique_installing_excel = getIntCellValue(row.getCell(3));
                String employeeName = row.getCell(1).getStringCellValue();

                // if no such element then it returns -1
        TableRow tableRow = new TableRow(cityId, employeeId, unique_installing_excel, employeeName);
        int existingEmployeeIdIndex = excelRows.indexOf(tableRow);

        // add a check if the element with the employeeId and cityId
        // is already in the array

        if(existingEmployeeIdIndex != -1) {
            TableRow existingExcelRow = excelRows.get(existingEmployeeIdIndex);
            existingExcelRow.installCount = existingExcelRow.installCount + unique_installing_excel;
        } else {
            if(employeeId != -1) {
                        excelRows.add(tableRow);
            } else {
            System.out.println("unknown detected!");
            }
        }

            }
        }
        catch (IOException e) {
            //throw new RuntimeException(e);
        }
    }
}

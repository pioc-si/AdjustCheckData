package helpers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BitrixEmployeeExcel extends CommonExcel {

    public class BitrixTableRow {
        public String employeeName;
        public String storeName;
        public int installCount;

        public BitrixTableRow(String employeeName, String storeName, int installCount) {
            this.employeeName = employeeName;
            this.storeName = storeName;
            this.installCount = installCount;
        }

        @Override
        public boolean equals(Object obj) {
            BitrixTableRow r = (BitrixTableRow)obj;
            return this.employeeName == r.employeeName; //&&
                    //this.StoreName == r.StoreName;
        }
    }

    public ArrayList<BitrixTableRow> bitrixExcelRows = new ArrayList<>();


    public BitrixEmployeeExcel(String pathToExcel) {

        try {
            FileInputStream file = new FileInputStream(pathToExcel);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum(); //all rows

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);

                String employeeName = row.getCell(1).getStringCellValue();
                String storeName =  row.getCell(3).getStringCellValue();
                int unique_installing_excel = getIntCellValue(row.getCell(4));

                BitrixTableRow tableRow = new BitrixTableRow(employeeName, storeName, unique_installing_excel);

                bitrixExcelRows.add(tableRow);

            }
        }
        catch (IOException e) {

        }

    }

    public int getUniqueInstallsByEmployeeName(String employeeName) {

        for (BitrixTableRow row :  bitrixExcelRows) {
            if (row.employeeName.equals(employeeName)) {
                return row.installCount;
            }
        }

        return -1;
    }
}

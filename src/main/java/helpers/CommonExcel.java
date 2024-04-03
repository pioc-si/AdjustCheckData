package helpers;

import org.apache.poi.ss.usermodel.Cell;

public class CommonExcel {

    public static int getIntCellValue(Cell cell) {

        switch (cell.getCellType()) {
            case NUMERIC:
                // Handle numeric value
                try {
                    return (int) cell.getNumericCellValue();
                } catch (NumberFormatException e) {
                    System.out.println("The string is not a valid integer");
                    return -1;
                }
            case STRING:
                // Handle string value
                try {
                    String stringValue = cell.getStringCellValue();
                    return Integer.parseInt(stringValue.trim()); // Convert string to integer
                } catch (NumberFormatException e) {
                    System.out.println("The string is not a valid integer");
                    return -1;
                }
            default:
                // Handle other types if needed
                System.out.println("Cell type not supported.");
                return -1;
        }
    }

}

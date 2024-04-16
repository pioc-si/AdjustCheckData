package tests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import config.Props;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.testng.annotations.Test;
import pages.BitrixWebTablePage;
import pages.DeliverablesPage;
import pages.NonShopId;

public class CheckTableDataTest extends TestsSetup {

  Props props = Props.props;
  // Create a new Workbook
  Workbook workbook = new XSSFWorkbook(); // For .xlsx format

  @Test
  public void checkBitrixInstalls() {
    String[] shopIds = {
      "677", "506", "491", "413", "327", "329", "402", "167", "191", "616", "683", "163", "165",
      "689", "159", "161", "225", "404", "496", "585", "615", "673", "251", "255", "249", "435",
      "263", "265", "243", "259", "697", "261", "446", "680", "666", "610", "678"
    };
    ArrayList<String> shopIdList = new ArrayList<>(Arrays.asList(shopIds));

    BitrixWebTablePage bwtp = new BitrixWebTablePage();

    int index = 0;

    // Create a Sheet
    Sheet sheet2 = workbook.createSheet("Битрикс и Аджаст(по магазину)");

    // Create a Header Row
    Row firstExcelRow = sheet2.createRow(index);

    // Create Header Cells and set their values
    Cell bitrixEmployeeIdHeader = firstExcelRow.createCell(0);
    bitrixEmployeeIdHeader.setCellValue("bitrix employee id");

    Cell bitrixEmployeeFullNameHeader = firstExcelRow.createCell(1);
    bitrixEmployeeFullNameHeader.setCellValue("bitrix employee full name");

    Cell bitrixShopNameHeader = firstExcelRow.createCell(2);
    bitrixShopNameHeader.setCellValue("bitrix shop name");

    Cell bitrixUniqueInstallsHeader = firstExcelRow.createCell(3);
    bitrixUniqueInstallsHeader.setCellValue("bitrix unique installs");

    Cell adjustUniqueInstallsHeader = firstExcelRow.createCell(4);
    adjustUniqueInstallsHeader.setCellValue("adjust unique installs");

    for (BitrixWebTablePage.EmployeeItem bitrixEmployee : bwtp.bitrixWebTable.employee_items) {
      System.out.println("bitrix user id: " + bitrixEmployee.user_id);
      System.out.println("bitrix shop id: " + bitrixEmployee.shop_id);

      // clicking on the shop (or city) with the id from bitrix
      NonShopId deliverablesPageShop = new NonShopId(String.valueOf(bitrixEmployee.shop_id));
      System.out.println(deliverablesPageShop.nonShopIdUsersTable.getRows().size());

      NonShopId.Row adjustEmployee =
          deliverablesPageShop.nonShopIdUsersTable.getRows().stream()
              .filter(
                  employee ->
                      String.valueOf(employee.adgroup)
                          .equals(String.valueOf(bitrixEmployee.user_id)))
              .findFirst()
              .orElse(null); // Provide a default value if no element is found

      Row finalExcelRow = sheet2.createRow(index + 1);

      Cell bitrixEmployeeIdCell = finalExcelRow.createCell(0);
      bitrixEmployeeIdCell.setCellValue(String.valueOf(bitrixEmployee.user_id));

      Cell bitrixEmployeeFullNameCell = finalExcelRow.createCell(1);
      bitrixEmployeeFullNameCell.setCellValue(bitrixEmployee.full_name);

      Cell bitrixShopNameCell = finalExcelRow.createCell(2);
      bitrixShopNameCell.setCellValue(bitrixEmployee.shop);

      Cell bitrixUniqueInstallsCell = finalExcelRow.createCell(3);
      bitrixUniqueInstallsCell.setCellValue(String.valueOf(bitrixEmployee.installed_count));

      Cell adjustUniqueInstallsCell = finalExcelRow.createCell(4);

      if (adjustEmployee != null) {
        System.out.println("adjust employee installs: " + adjustEmployee.install_unique_events);
        adjustUniqueInstallsCell.setCellValue(String.valueOf(adjustEmployee.install_unique_events));
      } else {
        adjustUniqueInstallsCell.setCellValue("not in adjust shop");
        System.out.println("not in adjust shop");
      }

      index += 1;
    }

    // Write the workbook to a file
    try (FileOutputStream fileOut = new FileOutputStream("errors.xlsx")) {
      workbook.write(fileOut);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  @Test
  public void checkAdjustInstalls() {

    System.out.println("starting tests...");

    DeliverablesPage dp = new DeliverablesPage();
    List<DeliverablesPage.Row> nonShopIds = dp.deliverablesTable.getRows();
    System.out.println("deliverables initialized");
    System.out.println(nonShopIds.size());

    int index = 0;

    // Create a Sheet
    Sheet sheet1 = workbook.createSheet("Installs по городу");

    // Create a Header Row
    Row firstExcelRow = sheet1.createRow(index);

    // Create Header Cells and set their values
    Cell nonShopIdCellHeader = firstExcelRow.createCell(0);
    nonShopIdCellHeader.setCellValue("non shop id");

    Cell employeeIdCellHeader = firstExcelRow.createCell(1);
    employeeIdCellHeader.setCellValue("employee id");

    Cell installUniqueEventsCellHeader = firstExcelRow.createCell(2);
    installUniqueEventsCellHeader.setCellValue("installs unique");

    Cell bitrixEmployeeNameHeader = firstExcelRow.createCell(3);
    bitrixEmployeeNameHeader.setCellValue("employee name");

    Cell bitrixEmployeeShopHeader = firstExcelRow.createCell(4);
    bitrixEmployeeShopHeader.setCellValue("employee shop");

    Cell bitrixShopIdHeader = firstExcelRow.createCell(5);
    bitrixShopIdHeader.setCellValue("shop id");

    Cell adjustInstallsShopIdHeader = firstExcelRow.createCell(6);
    adjustInstallsShopIdHeader.setCellValue("adjust installs shop id");

    Cell bitrixInstallUniqueEventsHeader = firstExcelRow.createCell(7);
    bitrixInstallUniqueEventsHeader.setCellValue("install count bitrix");

    BitrixWebTablePage bwtp = new BitrixWebTablePage();

    for (DeliverablesPage.Row row : nonShopIds) { // row.campaign
      System.out.println("============");
      System.out.println(row.campaign);
      NonShopId nid = new NonShopId(row.campaign); // row.campaign = 179

      for (NonShopId.Row nidRow : nid.nonShopIdUsersTable.getRows()) {
        System.out.println(nidRow.adgroup);
        System.out.println(nidRow.install_unique_events);

        BitrixWebTablePage.EmployeeItem bitrixEmployee =
            bwtp.bitrixWebTable.employee_items.stream()
                .filter(
                    employee ->
                        String.valueOf(employee.user_id).equals(String.valueOf(nidRow.adgroup)))
                .findFirst()
                .orElse(null); // Provide a default value if no element is found

        // Create a Row
        Row finalExcelRow = sheet1.createRow(index + 1);

        // Create a Cell and set a value
        Cell nonShopIdCell = finalExcelRow.createCell(0);
        nonShopIdCell.setCellValue(row.campaign);

        // nidRow.adgroup is employee Id
        Cell employeeIdCell = finalExcelRow.createCell(1);
        employeeIdCell.setCellValue(nidRow.adgroup);

        Cell installUniqueEventsCell = finalExcelRow.createCell(2);
        installUniqueEventsCell.setCellValue(nidRow.install_unique_events);

        Cell bitrixEmployeeNameCell = finalExcelRow.createCell(3);
        Cell bitrixEmployeeShopNameCell = finalExcelRow.createCell(4);
        Cell bitrixShopIdCell = finalExcelRow.createCell(5);
        Cell adjustInstallsShopIdCell = finalExcelRow.createCell(6);
        Cell bitrixInstallUniqueEventsCell = finalExcelRow.createCell(7);

        if (bitrixEmployee != null) {
          // Proceed with the found employee
          bitrixEmployeeNameCell.setCellValue(bitrixEmployee.full_name);
          bitrixEmployeeShopNameCell.setCellValue(bitrixEmployee.shop);
          bitrixShopIdCell.setCellValue(bitrixEmployee.shop_id);

          // pass storeId to NonShopId constructor
          NonShopId validUniqueInstallsObject = new NonShopId(bitrixEmployee.shop_id);
          // employee ids, we need to filter them
          var employeeRow =
              validUniqueInstallsObject.nonShopIdUsersTable.getRows().stream()
                  .filter(
                      employee ->
                          String.valueOf(employee.adgroup).equals(String.valueOf(nidRow.adgroup)))
                  .findFirst()
                  .orElse(null); // Provide a default value if no element is found

          var uniqueInstalls = "not identified";

          if (employeeRow != null) {
            uniqueInstalls = employeeRow.install_unique_events;
          }

          adjustInstallsShopIdCell.setCellValue(uniqueInstalls);

          bitrixInstallUniqueEventsCell.setCellValue(bitrixEmployee.installed_count);
        } else {
          // Handle the case where no employee is found
          bitrixEmployeeNameCell.setCellValue("not found");
          bitrixEmployeeShopNameCell.setCellValue("not found");
          bitrixShopIdCell.setCellValue("not found");
          bitrixInstallUniqueEventsCell.setCellValue("not found");

          // sheet.removeRow(finalExcelRow); // Remove the row
          // index -= 1;
        }

        index += 1;
      }

    }

    // Write the workbook to a file
    try (FileOutputStream fileOut = new FileOutputStream("errors.xlsx")) {
      workbook.write(fileOut);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @After
  public void saveAndCloseWorkbook() {

      try {
        workbook.close(); // Close the workbook to release resources
      } catch (IOException e) {
        e.printStackTrace();
      }

  }

}


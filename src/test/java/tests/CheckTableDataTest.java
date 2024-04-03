package tests;

import com.codeborne.selenide.SelenideElement;
import config.Props;
import org.testng.annotations.Test;
import pages.AdjustTable;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckTableDataTest extends TestsSetup {

    Props props = Props.props;

    @Test
    public void checkLogin() {
        new LoginPage();
        new AdjustTable();

    }
/*
    public static void getUniqueInstalls(){

        SelenideElement employeeIdRows =  $x("//div[@role='rowgroup']//div[@role='row']");

        //SelenideElement rowCell = $x("//div[@role='rowgroup']//div[@role='cell']");

        for(SelenideElement row : rows) {

        }
    }


/*
    public static int getCellById(int employeeId) {
        String employeeIdText = Integer.toString(employeeId);
        SelenideElement employeeIdRows =  $x("//div[@role='rowgroup']//div[@role='row']");

        SelenideElement rowCell = $x("//div[@role='rowgroup']//div[@role='cell']");

        for (int i = 0; i < employeeIdRows.size(); i++) {
            String employeeIdRow = employeeIdRows.get(i).getText(); //index
            System.out.println("employeeIdText: " + employeeIdText);
            if (employeeIdRow.equals(employeeIdText)) {
                System.out.println("The element is found!");
                return i;

            }
        }
        return -1;

    }


    public static int getUniqueInstall(int tableIndex) {
        SelenideElement tableRow = tableRows.get(tableIndex);
        SelenideElement installUniqueTableCell = tableRowData.get(5); //по факту 6, индекс -1
        String installUniqueText = installUniqueTableCell.text();
        return Integer.parseInt(installUniqueText);
    }

/*
    public static int getIndexByEmployeeId(int employeeId) {
        String employeeIdText = Integer.toString(employeeId);
        System.out.println("EmployeeId is " + employeeId);
        ElementsCollection employeeIdRows = $$x("//*[@class='tracker-link']//span");
        System.out.println("employeeIdRows: " + employeeIdRows.size());
        for (int i = 0; i < employeeIdRows.size(); i++) {
            String employeeIdRow = employeeIdRows.get(i).getText(); //index
            System.out.println("employeeIdText: " + employeeIdText);
            if (employeeIdRow.equals(employeeIdText)) {
                System.out.println("The element is found!");
                return i;
            }
        }
        return -1;
    }

    public static int getInstallUnique(int tableIndex) {
        ElementsCollection tableRows = $$x("//*[contains(@id, 'tr-value') and not(@class='tr tr-body aggregate')]");
        System.out.println("table rows size is: " + tableRows.size());
        SelenideElement tableRow = tableRows.get(tableIndex);
        ElementsCollection tableRowData = tableRow.$$x(".//*[contains(@class, 'td')]");
        System.out.println("table row data size is: " + tableRowData.size());
	System.out.println("cell position: " + Props.props.uniqueInstallsCellPosition());
        SelenideElement installUniqueTableCell = tableRowData.get(21);
	System.out.println("cell: " + installUniqueTableCell);
        String installUniqueText = installUniqueTableCell.text();
	System.out.println("installUniqueText: " + installUniqueText);
        return Integer.parseInt(installUniqueText);
    }

    @DataProvider(name = "results")
    public Object[][] PrepareTestData() {
	super.beforeEachTest();

        new LoginPage();
        new AdjustTable();

        EmployeeExcel ee = new EmployeeExcel(props.inputFile());

	int totalCount = ee.excelRows.size();
        System.out.println("total count: " + totalCount);

	// 3 columns that we need: employeeName,
	// uniqueInstallsAdjust, uniqueInstallsBitrix
	Object[][] testData = new Object[totalCount][3];

        BitrixEmployeeExcel be = new BitrixEmployeeExcel(props.checkFile());

        int index = 0;
        for (EmployeeExcel.TableRow row : ee.excelRows) {  //for each row in excel table
            System.out.println("============");
            System.out.println(row.cityId);
            System.out.println(row.employeeId);
            System.out.println(row.installCount);
            System.out.println("============");

            SelenideElement shopById = $x("//a[.//span[text()='" + row.cityId + "']]");
            shopById.click();
            String href = shopById.getAttribute("href");
            open(href);
	    sleep(8000);

            int indexEmployee = getIndexByEmployeeId(row.employeeId);
            System.out.println("indexEmployee: " + indexEmployee);
            int uniqueInstallsAdjust = getInstallUnique(indexEmployee);

            int totalSumInstallUniqueExcelAdjust = uniqueInstallsAdjust + row.installCount;
            System.out.println("total sum: " + totalSumInstallUniqueExcelAdjust);

            int uniqueInstallsBitrix = be.getUniqueInstallsByEmployeeName(row.employeeName);

	    System.out.println("sum from Bitrix: " + uniqueInstallsBitrix);

	    testData[index][0] = row.employeeName;
	    testData[index][1] = totalSumInstallUniqueExcelAdjust;
	    testData[index][2] = uniqueInstallsBitrix;
            index += 1;
	    open("https://dash.adjust.com/#/");
	    sleep(4000);
	    new AdjustTable();
        }

	return testData;

    }

    @Test(dataProvider = "results", testName = "Check that unique installs match")
    public void checkUniqueInstalls(String employeeName, int totalSumInstallUniqueExcelAdjust, int uniqueInstallsBitrix) {
        assert totalSumInstallUniqueExcelAdjust == uniqueInstallsBitrix :
                "Expected result " + employeeName + " is " + uniqueInstallsBitrix +
                        ", but actual result is " +
                        totalSumInstallUniqueExcelAdjust;
    }
*/
}

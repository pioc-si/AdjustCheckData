package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AdjustTable {
    private static SelenideElement menuDatascapeButton = $x("//div[@role='navigation']//h3/span[text()='Datascape']");
    private static SelenideElement reportsButton = $x("//div[@role='navigation']//div/span[text()='Reports']");
    private static SelenideElement deliverablesReport = $x("//a[span[contains(text(),'Deliverables')]]");
    private static SelenideElement lichiStoreButton = $x("//p[contains(@data-testid, 'LICHI Store Install Counter')]");
    private static SelenideElement thisMonthButton = $x("//div[contains(@class, 'DatePickerButton')]");
    private static SelenideElement lastMonthButton = $x("//ul[@data-testid='period-selector']/li//*[contains(text(), 'Last Month')]");
    private static SelenideElement applyDateButton = $x("//div[contains(@class, 'DatePickerContainer')]//button/span[text()='Apply']");
    private static SelenideElement reloadDataButton = $x("//button[@data-testid='dash_exp_runReport']/span[text()='Reload data']");
    private static SelenideElement correctDate = $x("//div[contains(@class, 'DatePickerButton')]/time[text()='Last Month']");




    public AdjustTable() {
        menuDatascapeButton.shouldBe(enabled).click();
        reportsButton.shouldBe(enabled).click();
        deliverablesReport.shouldBe(visible);
        System.out.println("This is element: " + deliverablesReport);
        String href = deliverablesReport.getAttribute("href");
        open(href);
        lichiStoreButton.shouldBe(enabled).click();

        chooseDate();
    }

    public void chooseDate() {
        thisMonthButton.shouldBe(enabled).click();
        lastMonthButton.shouldBe(enabled).click();
        applyDateButton.shouldBe(enabled).click();
        reloadDataButton.shouldBe(enabled).click();
        correctDate.shouldBe(exist);

    }
    
}
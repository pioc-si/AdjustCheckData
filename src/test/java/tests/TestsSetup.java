package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Props;
import helpers.AllureHelper;
import io.qameta.allure.Allure;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class TestsSetup {
    protected ChromeOptions options = new ChromeOptions();
    protected static Props props = Props.props;

    private static void setWebDriverConfiguration(ChromeOptions chromeOptions) {
        Configuration.browserCapabilities = chromeOptions;
        Configuration.browserSize = props.browserSize();
        Configuration.pageLoadTimeout = Long.parseLong(props.pageLoadTimeout());
        Configuration.timeout = Long.parseLong(props.timeout());
        Configuration.holdBrowserOpen = true;

    }

    @BeforeMethod
    public void beforeEachTest() {
        setWebDriverConfiguration(options);
        open(props.adjustUrl());
    }

    @AfterMethod
    public void afterEachTest() {
        new AllureHelper().afterTestExecution();
        Allure.step("Close webDriver", Selenide::closeWebDriver);
    }
}

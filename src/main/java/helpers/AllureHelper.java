package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

public class AllureHelper {

    public void afterTestExecution() {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png",
                Selenide.screenshot(OutputType.BYTES));
    }

}

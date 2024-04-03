package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static config.Props.props;

public class LoginPage {

    private final SelenideElement loginField = $x("//input[@name='email']");
    private final SelenideElement passwordField = $x("//input[@name='password']");
    private final SelenideElement signInButton = $x("//button[@type='submit']");


    public LoginPage() {
        loginField.shouldBe(visible).sendKeys(props.login());
        passwordField.shouldBe(visible).sendKeys(props.password());
        signInButton.shouldBe(visible).click();

    }
}

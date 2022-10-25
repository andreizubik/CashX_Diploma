package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class OTPCodePage {
    private SelenideElement smsCodeInput = $(name("password"));
    private SelenideElement continueButton = $(cssSelector("button[type=submit]"));

    public void inputSMSCode() {
        smsCodeInput.sendKeys("1111");
        continueButton.click();
    }
}

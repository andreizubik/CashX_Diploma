package pages.front;

import com.codeborne.selenide.SelenideElement;
import static_data.WebURLs;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class FrontLoginPage {

    private SelenideElement phoneNumberInput = $(name("phone_number"));
    private SelenideElement getTheCodeButton = $(cssSelector("button[type=submit]"));

    public void openLoginPage(String domain) {
        open(domain + WebURLs.frontLoginURL);
    }

    public void inputPhoneNumber(String phone) {
        phoneNumberInput.sendKeys(phone);
        getTheCodeButton.click();
    }
}

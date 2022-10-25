package pages;

import com.codeborne.selenide.SelenideElement;
import static_data.WebURLs;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class LoginPage {

    private SelenideElement phoneNumberInput = $(name("phone_number"));
    private SelenideElement getTheCodeButton = $(cssSelector("button[type=submit]"));

    public void openLoginPage(String domain) {
        open(domain+ WebURLs.loginURL);
    }

    public void inputPhoneNumber() {
        phoneNumberInput.sendKeys("711 111 111");
        getTheCodeButton.click();
    }
}

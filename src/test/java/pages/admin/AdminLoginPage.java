package pages.admin;

import com.codeborne.selenide.SelenideElement;
import static_data.WebURLs;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class AdminLoginPage {
    private SelenideElement userNameInput = $(name("username"));
    private SelenideElement passwordInput = $(name("password"));
    private SelenideElement getTheSignInButton = $(cssSelector("button[type=submit]"));

    public void openLoginPage(String domain) {
        open(domain + WebURLs.adminLoginURL);
    }

    public void inputUsername(String username) {
        userNameInput.sendKeys(username);
    }
    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void clickSignInButton() {
        getTheSignInButton.click();
    }
}

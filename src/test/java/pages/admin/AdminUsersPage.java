package pages.admin;

import com.codeborne.selenide.SelenideElement;
import static_data.WebURLs;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.*;

public class AdminUsersPage {
    private SelenideElement addFilterButton = $(cssSelector("button[aria-label='Add filter']"));
    private SelenideElement phoneNumberFilter = $(cssSelector("li[data-key='profile->phone_number']"));
    private SelenideElement phoneNumberInput = $(id("profile->phone_number"));
    private SelenideElement userTableRaw = $(cssSelector("tr[resource='users']"));

    private SelenideElement rowsPerPage = $(xpath("//p[contains(text(), 'of')]"));
    public void waitForOneRawInTable() {
        rowsPerPage.shouldHave(exactText("1-1 of 1"), Duration.ofSeconds(10));
    }

    public void openUsersPage(String domain) {
        open(domain + WebURLs.adminUsersPageURL);
        addFilterButton.shouldBe(enabled, Duration.ofSeconds(10));
    }

    public void clickAddFilterButton() {
        addFilterButton.click();
    }

    public void clickPhoneNumberFilter() {
        phoneNumberFilter.click();
    }

    public void inputPhoneNumber(String phone) {
        phoneNumberInput.sendKeys(phone);

    }

    public void clickUserTableRaw() {
        userTableRaw.click();
    }
}

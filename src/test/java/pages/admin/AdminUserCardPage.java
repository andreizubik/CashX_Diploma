package pages.admin;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.*;

public class AdminUserCardPage {
    private SelenideElement notificationsTab = $(id("scrollable-auto-tab-1"));
    private SelenideElement otpCodeMessage = $(xpath("//td[text()='sms_one_time_password']//following-sibling::td[1]"));
    private SelenideElement applicationTab = $(id("scrollable-auto-tab-5"));
    private SelenideElement applicationRequestID = $(xpath("//a[contains(@href, 'show')][1]"));
    private SelenideElement lastNameField = $(id("last_name"));
    private SelenideElement saveButton = $(name("Save"));
    public void clickOnNotificationsTab() {
        notificationsTab.click();
    }

    public String getCode() {
        String textMessage = otpCodeMessage.getText();
        return textMessage.replaceAll("[^0-9]", "");
    }

    public void openApplicationTab() {
        applicationTab.click();
    }

    public void openApplicationID() {
        applicationRequestID.click();
    }

    public void clickOnLastNameField() {
        lastNameField.click();
    }

    public void clearLastName() {
        lastNameField.clear();

    }
    public void clickOnSaveButton() {
        saveButton.click();
    }

}
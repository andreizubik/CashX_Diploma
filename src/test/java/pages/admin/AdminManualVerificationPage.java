package pages.admin;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import elements.DropDownElement;

import static com.codeborne.selenide.Selenide.$;

public class AdminManualVerificationPage {

    private SelenideElement submitButton = $(new ByText("Submit"));

    public void clickOnContactPersonVerificationDropdown() {
        new DropDownElement().successStatus("Client verification.");
    }

    public void clickOnEmployerVerificationDropdown() {
        new DropDownElement().successStatus("Contact person verification.");
    }

    public void clickOnClientVerificationConfirmed() {
        new DropDownElement().successStatus("Employer verification.");
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

}

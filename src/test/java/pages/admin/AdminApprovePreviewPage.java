package pages.admin;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.$;

public class AdminApprovePreviewPage {
    private SelenideElement submitButton = $(new ByText("Submit"));

    public void clickOnSubmitButton() {
        submitButton.click();
    }
}

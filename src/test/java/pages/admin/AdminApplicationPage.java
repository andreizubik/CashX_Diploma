package pages.admin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import elements.TableRawElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class AdminApplicationPage {

    private SelenideElement clientVerificationButton = $(new ByText("Manual verification"));
    private SelenideElement approveButton = $(new ByText("Approve"));
    private SelenideElement startProcessing = $(new ByText("Start processing"));
    private SelenideElement startProcessingDropDown = $(id("decision-engine-select"));
    private SelenideElement manualButton = $(xpath("//li[@data-value='manual']"));
    private SelenideElement submitButton = $(new ByText("Submit"));
    private SelenideElement assignVerifierButton = $(new ByText("Assign verifier"));
    private SelenideElement assignVerifierDropDown = $(id("assign-verifier-select"));
    private String selectAdminButton = "//li[text()='%s']";

    public String getRequestedPrincipal() {
        TableRawElement tableRawElement = new TableRawElement();
        return tableRawElement.getDataFromRaw("Requested principal").replaceAll("[^0-9]", "");
    }
    public String getRequestedTenor() {
        TableRawElement tableRawElement = new TableRawElement();
        return tableRawElement.getDataFromRaw("Requested tenor");
    }
    public String getState() {
        TableRawElement tableRawElement = new TableRawElement();
        return tableRawElement.getDataFromRaw("State");
    }
    public String getState(String status) {
        TableRawElement tableRawElement = new TableRawElement();
        return tableRawElement.getDataFromRaw("State", status);
    }
    public void clickOnStartProcessingButton() {
        startProcessing.click();
    }
    public void clickOnManualVerificationButton() {
        clientVerificationButton.click();
    }
    public void clickOnStartProcessingDropDown() {
        startProcessingDropDown.click();
    }
    public void clickOnManualButton() {
        manualButton.click();
    }
    public void clickOnSubmitButton() {
        submitButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        submitButton.click();
        submitButton.shouldBe(Condition.disappear, Duration.ofSeconds(5));
    }
    public void clickOnAssignVerifierButton() {
        assignVerifierButton.click();
    }
    public void clickOnAssignVerifierDropDownButton() {
        assignVerifierDropDown.click();
    }
    public void selectRootAdmin() {
        $(By.xpath(String.format(selectAdminButton, System.getProperty("username")))).click();
    }
    public void clickOnApproveButton() {
        approveButton.click();
    }

}

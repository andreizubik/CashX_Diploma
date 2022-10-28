package pages.admin;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import elements.TableRawElement;

import static com.codeborne.selenide.Selenide.$;

public class AdminApplicationPage {

    private SelenideElement clientVerificationButton = $(new ByText("Manual verification"));
    private SelenideElement approveButton = $(new ByText("Approve"));


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
    public void clickOnManualVerificationButton() {
        clientVerificationButton.click();
    }
    public void clickOnApproveButton() {
        approveButton.click();
    }



}

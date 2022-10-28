package elements;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class DropDownElement {
    private String dropDownXpath = "//span[text()='%s']//ancestor::li//div[contains(@class, 'selectMenu')]";
    private String statusXpath = "//li[@data-value='%s']";

    public void successStatus(String label) {
        String fullXpath = String.format(dropDownXpath, label);
        $(xpath(fullXpath)).click();
        String statusFullXpath = String.format(statusXpath, "success");
        $(xpath(statusFullXpath)).click();
    }
}

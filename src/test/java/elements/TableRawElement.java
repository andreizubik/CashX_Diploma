package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class TableRawElement {
    private String tableRawXpath = "//td[text()='%s']//following-sibling::td";

    public String getDataFromRaw(String label) {
        String fullXpath = String.format(tableRawXpath, label);
        SelenideElement tableRawElement = $(xpath(fullXpath));
        return tableRawElement.getText();
    }
}


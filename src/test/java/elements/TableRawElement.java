package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class TableRawElement {
    private String tableRawXpath = "//td[text()='%s']//following-sibling::td";

    public String getDataFromRaw(String label) {
        String fullXpath = String.format(tableRawXpath, label);
        SelenideElement tableRawElement = $(xpath(fullXpath));
        return tableRawElement.getText();
    }

    public String getDataFromRaw(String label, String status) {
        String fullXpath = String.format(tableRawXpath, label);
        SelenideElement tableRawElement = $(xpath(fullXpath));
        tableRawElement.shouldBe(not(Condition.exactText(status)), Duration.ofSeconds(5));
        return tableRawElement.getText();
    }
}


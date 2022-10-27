package pages.front;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.*;

public class FrontCalculatorPage {

    private ElementsCollection plusButtons = $$(xpath("//div[contains(@class, 'plus')]"));
    private ElementsCollection amountAndTermInputs = $$(tagName("input"));
    private SelenideElement applyForLoanButton = $(cssSelector("button[type=submit]"));

    private SelenideElement loanAcceptedImage = $(cssSelector("[alt=loanAccepted]"));

    public void clickOnPlusButtons() {
        applyForLoanButton.shouldBe(enabled, Duration.ofSeconds(10));
        for (SelenideElement plusButton : plusButtons
        ) {
            plusButton.shouldBe(enabled, Duration.ofSeconds(10));
            plusButton.click();
        }
    }

    public ArrayList<String> getAmountAndTerm() {
        ArrayList<String> amountAndTerms = new ArrayList<>();
        for (SelenideElement input : amountAndTermInputs
        ) {
            amountAndTerms.add(input.getValue().replaceAll("[^0-9]", ""));
        }
        return amountAndTerms;
    }

    public void clickOnApplyForLoanButton() {
        applyForLoanButton.click();
        loanAcceptedImage.shouldBe(visible, Duration.ofSeconds(10));
    }

}


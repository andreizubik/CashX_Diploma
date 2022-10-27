package pages.front;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class FrontPersonalAccountPage {
    private SelenideElement findUserName = $(xpath("//a//span"));

    public String getUserName() {
        findUserName.shouldBe(not(empty), Duration.ofSeconds(10));
        return findUserName.getText();
    }
}

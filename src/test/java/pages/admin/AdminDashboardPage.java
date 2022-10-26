package pages.admin;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class AdminDashboardPage {
    private SelenideElement profileButton = $(cssSelector("button[aria-label=Profile]"));
    public boolean isProfileButtonDisplayed() {
        profileButton.shouldBe(visible, Duration.ofSeconds(10));
        return profileButton.isDisplayed();
    }
}

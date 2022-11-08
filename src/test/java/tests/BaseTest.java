package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import tools.PropertyManager;
import tools.TestListener;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners(TestListener.class)
public class BaseTest {
    protected String domainFront;
    protected String domainAdmin;
    protected String phone;

    protected String username;
    protected String password;
    protected String otp;

    @BeforeSuite
    public void startAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeClass
    public void setUP() {
        PropertyManager propertyManager = new PropertyManager();
        domainFront = propertyManager.get("FRONTURL");
        domainAdmin = propertyManager.get("ADMINURL");
        phone = propertyManager.get("PHONE");
        username = propertyManager.get("USERNAME");
        password = propertyManager.get("PASSWORD");
        Configuration.timeout = 20000;
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}

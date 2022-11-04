package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected String domainFront;
    protected String domainAdmin;
    protected String phone;

    protected String username;
    protected String password;
    protected String otp;

    @BeforeSuite
    public void getURLs() {
        //TODO rework to read from app.properties or env variables
        domainFront = System.getProperty("frontURL");
        domainAdmin = System.getProperty("adminURL");
        phone = System.getProperty("phone");
        username = System.getProperty("username");
        password = System.getProperty("password");
        Configuration.timeout = 20000;
    }

    //TODO close browser
}

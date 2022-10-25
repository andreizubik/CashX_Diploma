package tests;

import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected String domainFront;
    protected String domainAdmin;

    @BeforeSuite
    public void getURLs() {
        domainFront = System.getProperty("FrontURL");
        domainAdmin = "https://staging-master-ke8rgq.cashx-lk.avgr.it";


    }
}

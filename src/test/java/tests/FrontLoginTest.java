package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.front.FrontPersonalAccountPage;
import steps.FrontLoginSteps;

public class FrontLoginTest extends BaseTest {

    @Test
    public void loginTest() {
        FrontLoginSteps frontLoginSteps = new FrontLoginSteps();
        frontLoginSteps.login(domainAdmin,domainFront, phone, username, password);
        FrontPersonalAccountPage personalAccountPage = new FrontPersonalAccountPage();
        Assert.assertEquals(personalAccountPage.getUserName(), "Jarod", "UserNameIsNotMatched");
    }
}

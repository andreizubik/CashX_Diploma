package tests;

import org.testng.annotations.Test;
import pages.admin.AdminDashboardPage;
import steps.AdminLoginSteps;

import static org.testng.Assert.assertTrue;

public class AdminLoginTest extends BaseTest {
    @Test
    public void loginTest() {
        AdminLoginSteps adminLoginSteps = new AdminLoginSteps();
        adminLoginSteps.login(domainAdmin, username, password);
        AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
        assertTrue(adminDashboardPage.isProfileButtonDisplayed(), "Profile Button is not displayed");
    }
}

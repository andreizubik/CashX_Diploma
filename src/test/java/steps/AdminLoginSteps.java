package steps;

import pages.admin.AdminDashboardPage;
import pages.admin.AdminLoginPage;

public class AdminLoginSteps {
    public void login(String domainAdmin, String username, String password) {
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.openLoginPage(domainAdmin);
        adminLoginPage.inputUsername(username);
        adminLoginPage.inputPassword(password);
        adminLoginPage.clickSignInButton();
        AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
        adminDashboardPage.isProfileButtonDisplayed();
    }
}

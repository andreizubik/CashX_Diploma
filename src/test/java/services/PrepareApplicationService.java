package services;

import pages.admin.AdminApplicationPage;
import pages.admin.AdminUserCardPage;
import steps.FrontCalculatorSteps;
import steps.FrontLoginSteps;
import steps.UsersPageSteps;

public class PrepareApplicationService {
    public static String prepareApplication(String domainAdmin, String domainFront, String phone, String username, String password) {
        FrontLoginSteps frontLoginSteps = new FrontLoginSteps();
        frontLoginSteps.login(domainAdmin, domainFront, phone, username, password);
        FrontCalculatorSteps frontCalculatorSteps = new FrontCalculatorSteps();
        frontCalculatorSteps.requestLoan();
        UsersPageSteps usersPageSteps = new UsersPageSteps();
        usersPageSteps.searchForUserByPhone(phone, domainAdmin);
        AdminUserCardPage adminUserCardPage = new AdminUserCardPage();
        adminUserCardPage.openApplicationTab();
        adminUserCardPage.openApplicationID();
        AdminApplicationPage adminApplicationPage = new AdminApplicationPage();
        return adminApplicationPage.getState();
    }
}

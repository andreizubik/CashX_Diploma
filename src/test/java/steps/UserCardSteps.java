package steps;

import pages.admin.AdminUserCardPage;

public class UserCardSteps {
    public String getCode() {
        AdminUserCardPage adminUserCardPage = new AdminUserCardPage();
        adminUserCardPage.clickOnNotificationsTab();
        return adminUserCardPage.getCode();

    }
}

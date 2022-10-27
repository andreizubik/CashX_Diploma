package steps;

import pages.admin.AdminUsersPage;

public class UsersPageSteps {
    public void searchForUserByPhone(String phone, String domain) {
        AdminUsersPage adminUsersPage = new AdminUsersPage();
        adminUsersPage.openUsersPage(domain);
        adminUsersPage.clickAddFilterButton();
        adminUsersPage.clickPhoneNumberFilter();
        adminUsersPage.inputPhoneNumber(phone);
        adminUsersPage.waitForOneRawInTable();
        adminUsersPage.clickUserTableRaw();
    }

}

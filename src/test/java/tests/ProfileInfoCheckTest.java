package tests;

import org.testng.annotations.Test;
import pages.admin.AdminUserCardPage;

public class ProfileInfoCheckTest extends BaseTest {
    @Test
    public void checkProfileInfoTest() {
        AdminUserCardPage adminUserCardPage = new AdminUserCardPage();
        adminUserCardPage.clickOnLastNameField();
        adminUserCardPage.clearLastName();
        adminUserCardPage.clickOnSaveButton();

    }
}
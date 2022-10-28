package steps;

import pages.admin.AdminApplicationPage;
import pages.admin.AdminApprovePreviewPage;

public class AdminAprovePreviewSteps {
    public void approveConditions() {
        AdminApplicationPage adminApplicationPage = new AdminApplicationPage();
        adminApplicationPage.clickOnApproveButton();
        AdminApprovePreviewPage adminApprovePreviewPage = new AdminApprovePreviewPage();
        adminApprovePreviewPage.clickOnSubmitButton();
    }
}

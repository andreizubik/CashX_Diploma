package steps;

import pages.admin.AdminApplicationPage;
import pages.admin.AdminManualVerificationPage;

public class AdminManualVerificationSteps {
    public void confirmConditions() {
        AdminApplicationPage applicationPage = new AdminApplicationPage();
        applicationPage.clickOnManualVerificationButton();
        AdminManualVerificationPage manualVerificationPage = new AdminManualVerificationPage();
        manualVerificationPage.clickOnClientVerificationConfirmed();
        manualVerificationPage.clickOnContactPersonVerificationDropdown();
        manualVerificationPage.clickOnEmployerVerificationDropdown();
        manualVerificationPage.clickOnSubmitButton();

    }
}

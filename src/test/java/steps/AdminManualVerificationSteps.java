package steps;

import pages.admin.AdminApplicationPage;
import pages.admin.AdminManualVerificationPage;

public class AdminManualVerificationSteps {
    public void confirmConditions() {
        AdminApplicationPage applicationPage = new AdminApplicationPage();
        applicationPage.clickOnStartProcessingButton();
        applicationPage.clickOnStartProcessingDropDown();
        applicationPage.clickOnManualButton();
        applicationPage.clickOnSubmitButton();
        applicationPage.clickOnAssignVerifierButton();
        applicationPage.clickOnAssignVerifierDropDownButton();
        applicationPage.selectRootAdmin();
        applicationPage.clickOnSubmitButton();
        applicationPage.clickOnManualVerificationButton();
        AdminManualVerificationPage manualVerificationPage = new AdminManualVerificationPage();
        manualVerificationPage.clickOnClientVerificationConfirmed();
        manualVerificationPage.clickOnContactPersonVerificationDropdown();
        manualVerificationPage.clickOnEmployerVerificationDropdown();
        manualVerificationPage.clickOnSubmitButton();

    }
}

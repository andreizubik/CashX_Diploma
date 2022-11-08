package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.admin.AdminApplicationPage;
import services.CloseAllApplications;
import services.PrepareApplicationService;
import steps.AdminManualVerificationSteps;
import steps.Adminaprovepreviewsteps;

public class ApproveLoanTest extends BaseTest {
    @BeforeClass
    public void clearApplications() {
        CloseAllApplications.closeApplications(domainAdmin, "101", username, password);
    }

    @Test
    public void approveApplicationTest() {
        PrepareApplicationService.prepareApplication(domainAdmin, domainFront, phone, username, password);
        AdminManualVerificationSteps adminManualVerificationSteps = new AdminManualVerificationSteps();
        adminManualVerificationSteps.confirmConditions();
        Adminaprovepreviewsteps adminAprovePreviewSteps = new Adminaprovepreviewsteps();
        adminAprovePreviewSteps.approveConditions();
        AdminApplicationPage adminApplicationPage = new AdminApplicationPage();
        Assert.assertEquals(adminApplicationPage.getState("processing"), "approved");
    }
}


//страница для баксов
//в серивасх добавить метод, который будет забирать код апрува (зайти в юзер кард, кликнуть на эп..)


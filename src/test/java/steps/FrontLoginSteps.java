package steps;

import pages.front.FrontLoginPage;
import pages.front.FrontOTPCodePage;
import services.GetCodeService;

public class FrontLoginSteps {
    public void login(String domainAdmin, String domainFront, String phone, String username, String password) {
        String otp = GetCodeService.getCode(domainAdmin, username, password, phone);
        FrontLoginPage frontLoginPage = new FrontLoginPage();
        frontLoginPage.openLoginPage(domainFront);
        frontLoginPage.inputPhoneNumber(phone);
        FrontOTPCodePage frontOTPCodePage = new FrontOTPCodePage();
        frontOTPCodePage.inputSMSCode(otp);
    }
}


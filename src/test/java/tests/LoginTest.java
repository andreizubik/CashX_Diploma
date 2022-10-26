package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.front.LoginPage;
import pages.front.OTPCodePage;
import pages.front.PersonalAccountPage;
import services.GetCodeService;

//����� �� https://stage-master-o6sfsg.cashx-lk.avgr.it
//� ���� Phone Number ��������� ����� �������� 711 111 111
//�������� Get the code
//� ���� SMS code ��������� ��� 1111
//�������� Continue
//��������� ��������� �� ��� ������������ Jarod

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        String code = GetCodeService.getCode(domainAdmin, username, password, phone);
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(domainFront);
        loginPage.inputPhoneNumber(phone);
        OTPCodePage otpCodePage = new OTPCodePage();
        otpCodePage.inputSMSCode(code);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        Assert.assertEquals(personalAccountPage.getUserName(), "Jarod", "UserNameIsNotMatched");
    }
}

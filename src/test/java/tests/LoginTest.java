package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OTPCodePage;
import pages.PersonalAccountPage;

public class LoginTest extends BaseTest {
    //����� �� https://stage-master-o6sfsg.cashx-lk.avgr.it
    //� ���� Phone Number ��������� ����� �������� 711 111 111
    //�������� Get the code
    //� ���� SMS code ��������� ��� 1111
    //�������� Continue
    //��������� ��������� �� ��� ������������ Jarod

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(domainFront);
        loginPage.inputPhoneNumber();
        OTPCodePage otpCodePage = new OTPCodePage();
        otpCodePage.inputSMSCode();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        Assert.assertEquals(personalAccountPage.getUserName(), "Jarod", "UserNameIsNotMatched");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OTPCodePage;
import pages.PersonalAccountPage;

public class LoginTest extends BaseTest {
    //Зайти на https://stage-master-o6sfsg.cashx-lk.avgr.it
    //В поле Phone Number указываем номер телефона 711 111 111
    //Нажимаем Get the code
    //В поле SMS code указываем ОТР 1111
    //Нажимаем Continue
    //Проверяем появилось ли имя пользователя Jarod

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

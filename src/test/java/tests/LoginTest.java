package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.front.LoginPage;
import pages.front.OTPCodePage;
import pages.front.PersonalAccountPage;
import services.GetCodeService;

//Зайти на https://stage-master-o6sfsg.cashx-lk.avgr.it
//В поле Phone Number указываем номер телефона 711 111 111
//Нажимаем Get the code
//В поле SMS code указываем ОТР 1111
//Нажимаем Continue
//Проверяем появилось ли имя пользователя Jarod

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

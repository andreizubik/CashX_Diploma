package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.front.FrontPersonalAccountPage;
import steps.FrontLoginSteps;

//Зайти на https://stage-master-o6sfsg.cashx-lk.avgr.it
//В поле Phone Number указываем номер телефона 711 111 111
//Нажимаем Get the code
//В поле SMS code указываем ОТР 1111
//Нажимаем Continue
//Проверяем появилось ли имя пользователя Jarod

public class FrontLoginTest extends BaseTest {

    @Test
    public void loginTest() {
        FrontLoginSteps frontLoginSteps = new FrontLoginSteps();
        frontLoginSteps.login(domainAdmin,domainFront, phone, username, password);
        FrontPersonalAccountPage personalAccountPage = new FrontPersonalAccountPage();
        Assert.assertEquals(personalAccountPage.getUserName(), "Jarod", "UserNameIsNotMatched");
    }
}

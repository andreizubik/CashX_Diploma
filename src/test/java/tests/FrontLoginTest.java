package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.front.FrontPersonalAccountPage;
import steps.FrontLoginSteps;

//����� �� https://stage-master-o6sfsg.cashx-lk.avgr.it
//� ���� Phone Number ��������� ����� �������� 711 111 111
//�������� Get the code
//� ���� SMS code ��������� ��� 1111
//�������� Continue
//��������� ��������� �� ��� ������������ Jarod

public class FrontLoginTest extends BaseTest {

    @Test
    public void loginTest() {
        FrontLoginSteps frontLoginSteps = new FrontLoginSteps();
        frontLoginSteps.login(domainAdmin,domainFront, phone, username, password);
        FrontPersonalAccountPage personalAccountPage = new FrontPersonalAccountPage();
        Assert.assertEquals(personalAccountPage.getUserName(), "Jarod", "UserNameIsNotMatched");
    }
}

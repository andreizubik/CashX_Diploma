package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.admin.AdminApplicationPage;
import pages.admin.AdminUserCardPage;
import services.CloseAllApplications;
import steps.*;

import java.util.ArrayList;

public class LoanApplicationFlowTest extends BaseTest {
    @BeforeClass
    public void clearApplications() {
        CloseAllApplications.closeApplications(domainAdmin, "101", username, password);
    }
    //Precondition:проверить есть ли у пользователя заявки, если есть - закрыть
    //Залогиниться в админку
    //Перейти во вкладку Users
    //Найти по номеру телефона юзера
    //Перейти во вкладку Applications
    //Проверить, есть ли заявки в статусе processed или approved
    //Если есть один из этих статусов - переходим в заявку
    //Нжаимаем Reject
    //Выставляем причину отказа - Archive (0 дней), подтвердить.

    //Тест "создание заявки"
    // *Залогиниться в аккаунт на фронте
    //Кликнуть Loan Amount и Loan Term и записать полученные значения
    //Кликнуть Apply for a loan
    //Зайти в админку
    //Перейти во вкладку Users
    //По номеру телефона найти юзера
    //Перейти во вкладку Applications
    //Проверить что заявка в статусе processing (т.е. создана)
    //Проверить совпадает ли сумма и срок в заявке с тем, что выбрали на калькуляторе


    @Test
    public void createApplicationTest() {
        FrontLoginSteps frontLoginSteps = new FrontLoginSteps();
        frontLoginSteps.login(domainAdmin, domainFront, phone, username, password);
        FrontCalculatorSteps frontCalculatorSteps = new FrontCalculatorSteps();
        ArrayList<String> amountAndTerms = frontCalculatorSteps.requestLoan();
        UsersPageSteps usersPageSteps = new UsersPageSteps();
        usersPageSteps.searchForUserByPhone(phone, domainAdmin);
        AdminUserCardPage adminUserCardPage = new AdminUserCardPage();
        adminUserCardPage.openApplicationTab();
        adminUserCardPage.openApplicationID();
        AdminApplicationPage adminApplicationPage = new AdminApplicationPage();
        String state = adminApplicationPage.getState();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(state).isEqualTo("pending");
        assertions.assertAll();
    }

    //TODO Р·Р°РІРёСЃРёРјРёС‹Рµ С‚РµСЃС‚С‹ - СЌС‚Рѕ РїР»РѕС…Рѕ
    @Test(dependsOnMethods = {"createApplicationTest"})
    //Тест:approve of application
    //создать 2 страницы (manual verification модалка и 3 элемента дропдауна, approve превью)
    //на странице application описать 2 кнопки выше
    //нажать на кнопку manual verification, проставляем все статусы конфирмд, жмем сабмит
    //нажать кнопку апрув и сабмит
    //проверяем, что заявка в статусе апрувд

    public void approveApplicationTest() {
        AdminManualVerificationSteps adminManualVerificationSteps = new AdminManualVerificationSteps();
        adminManualVerificationSteps.confirmConditions();
        Adminaprovepreviewsteps adminAprovePreviewSteps = new Adminaprovepreviewsteps();
        adminAprovePreviewSteps.approveConditions();
        AdminApplicationPage adminApplicationPage = new AdminApplicationPage();
        Assert.assertEquals(adminApplicationPage.getState("processing"), "approved");

    }
    //войти в админку в юзер кард в нотификейшнс и забрать ОТР
    //вернуться по урлу обратно на фронте
    //ввести смскод, сабмит и ассерт

    //TODO @AfterMethod СЃ СѓРґР°Р»РµРЅРёРµРј Р·Р°СЏРІРєРё С‡РµСЂРµР· Р°РґРјРёРЅРєСѓ
}

    //страница для баксов
    //в серивасх добавить метод, который будет забирать код апрува (зайти в юзер кард, кликнуть на эп..)
}
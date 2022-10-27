package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.admin.AdminUserCardPage;
import pages.admin.ApplicationPage;
import steps.FrontCalculatorSteps;
import steps.FrontLoginSteps;
import steps.UsersPageSteps;

import java.util.ArrayList;

public class LoanApplicationFlowTest extends BaseTest {
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


//Test



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
        ApplicationPage applicationPage = new ApplicationPage();
        String principal = applicationPage.getRequestedPrincipal();
        String tenor = applicationPage.getRequestedTenor();
        String state = applicationPage.getState();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(state).isEqualTo("processing");
        assertions.assertThat(principal).contains(amountAndTerms.get(0));
        assertions.assertThat(tenor).isEqualTo(amountAndTerms.get(1));
        assertions.assertAll();
    }

    @Test(dependsOnMethods = {"createApplicationTest"})
    public void approveApplicationTest() {
        //Тест:aprove of application
        //создать 2 страницы (manual verification модалка и 3 элемента дропдауна, approve превью)
        //на странице application описать 2 кнопки выше
        //нажать на кнопку manual verification, проставляем все статусы конфирмд, жмем сабмит
        //нажать кнопку апрув и сабмит
        //проверяем, что заявка в статусе апрувд
    }
}

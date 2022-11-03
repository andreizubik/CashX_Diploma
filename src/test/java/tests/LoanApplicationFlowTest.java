package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.AdminApplicationPage;
import pages.admin.AdminUserCardPage;
import steps.*;

import java.util.ArrayList;

public class LoanApplicationFlowTest extends BaseTest {
    //Precondition:��������� ���� �� � ������������ ������, ���� ���� - �������
    //������������ � �������
    //������� �� ������� Users
    //����� �� ������ �������� �����
    //������� �� ������� Applications
    //���������, ���� �� ������ � ������� processed ��� approved
    //���� ���� ���� �� ���� �������� - ��������� � ������
    //�������� Reject
    //���������� ������� ������ - Archive (0 ����), �����������.

    //���� "�������� ������"
    // *������������ � ������� �� ������
    //�������� Loan Amount � Loan Term � �������� ���������� ��������
    //�������� Apply for a loan
    //����� � �������
    //������� �� ������� Users
    //�� ������ �������� ����� �����
    //������� �� ������� Applications
    //��������� ��� ������ � ������� processing (�.�. �������)
    //��������� ��������� �� ����� � ���� � ������ � ���, ��� ������� �� ������������


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
        String principal = adminApplicationPage.getRequestedPrincipal();
        String tenor = adminApplicationPage.getRequestedTenor();
        String state = adminApplicationPage.getState();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(state).isEqualTo("pending");
        assertions.assertThat(principal).contains(amountAndTerms.get(0));
        assertions.assertThat(tenor).isEqualTo(amountAndTerms.get(1));
        assertions.assertAll();
    }

    //TODO зависимиые тесты - это плохо
    @Test(dependsOnMethods = {"createApplicationTest"})
    //����:approve of application
    //������� 2 �������� (manual verification ������� � 3 �������� ���������, approve ������)
    //�� �������� application ������� 2 ������ ����
    //������ �� ������ manual verification, ����������� ��� ������� ��������, ���� ������
    //������ ������ ����� � ������
    //���������, ��� ������ � ������� ������

    public void approveApplicationTest() {
        AdminManualVerificationSteps adminManualVerificationSteps = new AdminManualVerificationSteps();
        adminManualVerificationSteps.confirmConditions();
        AdminAprovePreviewSteps adminAprovePreviewSteps = new AdminAprovePreviewSteps();
        adminAprovePreviewSteps.approveConditions();
        AdminApplicationPage adminApplicationPage = new AdminApplicationPage();
        Assert.assertEquals(adminApplicationPage.getState("processing"), "approved");
    }

    //TODO @AfterMethod с удалением заявки через админку
}

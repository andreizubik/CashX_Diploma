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
        //����:aprove of application
        //������� 2 �������� (manual verification ������� � 3 �������� ���������, approve ������)
        //�� �������� application ������� 2 ������ ����
        //������ �� ������ manual verification, ����������� ��� ������� ��������, ���� ������
        //������ ������ ����� � ������
        //���������, ��� ������ � ������� ������
    }
}

package steps;

import pages.front.FrontCalculatorPage;

import java.util.ArrayList;

public class FrontCalculatorSteps {
    //TODO parametrize to request different loans
    public ArrayList<String> requestLoan() {
        FrontCalculatorPage frontCalculatorPage = new FrontCalculatorPage();
        frontCalculatorPage.clickOnPlusButtons();
        ArrayList<String> amountAndTerms = frontCalculatorPage.getAmountAndTerm();
        frontCalculatorPage.clickOnApplyForLoanButton();
        return amountAndTerms;
    }
}

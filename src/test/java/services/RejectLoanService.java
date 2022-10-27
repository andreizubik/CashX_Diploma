package services;

import steps.AdminLoginSteps;
import steps.UserCardSteps;
import steps.UsersPageSteps;

public class RejectLoanService {
    public static void rejectLoan(String domainAdmin, String username, String password, String phone) {
        AdminLoginSteps adminLoginSteps = new AdminLoginSteps();
        adminLoginSteps.login(domainAdmin, username, password);
        UsersPageSteps usersSteps = new UsersPageSteps();
        usersSteps.searchForUserByPhone(phone, domainAdmin);
        UserCardSteps userCardSteps = new UserCardSteps();

    }
}

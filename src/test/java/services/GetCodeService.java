package services;

import steps.AdminLoginSteps;
import steps.UserCardSteps;
import steps.UsersPageSteps;

public class GetCodeService {
    public static String getCode(String domainAdmin, String username, String password, String phone) {
        AdminLoginSteps adminLoginSteps = new AdminLoginSteps();
        adminLoginSteps.login(domainAdmin, username, password);
        UsersPageSteps usersSteps = new UsersPageSteps();
        usersSteps.searchForUserByPhone(phone,domainAdmin);
        UserCardSteps userCardSteps = new UserCardSteps();
        String code = userCardSteps.getCode();
        return code;
    }
}

package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.CloseAllApplications;
import services.PrepareApplicationService;

public class RequestLoanTest extends BaseTest {
    @BeforeClass
    public void clearApplications() {
        CloseAllApplications.closeApplications(domainAdmin, "101", username, password);
    }

    @Test
    public void createApplicationTest() {
        String state = PrepareApplicationService.prepareApplication(domainAdmin, domainFront, phone, username, password);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(state).isEqualTo("pending");
        assertions.assertAll();
    }
}


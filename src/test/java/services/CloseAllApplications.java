package services;

import io.restassured.http.ContentType;
import model.ApplicationsResponse;
import model.CancellationModel;
import model.CancellationParams;
import model.LoginModel;

import java.util.List;

import static io.restassured.RestAssured.given;
import static static_data.WebURLs.*;
import static static_data.WebURLs.makeTransaction;

public class CloseAllApplications {
    public static void closeApplications(String apiURL, String userId, String adminUserName, String adminPassword) {
        LoginModel loginModel = LoginModel
                .builder()
                .username(adminUserName)
                .password(adminPassword)
                .build();

        String token = given()
                .contentType(ContentType.JSON)
                .header("x-auth-ctx","admin")
                .body(loginModel)
                .post(apiURL.concat(apiAdminLogin))
                .then().extract().path("token");

        List<ApplicationsResponse> userApplications = given()
                .contentType(ContentType.JSON)
                .header("x-auth-token", token)
                .param("user.id", userId)
                .param("order[id]", "DESC")
                .param("items_per_page", "100")
                .get(apiURL.concat(allApplications))
                .then()
                .extract()
                .jsonPath()
                .getList("", ApplicationsResponse.class);
        if (userApplications.size()!=0) {
            for (ApplicationsResponse application:
                    userApplications) {
                if(application.getState().equals("pending")) {
                    String contentUrl = String.format(makeTransaction, application.getId());
                    given().contentType(ContentType.JSON)
                            .header("x-auth-token", token)
                            .body("{\"name\":\"start_processing\",\"params\":{\"decision_engine_id\":\"manual\"}}")
                            .post(apiURL.concat(contentUrl));

                    given().contentType(ContentType.JSON)
                            .header("x-auth-token", token)
                            .body("{\"name\":\"assign_verifier\",\"params\":{\"verifier_id\":1}}")
                            .post(apiURL.concat(contentUrl));

                    given().contentType(ContentType.JSON)
                            .header("x-auth-token", token)
                            .body("{\"name\":\"reject\",\"params\":{\"rejection_reason_code\":43}}")
                            .post(apiURL.concat(contentUrl));
                } if (application.getState().equals("processing")) {
                    String contentUrl = String.format(makeTransaction, application.getId());
                    if(application.getVerifierUsername() == null) {
                        given().contentType(ContentType.JSON)
                                .header("x-auth-token", token)
                                .body("{\"name\":\"assign_verifier\",\"params\":{\"verifier_id\":1}}")
                                .post(apiURL.concat(contentUrl));
                    }
                    given().contentType(ContentType.JSON)
                            .header("x-auth-token", token)
                            .body("{\"name\":\"reject\",\"params\":{\"rejection_reason_code\":43}}")
                            .post(apiURL.concat(contentUrl));
                } if (application.getState().equals("approved")) {
                    CancellationModel cancellationModel = CancellationModel.builder()
                            .name("cancel")
                            .params(CancellationParams.builder().build())
                            .build();
                    String contentUrl = String.format(makeTransaction, application.getId());
                    given().contentType(ContentType.JSON)
                            .header("x-auth-token", token)
                            .body(cancellationModel)
                            .post(apiURL.concat(contentUrl));
                }
            }
        }

    }
 }

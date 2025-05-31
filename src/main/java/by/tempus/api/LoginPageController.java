package by.tempus.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginPageController {

    private String BASE_URL = "https://tempus.by";
    private String LOGIN_URL = BASE_URL + "/bitrix/services/main/ajax.php";

    private Response response;

    public LoginPageController(String email, String password) {
        response = getPostResponseLogin(email, password);
    }

//    public LoginPageController(String email) {
//        response = getPostResponseLogin(email);
//    }
//
//    public LoginPageController(String password) {
//        response = getPostResponseLogin(password);
//    }


    private Response getPostResponseLogin(String email, String password) {
        Response response = getPostResponseLogin(LOGIN_URL, getQueryParams(), getFormParams(email, password));

        return response;
    }

//    private Response getPostResponseLogin(String email) {
//        Response response = getPostResponseLogin(LOGIN_URL, getQueryParams(), getFormParams(email));
//
//        return response;
//    }
//
//    private Response getPostResponseLogin(String password) {
//        Response response = getPostResponseLogin(LOGIN_URL, getQueryParams(), getFormParams(password));
//
//        return response;
//    }

    private Response getPostResponseLogin(String endpoint, Map<String, String> queryParams, Map<String, String> formParams) {
        Response response = given()
                .queryParams(queryParams)
                .formParams(formParams)
                .when().post(endpoint);

        return response;
    }

    public int getStatusCode() {

        return response.statusCode();
    }

    public String getTextErrorMessage() {
        return response.path("errors[0].message");
    }

    private static Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", "imedia:main.api.Auth.loginByEmail");
        return queryParams;
    }

    private static Map<String, String> getFormParams(String email, String password) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("email", email);
        formParams.put("password", password);

        return formParams;
    }

//    private static Map<String, String> getFormParams(String password) {
//        Map<String, String> formParams = new HashMap<>();
//        formParams.put("password", password);
//
//        return formParams;
//    }
//
//
//    private static Map<String, String> getFormParams(String email) {
//        Map<String, String> formParams = new HashMap<>();
//        formParams.put("email", email);
//
//        return formParams;
//    }
}

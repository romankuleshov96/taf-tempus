package by.tempus.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginFormController extends BaseController {

    private String LOGIN_URL = BASE_URL + "/bitrix/services/main/ajax.php";

    public LoginFormController() {
    }

    protected Response getPostResponseLogin(String email, String password) {
        Response response = getPostResponseLogin(LOGIN_URL, getQueryParams(), getFormParams(email, password));

        return response;
    }

    protected Response getPostResponseLoginEmailOnly(String email) {
        Response response = getPostResponseLogin(LOGIN_URL, getQueryParams(), getFormParamsByEmail(email));

        return response;
    }

    protected Response getPostResponseLoginPasswordOnly(String password) {
        Response response = getPostResponseLogin(LOGIN_URL, getQueryParams(), getFormParamsByPassword(password));

        return response;
    }

    public int getStatusCode(Response response) {

        return response.statusCode();
    }

    public String getTextErrorMessage(Response response) {
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

    private static Map<String, String> getFormParamsByPassword(String password) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("password", password);

        return formParams;
    }


    private static Map<String, String> getFormParamsByEmail(String email) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("email", email);

        return formParams;
    }
}

package by.tempus.api.login;

import by.tempus.api.BaseController;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginApiController extends BaseController {

    private static String LOGIN_QUERY_PARAM = BASE_QUERY_PARAM + "loginByEmail";

    public LoginApiController() {
    }

    public static Response getPostResponseLogin(String email, String password) {
        return getPostResponse(getQueryParams(LOGIN_QUERY_PARAM), getFormParams(email, password));
    }

    public static Response getPostResponseLoginEmailOnly(String email) {
        return getPostResponse(getQueryParams(LOGIN_QUERY_PARAM), getFormParamsByEmail(email));
    }

    public static Response getPostResponseLoginPasswordOnly(String password) {
        return getPostResponse(getQueryParams(LOGIN_QUERY_PARAM), getFormParamsByPassword(password));
    }

    public static Response getPostResponseLoginWithoutKeys() {
        return getPostResponse(getQueryParams(LOGIN_QUERY_PARAM), new HashMap<>());
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

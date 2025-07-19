package by.tempus.api.reset.password;

import by.tempus.api.BaseController;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ResetPasswordApiController extends BaseController {

    private static String RESET_PASSWORD_QUERY_PARAM = BASE_QUERY_PARAM + "restore";

    public ResetPasswordApiController() {
    }

    public static Response getPostResponseResetPassword(String email) {
        return getPostResponse(getQueryParams(RESET_PASSWORD_QUERY_PARAM), getFormParams(email));
    }

    public static Response getPostResponseResetPasswordWithoutKey() {
        return getPostResponse(getQueryParams(RESET_PASSWORD_QUERY_PARAM), new HashMap<>());
    }

    private static Map<String, String> getFormParams(String email) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("email", email);

        return formParams;
    }
}

package by.tempus.api.registration;

import by.tempus.api.BaseController;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RegistrationApiController extends BaseController {

    private static String REGISTRATION_QUERY_PARAM = BASE_QUERY_PARAM + "registration";

    public RegistrationApiController() {
    }

    public static Response getPostResponseRegistration(String fullName, String email, String phone, String password, String passwordRepeat) {
        return getPostResponse(getQueryParams(REGISTRATION_QUERY_PARAM),
                getFormParams(fullName, email, phone, password, passwordRepeat));
    }

    public static Response getPostResponseRegistrationWithoutKeys() {
        return getPostResponse(getQueryParams(REGISTRATION_QUERY_PARAM), new HashMap<>());
    }

    private static Map<String, String> getFormParams(String fullName, String email, String phone, String password, String passwordRepeat) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("fullName", fullName);
        formParams.put("email", email);
        formParams.put("phone", phone);
        formParams.put("password", password);
        formParams.put("passwordRepeat", passwordRepeat);

        return formParams;
    }
}

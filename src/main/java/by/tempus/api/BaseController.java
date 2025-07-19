package by.tempus.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseController {

    protected static String BASE_URL = "https://tempus.by";
    protected static String API_BASE_URL = BASE_URL + "/bitrix/services/main/ajax.php";
    protected static String BASE_QUERY_PARAM = "imedia:main.api.Auth.";

    protected static Response getPostResponse(Map<String, String> queryParams, Map<String, String> formParams) {
        Response response = given()
                .queryParams(queryParams)
                .formParams(formParams)
                .when()
                .post(API_BASE_URL);

        return response;
    }

    protected static Map<String, String> getQueryParams(String queryParamsValue) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", queryParamsValue);
        return queryParams;
    }

    public static int getStatusCode(Response response) {
        return response.statusCode();
    }

    public static String getTextErrorMessage(Response response) {
        return response.path("errors[0].message");
    }
}

package by.tempus.api;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseController {

    protected String BASE_URL = "https://tempus.by";

    protected Response getPostResponseLogin(String endpoint, Map<String, String> queryParams, Map<String, String> formParams) {
        Response response = given()
                .queryParams(queryParams)
                .formParams(formParams)
                .when().post(endpoint);

        return response;
    }
}

package by.tempus.api;

import by.tempus.api.reset.password.ResetPasswordApiController;
import by.tempus.api.reset.password.ResetPasswordApiMessages;
import by.tempus.utils.CredentialGenerators;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static by.tempus.api.BaseController.getStatusCode;
import static by.tempus.api.BaseController.getTextErrorMessage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResetPasswordApiTest {

    private Response response;
    private String email;

    @BeforeEach
    public void setup() {
        email = CredentialGenerators.getValidEmail();
    }

    @Test
    @DisplayName("Reset Password - Verify API response to request with non-existent credential values")
    public void testNotExistedCredentials() {
        response = ResetPasswordApiController.getPostResponseResetPassword(email);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(ResetPasswordApiMessages.NOT_EXISTED_USER, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Reset Password - Verify API response to request with invalid email format value")
    public void testInvalidEmailFormat() {
        String emailWithoutDomainPart = CredentialGenerators.getInvalidEmailWithoutDomainZonePart();
        response = ResetPasswordApiController.getPostResponseResetPassword(emailWithoutDomainPart);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(ResetPasswordApiMessages.INVALID_EMAIL_FORMAT, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Reset Password - Verify API response to request with empty email value")
    public void testEmptyEmailField() {
        response = ResetPasswordApiController.getPostResponseResetPassword(null);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(ResetPasswordApiMessages.EMPTY_EMAIL_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Reset Password - Verify API response to request without email key in FormParams")
    public void testWithoutEmailKey() {
        response = ResetPasswordApiController.getPostResponseResetPasswordWithoutKey();

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(ResetPasswordApiMessages.KEY_EMAIL_NOT_FOUND, getTextErrorMessage(response))
        );
    }
}

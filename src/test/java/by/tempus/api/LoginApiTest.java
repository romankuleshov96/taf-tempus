package by.tempus.api;

import by.tempus.api.login.LoginApiController;
import by.tempus.api.login.LoginApiMessages;
import by.tempus.utils.CredentialGenerators;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static by.tempus.api.login.LoginApiController.getStatusCode;
import static by.tempus.api.login.LoginApiController.getTextErrorMessage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginApiTest {

    private Response response;
    private String email;
    private String password;

    @BeforeEach
    public void setup() {
        email = CredentialGenerators.getValidEmail();
        password = CredentialGenerators.getValidPassword();
    }

    @Test
    @DisplayName("Login - Verify API response to request with non-existent credential values")
    public void testNotExistedCredentials() {
        response = LoginApiController.getPostResponseLogin(email, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.NOT_EXISTED_USER, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Login - Verify API response to request with invalid email format value")
    public void testInvalidEmailFormat() {
        String emailWithoutDomainPart = CredentialGenerators.getInvalidEmailWithoutDomainZonePart();

        response = LoginApiController.getPostResponseLogin(emailWithoutDomainPart, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.INVALID_EMAIL_FORMAT, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Login - Verify API response to request with empty email value")
    public void testEmptyEmailField() {
        response = LoginApiController.getPostResponseLogin(null, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.EMPTY_EMAIL_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Login - Verify API response to request with empty password value")
    public void testEmptyPasswordField() {
        response = LoginApiController.getPostResponseLogin(email, null);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.EMPTY_PASSWORD_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Login - Verify API response to request with empty email and password values")
    public void testEmptyEmailAndPasswordFields() {
        response = LoginApiController.getPostResponseLogin(null, null);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.EMPTY_EMAIL_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Login - Verify API response to request without email key in FormParams")
    public void testWithoutEmailKey() {
        response = LoginApiController.getPostResponseLoginPasswordOnly(password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.KEY_EMAIL_NOT_FOUND, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Login - Verify API response to request without password key in FormParams")
    public void testWithoutPasswordKey() {
        response = LoginApiController.getPostResponseLoginEmailOnly(email);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.KEY_PASSWORD_NOT_FOUND, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Login - Verify API response to request without email and password keys in FormParams")
    public void testWithoutEmailAndPasswordKeys() {
        response = LoginApiController.getPostResponseLoginWithoutKeys();

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(LoginApiMessages.KEY_EMAIL_NOT_FOUND, getTextErrorMessage(response))
        );
    }
}

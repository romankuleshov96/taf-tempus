package by.tempus.api;

import by.tempus.api.registration.RegistrationApiController;
import by.tempus.api.registration.RegistrationApiMessages;
import by.tempus.utils.CredentialGenerators;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static by.tempus.api.BaseController.getStatusCode;
import static by.tempus.api.BaseController.getTextErrorMessage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationApiTest {

    private Response response;
    private String fullName;
    private String email;
    private String phone;
    private String password;

    @BeforeEach
    public void setup() {
        fullName = CredentialGenerators.getName();
        email = CredentialGenerators.getValidEmail();
        phone = CredentialGenerators.getValidBelarusPhoneNumber();
        password = CredentialGenerators.getValidPassword();
    }

    @Test
    @DisplayName("Registration - Verify API response to request with empty full name value")
    public void testEmptyFullNameValue() {
        response = RegistrationApiController.getPostResponseRegistration(null, email, phone, password, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.EMPTY_FULL_NAME_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with empty email value")
    public void testEmptyEmailValue() {
        response = RegistrationApiController.getPostResponseRegistration(fullName, null, phone, password, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.EMPTY_EMAIL_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with empty phone value")
    public void testEmptyPhoneValue() {
        response = RegistrationApiController.getPostResponseRegistration(fullName, email, null, password, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.EMPTY_PHONE_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with empty password value")
    public void testEmptyPasswordValue() {
        response = RegistrationApiController.getPostResponseRegistration(fullName, email, phone, null, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.EMPTY_PASSWORD_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with empty repeat password value")
    public void testEmptyRepeatPasswordValue() {
        response = RegistrationApiController.getPostResponseRegistration(fullName, email, phone, password, null);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.PASSWORD_NOT_MATCHED, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with invalid email format value")
    public void testInvalidEmailFormat() {
        String emailWithoutDomainPart = CredentialGenerators.getInvalidEmailWithoutDomainZonePart();

        response = RegistrationApiController.getPostResponseRegistration(fullName, emailWithoutDomainPart, phone, password, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.INVALID_EMAIL_FORMAT, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with invalid phone value")
    public void testInvalidPhoneValue() {
        String invalidPhoneNumber = CredentialGenerators.getInvalidBelarusPhoneNumber();

        response = RegistrationApiController.getPostResponseRegistration(fullName, email, invalidPhoneNumber, password, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.INVALID_PHONE_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with not required password value")
    public void testNotRequiredPasswordValue() {
        String invalidPassword = CredentialGenerators.getInvalidPassword();

        response = RegistrationApiController.getPostResponseRegistration(fullName, email, phone, invalidPassword, invalidPassword);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.NOT_REQUIRED_PASSWORD_VALUE, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with not not matched password values")
    public void testNotMatchedPasswordValue() {
        String differentPassword = CredentialGenerators.getValidPassword();

        response = RegistrationApiController.getPostResponseRegistration(fullName, email, phone, password, differentPassword);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.PASSWORD_NOT_MATCHED, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request with used phone number value")
    public void testUsedPhoneNumberValue() {
        String usedPhoneNumber = "+375291234567";

        response = RegistrationApiController.getPostResponseRegistration(fullName, email, usedPhoneNumber, password, password);

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.ALREADY_USED_PHONE_NUMBER, getTextErrorMessage(response))
        );
    }

    @Test
    @DisplayName("Registration - Verify API response to request without all keys in FormParams")
    public void testWithoutKeys() {
        response = RegistrationApiController.getPostResponseRegistrationWithoutKeys();

        assertAll(
                () -> assertEquals(200, getStatusCode(response), "Status code should be 200"),
                () -> assertEquals(RegistrationApiMessages.KEY_FULL_NAME_NOT_FOUND, getTextErrorMessage(response))
        );
    }
}

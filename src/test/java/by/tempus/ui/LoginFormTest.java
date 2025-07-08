package by.tempus.ui;

import by.tempus.pages.Header;
import by.tempus.pages.login.LoginForm;
import by.tempus.pages.login.LoginFormLocalizations;
import by.tempus.pages.registration.RegistrationForm;
import by.tempus.pages.reset.password.ResetPasswordForm;
import by.tempus.utils.CredentialGenerators;
import by.tempus.utils.Waits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginFormTest extends BaseTest{

    private String email;
    private String invalidEmail;
    private String password;

    public Header header;
    public LoginForm loginForm;

    @BeforeEach
    public void setup() {
        email = CredentialGenerators.getValidEmail();
        invalidEmail = CredentialGenerators.getInvalidEmailWithoutDomenZonePart();
        password = CredentialGenerators.getValidPassword();

        header = new Header();
        header.clickAccountButton();
        loginForm = new LoginForm();

        Waits.waitUntilElementIsDisplayed(loginForm.getLoginTitle());
    }

    @Test
    @DisplayName("Verify all elements text - Login form")
    public void testLoginFormUIElementsText() {
        assertAll(
                () -> assertEquals(LoginFormLocalizations.LOGIN_TITLE, loginForm.getTextLoginTitle()),
                () -> assertEquals(LoginFormLocalizations.REGISTRATION_TITLE, loginForm.getTextRegistrationTitle()),
                () -> assertEquals(LoginFormLocalizations.EMAIL_FIELD_PLACEHOLDER, loginForm.getTextEmailFieldPlaceholder()),
                () -> assertEquals(LoginFormLocalizations.PASSWORD_FIELD_PLACEHOLDER, loginForm.getTextPasswordFieldPlaceholder()),
                () -> assertEquals(LoginFormLocalizations.RESET_PASSWORD_BUTTON, loginForm.getTextResetPasswordButton()),
                () -> assertEquals(LoginFormLocalizations.SUBMIT_BUTTON, loginForm.getTextSubmitButton())
        );
    }

    @Test
    @DisplayName("Verify validation messages for all empty fields")
    public void testEmptyEmailAndPasswordFieldsValidationText() {
        loginForm.clickSubmitButton();

        assertEquals(LoginFormLocalizations.EMAIL_FIELD_VALIDATION_MESSAGE, loginForm.getTextEmailFieldValidationMessage());
        assertEquals(LoginFormLocalizations.PASSWORD_FIELD_VALIDATION_MESSAGE, loginForm.getTextPasswordFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation message for empty 'Email' field")
    public void testEmptyEmailFieldValidationText() {
        loginForm.sendKeysPasswordField(password);
        loginForm.clickSubmitButton();

        assertEquals(LoginFormLocalizations.EMAIL_FIELD_VALIDATION_MESSAGE, loginForm.getTextEmailFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation message for empty 'Password' field")
    public void testEmptyPasswordFieldValidationText() {
        loginForm.sendKeysEmailField(email);
        loginForm.clickSubmitButton();

        assertEquals(LoginFormLocalizations.PASSWORD_FIELD_VALIDATION_MESSAGE, loginForm.getTextPasswordFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation message for invalid email format value")
    public void testInvalidEmailFormatValueValidationText() {
        loginForm.sendKeysEmailField(invalidEmail);
        loginForm.sendKeysPasswordField(password);
        loginForm.clickSubmitButton();

        assertEquals(LoginFormLocalizations.INVALID_EMAIL_VALIDATION_MESSAGE, loginForm.getTextEmailFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation message for not existed user value")
    public void testNotExistedUserValueValidationText() {
        loginForm.sendKeysEmailField(email);
        loginForm.sendKeysPasswordField(password);
        loginForm.clickSubmitButton();

        Waits.waitUntilElementIsDisplayed(loginForm.getErrorPopup());

        assertEquals(LoginFormLocalizations.ERROR_POPUP, loginForm.getTextErrorPopup());
    }

    @Test
    @DisplayName("Verify redirection to Reset Password form")
    public void testResetPasswordFormRedirection() {
        ResetPasswordForm resetPasswordForm = loginForm.clickReetPasswordButton();

        assertTrue(resetPasswordForm.isResetPasswordFormDisplayed());
    }

    @Test
    @DisplayName("Verify redirection to Registration form")
    public void testRegistrationFormRedirection() {
        RegistrationForm registrationForm = loginForm.clickRegistrationTitle();

        assertTrue(registrationForm.isRegistrationFormDisplayed());
    }
}

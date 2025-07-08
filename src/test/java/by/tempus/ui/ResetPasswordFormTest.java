package by.tempus.ui;

import by.tempus.pages.Header;
import by.tempus.pages.login.LoginForm;
import by.tempus.pages.login.LoginFormLocalizations;
import by.tempus.pages.registration.RegistrationForm;
import by.tempus.pages.reset.password.ResetPasswordForm;
import by.tempus.pages.reset.password.ResetPasswordLocalizations;
import by.tempus.utils.CredentialGenerators;
import by.tempus.utils.Waits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResetPasswordFormTest extends BaseTest {

    private String email;
    private String invalidEmail;

    public Header header;
    public ResetPasswordForm resetPasswordForm;

    @BeforeEach
    public void setup() {
        email = CredentialGenerators.getValidEmail();
        invalidEmail = CredentialGenerators.getInvalidEmailWithoutDomenZonePart();

        header = new Header();
        header.clickAccountButton();
        resetPasswordForm = new LoginForm().clickReetPasswordButton();
    }

    @Test
    @DisplayName("Verify all elements text - Reset password form")
    public void testResetPasswordFormUIElementsText() {
        assertAll(
                () -> assertEquals(LoginFormLocalizations.LOGIN_TITLE, resetPasswordForm.getTextLoginTitle()),
                () -> assertEquals(LoginFormLocalizations.REGISTRATION_TITLE, resetPasswordForm.getTextRegistrationTitle()),
                () -> assertEquals(ResetPasswordLocalizations.RESTORE_PASSWORD_TITLE, resetPasswordForm.getTextRestorePasswordTitle()),
                () -> assertEquals(ResetPasswordLocalizations.EMAIL_FIELD_PLACEHOLDER, resetPasswordForm.getTextEmailFieldPlaceholder()),
                () -> assertEquals(ResetPasswordLocalizations.SUBMIT_RESET_PASSWORD_BUTTON, resetPasswordForm.getTextSubmitResetPasswordButton())
        );
    }

    @Test
    @DisplayName("Verify validation message for empty 'Email' field")
    public void testEmptyEmailFieldValidationText() {
        resetPasswordForm.clickSubmitResetPasswordButton();

        assertEquals(ResetPasswordLocalizations.EMAIL_FIELD_VALIDATION_MESSAGE, resetPasswordForm.getTextEmailFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation message for invalid email format value")
    public void testInvalidEmailFormatValueValidationText() {
        resetPasswordForm.sendKeysEmailField(invalidEmail);
        resetPasswordForm.clickSubmitResetPasswordButton();

        assertEquals(ResetPasswordLocalizations.INVALID_EMAIL_VALIDATION_MESSAGE, resetPasswordForm.getTextEmailFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation message for not existed user value")
    public void testNotExistedUserValueValidationText() {
        resetPasswordForm.sendKeysEmailField(email);
        resetPasswordForm.clickSubmitResetPasswordButton();

        Waits.waitUntilElementIsDisplayed(resetPasswordForm.getValidationPopup());
        assertEquals(ResetPasswordLocalizations.INVALID_DATA_VALIDATION_POPUP, resetPasswordForm.getTextValidationPopup());
    }

    @Test
    @DisplayName("Verify redirection to Login form")
    public void testLoginFormRedirection() {
        LoginForm loginForm = resetPasswordForm.clickLoginTitle();

        assertTrue(loginForm.isLoginFormDisplayed());
    }

    @Test
    @DisplayName("Verify redirection to Registration form")
    public void testRegistrationFormRedirection() {
        RegistrationForm registrationForm = resetPasswordForm.clickRegistrationTitle();

        assertTrue(registrationForm.isRegistrationFormDisplayed());
    }
}

package by.tempus.ui;

import by.tempus.pages.Header;
import by.tempus.pages.login.LoginForm;
import by.tempus.pages.login.LoginFormLocalizations;
import by.tempus.pages.registration.RegistrationForm;
import by.tempus.pages.registration.RegistrationFormLocalizations;
import by.tempus.utils.CredentialGenerators;
import by.tempus.driver.Waits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationFormTest extends BaseTest {

    private final static String EXISTED_EMAIL = "test@test.com";
    private final static String EXISTED_PHONE_NUMBER = "+375291234567";

    private String email;
    private String invalidEmail;
    private String phone;
    private String invalidPhone;
    private String password;
    private String invalidPassword;
    private String name;

    public Header header;
    public RegistrationForm registrationForm;

    @BeforeEach
    public void setup() {
        email = CredentialGenerators.getValidEmail();
        invalidEmail = CredentialGenerators.getInvalidEmailWithoutDomainZonePart();
        phone = CredentialGenerators.getValidBelarusPhoneNumber();
        invalidPhone = CredentialGenerators.getInvalidBelarusPhoneNumber();
        password = CredentialGenerators.getValidPassword();
        invalidPassword = CredentialGenerators.getInvalidPassword();
        name = CredentialGenerators.getName();

        header = new Header();
        header.clickAccountButton();
        registrationForm = new LoginForm().clickRegistrationTitle();
    }

    @Test
    @DisplayName("Verify all elements text - Registration form")
    public void testRegistrationFormUIElementsText() {
        assertAll(
                () -> assertEquals(LoginFormLocalizations.LOGIN_TITLE, registrationForm.getTextLoginTitle()),
                () -> assertEquals(LoginFormLocalizations.REGISTRATION_TITLE, registrationForm.getTextRegistrationTitle()),
                () -> assertEquals(RegistrationFormLocalizations.NAME_FIELD_PLACEHOLDER, registrationForm.getTextNameFieldPlaceholder()),
                () -> assertEquals(RegistrationFormLocalizations.EMAIL_FIELD_PLACEHOLDER, registrationForm.getTextEmailFieldPlaceholder()),
                () -> assertEquals(RegistrationFormLocalizations.PHONE_FIELD_PLACEHOLDER, registrationForm.getTextPhoneFieldPlaceholder()),
                () -> assertEquals(RegistrationFormLocalizations.PASSWORD_FIELD_PLACEHOLDER, registrationForm.getTextPasswordFieldPlaceholder()),
                () -> assertEquals(RegistrationFormLocalizations.REPEAT_PASSWORD_FIELD_PLACEHOLDER, registrationForm.getTextRepeatPasswordFieldPlaceholder()),
                () -> assertEquals(RegistrationFormLocalizations.AGREEMENT_TEXT, registrationForm.getTextAgreementText()),
                () -> assertEquals(RegistrationFormLocalizations.SUBMIT_REGISTRATION_BUTTON, registrationForm.getTextSubmitRegistrationButton())
        );
    }

    @Test
    @DisplayName("Verify validation messages for all empty fields")
    public void testAllEmptyFieldsValidationText() {
        registrationForm.clickRegistrationButton();

        assertAll(
                () -> assertEquals(RegistrationFormLocalizations.NAME_FIELD_VALIDATION_MESSAGE, registrationForm.getTextNameFieldValidationMessage()),
                () -> assertEquals(RegistrationFormLocalizations.EMAIL_FIELD_VALIDATION_MESSAGE, registrationForm.getTextEmailFieldValidationMessage()),
                () -> assertEquals(RegistrationFormLocalizations.INVALID_PHONE_VALIDATION_MESSAGE, registrationForm.getTextPhoneFieldValidationMessage()),
                () -> assertEquals(RegistrationFormLocalizations.PASSWORD_FIELD_VALIDATION_MESSAGE, registrationForm.getTextPasswordFieldValidationMessage()),
                () -> assertEquals(RegistrationFormLocalizations.AGREEMENT_CHECK_BOX_VALIDATION_MESSAGE, registrationForm.getTextAgreementCheckBoxValidationMessage())
        );
    }

    @Test
    @DisplayName("Verify validation message for invalid email format value")
    public void testInvalidEmailFormatValueValidationText() {
        registrationForm.sendKeysEmailField(invalidEmail);
        registrationForm.clickAgreementCheckBox();
        registrationForm.clickRegistrationButton();

        assertEquals(RegistrationFormLocalizations.INVALID_EMAIL_VALIDATION_MESSAGE, registrationForm.getTextEmailFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation for invalid phone value")
    public void testInvalidPhoneValueValidationText() {
        registrationForm.sendKeysPhoneField(invalidPhone);
        registrationForm.clickRegistrationButton();

        assertEquals(RegistrationFormLocalizations.INVALID_PHONE_VALIDATION_MESSAGE, registrationForm.getTextPhoneFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation for not matched password values")
    public void testNotMatchedPasswordValuesValidationText() {
        registrationForm.sendKeysPasswordField(password);
        registrationForm.sendKeysRepeatPasswordField(password + 1);
        registrationForm.clickRegistrationButton();

        assertEquals(RegistrationFormLocalizations.REPEAT_PASSWORD_FIELD_VALIDATION_MESSAGE, registrationForm.getTextRepeatPasswordFieldValidationMessage());
    }

    @Test
    @DisplayName("Verify validation for not required password values")
    public void testNotRequiredPasswordValuesValidationText() {
        registrationForm.sendKeysNameField(name);
        registrationForm.sendKeysEmailField(email);
        registrationForm.sendKeysPhoneField(phone);
        registrationForm.sendKeysPasswordField(invalidPassword);
        registrationForm.sendKeysRepeatPasswordField(invalidPassword);
        registrationForm.clickAgreementCheckBox();
        registrationForm.clickRegistrationButton();

        Waits.waitUntilElementIsDisplayed(registrationForm.getValidationPopup());
        assertEquals(RegistrationFormLocalizations.PASSWORD_VALIDATION_POPUP, registrationForm.getTextValidationPopup());
    }

    @Test
    @DisplayName("Verify validation for existed Email value")
    public void testExistedEmailValueValidationText() {
        registrationForm.sendKeysNameField(name);
        registrationForm.sendKeysEmailField(EXISTED_EMAIL);
        registrationForm.sendKeysPhoneField(phone);
        registrationForm.sendKeysPasswordField(password);
        registrationForm.sendKeysRepeatPasswordField(password);
        registrationForm.clickAgreementCheckBox();
        registrationForm.clickRegistrationButton();

        Waits.waitUntilElementIsDisplayed(registrationForm.getValidationPopup());
        assertEquals(RegistrationFormLocalizations.EXISTED_EMAIL_VALIDATION_POPUP, registrationForm.getTextValidationPopup());
    }

    @Test
    @DisplayName("Verify validation for existed Phone value")
    public void testExistedPhoneValueValidationText() {
        registrationForm.sendKeysNameField(name);
        registrationForm.sendKeysEmailField(email);
        registrationForm.sendKeysPhoneField(EXISTED_PHONE_NUMBER);
        registrationForm.sendKeysPasswordField(password);
        registrationForm.sendKeysRepeatPasswordField(password);
        registrationForm.clickAgreementCheckBox();
        registrationForm.clickRegistrationButton();

        Waits.waitUntilElementIsDisplayed(registrationForm.getValidationPopup());
        assertEquals(RegistrationFormLocalizations.EXISTED_PHONE_VALIDATION_POPUP, registrationForm.getTextValidationPopup());
    }

    @Test
    @DisplayName("Verify redirection to Login form")
    public void testLoginFormRedirection() {
        LoginForm loginForm = registrationForm.clickLoginTitle();

        assertTrue(loginForm.isLoginFormDisplayed());
    }

}

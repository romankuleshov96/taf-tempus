package by.tempus.ui;

import by.tempus.pages.Header;
import by.tempus.pages.login.LoginForm;
import by.tempus.pages.login.LoginFormLocalizations;
import by.tempus.pages.registration.RegistrationForm;
import by.tempus.pages.registration.RegistrationFormLocalizations;
import by.tempus.utils.Waits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationFormTest extends BaseTest {

    private final static String EXISTED_EMAIL = "test@test.com";
    private final static String EXISTED_PHONE_NUMBER = "+375291234567";

    public Header header;
    public RegistrationForm registrationForm;

    @BeforeEach
    public void setup() {
        header = new Header();
        header.clickAccountButton();
        registrationForm = new LoginForm().clickRegistrationTitle();
    }

    @Test
    @DisplayName("Verify all elements text - Registration form")
    public void testRegistrationFormUIElementsText() {
        assertAll(
                () -> assertEquals(registrationForm.getTextLoginTitle(), LoginFormLocalizations.LOGIN_TITLE),
                () -> assertEquals(registrationForm.getTextRegistrationTitle(), LoginFormLocalizations.REGISTRATION_TITLE),
                () -> assertEquals(registrationForm.getTextNameFieldPlaceholder(), RegistrationFormLocalizations.NAME_FIELD_PLACEHOLDER),
                () -> assertEquals(registrationForm.getTextEmailFieldPlaceholder(), RegistrationFormLocalizations.EMAIL_FIELD_PLACEHOLDER),
                () -> assertEquals(registrationForm.getTextPhoneFieldPlaceholder(), RegistrationFormLocalizations.PHONE_FIELD_PLACEHOLDER),
                () -> assertEquals(registrationForm.getTextPasswordFieldPlaceholder(), RegistrationFormLocalizations.PASSWORD_FIELD_PLACEHOLDER),
                () -> assertEquals(registrationForm.getTextRepeatPasswordFieldPlaceholder(), RegistrationFormLocalizations.REPEAT_PASSWORD_FIELD_PLACEHOLDER),
                () -> assertEquals(registrationForm.getTextAgreementText(), RegistrationFormLocalizations.AGREEMENT_TEXT),
                () -> assertEquals(registrationForm.getTextSubmitRegistrationButton(), RegistrationFormLocalizations.SUBMIT_REGISTRATION_BUTTON)
        );
    }

    @Test
    @DisplayName("Verify validation messages for all empty fields")
    public void testAllEmptyFieldsValidationText() {
        registrationForm.clickRegistrationButton();

        assertAll(
                () -> assertEquals(registrationForm.getTextNameFieldValidationMessage(), RegistrationFormLocalizations.NAME_FIELD_VALIDATION_MESSAGE),
                () -> assertEquals(registrationForm.getTextEmailFieldValidationMessage(), RegistrationFormLocalizations.EMAIL_FIELD_VALIDATION_MESSAGE),
                () -> assertEquals(registrationForm.getTextPhoneFieldValidationMessage(), RegistrationFormLocalizations.INVALID_PHONE_VALIDATION_MESSAGE),
                () -> assertEquals(registrationForm.getTextPasswordFieldValidationMessage(), RegistrationFormLocalizations.PASSWORD_FIELD_VALIDATION_MESSAGE),
                () -> assertEquals(registrationForm.getTextAgreementCheckBoxValidationMessage(), RegistrationFormLocalizations.AGREEMENT_CHECK_BOX_VALIDATION_MESSAGE)
        );
    }

    @Test
    @DisplayName("Verify validation message for invalid email format value")
    public void testInvalidEmailFormatValueValidationText() {
        registrationForm.sendKeysEmailField("test@test");
        registrationForm.clickRegistrationButton();

        assertEquals(registrationForm.getTextEmailFieldValidationMessage(), RegistrationFormLocalizations.INVALID_EMAIL_VALIDATION_MESSAGE);
    }

    @Test
    @DisplayName("Verify validation for invalid phone value")
    public void testInvalidPhoneValueValidationText() {
        registrationForm.sendKeysPhoneField("+37529123");
        registrationForm.clickRegistrationButton();

        assertEquals(registrationForm.getTextPhoneFieldValidationMessage(), RegistrationFormLocalizations.INVALID_PHONE_VALIDATION_MESSAGE);
    }

    @Test
    @DisplayName("Verify validation for not matched password values")
    public void testNotMatchedPasswordValuesValidationText() {
        registrationForm.sendKeysPasswordField("123");
        registrationForm.sendKeysRepeatPasswordField("234");
        registrationForm.clickRegistrationButton();

        assertEquals(registrationForm.getTextRepeatPasswordFieldValidationMessage(), RegistrationFormLocalizations.REPEAT_PASSWORD_FIELD_VALIDATION_MESSAGE);
    }

    @Test
    @DisplayName("Verify validation for not required password values")
    public void testNotRequiredPasswordValuesValidationText() {
        registrationForm.sendKeysNameField("Name");
        registrationForm.sendKeysEmailField("ttt@ttt.com");
        registrationForm.sendKeysPhoneField("+375291236567");
        registrationForm.sendKeysPasswordField("123");
        registrationForm.sendKeysRepeatPasswordField("123");
        registrationForm.clickAgreementCheckBox();
        registrationForm.clickRegistrationButton();

        Waits.waitUntilElementIsDisplayed(registrationForm.getValidationPopup());
        assertEquals(registrationForm.getTextValidationPopup(), RegistrationFormLocalizations.PASSWORD_VALIDATION_POPUP);
    }

    @Test
    @DisplayName("Verify validation for existed Email value")
    public void testExistedEmailValueValidationText() {
        registrationForm.sendKeysNameField("Name");
        registrationForm.sendKeysEmailField(EXISTED_EMAIL);
        registrationForm.sendKeysPhoneField("+375291236567");
        registrationForm.sendKeysPasswordField("123");
        registrationForm.sendKeysRepeatPasswordField("123");
        registrationForm.clickAgreementCheckBox();
        registrationForm.clickRegistrationButton();

        Waits.waitUntilElementIsDisplayed(registrationForm.getValidationPopup());
        assertEquals(registrationForm.getTextValidationPopup(), RegistrationFormLocalizations.EXISTED_EMAIL_VALIDATION_POPUP);
    }

    @Test
    @DisplayName("Verify validation for existed Phone value")
    public void testExistedPhoneValueValidationText() {
        registrationForm.sendKeysNameField("Name");
        registrationForm.sendKeysEmailField("tesssst@tt.ccc");
        registrationForm.sendKeysPhoneField(EXISTED_PHONE_NUMBER);
        registrationForm.sendKeysPasswordField("123");
        registrationForm.sendKeysRepeatPasswordField("123");
        registrationForm.clickAgreementCheckBox();
        registrationForm.clickRegistrationButton();

        Waits.waitUntilElementIsDisplayed(registrationForm.getValidationPopup());
        assertEquals(registrationForm.getTextValidationPopup(), RegistrationFormLocalizations.EXISTED_PHONE_VALIDATION_POPUP);
    }

    @Test
    @DisplayName("Verify redirection to Login form")
    public void testLoginFormRedirection() {
        LoginForm loginForm = registrationForm.clickLoginTitle();

        assertTrue(loginForm.isLoginFormDisplayed());
    }

}

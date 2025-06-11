package by.tempus.pages.registration;

import by.tempus.driver.Driver;
import by.tempus.pages.login.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationForm {

    private final By loginTitle = By.xpath("(//button[@class=\"tabs__btn-action\"])[1]");
    private final By registrationTitle = By.xpath("(//button[@class=\"tabs__btn-action\"])[2]");

    private final By nameField = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//input[@name=\"fullName\"]");
    private final By nameFieldPlaceholder = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required\"]//span[@class=\"form-input__placeholder\"]");
    private final By nameFieldValidationMessage = By.xpath("//label[@class=\"form-input is-required is-error\"]//span[@class=\"form-input__error-message\"]");

    private final By emailField = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//input[@name=\"email\"]");
    private final By emailFieldPlaceholder = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-email\"]//span[@class=\"form-input__placeholder\"]");
    private final By emailFieldValidationMessage = By.xpath("//label[@class=\"form-input is-required is-email is-error\"]//span[@class=\"form-input__error-message\"]");

    private final By phoneField = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-phone phone-input\"]");
    private final By phoneFieldPlaceholder = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-phone phone-input\"]//span[@class=\"form-input__placeholder\"]");
    private final By phoneFieldValidationMessage = By.xpath("//label[@class=\"form-input is-required is-phone phone-input is-error\"]//span[@class=\"form-input__error-message\"]");

    private final By passwordField = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-password\"]");
    private final By passwordFieldPlaceholder = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//label[@class=\"form-input is-required is-password\"]//span[@class=\"form-input__placeholder\"]");
    private final By passwordFieldValidationMessage = By.xpath("//label[@class=\"form-input is-required is-password is-error\"]//span[@class=\"form-input__error-message\"]");

    private final By repeatPasswordField = By.xpath("//label[@class=\"form-input is-required is-confirm-password\"]");
    private final By repeatPasswordFieldPlaceholder = By.xpath("//label[@class=\"form-input is-required is-confirm-password\"]//span[@class=\"form-input__placeholder\"]");
    private final By repeatPasswordFieldValidationMessage = By.xpath("//label[@class=\"form-input is-required is-confirm-password is-error\"]//span[@class=\"form-input__error-message\"]");

    private final By agreementCheckBox = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//span[@class=\"form-input is-checkbox is-required checkbox-input\"]");
    private final By agreementCheckBoxValidationMessage = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//span[@class=\"form-input is-checkbox is-required checkbox-input\"]//span[@class=\"form-input__error-message\"]");
    private final By agreementText = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//span[@class=\"agreement__text\"]");

    private final By submitRegistrationButton = By.xpath("//form[@class=\"form registration__form js-validate-form\"]//button[@type=\"submit\"]");

    private final By validationPopup = By.xpath("//div[@class=\"success-popup__text\"]");

    protected WebDriver driver;

    public RegistrationForm() {
        driver = Driver.getDriver();
    }

    public WebElement getValidationPopup() {
        return driver.findElement(validationPopup);
    }

    //get text
    public String getTextLoginTitle() {
        return driver.findElement(loginTitle).getText();
    }

    public String getTextRegistrationTitle() {
        return driver.findElement(registrationTitle).getText();
    }

    public String getTextNameFieldPlaceholder() {
        return driver.findElement(nameFieldPlaceholder).getText();
    }

    public String getTextNameFieldValidationMessage() {
        return driver.findElement(nameFieldValidationMessage).getText();
    }

    public String getTextEmailFieldPlaceholder() {
        return driver.findElement(emailFieldPlaceholder).getText();
    }

    public String getTextEmailFieldValidationMessage() {
        return driver.findElement(emailFieldValidationMessage).getText();
    }

    public String getTextPhoneFieldPlaceholder() {
        return driver.findElement(phoneFieldPlaceholder).getText();
    }

    public String getTextPhoneFieldValidationMessage() {
        return driver.findElement(phoneFieldValidationMessage).getText();
    }

    public String getTextPasswordFieldPlaceholder() {
        return driver.findElement(passwordFieldPlaceholder).getText();
    }

    public String getTextPasswordFieldValidationMessage() {
        return driver.findElement(passwordFieldValidationMessage).getText();
    }

    public String getTextRepeatPasswordFieldPlaceholder() {
        return driver.findElement(repeatPasswordFieldPlaceholder).getText();
    }

    public String getTextRepeatPasswordFieldValidationMessage() {
        return driver.findElement(repeatPasswordFieldValidationMessage).getText();
    }

    public String getTextAgreementCheckBoxValidationMessage() {
        return driver.findElement(agreementCheckBoxValidationMessage).getText();
    }

    public String getTextAgreementText() {
       return driver.findElement(agreementText).getText();
    }

    public String getTextValidationPopup() {
        return driver.findElement(validationPopup).getText();
    }

    public String getTextSubmitRegistrationButton() {
        return driver.findElement(submitRegistrationButton).getText();
    }

    //click
    public void clickAgreementCheckBox() {
        driver.findElement(agreementCheckBox).click();
    }

    public void clickRegistrationButton() {
        driver.findElement(submitRegistrationButton).click();
    }

    public LoginForm clickLoginTitle() {
        driver.findElement(loginTitle).click();

        return new LoginForm();
    }

    //sendKeys
    public void sendKeysNameField(String nameValue) {
        driver.findElement(nameField).sendKeys(nameValue);
    }

    public void sendKeysEmailField(String emailValue) {
        driver.findElement(emailField).sendKeys(emailValue);
    }

    public void sendKeysPhoneField(String phoneValue) {
        driver.findElement(phoneField).sendKeys(phoneValue);
    }

    public void sendKeysPasswordField(String passwordValue) {
        driver.findElement(passwordField).sendKeys(passwordValue);
    }

    public void sendKeysRepeatPasswordField(String repeatPasswordValue) {
        driver.findElement(repeatPasswordField).sendKeys(repeatPasswordValue);
    }

    //isLoginFormDisplayed
    public boolean isRegistrationFormDisplayed() {
        return (
                driver.findElement(registrationTitle).isDisplayed() &&
                driver.findElement(nameField).isDisplayed() &&
                        driver.findElement(emailField).isDisplayed() &&
                        driver.findElement(phoneField).isDisplayed() &&
                        driver.findElement(passwordField).isDisplayed() &&
                        driver.findElement(repeatPasswordField).isDisplayed() &&
                        driver.findElement(repeatPasswordField).isDisplayed() &&
                        driver.findElement(agreementCheckBox).isDisplayed() &&
                        driver.findElement(agreementText).isDisplayed() &&
                        driver.findElement(submitRegistrationButton).isDisplayed()
        );
    }
}

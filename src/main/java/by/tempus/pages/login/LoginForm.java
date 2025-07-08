package by.tempus.pages.login;

import by.tempus.driver.Driver;
import by.tempus.pages.BaseForm;
import by.tempus.pages.reset.password.ResetPasswordForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm extends BaseForm {

    private final By emailField = By.xpath("//label[@class=\"form-input is-required is-email check-email\"]");
    private final By emailFieldPlaceholder = By.xpath("//label[@class=\"form-input is-required is-email check-email\"]//span[@class=\"form-input__placeholder\"]");
    private final By emailFieldValidationMessage = By.xpath("//label[@class=\"form-input is-required is-email check-email is-error\"]//span[@class=\"form-input__error-message\"]");

    private final By passwordField = By.xpath("//form[@class=\"form authorize__form js-validate-form\"]//label[@class=\"form-input is-required is-password\"]");
    private final By passwordFieldPlaceholder = By.xpath("//form[@class=\"form authorize__form js-validate-form\"]//label[@class=\"form-input is-required is-password\"]//span[@class=\"form-input__placeholder\"]");
    private final By passwordFieldValidationMessage = By.xpath("//label[@class=\"form-input is-required is-password is-error\"]//span[@class=\"form-input__error-message\"]");

    private final By resetPasswordButton = By.xpath("//button[@class=\"form__action j-tabBtnHandle\"]");
    private final By submitLoginButton = By.xpath("//form[@class=\"form authorize__form js-validate-form\"]//button[@type=\"submit\"]");
    private final By errorPopup = By.xpath("//div[@class=\"success-popup__text\"]");

    protected WebDriver driver;

    public LoginForm() {
        driver = Driver.getDriver();
    }

    public WebElement getErrorPopup() {
        return driver.findElement(errorPopup);
    }

    //get text
    public String getTextEmailFieldPlaceholder() {
        return driver.findElement(emailFieldPlaceholder).getText();
    }

    public String getTextEmailFieldValidationMessage() {
        return driver.findElement(emailFieldValidationMessage).getText();
    }

    public String getTextPasswordFieldPlaceholder() {
        return driver.findElement(passwordFieldPlaceholder).getText();
    }

    public String getTextPasswordFieldValidationMessage() {
        return driver.findElement(passwordFieldValidationMessage).getText();
    }

    public String getTextResetPasswordButton() {
        return driver.findElement(resetPasswordButton).getText();
    }

    public String getTextSubmitButton() {
        return driver.findElement(submitLoginButton).getText();
    }

    public String getTextErrorPopup() {
        return driver.findElement(errorPopup).getText();
    }

    //click
    public void clickSubmitButton() {
        driver.findElement(submitLoginButton).click();
    }

    public ResetPasswordForm clickReetPasswordButton() {
        driver.findElement(resetPasswordButton).click();

        return new ResetPasswordForm();
    }

    //sendKeys
    public void sendKeysEmailField(String emailValue) {
        driver.findElement(emailField).sendKeys(emailValue);
    }

    public void sendKeysPasswordField(String passwordValue) {
        driver.findElement(passwordField).sendKeys(passwordValue);
    }

    //isLoginFormDisplayed
    public boolean isLoginFormDisplayed() {
        return (
                driver.findElement(loginTitle).isDisplayed() &&
                driver.findElement(emailField).isDisplayed() &&
                driver.findElement(passwordField).isDisplayed() &&
                driver.findElement(resetPasswordButton).isDisplayed() &&
                driver.findElement(submitLoginButton).isDisplayed()
                );
    }
}

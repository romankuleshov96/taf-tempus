package by.tempus.pages.reset.password;

import by.tempus.driver.Driver;
import by.tempus.pages.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ResetPasswordForm extends BaseForm {

    private final By restorePasswordTitle = By.xpath("//form[@class=\"form restore__form js-validate-form\"]//div[@class=\"form__recover\"]");
    private final By emailField = By.xpath("//form[@class=\"form restore__form js-validate-form\"]//label[@class=\"form-input is-required is-email\"]");
    private final By emailFieldPlaceholder = By.xpath("//form[@class=\"form restore__form js-validate-form\"]//label[@class=\"form-input is-required is-email\"]//span[@class=\"form-input__placeholder\"]");
    private final By emailFieldValidationMessage = By.xpath("//form[@class=\"form restore__form js-validate-form\"]//label[@class=\"form-input is-required is-email is-error\"]//span[@class=\"form-input__error-message\"]");
    private final By submitResetPasswordButton = By.xpath("//form[@class=\"form restore__form js-validate-form\"]//button[@class=\"button is-primary\"]");
    private final By validationPopup = By.xpath("//div[@class=\"success-popup__text\"]");

    protected WebDriver driver;

    public ResetPasswordForm() {
        driver = Driver.getDriver();
    }

    public WebElement getValidationPopup() {
        return driver.findElement(validationPopup);
    }

    public String getTextRestorePasswordTitle() {
        return driver.findElement(restorePasswordTitle).getText();
    }

    public String getTextEmailFieldPlaceholder() {
        return driver.findElement(emailFieldPlaceholder).getText();
    }

    public String getTextEmailFieldValidationMessage() {
        return driver.findElement(emailFieldValidationMessage).getText();
    }

    public String getTextSubmitResetPasswordButton() {
        return driver.findElement(submitResetPasswordButton).getText();
    }

    public String getTextValidationPopup() {
        return driver.findElement(validationPopup).getText();
    }

    public void clickSubmitResetPasswordButton() {
        driver.findElement(submitResetPasswordButton).click();
    }

    public void sendKeysEmailField(String emailValue) {
        driver.findElement(emailField).sendKeys(emailValue);
    }

    public boolean isResetPasswordFormDisplayed() {

        return (
                driver.findElement(restorePasswordTitle).isDisplayed() &&
                        driver.findElement(emailField).isDisplayed() &&
                        driver.findElement(submitResetPasswordButton).isDisplayed()
        );
    }
}

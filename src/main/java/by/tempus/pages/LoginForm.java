package by.tempus.pages;

import by.tempus.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {

    private final By loginTitle = By.xpath("(//button[@class=\"tabs__btn-action\"])[1]");
//    private final By registrationTitle;
//    private final By emailField;
//    private final By emailFieldPlaceholder;
//    private final By emailFieldValidationMessage;
//    private final By passwordField;
//    private final By passwordFieldPlaceholder;
//    private final By passwordFieldValidationMessage;
//    private final By resetPasswordButton;
//    private final By submitButton;

    protected WebDriver driver;

    public LoginForm() {
        driver = Driver.getDriver();
    }

    public WebElement getLoginTitle() {
        return driver.findElement(loginTitle);
    }

    public String getTextLoginTitle() {
        return driver.findElement(loginTitle).getText();
    }
}

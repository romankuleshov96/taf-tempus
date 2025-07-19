package by.tempus.pages;

import by.tempus.driver.Driver;
import by.tempus.pages.login.LoginForm;
import by.tempus.pages.registration.RegistrationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseForm {

    protected final By loginTitle = By.xpath("(//button[@class=\"tabs__btn-action\"])[1]");
    protected final By registrationTitle = By.xpath("(//button[@class=\"tabs__btn-action\"])[2]");

    protected WebDriver driver;

    public BaseForm() {
        driver = Driver.getDriver();
    }

    public WebElement getLoginTitle() {
        return driver.findElement(loginTitle);
    }

    public String getTextLoginTitle() {
        return driver.findElement(loginTitle).getText();
    }

    public String getTextRegistrationTitle() {
        return driver.findElement(registrationTitle).getText();
    }

    public LoginForm clickLoginTitle() {
        driver.findElement(loginTitle).click();

        return new LoginForm();
    }

    public RegistrationForm clickRegistrationTitle() {
        driver.findElement(registrationTitle).click();

        return new RegistrationForm();
    }
}

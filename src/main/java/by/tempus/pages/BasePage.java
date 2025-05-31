package by.tempus.pages;

import by.tempus.driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final String BASE_URL = "https://tempus.by/";

    protected WebDriver driver;

    public BasePage() {

        driver = Driver.getDriver();
    }

    public void openHomePage() {

        driver.get(BASE_URL);
    }
}

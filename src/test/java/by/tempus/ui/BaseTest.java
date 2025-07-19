package by.tempus.ui;

import by.tempus.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    private final String BASE_URL = "https://tempus.by/";

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }
}
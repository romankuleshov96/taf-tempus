package by.tempus.ui;

import by.tempus.driver.Driver;
import by.tempus.pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void openHomePage() {
        BasePage basePage = new BasePage();
        basePage.openHomePage();
    }

    @AfterEach
    public void closeDriver() {

        Driver.closeDriver();
    }
}

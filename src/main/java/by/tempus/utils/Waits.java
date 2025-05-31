package by.tempus.utils;

import by.tempus.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    protected Wait<WebDriver> wait;

    public static void waitUntilElementIsDisplayed(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(d -> element.isDisplayed());
    }
}

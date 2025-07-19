package by.tempus.pages.basket;

import by.tempus.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    protected WebDriver driver;

    private final By title = By.xpath("//h1[@class='h4']");
    private final By productItemName = By.xpath("//a[@class=\"cart-row__title h6\"]");
    private final By getProductItemPrice = By.xpath("//span[@class=\"cart-row__main-price h6\"]");

    public BasketPage() {
        driver = Driver.getDriver();
    }

    public String getTextTitle() {
        return driver.findElement(title).getText();
    }

    public String getTextProductItemName() {
        return driver.findElement(productItemName).getText();
    }

    public String getTextProductItemPrice() {
        return driver.findElement(getProductItemPrice).getText();
    }
}

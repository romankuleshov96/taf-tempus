package by.tempus.pages;

import by.tempus.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private final By ACCOUNT_BUTTON = By.xpath("//div[@class=\"header__wrapper\"]//button[@class=\"icons__action icons__action--account j-sidePanel\"]");
    private final By BASKET_BUTTON = By.xpath("//div[@class=\"header__icons\"]//a[@href=\"/basket/\"]");
    private final By BASKET_ITEM_COUNTER = By.xpath("//div[@class=\"header__icons\"]//span[@class=\"icons__counter icons__counter--cart\"]");
    private final By ALL_BRANDS_BUTTON = By.xpath("//div[@class=\"tags\"]//a[@href=\"/brands/\"]");

    protected WebDriver driver;

    public Header() {
        driver = Driver.getDriver();
    }

    //click
    public void clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    public void clickCartButton() {
        driver.findElement(BASKET_BUTTON).click();
    }

     public void clickAllBrandsButton() {
        driver.findElement(ALL_BRANDS_BUTTON).click();
     }

    //getText
    public String getCartItemCounterText() {
        return driver.findElement(BASKET_ITEM_COUNTER).getText();
    }
}

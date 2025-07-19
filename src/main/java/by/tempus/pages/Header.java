package by.tempus.pages;

import by.tempus.driver.Driver;
import by.tempus.pages.basket.BasketPage;
import by.tempus.pages.brands.AllBrandsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {

    private final By ACCOUNT_BUTTON = By.xpath("//div[@class=\"header__wrapper\"]//button[@class=\"icons__action icons__action--account j-sidePanel\"]");
    private final By BASKET_BUTTON = By.xpath("//div[@class=\"header__icons\"]//a[@href=\"/basket/\"]");
    private final By BASKET_ITEM_COUNTER = By.xpath("//div[@class=\"header__icons\"]//span[@class=\"icons__counter icons__counter--cart\"]");
    private final By ALL_BRANDS_BUTTON = By.xpath("//div[@class=\"tags\"]//a[@href=\"/brands/\"]");

    protected WebDriver driver;

    public Header() {
        driver = Driver.getDriver();
    }

    public WebElement getBasketItemCounter() {
        return driver.findElement(BASKET_ITEM_COUNTER);
    }

    public void clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    public BasketPage clickBasketButton() {
        driver.findElement(BASKET_BUTTON).click();

        return new BasketPage();
    }

    public AllBrandsPage clickAllBrandsButton() {
        driver.findElement(ALL_BRANDS_BUTTON).click();

        return new AllBrandsPage();
    }

    public String getBasketItemCounterText() {
        return driver.findElement(BASKET_ITEM_COUNTER).getText();
    }
}

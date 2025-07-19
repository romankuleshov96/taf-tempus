package by.tempus.pages.product;

import by.tempus.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private final By title = By.xpath("//h1[@class='h2']");
    private final By priceTitle = By.xpath("//span[@class=\"product-page-main__main-price\"]");
    private final By addToBasketButton = By.xpath("//div[@class=\"product-page-main__actions block-cart hide-mob\"]//div[@class=\"button is-primary is-cart \"]");

    protected WebDriver driver;

    public ProductPage() {
        driver = Driver.getDriver();
    }

    public String getTextTitle() {
        return driver.findElement(title).getText();
    }

    public String getTextPriceTitle() {
        return driver.findElement(priceTitle).getText();
    }

    public void clickAddToBasketButton() {
        driver.findElement(addToBasketButton).click();
    }
}

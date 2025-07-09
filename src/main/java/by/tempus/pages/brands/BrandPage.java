package by.tempus.pages.brands;

import by.tempus.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandPage {

    private final By title = By.xpath("//h1[@class=\"h1\"]");
    private final By productCartNameTitle = By.xpath("//a[@class=\"product-card__name\"]");

    protected WebDriver driver;

    public BrandPage() {
        driver = Driver.getDriver();
    }

    public String getTextTitle() {
        return driver.findElement(title).getText();
    }

    public boolean areAllProductsTitlesContainBrandNameText(String brandName) {
        boolean areAllProductsTitlesContainBrandNameText = true;

        List<WebElement> productsTitles = driver.findElements(productCartNameTitle);

        for (WebElement productTitle : productsTitles) {
            if (!productTitle.getText().contains(brandName)) {
                areAllProductsTitlesContainBrandNameText = false;
                break;
            }
        }

        return areAllProductsTitlesContainBrandNameText;
    }

}

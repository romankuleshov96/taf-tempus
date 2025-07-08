package by.tempus.pages.brands;

import by.tempus.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllBrandsPage {

    private final By title = By.xpath("//h1[@class=\"h2\"]");
    private final By brandItemTitle = By.xpath("//a[@class=\"brand-card__title is-title\"]");

    protected WebDriver driver;

    public AllBrandsPage() {
        driver = Driver.getDriver();
    }

    //get text
    public String getTextTile() {
        return driver.findElement(title).getText();
    }

    //click
    public BrandPage clickSpecifiedBrandItem(String brandName) {
        List<WebElement> brandItemTitles = driver.findElements(brandItemTitle);

        for (WebElement brandItemTitle : brandItemTitles) {
            if (brandItemTitle.getText().equals(brandName)) {
                    brandItemTitle.click();
                    break;
            }
        }

        return new BrandPage();
    }

    //is displayed
    public boolean isBrandItemTitlesContainText(String brandName) {
        boolean isBrandItemTitlesContainText = false;

        List<WebElement> brandItemTitles = driver.findElements(brandItemTitle);

        for (WebElement brandItemTitle : brandItemTitles) {
            if (brandItemTitle.getText().equals(brandName)) {
                isBrandItemTitlesContainText = true;
            }
        }

        return isBrandItemTitlesContainText;
    }
}

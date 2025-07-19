package by.tempus.ui;

import by.tempus.pages.Header;
import by.tempus.pages.basket.BasketPage;
import by.tempus.pages.basket.BasketPageLocalizations;
import by.tempus.pages.brands.AllBrandsPage;
import by.tempus.pages.brands.AllBrandsPageLocalizations;
import by.tempus.pages.brands.BrandPage;
import by.tempus.pages.brands.BrandPageLocalizations;
import by.tempus.pages.product.ProductPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddProductToBasketTest extends BaseTest {

    public final String BRAND_NAME = "DKNY";
    public final String WATCH_MODEL_NAME = "NY8654";

    @Test
    @DisplayName("Verify - Add specified product to basket flow")
    public void testAddProductToBasket() {
        Header header = new Header();
        BasketPage basketPage = header.clickBasketButton();
        int basketItemCount = Integer.parseInt(header.getBasketItemCounterText());
        assertEquals(BasketPageLocalizations.TITLE_FOR_EMPTY_BASKET, basketPage.getTextTitle());

        AllBrandsPage allBrandsPage = header.clickAllBrandsButton();
        assertEquals(AllBrandsPageLocalizations.ALL_BRANDS_PAGE_TITLE, allBrandsPage.getTextTile());

        BrandPage brandPage = allBrandsPage.clickSpecifiedBrandItem(BRAND_NAME);
        assertEquals(BrandPageLocalizations.BRANDS_ITEM_TITLE + BRAND_NAME, brandPage.getTextTitle());
        assertTrue(brandPage.areAllProductsTitlesContainBrandNameText(BRAND_NAME));

        ProductPage productPage = brandPage.clickSpecifiedModelItem(WATCH_MODEL_NAME);
        assertTrue(productPage.getTextTitle().contains(WATCH_MODEL_NAME.toUpperCase()));

        String price = productPage.getTextPriceTitle();

        productPage.clickAddToBasketButton();
        header.clickBasketButton();
        assertEquals(basketItemCount + 1, Integer.valueOf(header.getBasketItemCounterText()));
        assertEquals(BasketPageLocalizations.TITLE_FOR_BASKET_WITH_PRODUCT, basketPage.getTextTitle());
        assertTrue(basketPage.getTextProductItemName().contains(WATCH_MODEL_NAME));
        assertEquals(price, basketPage.getTextProductItemPrice().toLowerCase());
    }
}

package by.tempus.ui;

import by.tempus.pages.Header;
import by.tempus.pages.brands.AllBrandsPage;
import by.tempus.pages.brands.BrandPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllBrandsPageTest extends BaseTest {

    public final static String BRAND_NAME = "DKNY";

    public AllBrandsPage allBrandsPage;

    @BeforeEach
    public void setup() {
        Header header = new Header();
        header.clickAllBrandsButton();
        allBrandsPage = new AllBrandsPage();
    }

    @Test
    @DisplayName("Verify title text - All Brands page")
    public void testTitleText() {
        assertEquals("БРЕНДЫ", allBrandsPage.getTextTile());
    }

    @Test
    @DisplayName("Verify brand titles list contains specified brand name")
    public void testBrandGridContainsSpecifiedBrandName() {
        assertTrue(allBrandsPage.isBrandItemTitlesContainText(BRAND_NAME));
    }

    @Test
    @DisplayName("Verify redirection to specified brand page")
    public void test() {
        BrandPage brandPage = allBrandsPage.clickSpecifiedBrandItem(BRAND_NAME);
        assertEquals("НАРУЧНЫЕ ЧАСЫ " + BRAND_NAME, brandPage.getTextTitle());
        assertTrue(brandPage.isAllProductsTitlesContainBrandNameText(BRAND_NAME));
    }
}

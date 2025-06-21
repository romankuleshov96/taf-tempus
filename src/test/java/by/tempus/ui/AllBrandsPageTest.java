package by.tempus.ui;

import by.tempus.pages.Header;
import by.tempus.pages.brands.AllBrandsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllBrandsPageTest extends BaseTest {

    public final static String BRAND_NAME = "TISSOT";

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
}

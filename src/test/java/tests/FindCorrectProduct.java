package tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.executors.LeftPanel;
import pages.executors.ProductDetails;
import pages.executors.SearchResult;
import util.DriverFactory;

@RunWith(JUnitParamsRunner.class)
public class FindCorrectProduct {
    private static LeftPanel homePageAction;
    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        homePageAction = new LeftPanel();
        driver = DriverFactory.getDriver();
    }

    @AfterClass
    public static void after() {
        DriverFactory.closeDriver();
    }

    @Test
    @Parameters({
            "Garmin Sportwatch Fenix 5 Plus Sapphire, Sportwatch Fenix 5 Plus Sapphire",
            "COLEMAN Tent, Tent Oak Canyon 4"
    })
    public void findCorrectProduct(String item, String productName) {
        driver.get("https://www.asadventure.com/en.html");
        SearchResult searchResultPage = homePageAction.searchItem(item);
        Assert.assertTrue("Search result is not visible", searchResultPage.getProductNamesOfItems().size() > 1);
        Assert.assertTrue("Search result not contains given product: " + productName, searchResultPage.getProductNamesOfItems().contains(productName));

        ProductDetails productDetails = searchResultPage.openSpecificProductNameFromSearchResult(productName);
        Assert.assertEquals(productName, productDetails.getProductName());
    }
}

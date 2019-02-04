package tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.executors.*;
import util.DriverFactory;

@RunWith(JUnitParamsRunner.class)
public class AddProductBeforeLogin {
    private static LeftPanel homePageAction;
    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        homePageAction = new LeftPanel();
        driver = DriverFactory.getDriver();
    }

    @AfterClass
    public static void after() {
        homePageAction.logout();
        DriverFactory.closeDriver();
    }

    @Test
    @Parameters({
            "test.user21@mailinator.com, DSNYktEjpD9MTMA, Garmin Sportwatch Fenix 5 Plus Sapphire, Sportwatch Fenix 5 Plus Sapphire"
    })
    public void addProductBeforeLogin(String username, String password, String item, String productName) {
        driver.get("https://www.asadventure.com/en.html");
        SearchResult searchResult = homePageAction.searchItem(item);
        Assert.assertTrue("Search result is not visible", searchResult.getProductNamesOfItems().size() > 1);
        Assert.assertTrue("Search result not contains given product: " + productName, searchResult.getProductNamesOfItems().contains(productName));

        ProductDetails productDetailsPage = searchResult.openSpecificProductNameFromSearchResult(productName);
        Assert.assertEquals(productName, productDetailsPage.getProductName());

        productDetailsPage.addToBasket();
        Basket basketPage = homePageAction.openBasket();
        Assert.assertTrue("This page is not 'Basket' page", basketPage.isOn());
        Assert.assertTrue(productName + " wasn't found in basket", basketPage.isProductInBasket(productName));

        CheckoutWelcome checkoutWelcomePage = basketPage.checkout();
        Assert.assertTrue("This page is not 'Checkout welcome' page", checkoutWelcomePage.isOn());

        BuySteps buyStepsPage = checkoutWelcomePage.login(username, password);
        Assert.assertTrue("This page is not 'Buy Steps' page", buyStepsPage.isOn());

        homePageAction.continueShopping();
        basketPage = homePageAction.openBasket();
        Assert.assertTrue(productName + " wasn't found in basket", basketPage.isProductInBasket(productName));

        basketPage.remove(productName);
        Assert.assertFalse(productName + " is present in the basket", basketPage.isProductInBasket(productName));
        Assert.assertTrue("Basket is not empty", basketPage.isBasketEmpty());
    }
}

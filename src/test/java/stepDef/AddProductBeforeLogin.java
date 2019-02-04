package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.executors.*;


public class AddProductBeforeLogin {
    private LeftPanel leftPanel = new LeftPanel();
    private ProductDetails productDetailsPage = new ProductDetails();
    private Basket basketPage = new Basket();
    private CheckoutWelcome checkoutWelcomePage = new CheckoutWelcome();
    private BuySteps buyStepsPage = new BuySteps();

    //Given I am on home page
    //When I search item "<item>"
    //Then I see specific product "<productName>" on search result
    //When I open item "<productName>"
    //Then I have found item "<productName>"


    @When("I add the product to basket")
    public void addProductToBasket() {
        productDetailsPage.addToBasket();
    }

    @And("I navigate to basket")
    public void navigateToBasket() {
        basketPage = leftPanel.openBasket();
    }

    @Then("I'm on basket page")
    public void isOnBasketPage() {
        Assert.assertTrue("This page is not 'Basket' page", basketPage.isOn());
    }

    @And("{string} appears in basket")
    public void isProductInBasket(String productName) {
        Assert.assertTrue(productName + " wasn't found in basket", basketPage.isProductInBasket(productName));
    }

    @When("I checkout")
    public void checkout() {
        basketPage.checkout();
    }

    @Then("I'm directed to checkout welcome page")
    public void isOnCheckoutWelcomePage() {
        Assert.assertTrue("This page is not 'Checkout welcome' page", checkoutWelcomePage.isOn());
    }

    @When("I login at checkout welcome page as {string} using {string}")
    public void loginAtCheckout(String username, String password) {
        buyStepsPage = checkoutWelcomePage.login(username, password);
    }

    @Then("I'm directed to Buy steps page")
    public void isOnBuySteps() {
        Assert.assertTrue("This page is not 'Buy Steps' page", buyStepsPage.isOn());
    }

    @When("I continue shopping")
    public void continueShopping() {
        leftPanel.continueShopping();
    }

    // And navigate to basket
    // Then the product appears in basket

    @When("I remove {string} from basket")
    public void removeProduct(String productName) {
        basketPage.remove(productName);
    }

    @Then("{string} no longer present in basket")
    public void isBasketEmpty(String productName) {
        Assert.assertFalse(productName + " is present in the basket", basketPage.isProductInBasket(productName));
    }

    @Then("the basket is empty")
    public void isBasketEmpty() {
        Assert.assertTrue("Basket is not empty", basketPage.isBasketEmpty());
    }

    @When("I logout")
    public void logout() {
        leftPanel.logout();
    }

    @Then("I'm not logged in")
    public void isNotLoggedIn() {
        Assert.assertFalse(leftPanel.isUserLoggedIn());
    }
}

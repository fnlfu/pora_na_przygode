package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.executors.LeftPanel;
import pages.executors.ProductDetails;
import pages.executors.SearchResult;
import util.DriverFactory;

public class FindCorrectProduct {

    LeftPanel homePageAction = new LeftPanel();
    SearchResult searchResult = new SearchResult();
    ProductDetails productDetails = new ProductDetails();

    WebDriver driver = DriverFactory.getDriver();

    @Given("I am on home page")
    public void iAmOnHomePage() {
        driver.get("https://www.asadventure.com/en.html");
    }

    @When("I search item {string}")
    public void iSearchItem(String item) {
        homePageAction.searchItem(item);
    }

    @And("I see specific product {string} on search result")
    public void iSeeSpecificProductOnSearchResult(String productName) {
        Assert.assertTrue("Search result is not visible", searchResult.getProductNamesOfItems().size()>1);
        Assert.assertTrue("Search result not contains given product: " + productName, searchResult.getProductNamesOfItems().contains(productName));
    }

    @And("I open item {string}")
    public void iOpenItem(String item) {
        searchResult.openSpecificProductNameFromSearchResult(item);
    }

    @Then("I have found item {string}")
    public void iHaveFoundItem(String productName) {
        Assert.assertEquals(productName, productDetails.getProductName());
    }
}

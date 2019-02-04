package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.executors.AccountMenu;
import pages.executors.LeftPanel;
import pages.executors.ProfileDetails;
import util.DriverFactory;

import java.util.concurrent.ThreadLocalRandom;

public class CanChangeAccountDetails {

    private ProfileDetails profilePage = new ProfileDetails();
    private LeftPanel homePageAction = new LeftPanel();
    private AccountMenu accountMenu = new AccountMenu();

    private WebDriver driver = DriverFactory.getDriver();

    private int randomNum = ThreadLocalRandom.current().nextInt(100000000, 1000000000);
    private String newPhoneNum = String.valueOf(randomNum);

    @When("I login as {string} using {string}")
    public void loginAs(String username, String password){
        accountMenu = homePageAction.login(username, password);
    };

    @And("I can access Profile Details page")
    public void profileDetailsPageDisplayed(){
        profilePage = accountMenu.openProfileDetails();
        Assert.assertTrue(profilePage.isOn());
    }

    @And("I update Phone number")
    public void updatePhoneNumber(){
        profilePage.updatePhoneNumber(newPhoneNum);
        profilePage.saveChanges();
        Assert.assertTrue(profilePage.isDetailsSavedPopupDisplayed());
    }

    @Then("changes are saved")
    public void areChangesSaved(){
        driver.navigate().refresh();
        Assert.assertTrue("This is not Profile Details page", profilePage.isOn());
        Assert.assertEquals("Entered phone number wasn't saved", profilePage.getPhoneNumber(), newPhoneNum);
    }
}

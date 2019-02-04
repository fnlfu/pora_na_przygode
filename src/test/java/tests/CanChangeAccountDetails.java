package tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.executors.AccountMenu;
import pages.executors.LeftPanel;
import pages.executors.ProfileDetails;
import util.DriverFactory;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(JUnitParamsRunner.class)
public class CanChangeAccountDetails {
    private static LeftPanel homePageAction;
    private static WebDriver driver;
    private static String newPhoneNum;

    @BeforeClass
    public static void before() {
        homePageAction = new LeftPanel();
        driver = DriverFactory.getDriver();
        int randomNum = ThreadLocalRandom.current().nextInt(100000000, 1000000000);
        newPhoneNum = String.valueOf(randomNum);
    }

    @AfterClass
    public static void after() {
        homePageAction.logout();
        DriverFactory.closeDriver();
    }

    @Test
    @Parameters({
            "test.user21@mailinator.com, DSNYktEjpD9MTMA"
    })
    public void canChangeAccountDetails(String username, String password) {
        driver.get("https://www.asadventure.com/en.html");
        AccountMenu accountMenu = homePageAction.login(username, password);
        ProfileDetails profilePage = accountMenu.openProfileDetails();
        Assert.assertTrue(profilePage.isOn());

        profilePage.updatePhoneNumber(newPhoneNum);
        profilePage.saveChanges();
        Assert.assertTrue(profilePage.isDetailsSavedPopupDisplayed());

        driver.navigate().refresh();
        Assert.assertTrue("This is not Profile Details page", profilePage.isOn());
        Assert.assertEquals("Entered phone number wasn't saved", profilePage.getPhoneNumber(), newPhoneNum);
    }
}

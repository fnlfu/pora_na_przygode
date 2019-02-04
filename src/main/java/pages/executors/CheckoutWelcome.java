package pages.executors;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.CheckoutWelcomeLocators;
import util.DriverFactory;
import util.Helpers;

public class CheckoutWelcome extends CheckoutWelcomeLocators{

    public CheckoutWelcome() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public Boolean isOn() {
        return Helpers.isElementDisplayed(welcomeTitle);
    }

    public BuySteps login(String username, String password) {
        email.sendKeys(username);
        continueToCheckoutBtn.click();

        DriverFactory.wait.until(ExpectedConditions.visibilityOf(loginCheckbox));
        loginCheckbox.click();
        this.password.sendKeys(password);
        Helpers.waitForElementToBeClickable(continueToCheckoutBtn);
        continueToCheckoutBtn.click();

        return new BuySteps();
    }
}

package pages.executors;

import org.openqa.selenium.support.PageFactory;
import pages.locators.BuyStepsLocators;
import util.DriverFactory;
import util.Helpers;

public class BuySteps extends BuyStepsLocators{

    public BuySteps() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public boolean isOn() {
        return Helpers.isElementDisplayed(progressBar);
    }
}
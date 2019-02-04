package pages.executors;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.AccountMenuLocators;
import util.DriverFactory;

public class AccountMenu extends AccountMenuLocators{

    public AccountMenu() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public ProfileDetails openProfileDetails() {
        DriverFactory.wait.until(ExpectedConditions.visibilityOf(profileDetails));
        profileDetails.click();

        return new ProfileDetails();
    }
}

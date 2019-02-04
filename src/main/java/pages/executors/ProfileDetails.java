package pages.executors;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.ProfileDetailsLocators;
import util.DriverFactory;
import util.Helpers;

public class ProfileDetails extends ProfileDetailsLocators{


    public ProfileDetails() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public boolean isOn() {
        return Helpers.isElementDisplayed(pageTitle);
    }

    public void updatePhoneNumber(String value) {
        phoneNumber.clear();
        phoneNumber.sendKeys(value);
    }

    public void saveChanges() {
        saveBtn.click();
    }

    public String getPhoneNumber() {
        return phoneNumber.getAttribute("value");
    }

    public boolean isDetailsSavedPopupDisplayed() {
        return Helpers.isElementDisplayed(detailsSavedPopup);
    }
}

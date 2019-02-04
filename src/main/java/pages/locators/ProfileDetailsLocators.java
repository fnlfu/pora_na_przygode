package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfileDetailsLocators {

    @FindBy(how = How.XPATH, using = "//input[@id='phone']")
    public WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "//button[@id='updateAccount']")
    public WebElement saveBtn;

    @FindBy(how = How.XPATH, using = "//div[@class = 'page-breadcrumb__container']//span[text()='Profile details']")
    public WebElement pageTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Your details were successfully saved')]")
    public WebElement detailsSavedPopup;
}

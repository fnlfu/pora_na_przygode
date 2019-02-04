package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftPanelLocators {

    @FindBy(how = How.ID, using = "search")
    public WebElement searchInupt;

    @FindBy(how = How.CSS, using = "div[title=\"Account\"]")
    public WebElement accountBtn;

    @FindBy(how = How.XPATH, using = "//input[@id='login__form__user']")
    public WebElement usernameField;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(how = How.CSS, using = "button.button__flyout.button__login")
    public WebElement loginBtn;

    @FindBy(how = How.CSS, using = "div#vertical-basket")
    public WebElement basketMenuBtn;

    @FindBy(how = How.CSS, using = "a.button__basket.ng-binding")
    public WebElement goToBasketBtn;

    @FindBy(how = How.CSS, using = "a.call-to-action__button--center.call-to-action__menu")
    public WebElement continueShoppingBtn;

    @FindBy(how = How.CSS, using = "button.button__flyout.button__logout")
    public WebElement logoutBtn;
}

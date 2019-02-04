package pages.executors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.LeftPanelLocators;
import util.DriverFactory;
import util.Helpers;

public class LeftPanel extends LeftPanelLocators{

    public LeftPanel() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    private WebElement searchInput(String item) {
        searchInupt.sendKeys(item);
        return searchInupt;
    }

    public AccountMenu login(String username, String password) {
        accountBtn.click();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();

        return new AccountMenu();
    }

    public void searchItem(String item) {
        searchInput(item).sendKeys(Keys.ENTER);
    }

    public AccountMenu openAccountMenu() {
        accountBtn.click();
        return new AccountMenu();
    }

    public Basket openBasket() {
        basketMenuBtn.click();
        Helpers.delay(1);
        goToBasketBtn.click();
        return new Basket();
    }

    public void continueShopping() {
        continueShoppingBtn.click();
    }

    public void logout() {
        accountBtn.click();
        Helpers.delay(1);
        logoutBtn.click();
        DriverFactory.wait.until(ExpectedConditions.textToBePresentInElement(accountBtn, "Account"));
    }

    public boolean isUserLoggedIn() {
        return accountBtn.getText().contains("Welcome");
    }
}

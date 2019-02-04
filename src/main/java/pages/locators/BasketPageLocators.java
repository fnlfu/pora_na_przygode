package pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BasketPageLocators {
    @FindBy(how = How.XPATH, using = "//h2//b[contains(text(),'Basket')]")
    public WebElement heading;

    @FindBy(how = How.CSS, using = "button.button__order#order-top")
    public WebElement checkoutBtn;

    @FindBy(how = How.CSS, using = "div.checkout-basket__description")
    public List<WebElement> productNames;

    @FindBy(how = How.CSS, using = "div.checkout-basket__content-item__container")
    public List<WebElement> productSections;
}

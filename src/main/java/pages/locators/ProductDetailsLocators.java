package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductDetailsLocators {

    @FindBy(how = How.CSS, using = ".product-detail .a-product-name")
    public WebElement productName;

    @FindBy(how = How.CSS, using = "button.a-button--add-to-basket.button__pdp.button__add")
    public WebElement addToBasketBtn;

    @FindBy(how = How.CSS, using = "button.button__popup.button__close")
    public WebElement continueShopping;

    @FindBy(how = How.CSS, using = "div.o-basket-popup")
    public WebElement basketPopup;
}

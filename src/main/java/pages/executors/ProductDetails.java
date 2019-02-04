package pages.executors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.ProductDetailsLocators;
import util.DriverFactory;

public class ProductDetails extends ProductDetailsLocators{

    public ProductDetails() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getProductName(){
        return productName.getText();
    }

    public void addToBasket() {
        addToBasketBtn.click();
        closeBasketPopup();
    }

    public void closeBasketPopup() {
        DriverFactory.wait.until(ExpectedConditions.visibilityOf(basketPopup));
        continueShopping.click();
    }
}

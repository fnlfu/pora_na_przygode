package pages.executors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.BasketPageLocators;
import util.DriverFactory;
import util.Helpers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket extends BasketPageLocators{

    public Basket() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public boolean isOn() {
        return Helpers.isElementDisplayed(heading);
    }

    public boolean isProductInBasket(String productName) {
        return getProductsInBasket().contains(productName);
    }

    public void checkout() {

        checkoutBtn.click();
    }

    public void remove(String productName) {
        if(isProductInBasket(productName))
        {
            WebElement productSection = getProductSectionByName(productName);
            productSection.findElement(By.cssSelector("a.checkout-basket__remove-product")).click();
            DriverFactory.wait.until(ExpectedConditions.invisibilityOfAllElements(productSection));
        }
    }

    public Boolean isBasketEmpty() {
        return getProductsInBasket().isEmpty();
    }

    private List<String> getProductsInBasket(){
        List<String> productsList = new ArrayList<String>();
        productNames.forEach(el -> productsList.add(el.getText()));
        return productsList;
    }

    private WebElement getProductSectionByName(String product){
        List<WebElement> result = productSections
                .stream()
                .filter(item -> item.getText().contains(product))
                .collect(Collectors.toList());
        return result.get(0);
    }
}

package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchResultLocators {

    @FindBy(how = How.CLASS_NAME, using = "m-product-tile__container")
    public List<WebElement> itemsOnSearchList;

    @FindBy(how = How.CLASS_NAME, using = "a-product-name")
    public List<WebElement> productNamesOnSearchList;

}

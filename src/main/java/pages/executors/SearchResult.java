package pages.executors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.locators.SearchResultLocators;
import util.DriverFactory;
import util.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResult extends SearchResultLocators {

    public SearchResult() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement getItemFromSearchList(int itemIndex) {
        return itemsOnSearchList.get(itemIndex);
    }

    public WebElement getProductNameOfSelectedItem(int itemIndex) {
        return productNamesOnSearchList.get(itemIndex);
    }

    public List<String> getProductNamesOfItems() {
        List<String> itemsList = new ArrayList<>();
        for (WebElement item : productNamesOnSearchList) {
            itemsList.add(item.getText());
        }
        return itemsList;
    }

    public ProductDetails openSpecificProductNameFromSearchResult(String selectedItem) {
        List<WebElement> result = productNamesOnSearchList
                .stream()
                .filter(item -> item.getText().equals(selectedItem))
                .collect(Collectors.toList());
        Helpers.scrollTo(result.get(0)).click();
        return new ProductDetails();
    }
}

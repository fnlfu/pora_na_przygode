package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuyStepsLocators {
    @FindBy(how = How.CSS, using = "ul.buy-progress__bar")
    public WebElement progressBar;
}

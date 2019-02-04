package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountMenuLocators {



    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Profile details')]")
    public WebElement profileDetails;
}

package util;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Helpers {
    public static WebElement scrollTo(WebElement element) {
        element.getLocation();
        WebDriver driver = DriverFactory.getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        return element;
    }

    public static boolean isElementDisplayed(WebElement locator) {
        try{
            DriverFactory.wait.until(ExpectedConditions.visibilityOf(locator));
        }
        catch (ElementNotVisibleException ex){
            return false;
        }
        return true;
    }
    public static void waitForElementToBeClickable(WebElement element){
        DriverFactory.wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void delay(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

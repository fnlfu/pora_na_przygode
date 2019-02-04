package util;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriverWait wait = initializeDriverWait();

    private static WebDriverWait initializeDriverWait(){
        return new WebDriverWait(getDriver(), 5);
    }

    public static WebDriver getDriver() {
        if(driver == null){
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        WebDriver driver;
        String driverType = "CHROME";

        switch (driverType) {
            case "CHROME":

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("unknown browser parameter type");
        }

        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Before
    public void beforeScenario() {
        driver = getDriver();
    }

    @After
    public void afterScenario() {
        DriverFactory.closeDriver();
    }
}

package BaseSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public void setChromeDrivers(){

        String location = System.getProperty("user.dir")+"/src/test/resources/Driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", location);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swinji.azurewebsites.net/account/login");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }


    public  WebDriver getDriver(){

        return driver;
    }
}

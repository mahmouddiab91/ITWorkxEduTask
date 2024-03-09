package definitions;

import BaseSelenium.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class BasePage {
    static Driver driver = new Driver();
    public static WebDriver driverr = driver.getDriver();

    public static void waitForVisibility(WebElement element, Integer Wait){
        WebDriverWait wait = new WebDriverWait(driverr, Duration.ofSeconds(Wait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollVertical (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driverr;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void click(WebElement element){
        waitForVisibility(element, 10);
        element.click();
    }

    public void sendKey(WebElement element, String key){
        waitForVisibility(element, 10);
        element.sendKeys(key);
    }

    public String getAttribute(WebElement element){
        waitForVisibility(element, 10);
         return element.getText();
    }

}

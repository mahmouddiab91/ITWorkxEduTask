package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    @FindBy(id="Email") public WebElement emailField;
    @FindBy(id = "inputPassword") public WebElement passwordField;
    @FindBy(id="btnLogin") public WebElement LgnBtnField;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



}

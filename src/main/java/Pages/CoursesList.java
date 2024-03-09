package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesList {
    @FindBy(id= "txtCourseSearch") public WebElement srchField;
    @FindBy(xpath = "//em[@class='fa fa-search fa-lg']") public WebElement srchIcon;
    @FindBy(linkText = "TestMD") public WebElement addedItem;

    public CoursesList(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}

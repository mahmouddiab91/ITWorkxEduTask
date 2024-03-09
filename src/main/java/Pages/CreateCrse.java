package Pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCrse {
    @FindBy(xpath = "//a[@id='btnMyCoursesList']") public WebElement crseIcon;
    @FindBy(id = "btnListAddCourse") public WebElement addCrseBtn;
    @FindBy(id = "txtCourseName") public WebElement crseNameField;
    @FindBy(xpath = "//select[@id='courseGrade']") public WebElement slctGrdeDropdown;
    @FindBy(xpath = "//*[@id='courseGrade']/option[5]") public WebElement fthChoice;
    @FindBy(xpath = "//input[@placeholder='Course Teacher']") public WebElement slctTchrDropdown;
    @FindBy(xpath = "//input[@placeholder='Course Teacher']/option[0]") public WebElement frstOption;
    @FindBy(id = "btnSaveAsDraftCourse") public WebElement createBtn;

    public CreateCrse(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}

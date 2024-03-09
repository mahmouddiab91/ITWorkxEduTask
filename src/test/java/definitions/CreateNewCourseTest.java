package definitions;

import BaseSelenium.Driver;
import Pages.Login;
import Pages.CreateCrse;
import Pages.CoursesList;
import groovy.util.logging.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateNewCourseTest extends BasePage{

    public static Pages.Login Login;
    public static Pages.CreateCrse CreateCrse;
    public static Pages.CoursesList CoursesList;
    public static BaseSelenium.Driver Driver;

    WebDriver driver = null;

    @Given("open website using chrome browser")
    public void open_website_using_chrome_browser() {
        Driver = new Driver();
        Driver.setChromeDrivers();
        driver = Driver.getDriver();
    }

    @Given("fill home email field {string}")
    public void fill_home_email_field(String usrName) {
        Login = new Login(driver);
        System.out.println(usrName);
        sendKey(Login.emailField, usrName) ;
    }

    @Given("fill home password field {string}")
    public void fill_home_password_field(String psdWord) {
        Login = new Login(driver);
        sendKey(Login.passwordField, psdWord);
    }

    @Given("i click on login button")
    public void i_click_on_login_button() {
        Login = new Login(driver);
        click(Login.LgnBtnField);
    }

    @When("select courses from side menu")
    public void select_courses_from_side_menu() {
     CreateCrse = new CreateCrse(driver);
     click(CreateCrse.crseIcon);
    }

    @When("select add new course")
    public void select_add_new_course() {
        CreateCrse = new CreateCrse(driver);
        click(CreateCrse.addCrseBtn);
    }

    @When("fill course basic info using {string}")
    public void fill_course_basic_info_using(String crsName) {
        CreateCrse = new CreateCrse(driver);
        sendKey(CreateCrse.crseNameField, crsName);
        click(CreateCrse.slctGrdeDropdown);
        click(CreateCrse.fthChoice);
        scrollVertical(CreateCrse.slctTchrDropdown);
        click(CreateCrse.slctTchrDropdown);
        click(CreateCrse.frstOption);
    }

    @When("save new course")
    public void save_new_course() {
        click(CreateCrse.createBtn);
    }

    @Then("back to courses list page")
    public void back_to_courses_list_page() {
        CreateCrse = new CreateCrse(driver);
        click(CreateCrse.createBtn);
    }


    @Then("assert the course")
    public void assert_the_course(String crsName) {
        CoursesList = new CoursesList(driver);
        sendKey(CoursesList.srchField, crsName);
        Assert.assertEquals(getAttribute(CoursesList.addedItem), "TestMD");
    }

    @Then("Close Chrome Browser")
    public void close_chrome_browser() {
        driver.close();
        driver.quit();
    }

}

package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.FbHomepage;
import pageobjects.pagefactory.LoginForm;

import java.util.Date;

import static constants.SystemConstants.DEFAULT_LAST_NAME;
import static constants.SystemConstants.DEFAULT_LOGIN_NAME;
import static constants.SystemConstants.PAGELOADING;


public class LearnSelenium extends HomepageActions {
    LoginForm loginForm;

    private static final String TEST_URL = "http://demo.automationtesting.in/Register.html";

    @Override
    public String getUrl() {
        return TEST_URL;
    }


    @BeforeTest
    public void setUp() throws Exception {
        commonChromeSetup();


    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }


    //http://learn-automation.com/selenium-webdriver-c-sharp-tutorial/

    //@Test
    public void checkPageTitle() throws Exception {
        Thread.sleep(3000);
        String test = driver.getTitle();
        Assert.assertEquals(test, "Register", "Actual value is " + test);


    }


    @Test(description = "insert value into textboxes")
    public void insertintoTextboxes() throws InterruptedException {
        LoginForm loginForm = new FbHomepage(driver).getLoginForm();
        loginForm.getFirstname().sendKeys(DEFAULT_LOGIN_NAME);
        String actual = loginForm.getFirstname().getAttribute("value");
        Assert.assertEquals(actual, "Vaclav", "actual value is" + actual);
        loginForm.getLastname().sendKeys(DEFAULT_LAST_NAME);
        String alastname = loginForm.getLastname().getAttribute("value");
        Assert.assertEquals(alastname, "Jurena", "actual value is" + alastname);
        loginForm.getSubmitBtn().click();
        Thread.sleep(4000);

    }


    @Test(description = "insert text into Textarea")
    public void writeTextIntoTextArea() throws InterruptedException {
        LoginForm loginForm = new FbHomepage(driver).getLoginForm();
        String testSeleniumValue = "test " + new Date().toString();
        loginForm.getTextarea().sendKeys(testSeleniumValue);
    }

    //@Test
    public void handleCountryDropdown() throws InterruptedException {


        Thread.sleep(3000);
    }

    @Test
    public void handleCheckbox() throws InterruptedException {
        selectDropDownOption("", "Japan");

    }
}
















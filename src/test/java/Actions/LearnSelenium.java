package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LearnSelenium extends HomepageActions {

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

    @Test
    public void checkPageTitle() throws Exception {
        Thread.sleep(3000);
        String test = driver.getTitle();
        Assert.assertEquals(test, "Register", "Actual value is " + test);


    }


    @Test
    public void insertintoTextboxes() throws InterruptedException {

        WebElement namefield = driver.findElement(By.xpath("//*[@type='text' and @placeholder='First Name']"));
        if (namefield.isDisplayed()) {
            namefield.click();
        }
        namefield.sendKeys("Vaclav");
        String actual = namefield.getAttribute("value");
        Assert.assertEquals(actual, "Vaclav", "actual value is" + actual);
        WebElement lastnamefield = driver.findElement(By.xpath("//*[@type='text' and @placeholder='Last Name']"));
        if (lastnamefield.isDisplayed()) {
            lastnamefield.click();
        }
        lastnamefield.sendKeys("Jurena");
        String alastname = lastnamefield.getAttribute("value");
        Assert.assertEquals(alastname, "Jurena", "actual value is" + alastname);
        Thread.sleep(4000);

    }


    //vyzkoušet stejnou metodu pro


    @Test
    public void handleSkillsDropdownMenu() throws InterruptedException {
        WebElement dropdownSkills = driver.findElement(By.id("Skills"));
        Select skill = new Select(dropdownSkills);
        skill.selectByIndex(10);
        skill.selectByVisibleText("Android");
        Thread.sleep(3000);

    }

    @Test
    public void handleCountryDropdown() throws InterruptedException {
        WebElement countriesdropdown = driver.findElement(By.xpath("//*[@id ='countries']"));
        Select countries = new Select(countriesdropdown);
        countries.selectByIndex(1);
        countries.selectByVisibleText("Japan");

        Thread.sleep(3000);
    }

    @Test
    public void handleCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.xpath("//*[@id = 'checkbox1']"));
        if (checkbox.isDisplayed()) {
            checkbox.click();
        } else {
            System.out.println("Element neni dostupny");
        }

        Thread.sleep(4000);
        System.out.println("Test passed");
    }
}
















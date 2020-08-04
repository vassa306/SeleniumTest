package pageobjects.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginForm {
    WebDriver driver;
    private final WebElement firstname;
    private final WebElement lastname;
    private final WebElement textarea;
    private final WebElement submitBtn;



    public LoginForm(WebDriver driver) {
        firstname = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
        lastname = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        textarea = driver.findElement(By.xpath("//textarea"));
        submitBtn = driver.findElement(By.id("submitbtn"));



    }

    public WebElement getFirstname() {
        return firstname;
    }



    public WebElement getLastname()
    {
        return lastname;
    }

    public WebElement getTextarea() {
        return textarea;
    }

    public WebElement getSubmitBtn()
    {
        return submitBtn;
    }



}

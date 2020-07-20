package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {
    private final WebElement login;
    private final WebElement password;
    private final WebElement loginButton;


    public LoginForm(WebDriver driver) {
        login = driver.findElement(By.id("email"));
        password = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.id("u_0_b"));
    }

    public WebElement getLogin() {
        return login;
    }



    public WebElement getPassword() {
        return password;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }
}

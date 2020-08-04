package pageobjects;

import org.openqa.selenium.WebDriver;
import pageobjects.pagefactory.LoginForm;

public class FbHomepage {
    private LoginForm loginForm;

    public FbHomepage(WebDriver driver) {
        this.loginForm = new LoginForm(driver);
    }


    public LoginForm getLoginForm() {
        return loginForm;
    }


}

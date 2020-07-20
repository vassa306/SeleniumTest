package pageobjects;

import Actions.HomepageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static constants.SystemConstants.DEFAULT_LOGIN_NAME;
import static constants.SystemConstants.PAGELOADING;

class SeleniumTest extends HomepageActions {


    FbHomepage fbhomepage;


    private static final String TEST_URL = "http://www.facebook.com";


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

    @Test
    public void CheckPageTitle() throws Exception {
        Thread.sleep(3000);
        String test = driver.getTitle();
        Assert.assertEquals(test, "Facebook – přihlaste se, nebo se zaregistrujte", "Actual value is " + test);


    }

    @Test
    public void loginIntoFacebook() throws InterruptedException {

        getLogin();


    }


    public void getLogin() throws InterruptedException {
        System.out.println("Starting test getLogin");
        WebElement emailfield = driver.findElement(By.id("email"));
        emailfield.click();
        emailfield.sendKeys("");
        String actuallogin = emailfield.getAttribute("value");
        Assert.assertEquals(actuallogin, "");
        WebElement passfield = driver.findElement(By.id("pass"));
        passfield.click();
        passfield.sendKeys("");
        String acutalpass = driver.findElement(By.id("pass")).getAttribute("value");
        Assert.assertEquals(acutalpass, "");
        WebElement LoginBtn = driver.findElement(By.id("u_0_b"));
        LoginBtn.click();
        Thread.sleep(PAGELOADING);
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, "https://www.facebook.com/", "actual is " + expectedUrl);
        WebElement admmenu = driver.findElement(By.xpath("//div[@aria-label='Účet']"));
        admmenu.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mount_0_0 > div > div > div.rq0escxv.l9j0dhe7.du4w35lb > div:nth-child(2) > div.n7fi1qx3.hv4rvrfc.b3onmgus.poy2od1o.kr520xx4.ehxjyohh > div:nth-child(2) > div > div:nth-child(1) > div.j34wkznp.qp9yad78.pmk7jnqg.kr520xx4 > div.iqfcb0g7.tojvnm2t.a6sixzi8.k5wvi7nf.q3lfd5jv.pk4s997a.bipmatt0.cebpdrjk.qowsmv63.owwhemhu.dp1hu0rb.dhp61c6y.l9j0dhe7.iyyx5f41.a8s20v7p > div > div > div > div > div > div > div > div.kr520xx4.pedkr2u6.ms05siws.pnx7fd3z.b7h9ocf4.pmk7jnqg.j9ispegn.k4urcfbm > div.a8nywdso.sj5x9vvc.rz4wbd8a.ecm0bbzt > div > div:nth-child(5) > div")));
        logout.click();
        System.out.println("passed");
        /*
        WebElement element = driver.findElement(By.xpath("//a[@role = 'button']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
*/
        Thread.sleep(4000);

    }

    public void resetPasswordTest() throws InterruptedException {
        resetPasswordinFB();


        // Assert.assertEquals(resetlinktext,"Zapomněli jste přístup k účtu?");

    }

    public void resetPasswordinFB() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement reset = driver.findElement(By.linkText("Zapomněli jste přístup k účtu?"));
        reset.click();
        WebElement input = driver.findElement(By.id("identify_email"));
        input.sendKeys(DEFAULT_LOGIN_NAME);
        String actualvalue = input.getAttribute("value");
        Assert.assertEquals(actualvalue, "vassa306@gmail.com");
        WebElement searchbutton = driver.findElement(By.id("u_0_2"));
        if (searchbutton.isDisplayed()) {
            searchbutton.click();
        }
        Thread.sleep(5000);
    }


    public static void getAllappLinks() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for (WebElement link : allLinks) {
            System.out.println("link is: \n" + link.getText() + "\n" + " attribute: \n" + link.getAttribute("href"));
            System.out.println(allLinks.size());
            Assert.assertTrue(57 == allLinks.size(), "actual size of links is " + allLinks.size());
        }

    }
}






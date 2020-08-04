package Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public abstract class HomepageActions {
    protected static WebDriver driver;

    protected abstract String getUrl();

    public void commonChromeSetup() throws Exception {
        System.out.println("Starting test");
        System.setProperty("webdriver.chrome.driver", "C://Users//vjurena//Downloads//chromedriver_win32 (4)//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("launching Google Chrome browser");
        driver.get(getUrl());
    }

    public void commonEdgeSetup() throws Exception{
        System.out.println("starting test");
        System.setProperty("wedriver.firefox.driver", "C:\\Users\\vjurena\\Downloads\\firefox\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        System.out.println("launching Edge driver");
        driver.get(getUrl());

    }

    public static void selectDropDownOption(String dropDownID, String option) throws InterruptedException {
        String selector = "select2-" + dropDownID + "-container";

        Thread.sleep(2000);
        driver.findElement(id(selector)).click();
        Thread.sleep(1000);

        driver.findElement(cssSelector("input.select2-search__field")).sendKeys(option);
        Thread.sleep(500);
        driver.findElement(cssSelector("input.select2-search__field")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);



    }

}
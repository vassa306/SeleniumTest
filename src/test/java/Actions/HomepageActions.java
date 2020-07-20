package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class HomepageActions {
    protected static WebDriver driver;

    protected abstract String getUrl();

    public void commonChromeSetup() throws Exception {
        System.out.println("Starting test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vjurena\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
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

    public void selectDropdownMenu(){


    }

}
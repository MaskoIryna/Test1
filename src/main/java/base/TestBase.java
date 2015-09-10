package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 9/3/2015.
 */
public class TestBase {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        String browser = System.getProperty("browser", "firefox");

        /*switch (browser) {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "ie": driver = new InternetExplorerDriver(); break;
            default: driver = new FirefoxDriver(); break;
        }*/

        driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.tut.by");
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}

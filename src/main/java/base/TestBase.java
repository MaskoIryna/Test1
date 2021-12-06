package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("browser", CHROME);

        /*switch (browser) {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "ie": driver = new InternetExplorerDriver(); break;
            default: driver = new FirefoxDriver(); break;
        }*/

        Configuration.browser = browser;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;

        open("https://www.google.com/");
    }

//    @AfterMethod
//    public void teardown() {
//        driver.close();
//    }
}

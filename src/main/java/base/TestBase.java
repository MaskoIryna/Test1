package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;
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

        if (browser == EDGE) {
            WebDriver edge = new EdgeDriver();
            edge.manage().window().maximize();
            WebDriverRunner.setWebDriver(edge);
        } else {
            Configuration.browser = browser;
        }

        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;

        open("https://www.google.com/");
    }

    @AfterMethod
    public void teardown() {
        WebDriverRunner.closeWebDriver();
    }

    @AfterTest
    public void addEnvData() {
        File file = new File("target/allure-results/environment.properties");
        String envVars = "Browser=%s\nBrowser.Version=%s\nStand=%s";
        envVars = String.format(envVars, Configuration.browser, Configuration.browserVersion, "Prod");

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(envVars);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

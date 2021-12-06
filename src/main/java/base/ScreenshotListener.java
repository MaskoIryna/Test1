package base;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.codeborne.selenide.WebDriverRunner.source;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Allure.addAttachment("Screenshot", getScreenshotAsInputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Allure.addAttachment("Page source", "text", source(), ".html");
    }

    private static InputStream getScreenshotAsInputStream() throws FileNotFoundException {
        File screenshot = Selenide.screenshot(OutputType.FILE);
        return new FileInputStream(screenshot);
    }
}

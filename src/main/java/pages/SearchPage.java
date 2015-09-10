package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by student on 9/8/2015.
 */
public class SearchPage {

    private static final By RESULTS_LIST = By.className("b-results-list");
    private static final By RESULT = By.cssSelector("h3>a[target]");


    public static boolean checkLinkText(WebDriver driver, String linkText) {
        List<WebElement> linksList = /*driver.findElement(RESULTS_LIST)*/driver.findElements(RESULT);
        //boolean linkExists = false;

        for (WebElement webElement : linksList) {
            String actualText = webElement.getText();
            if (webElement.getText().equals(linkText)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLinkUrl(WebDriver driver, String linkUrl) {
        List<WebElement> linksList = driver.findElement(RESULTS_LIST).findElements(RESULT);
        //boolean linkExists = false;

        for (WebElement webElement : linksList) {
            if (webElement.getAttribute("href").equals(linkUrl)) {
                return true;
            }
        }
        return false;
    }
}

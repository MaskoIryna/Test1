package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by student on 9/3/2015.
 */
public class HomePage {
    private static final By SEARCH_FIELD = By.id("search_from_str");
    private static final By SEARCH_BUTTON = By.cssSelector(".button.big");

    public static void search(WebDriver driver, String searchStr) {
        driver.findElement(SEARCH_FIELD).sendKeys(searchStr);
        driver.findElement(SEARCH_BUTTON).click();
    }

}

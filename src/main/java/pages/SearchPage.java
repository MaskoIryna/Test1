package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private static final By RESULTS_LIST = By.id("search");
    private static final By RESULT_TEXT = By.cssSelector("#search a>br+h3");
    private static final By RESULT_LINK = By.xpath("//*[@id='search']//a[br]");


    public static boolean checkLinkText(String linkText) {
        List<SelenideElement> linksList = $$(RESULT_TEXT);

        for (WebElement webElement : linksList) {
//            String actualText = webElement.getText();
            if (webElement.getText().equals(linkText)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLinkUrl(String linkUrl) {
        List<SelenideElement> linksList = $$(RESULT_LINK);
        //boolean linkExists = false;

        for (WebElement webElement : linksList) {
            if (webElement.getAttribute("href").equals(linkUrl)) {
                return true;
            }
        }
        return false;
    }
}

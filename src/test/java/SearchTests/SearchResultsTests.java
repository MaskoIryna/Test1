package SearchTests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

import static org.testng.AssertJUnit.assertTrue;

public class SearchResultsTests extends TestBase{
    private final String SEARCH_TEXT = "Selenium WebDriver";
    private final String SEARCH_RESULT_TEXT = "WebDriver | Selenium";
    private final String SEARCH_URL = "https://www.selenium.dev/documentation/webdriver/";

    @Test
    public void searchResultsLinksCheck() {
        HomePage.search(SEARCH_TEXT);
        assertTrue("Не найдено ссылки с заданым текстом", SearchPage.checkLinkText(SEARCH_RESULT_TEXT));
        assertTrue("Link Url not found", SearchPage.checkLinkUrl(SEARCH_URL));
    }
}

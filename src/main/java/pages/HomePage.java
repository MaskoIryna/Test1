package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private static final By SEARCH_FIELD = By.name("q");
    private static final By SEARCH_BUTTON = By.name("btnK");

    public static void search(String searchStr) {
        $(SEARCH_FIELD).sendKeys(searchStr);
        $(SEARCH_BUTTON).click();
    }

}

package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.IPageObject;
import util.TestProperties;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {
    String searchTerm;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        searchTerm = TestProperties
                .getTestDataProperties().getProperty("search_term");
    }

    @Test(groups = {"web"}, description = "Make sure receiving relevant results by search in Google search page")
    public void testValidateSearchResults() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        getDriver().get("https://www.google.com/");
        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getPo().getWelement("searchField").sendKeys(searchTerm);
        getPo().getWelement("searchField").sendKeys(Keys.ENTER);

        List<WebElement> searchResults = getPo().getListWelements("searchResults");

        assertFalse (searchResults.isEmpty());

        String someResult =  searchResults.get(0).getText();

        assertTrue(someResult.contains(searchTerm));

    }
}

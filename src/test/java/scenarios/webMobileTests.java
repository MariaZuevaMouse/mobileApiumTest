package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import testData.DataProviders;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {


    @Test(groups = {"web"}, description = "Make sure receiving relevant results by search in Google search page",
    dataProviderClass = DataProviders.class, dataProvider = "webTestTerm")
    public void testValidateSearchResults(String searchTerm) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InterruptedException {

        getDriver().get("https://www.google.com/");
        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getPo().getWelement("searchField").sendKeys(searchTerm);
        getPo().getWelement("searchField").sendKeys(Keys.ENTER);

//        getDriverWait().until(ExpectedConditions.visibilityOf(getPo().getWelement("searchResultAppeared")));

        List<WebElement> searchResults = getPo().getListWelements("searchResults");

        assertFalse (searchResults.isEmpty());

        String someResult =  searchResults.get(0).getText();

        assertTrue(someResult.contains(searchTerm));

    }
}

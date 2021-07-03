package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebPageObject  {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(css = "div[id='rso'] div[role='heading'][aria-level='3']")
    private List<WebElement> searchResults;

    @FindBy(css = "a[href='https://www.epam-group.ru/']")
    private WebElement searchResultAppeared;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }


}

package setup;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IPageObject {

    WebElement getWelement(String weName)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    List<WebElement> getListWelements(String weName)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException;

}

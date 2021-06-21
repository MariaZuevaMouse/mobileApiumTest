package scenarios;

import org.testng.annotations.Test;
import pageObjects.NativeAppActions;
import setup.BaseTest;
import testdata.DataProviders;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Create simple account and login test",
            dataProviderClass = DataProviders.class, dataProvider = "nativeTestData")
    public void testRegisterAccount(String userMail, String userName, String userPassword)  throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        NativeAppActions.registerAccount(getPo(), userMail, userName, userPassword);

        NativeAppActions.loginAccount(getPo(), userMail, userPassword);

        String budgetPageName = getPo().getWelement("budgetPageName").getText();

        assert (budgetPageName.equals("BudgetActivity"));

    }

}

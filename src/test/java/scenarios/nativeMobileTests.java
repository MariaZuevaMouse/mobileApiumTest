package scenarios;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.NativeAppActions;
import pageObjects.NativeAppElements;
import setup.BaseTest;
import util.TestProperties;

public class nativeMobileTests extends BaseTest {
    String userMail;
    String userName;
    String userPassword;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        userMail = TestProperties.getTestDataProperties().getProperty("user_email");
        userName = TestProperties.getTestDataProperties().getProperty("user_name");
        userPassword = TestProperties.getTestDataProperties().getProperty("user_password");
        System.out.println("setUp  method done/ user mail: " + userMail);
    }

    @Test(groups = {"native"}, description = "Create simple account and login test")
    public void testRegisterAccount() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        NativeAppActions.registerAccount(getPo(), userMail, userName, userPassword);

        NativeAppActions.loginAccount(getPo(), userMail, userPassword);

        String budgetPageName = getPo().getWelement("budgetPageName").getText();

        assert (budgetPageName.contains("Budget"));

    }

}

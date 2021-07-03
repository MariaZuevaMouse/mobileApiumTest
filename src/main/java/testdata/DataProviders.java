package testdata;

import org.testng.annotations.DataProvider;
import util.TestProperties;

public class DataProviders {

    @DataProvider(name = "webTestTerm")
    public static Object[][] webTestTerm(){
        return new Object[][]{{TestProperties.getTestDataProperties().getProperty("search_term")}};
    }

    @DataProvider(name = "nativeTestData")
    public static Object[][] nativeTestData(){
        return new Object[][]{{TestProperties.getTestDataProperties().getProperty("user_email"),
                TestProperties.getTestDataProperties().getProperty("user_name"),
                TestProperties.getTestDataProperties().getProperty("user_password")}};
    }
}

package testdata;

import org.testng.annotations.DataProvider;
import util.TestProperties;

public class DataProviders {

    @DataProvider(name = "webTestTerm")
    public static Object[][] webTestTerm(){
        return new Object[][]{{TestProperties.getTestWebDataProperties().getProperty("search_term")}};
    }

    @DataProvider(name = "nativeTestData")
    public static Object[][] nativeTestData(){
        return new Object[][]{{TestProperties.getTestNativeDataProperties().getProperty("user_email"),
                TestProperties.getTestNativeDataProperties().getProperty("user_name"),
                TestProperties.getTestNativeDataProperties().getProperty("user_password")}};
    }
}

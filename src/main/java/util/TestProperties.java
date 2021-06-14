package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static Properties testDataProperties;
    private static String testDataPropsPath = "src/main/resources/test.properties";

    static {
        testDataProperties = new Properties();
        try (InputStream in = new FileInputStream(testDataPropsPath)){
            testDataProperties.load(in);
        }catch (IOException ex){
            System.out.println("Can not load properties file");
            ex.printStackTrace();
        }
    }

    public static Properties getTestDataProperties() {
        return testDataProperties;
    }
}

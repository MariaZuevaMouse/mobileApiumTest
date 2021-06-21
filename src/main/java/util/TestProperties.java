package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static Properties testNativeDataProperties;
    private static Properties testWebDataProperties;
    private static String testNativeDataPropsPath = "src/main/resources/testnative.properties";
    private static String testWebDataPropsPath = "src/main/resources/testweb.properties";

    static {
        testNativeDataProperties = new Properties();
        testWebDataProperties = new Properties();
        try (InputStream in = new FileInputStream(testNativeDataPropsPath);
             InputStream in2 = new FileInputStream(testWebDataPropsPath)){
            testNativeDataProperties.load(in);
            testWebDataProperties.load(in2);
        }catch (IOException ex){
            System.out.println("Can not load properties file");
            ex.printStackTrace();
        }
    }

    public static Properties getTestNativeDataProperties() {
        return testNativeDataProperties;
    }

    public static Properties getTestWebDataProperties() {
        return testWebDataProperties;
    }
}

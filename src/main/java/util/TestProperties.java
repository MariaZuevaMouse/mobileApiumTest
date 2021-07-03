package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static Properties testDataProperties;
    private static String testNativeDataPropsPath = "src/main/resources/testnative.properties";
    private static String testWebDataPropsPath = "src/main/resources/testweb.properties";
    
    public static void setTestDataProperties(String appType) throws Exception {
        testDataProperties = new Properties();
        if(appType.equals("web")) {
            loadProperties(testWebDataPropsPath);
        } else if (appType.equals("native")) {
            loadProperties(testNativeDataPropsPath);
        } else throw new Exception("Can not find test properties for app type: " + appType);
    }

    private static void loadProperties(String propsPath) {
        try(InputStream in = new FileInputStream(propsPath)) {
            testDataProperties.load(in);
        } catch (IOException ex) {
            System.out.println("Can not load properties file");
            ex.printStackTrace();
        }
    }

    public static Properties getTestDataProperties() {
        return testDataProperties;
    }
}

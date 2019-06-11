package pl.ufs.myjava.learning.configuration;

import java.io.IOException;
import java.util.Properties;

public abstract class ReadProperties {
    private Properties properties;

    protected void readProperties(String propertiesFileName) throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(propertiesFileName));
    }

    public String getProperty(String propertyName) {
        return properties != null ? properties.getProperty(propertyName) : null;
    }
}

package pl.ufs.myjava.learning.configuration;

import pl.ufs.myjava.learning.EquationFactory;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties extends ReadProperties {
    private static final String APPLICATION_PROPERTIES_FILE = "application.properties";

    public static final String ADDITION_MAX_NUMBER = "addition.max.number";
    public static final String SUBTRACTION_MAX_NUMBER = "subtraction.max.number";
    public static final String DEFAULT_EQUATION = "default.equation";

    public ApplicationProperties() {
        try {
            readProperties(APPLICATION_PROPERTIES_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

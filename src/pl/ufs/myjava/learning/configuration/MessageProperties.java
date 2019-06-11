package pl.ufs.myjava.learning.configuration;

import java.io.IOException;

public class MessageProperties extends ReadProperties {
    public static final String NEXT_EQUATION = "next.equation";
    public static final String ADDITON = "addition";
    public static final String SUBTRACTION = "subtraction";
    public static final String RESULT = "result";
    public static final String NO_RESULT = "no.result";

    private static final String MESSAGE_PROPERTIES_FILE = "messages.properties";

    public MessageProperties(String language) {
        try {
            readProperties(language + "." + MESSAGE_PROPERTIES_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

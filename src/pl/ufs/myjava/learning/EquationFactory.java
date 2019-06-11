package pl.ufs.myjava.learning;

import pl.ufs.myjava.learning.configuration.ApplicationProperties;

public class EquationFactory {
    public enum Type {ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION};

    private CreateSubtraction subtraction;
    private CreateAddition addition;

    public EquationFactory(ApplicationProperties applicationProperties) {
        createAddition(applicationProperties);
        createSubtraction(applicationProperties);
    }

    private void createSubtraction(ApplicationProperties applicationProperties) {
        subtraction = new CreateSubtraction(
                Integer.valueOf(applicationProperties.getProperty(ApplicationProperties.SUBTRACTION_MAX_NUMBER)));
    }

    private void createAddition(ApplicationProperties applicationProperties) {
        addition = new CreateAddition(
                Integer.valueOf(applicationProperties.getProperty(ApplicationProperties.ADDITION_MAX_NUMBER)));
    }

    public CreateEquation getEquation(String name) {
        CreateEquation result = null;
        Type type = Type.valueOf(name);

        switch (type) {
            case ADDITION:
                result = addition;
                break;
            case DIVISION:
                break;
            case SUBTRACTION:
                result = subtraction;
                break;
            case MULTIPLICATION:
                break;
        }

        return result;
    }
}

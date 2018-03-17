package pl.myjava.firstclass.math;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RowPanel extends JPanel {
    private List<JTextField> numbers;
    private JTextField result;
    private List<Operations> operations;

    public RowPanel(List<JTextField> numbers, JTextField result, List<Operations> operations) {
        this.numbers = numbers;
        this.result = result;
        this.operations = operations;

        validateNotEmpty();
        validateOperations();

        initUI();
    }

    private void initUI() {
        setLayout(new FlowLayout());
        addGUIElements();
    }

    private void addGUIElements() {
        for (int count = 0; count < numbers.size(); count++) {
            add(numbers.get(count));

            if (count < operations.size()) {
                add(operations.get(count).getImage());
            }
        }

        add(Operations.EQUALS.getImage());
        add(result);
    }

    private void validateOperations() {
        if ((numbers.size() - 1) != operations.size()) {
            throw new IllegalArgumentException("Operations list size should be smaller by one then numbers list");
        }
    }

    private void validateNotEmpty() {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("Numbers are empty");
        }

        if (result == null) {
            throw new IllegalArgumentException("Result is empty");
        }

        if (operations == null || operations.size() == 0) {
            throw new IllegalArgumentException("Operations are empty");
        }
    }
}

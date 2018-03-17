package pl.myjava.firstclass.math;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MathMainWindow extends JFrame {
    private static final Integer MAX_NUMBER_OF_NUMBERS = 10;

    private List<List<JTextField>> numbers = new ArrayList<>();
    private List<List<JTextField>> results = new ArrayList<>();

    public MathMainWindow() {
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // For Test
        List<JTextField> numbers = Arrays.asList(new JTextField("5"), new JTextField("4"));

        numbers.forEach(number -> {
            number.setEditable(false);
            number.setFont(number.getFont().deriveFont(Font.PLAIN, 30));
        });

        List<Operations> operations = Arrays.asList(Operations.PLUS);
        JTextField result = new JTextField("");
        result.setEditable(true);
        result.setFont(result.getFont().deriveFont(Font.PLAIN, 30));
        result.setColumns(1);

        RowPanel testRowPanel = new RowPanel(numbers, result, operations);

        add(testRowPanel);
    }

    public static void show(final MathMainWindow frame) {
        EventQueue.invokeLater(() -> {
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        MathMainWindow window = new MathMainWindow();
        MathMainWindow.show(window);
    }
}

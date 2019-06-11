package pl.ufs.myjava.learning;

import pl.ufs.myjava.learning.configuration.ApplicationProperties;
import pl.ufs.myjava.learning.configuration.MessageProperties;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        ApplicationProperties applicationProperties = new ApplicationProperties();
        MessageProperties messageProperties = new MessageProperties("pl");
        EquationFactory equationFactory = new EquationFactory(applicationProperties);

        add(new MainPanel(
                equationFactory,
                applicationProperties,
                messageProperties));
        setTitle("Nauka liczenia");
        setSize(500, 500);
        setResizable(false);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}

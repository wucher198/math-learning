package pl.ufs.myjava.learning;

import pl.ufs.myjava.learning.configuration.ApplicationProperties;
import pl.ufs.myjava.learning.configuration.MessageProperties;
import pl.ufs.myjava.learning.panels.CentralPanel;
import pl.ufs.myjava.learning.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private EquationFactory equationFactory;
    private ApplicationProperties applicationProperties;
    private MessageProperties messageProperties;

    public MainPanel(EquationFactory equationFactory,
                     ApplicationProperties applicationProperties,
                     MessageProperties messageProperties) {
        this.equationFactory = equationFactory;
        this.applicationProperties = applicationProperties;
        this.messageProperties = messageProperties;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        CentralPanel centralPanel = new CentralPanel(
                equationFactory,
                applicationProperties,
                messageProperties);
        add(centralPanel, BorderLayout.CENTER);
        TopPanel topPanel = new TopPanel(
                equationFactory,
                applicationProperties,
                messageProperties,
                centralPanel);
        add(topPanel, BorderLayout.NORTH);
    }
}

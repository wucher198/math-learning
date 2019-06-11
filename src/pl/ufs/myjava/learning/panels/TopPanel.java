package pl.ufs.myjava.learning.panels;

import pl.ufs.myjava.learning.EquationFactory;
import pl.ufs.myjava.learning.configuration.ApplicationProperties;
import pl.ufs.myjava.learning.configuration.MessageProperties;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TopPanel extends JPanel {
    private EquationFactory equationFactory;
    private ApplicationProperties applicationProperties;
    private MessageProperties messageProperties;
    private CentralPanel centralPanel;

    public TopPanel (EquationFactory equationFactory,
                     ApplicationProperties applicationProperties,
                     MessageProperties messageProperties,
                     CentralPanel centralPanel) {
        this.equationFactory = equationFactory;
        this.applicationProperties = applicationProperties;
        this.messageProperties = messageProperties;
        this.centralPanel = centralPanel;
        initUI();
    }

    private void initUI() {
        JRadioButton radioAddition = new JRadioButton(
                messageProperties.getProperty(MessageProperties.ADDITON));
        radioAddition.setSelected(true);
        radioAddition.setActionCommand(EquationFactory.Type.ADDITION.name());
        radioAddition.addActionListener(this::changeEquation);

        JRadioButton radioSubtraction = new JRadioButton(
                messageProperties.getProperty(MessageProperties.SUBTRACTION));
        radioSubtraction.setActionCommand(EquationFactory.Type.SUBTRACTION.name());
        radioSubtraction.addActionListener(this::changeEquation);

        ButtonGroup group = new ButtonGroup();
        group.add(radioAddition);
        group.add(radioSubtraction);

        add(radioAddition);
        add(radioSubtraction);
    }

    private void changeEquation(ActionEvent event) {
        centralPanel
                .getResultBoxKeyListener()
                .changeCreateEquation(equationFactory.getEquation(event.getActionCommand()));
        centralPanel
                .getNextEquationActionListener()
                .changeCreateEquation(equationFactory.getEquation(event.getActionCommand()));
    }
}

package pl.ufs.myjava.learning.listeners;

import pl.ufs.myjava.learning.CreateEquation;
import pl.ufs.myjava.learning.configuration.MessageProperties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pl.ufs.myjava.learning.Constant.NEXT_BUTTON_COMMAND;

public class NextEquationActionListener implements ActionListener {
    private MessageProperties messageProperties;
    private CreateEquation createEquation;
    private JLabel equation;
    private JTextField resultBox;
    private JLabel resultMessage;

    public NextEquationActionListener(
            MessageProperties messageProperties,
            CreateEquation createEquation,
            JLabel equation,
            JTextField resultBox,
            JLabel resultMessage) {
        this.messageProperties = messageProperties;
        this.createEquation = createEquation;
        this.equation = equation;
        this.resultBox = resultBox;
        this.resultMessage = resultMessage;
    }

    public void changeCreateEquation(CreateEquation createEquation) {
        this.createEquation = createEquation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (NEXT_BUTTON_COMMAND.equals(e.getActionCommand())) {
            createEquation.createNext();
            equation.setText(createEquation.getEquation());
            resultMessage.setText(
                    messageProperties.getProperty(MessageProperties.RESULT)
            );
            resultBox.setText("");
            resultBox.requestFocus();
        }
    }
}

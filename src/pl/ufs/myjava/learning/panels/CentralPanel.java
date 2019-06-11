package pl.ufs.myjava.learning.panels;

import pl.ufs.myjava.learning.CreateEquation;
import pl.ufs.myjava.learning.EquationFactory;
import pl.ufs.myjava.learning.configuration.ApplicationProperties;
import pl.ufs.myjava.learning.configuration.MessageProperties;
import pl.ufs.myjava.learning.listeners.NextEquationActionListener;
import pl.ufs.myjava.learning.listeners.ResultBoxKeyListener;

import javax.swing.*;

import static pl.ufs.myjava.learning.Constant.*;

public class CentralPanel extends JPanel {
    private JLabel equation;
    private JTextField resultBox;
    private JLabel resultMessage;
    private JButton nextEquation;

    private ResultBoxKeyListener resultBoxKeyListener;
    private NextEquationActionListener nextEquationActionListener;

    private EquationFactory equationFactory;
    private ApplicationProperties applicationProperties;
    private MessageProperties messageProperties;

    public CentralPanel(EquationFactory equationFactory,
                        ApplicationProperties applicationProperties,
                        MessageProperties messageProperties) {
        this.equationFactory = equationFactory;
        this.applicationProperties = applicationProperties;
        this.messageProperties = messageProperties;
        initUI();
    }

    public ResultBoxKeyListener getResultBoxKeyListener() {
        return resultBoxKeyListener;
    }

    public NextEquationActionListener getNextEquationActionListener() {
        return nextEquationActionListener;
    }

    private void initUI() {
        initEquationLabel();
        initMessageLabel();
        initResultBox();
        initNextButton();
        addCentralElements();
    }

    private void addCentralElements() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(equation);
        add(resultBox);
        add(resultMessage);
        add(nextEquation);
    }

    private void initMessageLabel() {
        resultMessage = new JLabel(
                messageProperties.getProperty(MessageProperties.RESULT));
        resultMessage.setFont(smallFont);
    }

    private void initNextButton() {
        nextEquation = new JButton(
                messageProperties.getProperty(MessageProperties.NEXT_EQUATION)
        );
        nextEquation.setFont(buttonFont);
        nextEquation.setActionCommand(NEXT_BUTTON_COMMAND);
        nextEquationActionListener = new NextEquationActionListener(
                messageProperties,
                getDefaultEquation(),
                equation,
                resultBox,
                resultMessage);
        nextEquation.addActionListener(nextEquationActionListener);
    }

    private void initEquationLabel() {
        equation = new JLabel();
        equation.setFont(font);
        equation.setText(getDefaultEquation().getEquation());
        add(equation);
    }

    private void initResultBox() {
        resultBox = new JTextField();
        resultBox.setFont(font);
        resultBoxKeyListener = new ResultBoxKeyListener(
                messageProperties,
                getDefaultEquation(),
                resultBox,
                resultMessage);
        resultBox.addKeyListener(resultBoxKeyListener);
        resultBox.setFocusable(true);
    }

    private CreateEquation getDefaultEquation() {
        return equationFactory.getEquation(applicationProperties.getProperty(ApplicationProperties.DEFAULT_EQUATION));
    }
}

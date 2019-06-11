package pl.ufs.myjava.learning.listeners;

import pl.ufs.myjava.learning.CreateEquation;
import pl.ufs.myjava.learning.configuration.MessageProperties;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ResultBoxKeyListener implements KeyListener {
        private CreateEquation equation;
        private JTextField result;
        private JLabel message;
        private MessageProperties messageProperties;

        public ResultBoxKeyListener(
                MessageProperties messageProperties,
                CreateEquation equation,
                JTextField result,
                JLabel message) {
            this.messageProperties = messageProperties;
            this.equation = equation;
            this.result = result;
            this.message = message;
        }

        public void changeCreateEquation(CreateEquation createEquation) {
            this.equation = createEquation;
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_ENTER) {
                String strResult = result.getText();

                if (strResult != null && !strResult.isEmpty()) {
                    message.setText(Boolean.toString(equation.checkResult(Integer.valueOf(strResult))));
                } else {
                    message.setText(
                            messageProperties.getProperty(MessageProperties.NO_RESULT));
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
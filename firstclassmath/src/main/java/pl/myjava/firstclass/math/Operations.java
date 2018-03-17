package pl.myjava.firstclass.math;

import javax.imageio.ImageIO;
import javax.swing.*;

public enum Operations {
    PLUS("plus.png"),
    MINUS("minus.png"),
    DIVIDE("divide.png"),
    MULTIPLY("multiply.png"),
    EQUALS("equals.png");

    private String fileName;

    Operations(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public JLabel getImage() {
        JLabel result = new JLabel("");
        result.setIcon(new ImageIcon(getClass().getClassLoader().getResource(fileName)));

        return result;
    }
}

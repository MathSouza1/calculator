package com.matheuscardoso.calculator.components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    private static final int FONT_SIZE = 25;

    public Button(String text, Color color) {
        setText(text);
        setFont(new Font("courier", Font.PLAIN, FONT_SIZE));
        setOpaque(true);
        setBackground(color);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}

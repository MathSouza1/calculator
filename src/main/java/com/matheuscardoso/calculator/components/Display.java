package com.matheuscardoso.calculator.components;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    private static final int RED_COLOR_PARAMETER = 46;
    private static final int GREEN_COLOR_PARAMETER = 49;
    private static final int BLUE_COLOR_PARAMETER = 50;
    private static final int FONT_SIZE_JLABEL = 30;
    private static final int HORIZONTAL_GAP_BETWEEN_COMPONENTS = 10;
    private static final int VERTICAL_GAP_BETWEEN_COMPONENTS = 25;
    private final JLabel jLabel;

    public Display() {
        setBackground(new Color(RED_COLOR_PARAMETER, GREEN_COLOR_PARAMETER, BLUE_COLOR_PARAMETER));
        jLabel = new JLabel("12.345,67");
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Courier", Font.PLAIN, FONT_SIZE_JLABEL));
        setLayout(new FlowLayout(FlowLayout.RIGHT, HORIZONTAL_GAP_BETWEEN_COMPONENTS, VERTICAL_GAP_BETWEEN_COMPONENTS));
        add(jLabel);
    }
}

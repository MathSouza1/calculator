package com.matheuscardoso.calculator.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Keyboard extends JPanel  {

    private static final int NUMBER_ROWS_LAYOUT = 5;
    private static final int NUMBER_COLUMNS_LAYOUT = 4;
    private static final Color DARK_GRAY = new Color(68, 68, 68);
    private static final Color LIGHT_GRAY = new Color(99, 99, 99);
    private static final Color ORANGE = new Color(242, 163, 60);

    public Keyboard() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(layout);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridwidth = 2;
        addButton("AC", DARK_GRAY, constraints, 0, 0);
        constraints.gridwidth = 1;
        addButton("±", DARK_GRAY, constraints, 2, 0);
        addButton("/", ORANGE, constraints, 3, 0);

        addButton("7", LIGHT_GRAY, constraints, 0, 1);
        addButton("8", LIGHT_GRAY, constraints, 1, 1);
        addButton("9", LIGHT_GRAY, constraints, 2, 1);
        addButton("*", ORANGE, constraints, 3, 1);

        addButton("4", LIGHT_GRAY, constraints, 0, 2);
        addButton("5", LIGHT_GRAY, constraints, 1, 2);
        addButton("6", LIGHT_GRAY, constraints, 2, 2);
        addButton("-", ORANGE, constraints, 3, 2);

        addButton("1", LIGHT_GRAY, constraints, 0, 3);
        addButton("2", LIGHT_GRAY, constraints, 1, 3);
        addButton("3", LIGHT_GRAY, constraints, 2, 3);
        addButton("+", ORANGE, constraints, 3, 3);

        constraints.gridwidth = 2;
        addButton("0", LIGHT_GRAY, constraints, 0, 4);
        constraints.gridwidth = 1;
        addButton(",", LIGHT_GRAY, constraints, 2, 4);
        addButton("=", ORANGE, constraints, 3, 4);
    }

    private void addButton(String text, Color color, GridBagConstraints constraints, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        Button button = new Button(text, color);
        add(button, constraints);
    }
}

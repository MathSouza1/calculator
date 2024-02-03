package com.matheuscardoso.calculator.components;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JPanel {

    private static final int NUMBER_ROWS_LAYOUT = 5;
    private static final int NUMBER_COLUMNS_LAYOUT = 4;
    private static final Color DARK_GRAY = new Color(68, 68, 68);
    private static final Color LIGHT_GRAY = new Color(99, 99, 99);
    private static final Color ORANGE = new Color(242, 163, 60);

    public Keyboard() {
        setLayout(new GridLayout(NUMBER_ROWS_LAYOUT, NUMBER_COLUMNS_LAYOUT));
        add(new Button("AC", DARK_GRAY));
        add(new Button("+/-", DARK_GRAY));
        add(new Button("%", DARK_GRAY));
        add(new Button("/", ORANGE));

        add(new Button("7", LIGHT_GRAY));
        add(new Button("8", LIGHT_GRAY));
        add(new Button("9", LIGHT_GRAY));
        add(new Button("*", ORANGE));

        add(new Button("7", LIGHT_GRAY));
        add(new Button("8", LIGHT_GRAY));
        add(new Button("9", LIGHT_GRAY));
        add(new Button("*", ORANGE));

        add(new Button("7", LIGHT_GRAY));
        add(new Button("8", LIGHT_GRAY));
        add(new Button("9", LIGHT_GRAY));
        add(new Button("*", ORANGE));

        add(new Button("7", LIGHT_GRAY));
        add(new Button("8", LIGHT_GRAY));
        add(new Button("9", LIGHT_GRAY));
        add(new Button("*", ORANGE));
    }
}

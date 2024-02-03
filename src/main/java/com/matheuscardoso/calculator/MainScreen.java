package com.matheuscardoso.calculator;

import com.matheuscardoso.calculator.components.Display;
import com.matheuscardoso.calculator.components.Keyboard;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

    private static final int CALCULATOR_WIDTH = 232;
    private static final int CALCULATOR_HEIGHT = 322;
    private static final int DIMENSION_WIDTH = 233;
    private static final int DIMENSION_HEIGHT = 60;

    public MainScreen() {
        layoutOrganizer();

        setSize(CALCULATOR_WIDTH, CALCULATOR_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void layoutOrganizer() {
        setLayout(new BorderLayout());
        Display display = new Display();
        display.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        add(display, BorderLayout.NORTH);

        Keyboard keyboard = new Keyboard();
        add(keyboard, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MainScreen();
    }
}
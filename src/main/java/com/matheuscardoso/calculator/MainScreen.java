package com.matheuscardoso.calculator;

import javax.swing.*;

public class MainScreen extends JFrame {

    private static final int CALCULATOR_WIDTH = 232;
    private static final int CALCULATOR_HEIGHT = 322;

    public MainScreen() {
        setSize(CALCULATOR_WIDTH, CALCULATOR_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainScreen();
    }
}
package com.matheuscardoso.calculator.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyboardTest {

    @InjectMocks
    private Keyboard keyboard;

    @Mock
    private ActionEvent actionEvent;

    @Mock
    private JButton button;

    @BeforeEach
    void init() {
        button = new JButton();
        actionEvent = new ActionEvent(button, 1, "TESTE");
    }
    @Test
    void testKeyboardSuccessfully() {
        boolean valid = true;
        try {
            keyboard = new Keyboard();
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testKeyboardActionPerformedSuccessfully() {
        boolean valid = true;
        try {
            keyboard = new Keyboard();
            keyboard.actionPerformed(actionEvent);
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }
}

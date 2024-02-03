package com.matheuscardoso.calculator.components;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonTest {

    @InjectMocks
    private Button button;

    @Test
    void testButtonSuccessfully() {
        boolean valid = true;
        try {
            button = new Button("TESTE", Color.BLACK);
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }
}

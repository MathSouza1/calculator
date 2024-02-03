package com.matheuscardoso.calculator.components;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayTest {

    @InjectMocks
    private Display display;

    @Test
    void testDisplaySuccessfully() {
        boolean valid = true;
        try {
            display = new Display();
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testDisplayChangedValueSuccessfully() {
        boolean valid = true;
        try {
            display = new Display();
            display.changedValue("TESTE");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }
}


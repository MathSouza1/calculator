package com.matheuscardoso.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainScreenTest {

    @Test
    void testMainScreenSuccessfully() {
        boolean valid = true;
        try {
            MainScreen.main(new String[] {});
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }
}

package com.matheuscardoso.calculator.model;

import com.matheuscardoso.calculator.observers.MemoryObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemoryTest {

    @InjectMocks
    private Memory memory;

    @Mock
    private MemoryObserver observer;

    @BeforeEach
    void init() {
        memory = new Memory();
    }

    @Test
    void testInstanceGetter() {
        boolean valid = true;
        try {
            memory.getInstance();
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testGetActualText() {
        boolean valid = true;
        try {
            memory.getActualText();
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testAddObserver() {
        boolean valid = true;
        try {
            memory.addObserver(observer);
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeNull() {
        boolean valid = true;
        try {
            memory.processCommand(null);
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessValidText() {
        boolean valid = true;
        try {
            memory.processCommand("0");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeReset() {
        boolean valid = true;
        try {
            memory.processCommand("AC");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeSignalAndHyfen() {
        boolean valid = true;
        try {
            memory.setActualText("-");
            memory.processCommand("+/-");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeSignalAndNotHyfen() {
        boolean valid = true;
        try {
            memory.processCommand("±");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeNumber() {
        boolean valid = true;
        try {
            memory.setActualText("");
            memory.processCommand("9");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeComma() {
        boolean valid = true;
        try {
            memory.processCommand(",");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeDivided() {
        boolean valid = true;
        try {
            memory.processCommand("/");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeTimes() {
        boolean valid = true;
        try {
            memory.processCommand("*");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypePlus() {
        boolean valid = true;
        try {
            memory.processCommand("+");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testProcessCommandTypeMinus() {
        boolean valid = true;
        try {
            memory.processCommand("-");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testGetOperationResultPlus() {
        boolean valid = true;
        try {
            memory.processCommand("2");
            memory.processCommand("+");
            memory.processCommand("2");
            memory.processCommand("=");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testGetOperationResultMinus() {
        boolean valid = true;
        try {
            memory.processCommand("2");
            memory.processCommand("-");
            memory.processCommand("2");
            memory.processCommand("=");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testGetOperationResultTimes() {
        boolean valid = true;
        try {
            memory.processCommand("2");
            memory.processCommand("*");
            memory.processCommand("2");
            memory.processCommand("=");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    void testGetOperationResultDivided() {
        boolean valid = true;
        try {
            memory.processCommand("2");
            memory.processCommand("/");
            memory.processCommand("2");
            memory.processCommand("=");
        } catch (Exception e) {
            valid = false;
        }
        assertTrue(valid);
    }
}

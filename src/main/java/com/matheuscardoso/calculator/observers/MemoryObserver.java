package com.matheuscardoso.calculator.observers;

@FunctionalInterface
public interface MemoryObserver {
    void changedValue(String newValue);
}

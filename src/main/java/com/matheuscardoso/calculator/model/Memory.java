package com.matheuscardoso.calculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Memory {

    @Getter
    private static final Memory instance = new Memory();
    private String actualText = "";

    public String getActualText() {
        return actualText.isEmpty() ? "0" : actualText;
    }

}
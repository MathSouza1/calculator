package com.matheuscardoso.calculator.model;

import com.matheuscardoso.calculator.enumerators.CommandType;
import com.matheuscardoso.calculator.observers.MemoryObserver;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class Memory {

    @Getter
    private static final Memory instance = new Memory();
    private final List<MemoryObserver> observers = new ArrayList<>();
    private CommandType lastOperation = null;
    private boolean replace = false;
    @Setter
    private String actualText = "";
    private String bufferText = "";

    public String getActualText() {
        return actualText.isEmpty() ? "0" : actualText;
    }

    public void addObserver(MemoryObserver observer) {
        observers.add(observer);
    }

    public void processCommand(String text) {
        CommandType commandType = detectCommandType(text);
        if (commandType == null) {
            return;
        } else if (checkCommandTypeIsReset(commandType)) {
            actualText = "";
            bufferText = "";
            replace = false;
            lastOperation = null;
        } else if (checkCommandTypeIsSignalAndHasHyfen(commandType)) {
            actualText = actualText.substring(1);
        } else if (checkCommandTypeIsSignalAndHasNotHyfen(commandType)) {
            actualText = "-" + actualText;
        } else if (checkCommandTypeIsNumberOrComma(commandType)) {
            actualText = replace ? text : actualText + text;
            replace = false;
        } else {
            replace = true;
            actualText = getOperationResult();
            bufferText = actualText;
            lastOperation = commandType;
        }
        observers.forEach(observer -> observer.changedValue(getActualText()));
    }

    private String getOperationResult() {
        if (lastOperation == null || lastOperation == CommandType.EQUALS) {
            return actualText;
        }
        double bufferNumber = Double.parseDouble(bufferText.replace(",", "."));
        double actualNumber = Double.parseDouble(actualText.replace(",", "."));
        double result = 0;
        if(lastOperation == CommandType.PLUS) {
            result = bufferNumber + actualNumber;
        } else if(lastOperation == CommandType.MINUS) {
            result = bufferNumber - actualNumber;
        } else if(lastOperation ==  CommandType.TIMES) {
            result = bufferNumber * actualNumber;
        } else if(lastOperation == CommandType.DIVIDED) {
            result = bufferNumber / actualNumber;
        }

        String text = Double.toString(result).replace(".", ",");
        boolean integer = text.endsWith(",0");
        return integer ? text.replace(",0", "") : text;
    }

    private boolean checkCommandTypeIsNumberOrComma(CommandType commandType) {
        return commandType == CommandType.NUMBER || commandType == CommandType.COMMA;
    }

    private boolean checkCommandTypeIsSignalAndHasNotHyfen(CommandType commandType) {
        return commandType == CommandType.SIGNAL && !actualText.contains("-");
    }

    private boolean checkCommandTypeIsSignalAndHasHyfen(CommandType commandType) {
        return commandType == CommandType.SIGNAL && actualText.contains("-");
    }

    private boolean checkCommandTypeIsReset(CommandType commandType) {
        return commandType == CommandType.RESET;
    }

    private CommandType detectCommandType(String text) {
        if(isValidText(text)) {
            return null;
        }
        try {
            Integer.parseInt(text);
            return CommandType.NUMBER;
        } catch (NumberFormatException e) {
            if("AC".equals(text)) {
                return CommandType.RESET;
            } else if("/".equals(text)) {
                return CommandType.DIVIDED;
            } else if("*".equals(text)) {
                return CommandType.TIMES;
            } else if("+".equals(text)) {
                return CommandType.PLUS;
            } else if("-".equals(text)) {
                return CommandType.MINUS;
            } else if("=".equals(text)) {
                return CommandType.EQUALS;
            } else if("±".equals(text)) {
                return CommandType.SIGNAL;
            } else if("+/-".equals(text)) {
                return CommandType.SIGNAL;
            } else if(",".equals(text) && !actualText.contains(",")) {
                return CommandType.COMMA;
            }
        }
        return null;
    }

    private boolean isValidText(String text) {
        return actualText.isEmpty() && Objects.equals(text, "0");
    }
}
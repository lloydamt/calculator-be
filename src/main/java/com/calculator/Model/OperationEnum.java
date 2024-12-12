package com.calculator.Model;

public enum OperationEnum {
    ADDITION ("+"),
    SUBTRACTION ("-"),
    MUTLIPLICATION ("*"),
    DIVISION ("/");

    private String value;

    OperationEnum(final String value) {
        this.value = value;
    }
}
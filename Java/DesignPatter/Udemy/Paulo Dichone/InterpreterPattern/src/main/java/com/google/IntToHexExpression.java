package com.google;

public class IntToHexExpression implements Expression {
    private int num;

    public IntToHexExpression(int num) {
        this.num = num;
    }

    @Override
    public String interpreter(InterpreterContext interpreterContext) {
        return interpreterContext.getHexFormat(num);
    }
}

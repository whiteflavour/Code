package com.google;

public class IntToBinaryExpression implements Expression {
    private int num;

    public IntToBinaryExpression(int num) {
        this.num = num;
    }

    @Override
    public String interpreter(InterpreterContext interpreterContext) {
        return interpreterContext.getBinaryFormat(num);
    }
}

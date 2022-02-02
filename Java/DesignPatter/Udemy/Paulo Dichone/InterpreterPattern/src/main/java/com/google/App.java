package com.google;

public class App {
    private InterpreterContext interpreterContext;

    public static void main( String[] args ) {
        String first = "13 in Binary";
        String second = "28 in Hexadecimal";

        App interpreter = new App(new InterpreterContext());
        System.out.println(first + " = " + interpreter.interpret(first));
        System.out.println(second + " = " + interpreter.interpret(second));
    }

    public App(InterpreterContext interpreterContext) {
        this.interpreterContext = interpreterContext;
    }

    public String interpret(String str) {
        Expression expression = null;
        int num = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        if (str.contains("Hexadecimal")) {
            expression = new IntToHexExpression(num);
        } else if (str.contains("Binary")) {
            expression = new IntToBinaryExpression(num);
        } else {
            return str;
        }
        return expression.interpreter(interpreterContext);
    }
}

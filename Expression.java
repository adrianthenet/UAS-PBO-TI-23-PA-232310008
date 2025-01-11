package com.projectuas;

public class Expression {
    private String imagePath;
    private String expression;

    public Expression(String imagePath, String expression) {
        this.imagePath = imagePath;
        this.expression = expression;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getExpression() {
        return expression;
    }
}

package com.deceax.java8;

/**
 * Created by Lese on 3/16/16.
 */
public class AddOperator implements BinaryOperator {

    /*
     * simple addition operator which adds two operands
     */
    public int operate(int operand1, int operand2) {
        return operand1 + operand2;
    }
}

package com.deceax.java8;

/**
 * Created by Lese on 3/16/16.
 */
public class SubtractOperator implements BinaryOperator {

    /*
     * simple subtraction operator which subtracts two operands
     */
    public int operate(int operand1, int operand2) {
        return operand1 - operand2;
    }
}

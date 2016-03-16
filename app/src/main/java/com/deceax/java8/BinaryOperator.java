package com.deceax.java8;

import android.util.Log;

/**
 * Created by Lese on 3/16/16.
 */

/* BinaryOperator is a functional interface which is required for lambda usage
 * functional interfaces are interfaces with only one method
 * you can have as many default and static functions in the interface as you wish
 */
public interface BinaryOperator {
    int operate(int operand1, int operand2);

    /*
     * default functions are part of java 8 and allow the interface to define functions
     * which don't have to be overridden by the implementing class
     */
    default public void printOperands(int operand1, int operand2) {
        Log.d("Operands", getLogMessage(operand1, operand2));
    }

    /*
     * static functions inside of interfaces are also allowed in java 8
     */
    static String getLogMessage(int operand1, int operand2) {
        return String.valueOf(operand1 + ' ' + operand2);
    }
}

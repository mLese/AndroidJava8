package com.deceax.java8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;

    TextView result;

    Button add;
    Button subtract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        result = (TextView) findViewById(R.id.result);

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);

        setOnClickListeners();
        setOnClickListenersWithLambdas();
        setOnClickListenersWithFunctional();
    }

    /*
     * standard way of setting on click listeners
     */
    private void setOnClickListeners() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperation(new AddOperator()); // use addition operator
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperation(new SubtractOperator()); // use subtraction operator
            }
        });
    }

    /*
     * in this function we use a lambda expression to set the onClick listener
     * since the View.OnClickListener only has one method it is a functional interface and
     * can be simplified using a lambda expression
     * more info here https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
     */
    private void setOnClickListenersWithLambdas() {
        add.setOnClickListener(v -> doOperation(new AddOperator()));
        subtract.setOnClickListener(v -> doOperation(new SubtractOperator()));
    }

    /*
     * in this example we bypass the need to create implementations of the addition and subtraction
     * operations and define them using a lambda expression
     */
    private void setOnClickListenersWithFunctional() {
        add.setOnClickListener(v -> doOperation((op1, op2) -> op1 + op2));
        subtract.setOnClickListener(v -> doOperation((op1, op2) -> op1 - op2));
    }

    /* perform operation on operands using the BinaryOperator interface */
    private void doOperation(BinaryOperator operator) {
        int op1 = Integer.parseInt(num1.getText().toString());
        int op2 = Integer.parseInt(num2.getText().toString());
        result.setText(String.valueOf(operator.operate(op1, op2)));
        operator.printOperands(op1, op2);
    }
}

package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private float data1 = 0,data2 = 0;
    private enum Operator {None, Add, Subtract, Multiply, Divide}
    private boolean hasDot = false;
    private Operator operator = Operator.None;
    private char operatorSign;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText.setShowSoftInputOnFocus(false);
    }

    public void onClickNumericalButton(View view) {
        int buttonID = view.getId();
        editText = findViewById(R.id.editText);

        if (buttonID == R.id.button00) editText.setText(editText.getText() + "0");
        if (buttonID == R.id.button01) editText.setText(editText.getText() + "1");
        if (buttonID == R.id.button02) editText.setText(editText.getText() + "2");
        if (buttonID == R.id.button03) editText.setText(editText.getText() + "3");
        if (buttonID == R.id.button04) editText.setText(editText.getText() + "4");
        if (buttonID == R.id.button05) editText.setText(editText.getText() + "5");
        if (buttonID == R.id.button06) editText.setText(editText.getText() + "6");
        if (buttonID == R.id.button07) editText.setText(editText.getText() + "7");
        if (buttonID == R.id.button08) editText.setText(editText.getText() + "8");
        if (buttonID == R.id.button09) editText.setText(editText.getText() + "9");

        if (buttonID == R.id.buttonDot) {
            if (operator == Operator.None && !hasDot) {
                editText.setText(editText.getText() + ".");
                hasDot = true;
            }
            if (operator != Operator.None && hasDot) {
                editText.setText(editText.getText() + ".");
                hasDot = false;
            }
        }
    }
    public void onClickMathematicalButton(View view) {
        int buttonID = view.getId();
        editText = findViewById(R.id.editText);

        if (buttonID == R.id.buttonClear) {
            data2 = 0;
            data1 = 0;
            operator = Operator.None;
            operatorSign = 'f';
            hasDot = false;
            editText.setText("");
        }
        if (buttonID == R.id.buttonADD ) {
            if (data1 == 0) data1 = Float.valueOf(String.valueOf(editText.getText()));
            operator = Operator.Add;
            editText.setText(editText.getText() + "+");
            operatorSign = '+';
        }
        if (buttonID == R.id.buttonSubtract && operator == Operator.None) {
            if (data1 == 0) data1 = Float.valueOf(String.valueOf(editText.getText()));
            operator = Operator.Subtract;
            editText.setText(editText.getText() + "-");
            operatorSign = '-';
        }
        if (buttonID == R.id.buttonMultiply && operator == Operator.None) {
            if (data1 == 0) data1 = Float.valueOf(String.valueOf(editText.getText()));
            operator = Operator.Multiply;
            editText.setText(editText.getText() + "*");
            operatorSign = '*';
        }
        if (buttonID == R.id.buttonDivide && operator == Operator.None) {
            if (data1 == 0) data1 = Float.valueOf(String.valueOf(editText.getText()));
            operator = Operator.Divide;
            editText.setText(editText.getText() + "/");
            operatorSign = '/';
        }
        if (buttonID == R.id.buttonEqual && operator != Operator.None) {
            String string = String.valueOf(editText.getText());
            int operatorIndex = string.indexOf(operatorSign);
            String data2String = string.substring(operatorIndex+1,string.length());
            data2 = Float.parseFloat(data2String);

            if (operator == Operator.Add) data1 = data1 + data2;
            if (operator == Operator.Subtract) data1 = data1 - data2;
            if (operator == Operator.Multiply) data1 = data1 * data2;
            if (operator == Operator.Divide) data1 = data1 / data2;
            operator = Operator.None;
            editText.setText(Float.toString(data1));
        }

    }
}
package com.example.calculator_nash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button c, ce, plusMinus, div, seven, eight, nine, plus, four, five, six, minus, one, two, three, mult, zero, dot, equals;
    private TextView display;
    private double num1, num2;
    private boolean isNum1_set, isNum2_set, isOperationSet, isFirstInputSet, isResultCalculated, operationJUSTSet, isPlusPressed, isDivPressed, isMinusPressed, isMultPressed;
    private String operationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c=findViewById(R.id.clear); ce=findViewById(R.id.clear_everything); plusMinus=findViewById(R.id.negate); div=findViewById(R.id.divide); seven=findViewById(R.id.num_7);
        eight=findViewById(R.id.num_8); nine=findViewById(R.id.num_9); plus=findViewById(R.id.add); four=findViewById(R.id.num_4); five=findViewById(R.id.num_5); six=findViewById(R.id.num_6);
        minus=findViewById(R.id.subtract); one=findViewById(R.id.num_1); two=findViewById(R.id.num_2); three=findViewById(R.id.num_3); mult=findViewById(R.id.multiply);
        zero=findViewById(R.id.num_0); dot=findViewById(R.id.decimalPoint); equals=findViewById(R.id.equals);
        display=findViewById(R.id.Display);
        display.setText("0");
        isNum1_set = false;
        isNum2_set = false;
        isOperationSet = false;
        isFirstInputSet = false;
        isResultCalculated = false;
        operationJUSTSet = false;
        isPlusPressed = false;
        isDivPressed = false;
        isMinusPressed = false;
        isMultPressed = false;
        operationCode = "NULL";

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isResultCalculated) ce.performClick();
                if (!isOperationSet) {
                    isFirstInputSet = false;
                    updateText("clear");
                }
                else if (isNum1_set && isOperationSet) {

                    updateText("clear");
                }
            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNum1_set = false;
                isNum2_set = false;
                isOperationSet = false;
                isFirstInputSet = false;
                isResultCalculated = false;
                setButtonsUnpressed();
                setOperationCode("NULL");
                // unhighlight operator button
                updateText("clear");
            }
        });

        plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("+/-");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDivPressed = true;
                if (!isFirstInputSet) {
                    isFirstInputSet = true;
                    num1 = 0.0;
                    isNum1_set = true;
                    setOperationCode("/");
                }
                else if (!isNum1_set) {
                    num1 = Double.valueOf(display.getText().toString());
                    isNum1_set = true;
                    setOperationCode("/");
                    div.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));     // highlight divide button
                }
                else if (isResultCalculated) {
                    setOperationCode("/");
                    div.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("9");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPlusPressed = true;
                if (!isFirstInputSet) {
                    isFirstInputSet = true;
                    num1 = 0.0;
                    isNum1_set = true;
                    setOperationCode("+");
                }
                else if (!isNum1_set) {
                    num1 = Double.valueOf(display.getText().toString());
                    isNum1_set = true;
                    setOperationCode("+");
                    plus.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));   // highlight plus button
                }
                else if (isResultCalculated) {
                    setOperationCode("+");
                    plus.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("6");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMinusPressed = true;
                if (!isFirstInputSet) {
                    isFirstInputSet = true;
                    num1 = 0.0;
                    isNum1_set = true;
                    setOperationCode("-");
                }
                else if (!isNum1_set) {
                    num1 = Double.valueOf(display.getText().toString());
                    isNum1_set = true;
                    setOperationCode("-");
                    minus.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));    // highlight minus button
                }
                else if (isResultCalculated) {
                    setOperationCode("-");
                    minus.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("3");
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMultPressed = true;
                if (!isFirstInputSet) {
                    isFirstInputSet = true;
                    num1 = 0.0;
                    isNum1_set = true;
                    setOperationCode("*");
                }
                else if (!isNum1_set) {
                    num1 = Double.valueOf(display.getText().toString());
                    isNum1_set = true;
                    setOperationCode("*");
                    mult.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));    // highlight times button
                }
                else if (isResultCalculated) {
                    setOperationCode("*");
                    mult.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText("0");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFirstInputSet) isFirstInputSet = true;
                if (isOperationSet && operationJUSTSet) {
                    operationJUSTSet = false;
                    updateText("clear");
                }
                updateText(".");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isResultCalculated && !isOperationSet) {
                    calculateAndDisplay();
                }
                if (isNum1_set && isOperationSet) {
                    num2 = Double.valueOf(display.getText().toString());
                    isNum2_set = true;
                    calculateAndDisplay();
                }
            }
        });
    }

    protected void updateText(String s) {
        switch (s) {
            case"clear":
                display.setText("0");
                break;
            case"+/-":     //FIXME
                if (display.getText() == "0")
                    display.setText("-");
                else if (display.getText().charAt(0) == '-')
                    display.setText(display.getText().subSequence(1,display.getText().length()));
                else
                    display.setText("-"+display.getText());
                break;
            case"/":
                // nothing
                break;
            case"7": {
                if (display.getText().toString().equals("0")) { display.setText("7"); }
                else {display.setText(display.getText() + "7"); }
                break;
            }
            case"8": {
                if (display.getText().toString().equals("0")) { display.setText("8"); }
                else {display.setText(display.getText() + "8"); }
                break;
            }
            case"9":
                if (display.getText().toString().equals("0")) { display.setText("9"); }
                else {display.setText(display.getText() + "9"); }
                break;
            case"+":
                // nothing to do?
                break;
            case"4":
                if (display.getText().toString().equals("0")) { display.setText("4"); }
                else display.setText(display.getText()+"4");
                break;
            case"5":
                if (display.getText().toString().equals("0")) { display.setText("5"); }
                else display.setText(display.getText()+"5");
                break;
            case"6":
                if (display.getText().toString().equals("0")) { display.setText("6"); }
                else display.setText(display.getText()+"6");
                break;
            case"-":
                // stay the same
                break;
            case"1":
                if (display.getText().toString().equals("0")) { display.setText("1"); }
                else display.setText(display.getText()+"1");
                break;
            case"2":
                if (display.getText().toString().equals("0")) { display.setText("2"); }
                else display.setText(display.getText()+"2");
                break;
            case"3":
                if (display.getText().toString().equals("0")) { display.setText("3"); }
                else display.setText(display.getText()+"3");
                break;
            case"*":
                // implemented elsewhere
                break;
            case"0":
                if (display.getText().toString().equals("0")) { display.setText("0"); }
                else display.setText(display.getText()+"0");
                break;
            case".":
                if (display.getText().toString().equals("0")) { display.setText("0."); }
                else display.setText(display.getText()+".");
                break;
            case"=":
                // nothing doing
                break;
            default:
                System.out.println("Error, should never get this case");
        }
    }

    protected void setOperationCode(String code) {
        operationCode = code;

        if (operationCode == "NULL") {
            isOperationSet = false;
            operationJUSTSet = false;
        }
        else {
            isOperationSet = true;
            operationJUSTSet = true;
        }
    }

    protected void calculateAndDisplay() {
//            num2 = Double.valueOf(display.getText().toString());        //////////////
//            isNum2_set = true;                                          //////////////
        double result = Double.MIN_VALUE;
        switch (operationCode) {
            case"+":
                result = num1 + num2;
                break;
            case"-":
                result = num1 - num2;
                break;
            case"/":
                result = num1/num2;
                break;
            case"*":
                result = num1*num2;
                break;
            default:
                System.out.println("Error, this case should be unreachable");
        }
        isResultCalculated = true;
        num1 = result;
        isFirstInputSet = true;
        isNum1_set = true;
        isOperationSet = false;
        setButtonsUnpressed();
        updateText("clear");
        display.setText(Double.toString(result));
    }

    protected void setButtonsUnpressed() {
        plus.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        minus.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        div.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        mult.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        isPlusPressed = false;
        isDivPressed = false;
        isMinusPressed = false;
        isMultPressed = false;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String displayVal = display.getText().toString();
        outState.putString("displayVal", displayVal);
        outState.putString("operationCode", operationCode);

        outState.putBoolean("isNum1_set", isNum1_set);
        outState.putBoolean("isNum2_set", isNum2_set);
        outState.putBoolean("isOperationSet", isOperationSet);
        outState.putBoolean("isFirstInputSet", isFirstInputSet);
        outState.putBoolean("isResultCalculated", isResultCalculated);
        outState.putBoolean("operationJUSTSet", operationJUSTSet);
        outState.putBoolean("isPlusPressed", isPlusPressed);
        outState.putBoolean("isMinusPressed", isMinusPressed);
        outState.putBoolean("isDivPressed", isDivPressed);
        outState.putBoolean("isMultPressed", isMultPressed);

        outState.putDouble("num1", num1);
        outState.putDouble("num2", num2);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String displayVal = savedInstanceState.getString("displayVal");
        display.setText(displayVal);
        operationCode = savedInstanceState.getString("operationCode");

        isNum1_set = savedInstanceState.getBoolean("isNum1_set");
        isNum2_set = savedInstanceState.getBoolean("isNum2_set");
        isOperationSet = savedInstanceState.getBoolean("isOperationSet");
        isFirstInputSet = savedInstanceState.getBoolean("isFirstInputSet");
        isResultCalculated = savedInstanceState.getBoolean("isResultCalculated");
        operationJUSTSet = savedInstanceState.getBoolean("operationJUSTSet");
        isPlusPressed = savedInstanceState.getBoolean("isPlusPressed");
        isMinusPressed = savedInstanceState.getBoolean("isMinusPressed");
        isDivPressed = savedInstanceState.getBoolean("isDivPressed");
        isMultPressed = savedInstanceState.getBoolean("isMultPressed");

        num1 = savedInstanceState.getDouble("num1");
        num2 = savedInstanceState.getDouble("num2");

        if (isPlusPressed)  plus.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
        if (isMinusPressed)  minus.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
        if (isDivPressed)  div.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
        if (isMultPressed)  mult.setBackgroundColor(getResources().getColor(R.color.purple_200, getTheme()));
    }
}
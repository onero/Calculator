package dk.adamino.calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import dk.adamino.calculator.BLL.CalculatorService;
import dk.adamino.calculator.BLL.ICalculatorService;
import dk.adamino.calculator.Model.EOperator;

public class CalculatorActivity extends AppCompatActivity {

    public static final String SPACE = " ";
    public static final String ADDITION_STRING = " + ";
    public static final String DIVISION_STRING = " / ";
    public static final String MULTIPLICATION_STRING = " * ";
    public static final String SUBTRACTION_STRING = " - ";
    public static final String EQUALS_STRING = " = ";
    public static final String DOT_STRING = ".";

    private TextView mInputView;
    private TextView mResultView;

    private ICalculatorService mCalculatorService;

    private String mEquation;
    private BigDecimal mResult;

    private EOperator mCurrentOperation;

    private boolean mInEquation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mInputView = findViewById(R.id.tvInput);
        mResultView = findViewById(R.id.tvResult);

        mCalculatorService = new CalculatorService();
        mInEquation = false;
    }

    /**
     * Add a dot, if one isn't already present
     * @param view
     */
    public void onDotClick(View view) {
        String lastChar = getLastcharOfString();
        // Validate we're not clicking a new operator
        if (!lastChar.equals(DOT_STRING)) {
            mInputView.setText(mInputView.getText() + DOT_STRING);
        }else {
            Toast.makeText(this, R.string.DifferentActionErrorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Add a 0
     * @param view
     */
    public void onZeroClick(View view) {
        mInputView.setText(mInputView.getText() + "0");
    }

    /**
     * Add a 1
     * @param view
     */
    public void onOneClick(View view) {
        mInputView.setText(mInputView.getText() + "1");
    }

    /**
     * Add a 2
     * @param view
     */
    public void onTwoClick(View view) { mInputView.setText(mInputView.getText() + "2");}

    /**
     * Add a 3
     * @param view
     */
    public void onThreeClick(View view) {
        mInputView.setText(mInputView.getText() + "3");
    }

    /**
     * Add a 4
     * @param view
     */
    public void onFourClick(View view) {
        mInputView.setText(mInputView.getText() + "4");}

    /**
     * Add a 5
     * @param view
     */
    public void onFiveClick(View view) {
        mInputView.setText(mInputView.getText() + "5");}

    /**
     * Add a 6
     * @param view
     */
    public void onSixClick(View view) {
        mInputView.setText(mInputView.getText() + "6");}

    /**
     * Add a 7
     * @param view
     */
    public void onSevenClick(View view) {
        mInputView.setText(mInputView.getText() + "7");}

    /**
     * Add a 8
     * @param view
     */
    public void onEightClick(View view) {
        mInputView.setText(mInputView.getText() + "8");}

    /**
     * Add a 9
     * @param view
     */
    public void onNineClick(View view) {
        mInputView.setText(mInputView.getText() + "9");}

    /**
     * Compute calculation this far and set text to addition
     * @param view
     */
    public void onAddClick(View view) {
        String lastChar = getLastcharOfString();
        // Validate we're not clicking a new operator
        if (!lastChar.equals(SPACE)) {
            mEquation = mInputView.getText().toString();
            checkInEquation();
            mEquation = mInputView.getText() + ADDITION_STRING;
            mInputView.setText(mEquation);
            mInEquation = true;
        }else {
            if (mCurrentOperation == EOperator.ADDITION) {
                Toast.makeText(this, R.string.DifferentActionErrorMessage, Toast.LENGTH_SHORT).show();
            } else {
                String alteredEquation = getEquationStringBeforeLastOperator() + ADDITION_STRING;
                mEquation = alteredEquation;
                mInputView.setText(alteredEquation);
            }
        }
        mCurrentOperation = EOperator.ADDITION;
    }

    @NonNull
    private String getLastcharOfString() {
        return mInputView.getText().toString().substring(mInputView.getText().length() - 1);
    }

    /**
     * Check if we're in an equation
     * If so, evaluate current equation
     */
    private void checkInEquation() {
        if (mInEquation) {
            mResult = mCalculatorService.evaluateEquation(mEquation);
            mResultView.setText(mResult.toPlainString());
        }
    }


    /**
     * Compute calculation this far and set text to division
     * @param view
     */
    public void onDivideClick(View view) {
        String lastChar = getLastcharOfString();
        // Validate we're not clicking a new operator
        if (!lastChar.equals(SPACE)) {
            mEquation = mInputView.getText().toString();
            checkInEquation();
            mEquation = mInputView.getText() + DIVISION_STRING;
            mInputView.setText(mEquation);
            mInEquation = true;
        }else {
            if (mCurrentOperation == EOperator.DIVISION) {
                Toast.makeText(this, R.string.DifferentActionErrorMessage, Toast.LENGTH_SHORT).show();
            } else {
                String alteredEquation = getEquationStringBeforeLastOperator() + DIVISION_STRING;
                mEquation = alteredEquation;
                mInputView.setText(alteredEquation);
            }
        }
        mCurrentOperation = EOperator.DIVISION;
    }

    /**
     * Compute calculation this far and set text to multiplication
     * @param view
     */
    public void onMultiplyClick(View view) {
        String lastChar = getLastcharOfString();
        // Validate we're not clicking a new operator
        if (!lastChar.equals(SPACE)) {
            mEquation = mInputView.getText().toString();
            checkInEquation();
            mEquation = mInputView.getText() + MULTIPLICATION_STRING;
            mInputView.setText(mEquation);
            mInEquation = true;
        }else {
            if (mCurrentOperation == EOperator.MULTIPLICATION) {
                Toast.makeText(this, R.string.DifferentActionErrorMessage, Toast.LENGTH_SHORT).show();
            } else {
                String alteredEquation = getEquationStringBeforeLastOperator() + MULTIPLICATION_STRING;
                mEquation = alteredEquation;
                mInputView.setText(alteredEquation);
            }
        }
        mCurrentOperation = EOperator.MULTIPLICATION;
    }

    /**
     * Compute calculation this far and set text to substraction
     * @param view
     */
    public void onSubtractClick(View view) {
        String lastChar = getLastcharOfString();
        // Validate we're not clicking a new operator
        if (!lastChar.equals(SPACE)) {
            mEquation = mInputView.getText().toString();
            checkInEquation();
            mEquation = mInputView.getText() + SUBTRACTION_STRING;
            mInputView.setText(mEquation);
            mInEquation = true;
        }else {
            if (mCurrentOperation == EOperator.SUBTRACTION) {
                Toast.makeText(this, R.string.DifferentActionErrorMessage, Toast.LENGTH_SHORT).show();
            } else {
                String alteredEquation = getEquationStringBeforeLastOperator() + SUBTRACTION_STRING;
                mEquation = alteredEquation;
                mInputView.setText(alteredEquation);
            }
        }
        mCurrentOperation = EOperator.SUBTRACTION;
    }

    @NonNull
    private String getEquationStringBeforeLastOperator() {
        return mEquation.substring(0, mEquation.length() - 3);
    }

    /**
     * Compute final calculation and set text to current calculation
     * @param view
     */
    public void onEqualsClick(View view) {
        String lastChar = getLastcharOfString();
        // Validate we have a correct syntax
        if (!lastChar.equals(SPACE)) {
            mEquation = mInputView.getText().toString();
            checkInEquation();
            String finalString = mInputView.getText() + EQUALS_STRING + mResultView.getText();
            mResultView.setText(finalString);
            mInputView.setText("");
            mInEquation = false;
        } else {
            Toast.makeText(this, "Please add a number to the equation", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Clear view
     * @param view
     */
    public void onClearClick(View view) {
        mInputView.setText("");
        mResultView.setText("0");
    }
}

package dk.adamino.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import dk.adamino.calculator.BLL.CalculatorService;
import dk.adamino.calculator.BLL.ICalculatorService;

public class CalculatorActivity extends AppCompatActivity {

    private TextView mInputView;
    private TextView mResultView;

    private ICalculatorService mCalculatorService;

    private String mEquation;
    private BigDecimal mResult;

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
     * Add a dot
     * @param view
     */
    public void onDotClick(View view) {
        mInputView.setText(mInputView.getText() + ".");
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
        mEquation = mInputView.getText().toString();
        checkInEquation();
        mEquation = mInputView.getText() + " + ";
        mInputView.setText(mEquation);
        mInEquation = true;
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
        mEquation = mInputView.getText().toString();
        checkInEquation();
        mEquation = mInputView.getText() + " / ";
        mInputView.setText(mEquation);
        mInEquation = true;
    }

    /**
     * Compute calculation this far and set text to multiplication
     * @param view
     */
    public void onMultiplyClick(View view) {
        mEquation = mInputView.getText().toString();
        checkInEquation();
        mEquation = mInputView.getText() + " * ";
        mInputView.setText(mEquation);
        mInEquation = true;
    }

    /**
     * Compute calculation this far and set text to substraction
     * @param view
     */
    public void onSubtractClick(View view) {
        mEquation = mInputView.getText().toString();
        checkInEquation();
        mEquation = mInputView.getText() + " - ";
        mInputView.setText(mEquation);
        mInEquation = true;
    }

    /**
     * Compute final calculation and set text to current calculation
     * @param view
     */
    public void onEqualsClick(View view) {
        mEquation = mInputView.getText().toString();
        checkInEquation();
        String finalString = mInputView.getText() + " = " + mResultView.getText();
        mResultView.setText(finalString);
        mInputView.setText("");
        mInEquation = false;
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

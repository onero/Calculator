package dk.adamino.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import dk.adamino.calculator.BLL.CalculatorService;
import dk.adamino.calculator.BLL.ICalculatorService;
import dk.adamino.calculator.Model.EOperator;

import static dk.adamino.calculator.Model.EOperator.ADDITION;
import static dk.adamino.calculator.Model.EOperator.DIVISION;
import static dk.adamino.calculator.Model.EOperator.MULTIPLICATION;
import static dk.adamino.calculator.Model.EOperator.SUBTRACTION;

public class CalculatorActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mInfoTextView;

    private ICalculatorService mCalculatorService;

    private static final String TAG = "Adamino";

    private EOperator mCurrentOperator;

    private double mValueOne;
    private double mValueTwo;

    private DecimalFormat mDecimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mDecimalFormat = new DecimalFormat("#.##########");

        mEditText = findViewById(R.id.editText);
        mInfoTextView = findViewById(R.id.infoTextView);

        mCalculatorService = new CalculatorService();
        mValueOne = Double.NaN;
        mCurrentOperator = null;

    }

    /**
     * Add a dot
     * @param view
     */
    public void onDotClick(View view) {
        mEditText.setText(mEditText.getText() + ".");
    }

    /**
     * Add a 0
     * @param view
     */
    public void onZeroClick(View view) {
        mEditText.setText(mEditText.getText() + "0");
    }

    /**
     * Add a 1
     * @param view
     */
    public void onOneClick(View view) {
        mEditText.setText(mEditText.getText() + "1");
    }

    /**
     * Add a 2
     * @param view
     */
    public void onTwoClick(View view) {mEditText.setText(mEditText.getText() + "2");}

    /**
     * Add a 3
     * @param view
     */
    public void onThreeClick(View view) {
        mEditText.setText(mEditText.getText() + "3");
    }

    /**
     * Add a 4
     * @param view
     */
    public void onFourClick(View view) {mEditText.setText(mEditText.getText() + "4");}

    /**
     * Add a 5
     * @param view
     */
    public void onFiveClick(View view) {mEditText.setText(mEditText.getText() + "5");}

    /**
     * Add a 6
     * @param view
     */
    public void onSixClick(View view) {mEditText.setText(mEditText.getText() + "6");}

    /**
     * Add a 7
     * @param view
     */
    public void onSevenClick(View view) {mEditText.setText(mEditText.getText() + "7");}

    /**
     * Add a 8
     * @param view
     */
    public void onEightClick(View view) {mEditText.setText(mEditText.getText() + "8");}

    /**
     * Add a 9
     * @param view
     */
    public void onNineClick(View view) {mEditText.setText(mEditText.getText() + "9");}


    /**
     * Compute operand one and two with the current operator
     */
    private void compute() {
        try {
            mValueTwo = Double.parseDouble(mEditText.getText().toString());
            mValueOne = mCalculatorService.computeCalculation(mValueOne, mValueTwo, mCurrentOperator);
        } catch (Exception ex) {
            Log.i(TAG, ex.getMessage());
        }
    }


    /**
     * Parse user input for computation to a Double
     */
    private void parseOperand() {
        try {
            mValueOne = Double.parseDouble(mEditText.getText().toString());
        } catch (Exception ex) {
            Log.i(TAG, ex.getMessage());
        }
    }

    /**
     * Check for ongoing computation,
     * if so resolve
     * else just parse the operand
     */
    private void computeOrParse() {
        if (mCurrentOperator != null) {
            compute();
        } else {
            parseOperand();
        }
    }

    /**
     * Compute calculation this far and set text to addition
     * @param view
     */
    public void onAddClick(View view) {
        // TODO ALH: Check for finished computation (equals already clicked!)
        computeOrParse();

        mCurrentOperator = ADDITION;

        mInfoTextView.setText(mDecimalFormat.format(mValueOne) + " + ");

        mEditText.setText(null);
    }

    /**
     * Compute calculation this far and set text to division
     * @param view
     */
    public void onDivideClick(View view) {
        computeOrParse();

        mCurrentOperator = DIVISION;

        mInfoTextView.setText(mDecimalFormat.format(mValueOne) + " / ");

        mEditText.setText(null);
    }

    /**
     * Compute calculation this far and set text to multiplication
     * @param view
     */
    public void onMultiplyClick(View view) {
        computeOrParse();

        mCurrentOperator = MULTIPLICATION;

        mInfoTextView.setText(mDecimalFormat.format(mValueOne) + " * ");

        mEditText.setText(null);
    }

    /**
     * Compute calculation this far and set text to substraction
     * @param view
     */
    public void onSubstractClick(View view) {
        computeOrParse();

        mCurrentOperator = SUBTRACTION;

        mInfoTextView.setText(mDecimalFormat.format(mValueOne) + " - ");

        mEditText.setText(null);
    }

    /**
     * Compute final calculation and set text to current calculation
     * @param view
     */
    public void onEqualsClick(View view) {
        // Verify input
        if (!mEditText.getText().toString().isEmpty()) {
            compute();

            String equationString = mInfoTextView.getText().toString() +
                    mDecimalFormat.format(mValueTwo) + " = " + mDecimalFormat.format(mValueOne);

            mInfoTextView.setText(equationString);

            mEditText.setText(null);
            mValueOne = Double.NaN;
            mCurrentOperator = null;
        }
    }

    /**
     * Clear view
     * @param view
     */
    public void onClearClick(View view) {
        mValueOne = Double.NaN;
        mValueTwo = Double.NaN;
        mEditText.setText("");
        mInfoTextView.setText("");
    }
}

package dk.adamino.calculator.BLL;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class CalculatorService implements ICalculatorService {


    private static final String RESULT_PREFIX = "result = ";
    private static final String RESULT_STRING = "result";
    private static final String TAG = "CalculatorService";


    @Override
    public BigDecimal evaluateEquation(String equation) {
        BigDecimal result;
        Expression expression = new Expression(equation);
        expression.setPrecision(4);
        result = expression.eval();
        return result;
    }
}

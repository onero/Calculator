package dk.adamino.calculator.BLL;

import dk.adamino.calculator.Model.EOperator;

import static dk.adamino.calculator.Model.EOperator.ADDITION;
import static dk.adamino.calculator.Model.EOperator.DIVISION;
import static dk.adamino.calculator.Model.EOperator.MULTIPLICATION;
import static dk.adamino.calculator.Model.EOperator.SUBTRACTION;

public class CalculatorService implements ICalculatorService {

    @Override
    public Double computeCalculation(Double valueOne, Double valueTwo, EOperator operator) {
        Double result = 0.0;
        if(operator == ADDITION)
            result = valueOne + valueTwo;
        else if(operator == SUBTRACTION)
            result = valueOne - valueTwo;
        else if(operator == MULTIPLICATION)
            result = valueOne * valueTwo;
        else if(operator == DIVISION)
            result = valueOne / valueTwo;

        return result;
    }
}

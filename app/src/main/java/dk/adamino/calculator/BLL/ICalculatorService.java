package dk.adamino.calculator.BLL;

import dk.adamino.calculator.Model.EOperator;

public interface ICalculatorService {

    /**
     * Compute operation of two values with a provided operand
     * @param valueOne
     * @param valueTwo
     * @param operator
     * @return
     */
    Double computeCalculation(Double valueOne, Double valueTwo, EOperator operator);
}

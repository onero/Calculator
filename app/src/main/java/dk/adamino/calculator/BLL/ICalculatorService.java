package dk.adamino.calculator.BLL;

import java.math.BigDecimal;

public interface ICalculatorService {

    /**
     * Evaluate equation input as string
     * @param equation
     * @return
     */
    BigDecimal evaluateEquation(String equation);
}

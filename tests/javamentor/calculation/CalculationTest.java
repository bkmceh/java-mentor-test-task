package javamentor.calculation;

import javamentor.exceptions.RomanNumbersException;
import javamentor.validation.StringValidation;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationTest {

    @Test
    public void RomanNumbers1() {
        String inputString = "X - I";

        StringValidation.validate(inputString);
        Calculation.calculate();
    }

    @Test
    public void RomanNumbers2() {
        String inputString = "X + I";

        StringValidation.validate(inputString);
        Calculation.calculate();
    }

    @Test
    public void RomanNumbers3() {
        String inputString = "X / II";

        StringValidation.validate(inputString);
        Calculation.calculate();
    }

    @Test(expected = RomanNumbersException.class)
    public void RomanNumbers4() {
        String inputString = "X / IV";

        StringValidation.validate(inputString);
        Calculation.calculate();
    }
}
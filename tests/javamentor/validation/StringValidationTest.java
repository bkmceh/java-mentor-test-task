package javamentor.validation;

import javamentor.exceptions.ManyArithmeticOperationsException;
import javamentor.exceptions.NotFoundArithmeticOperationException;
import javamentor.exceptions.RomanNumbersException;
import javamentor.exceptions.SpaceExceptions;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringValidationTest {

    @Test(expected = NotFoundArithmeticOperationException.class)
    public void NotFoundOperations1() {
        String inputString = " 5454";
        StringValidation.validate(inputString);
    }

    @Test(expected = NotFoundArithmeticOperationException.class)
    public void NotFoundOperations2() {
        String inputString = "";
        StringValidation.validate(inputString);
    }

    @Test(expected = ManyArithmeticOperationsException.class)
    public void TooManyOperations1() {
        String inputString = "4 + 5 - 4";
        StringValidation.validate(inputString);
    }

    @Test(expected = ManyArithmeticOperationsException.class)
    public void TooManyOperations2() {
        String inputString = "+-";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void SpacesFromBegin1() {
        String inputString = "    5 + 34";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void SpacesFromBegin2() {
        String inputString = " 5+34";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void SpacesFromEnd1() {
        String inputString = "5 + 34      ";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void SpacesFromEnd2() {
        String inputString = "5 + 34 ";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void SpacesFromBeginAndEnd() {
        String inputString = "   5 + 34  ";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void checkingSpaces1() {
        String inputString = "5 +34";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void checkingSpaces2() {
        String inputString = "5+34";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void checkingSpaces3() {
        String inputString = "+534";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void checkingSpaces4() {
        String inputString = "5   +   34";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void checkingSpaces5() {
        String inputString = " + 34";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void checkingSpaces6() {
        String inputString = " + ";
        StringValidation.validate(inputString);
    }

    @Test(expected = SpaceExceptions.class)
    public void checkingSpaces7() {
        String inputString = "5+ 4";
        StringValidation.validate(inputString);
    }

    @Test
    public void romanNumbers1() {
        String inputString = "I + II";
        StringValidation.validate(inputString);
    }

    @Test(expected = RomanNumbersException.class)
    public void romanNumbersException1() {
        String inputString = "I - IX";
        StringValidation.validate(inputString);
    }

    @Test
    public void romanNumbers3() {
        String inputString = "I + I";
        StringValidation.validate(inputString);
    }

    @Test(expected = RomanNumbersException.class)
    public void romanNumbersException2() {
        String inputString = "IX - X";
        StringValidation.validate(inputString);
    }

    @Test
    public void romanNumbers5() {
        String inputString = "IX * V";
        StringValidation.validate(inputString);
    }

    @Test(expected = RomanNumbersException.class)
    public void romanNumbers6() {
        String inputString = "X / XI";
        StringValidation.validate(inputString);
    }
}
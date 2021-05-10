package javamentor.numbers.roman;

import javamentor.exceptions.RomanNumbersException;
import javamentor.operation.Operation;

public class RomanExceptionsChecker {

    public static void checkOnExceptions(int firstNumber, int secondNumber) {

        if (firstNumber <= secondNumber && Operation.getOperationSign() == '-') {
            throw new RomanNumbersException("Ответ не может быть отрицательным или равен 0" +
                    " при римских числах.");
        }

        if (firstNumber % secondNumber != 0 && Operation.getOperationSign() == '/') {
            throw new RomanNumbersException("Ответ при делении не целое число.");
        }
    }
}

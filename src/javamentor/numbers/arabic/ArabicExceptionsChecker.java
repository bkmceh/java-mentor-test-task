package javamentor.numbers.arabic;

import javamentor.exceptions.ArabicNumbersException;
import javamentor.operation.Operation;

// Класс проверяет возможные конкретные ошибки с арабскими числами
public class ArabicExceptionsChecker {

    public static void checkOnExceptions(final int firstNumber, final int secondNumber) {

        if (firstNumber == 0 || firstNumber > 10 || secondNumber == 0 || secondNumber > 10) {
            throw new ArabicNumbersException("Арабские числа должны быть от 1 до 10.");
        }

        if (firstNumber % secondNumber != 0 && Operation.getOperationSign() == '/') {
            throw new ArabicNumbersException("Ответ при делении не целое число.");
        }

    }
}

package javamentor.numbers.roman;

import javamentor.exceptions.RomanNumbersException;
import javamentor.operation.Operation;

// Класс проверяет конкретные возможные ошибки с римскими числами
public class RomanExceptionsChecker {

    public static void checkOnExceptions(final int firstNumber, final int secondNumber) {

        if (firstNumber <= secondNumber && Operation.getOperationSign() == '-') {
            throw new RomanNumbersException("Ответ не может быть отрицательным или равен 0" +
                    " при римских числах.");
        }

        if (firstNumber < secondNumber && Operation.getOperationSign() == '/') {
            throw new RomanNumbersException("Ответ должен быть больше нуля при римских числах.");
        }
    }
}

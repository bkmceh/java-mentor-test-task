package javamentor.validation;

import javamentor.exceptions.ManyArithmeticOperationsException;
import javamentor.exceptions.NotFoundArithmeticOperationException;
import javamentor.exceptions.RomanNumbersException;
import javamentor.exceptions.SpaceExceptions;
import javamentor.validation.numbers.RomanNumbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {

    private static final Pattern pattern = Pattern.compile("[+\\-*/]");


    public static void validate(String inputString) {

        Operation operation;
        operation = checkOperations(inputString);

        checkSpaces(inputString, operation);

        checkNumbers(inputString, operation);


    }

    private static Operation checkOperations(final String inputString) {

        Operation operation = new Operation();

        int count = 0;
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            count++;
            operation.setOperationIndex(matcher.start());
        }
        System.out.format("Совпадений %s\n", count);

        if (count > 1) {
            throw new ManyArithmeticOperationsException("Число арифметических операций чет много");
        }
        if (count == 0) {
            throw new NotFoundArithmeticOperationException("Не найдена арифметическая операция.");
        }

        return operation;
    }

    private static void checkSpaces(final String inputString, final Operation operation) {
        if (inputString.indexOf(' ') == 0
                || inputString.lastIndexOf(' ') == inputString.length() - 1) {
            throw new SpaceExceptions("Проверьте лишние пробелы в начале или в конце и введенные числа.");
        }

        if (operation.getOperationIndex() - inputString.indexOf(' ') != 1) {
            throw new SpaceExceptions("Проверьте расположение арифметического знака.");
        }

        if (inputString.lastIndexOf(' ') - operation.getOperationIndex() != 1) {
            throw new SpaceExceptions("Проверьте расположение арифметического знака.");
        }
    }

    private static void checkNumbers(final String inputString, final Operation operation) {

        int romanCount = 0;
        int arabicCount = 0;

        String firstNumber = inputString.substring(0, operation.getOperationIndex() - 1);
        String secondNumber = inputString.substring(operation.getOperationIndex() + 2);

        System.out.format("\nFirst: %s\nSecond: %s\n", firstNumber, secondNumber);

        for (RomanNumbers number:
             RomanNumbers.values()) {
            if (firstNumber.equals(number.toString())) {
                romanCount++;
            }
            if (secondNumber.equals(number.toString())) {
                romanCount++;
            }
        }

        System.out.format("\nCount of Roman numbers: %s\n", romanCount);

        if (romanCount == 1) {
            throw new RomanNumbersException("Римские числа должны быть от 1 до 10. " +
                    "Оба числа должны быть римскими.");
        }
    }
}

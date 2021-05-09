package javamentor.validation;

import javamentor.exceptions.ManyArithmeticOperationsException;
import javamentor.exceptions.NotFoundArithmeticOperationException;
import javamentor.exceptions.RomanNumbersException;
import javamentor.exceptions.SpaceExceptions;
import javamentor.numbers.Numbers;
import javamentor.numbers.arabic.ArabicNumbers;
import javamentor.numbers.roman.RomanConverter;
import javamentor.numbers.roman.RomanExceptionsChecker;
import javamentor.numbers.roman.RomanNumbersEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {

    private static final Pattern pattern = Pattern.compile("[+\\-*/]");

    public static void validate(String inputString) {

        checkOperations(inputString);

        System.out.println(Operation.getOperationSign());

        checkSpaces(inputString);

        checkNumbers(inputString);

    }

    private static void checkOperations(final String inputString) {

        int count = 0;
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            count++;
            Operation.setOperationIndex(matcher.start());
        }

        if (count > 1) {
            throw new ManyArithmeticOperationsException("Число арифметических операций чет много");
        }
        if (count == 0) {
            throw new NotFoundArithmeticOperationException("Не найдена арифметическая операция.");
        }

        Operation.setOperationSign(inputString.charAt(Operation.getOperationIndex()));

    }

    private static void checkSpaces(final String inputString) {
        if (inputString.indexOf(' ') == 0
                || inputString.lastIndexOf(' ') == inputString.length() - 1) {
            throw new SpaceExceptions("Проверьте лишние пробелы в начале или в конце и введенные числа.");
        }

        if (Operation.getOperationIndex() - inputString.indexOf(' ') != 1) {
            throw new SpaceExceptions("Проверьте расположение арифметического знака.");
        }

        if (inputString.lastIndexOf(' ') - Operation.getOperationIndex() != 1) {
            throw new SpaceExceptions("Проверьте расположение арифметического знака.");
        }
    }

    private static void checkNumbers(final String inputString) {

        String firstNumber = inputString.substring(0, Operation.getOperationIndex() - 1);
        String secondNumber = inputString.substring(Operation.getOperationIndex() + 2);

        if (isRomanNumbers(firstNumber, secondNumber)) {
            Numbers.isRoman = true;
            System.out.println("This numbers are roman!");
            RomanConverter.convertRomanToArabic();
            ArabicNumbers.setFirstNumber(RomanConverter.romanToArabic.get(firstNumber));
            ArabicNumbers.setSecondNumber(RomanConverter.romanToArabic.get(secondNumber));
            RomanExceptionsChecker.checkOnExceptions(
                    ArabicNumbers.getFirstNumber(),
                    ArabicNumbers.getSecondNumber());
        }

    }

    private static boolean isRomanNumbers(final String firstNumber,
                                          final String secondNumber) {

        int romanCount = 0;

        for (RomanNumbersEnum number :
                RomanNumbersEnum.values()) {
            if (firstNumber.equals(number.toString())) {
                romanCount++;
            }
            if (secondNumber.equals(number.toString())) {
                romanCount++;
            }
        }

        if (romanCount == 1) {
            throw new RomanNumbersException("Римские числа должны быть от 1 до 10. " +
                    "Оба числа должны быть римскими.");
        }

        return romanCount == 2;
    }
}

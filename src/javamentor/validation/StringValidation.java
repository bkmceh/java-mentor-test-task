package javamentor.validation;

import javamentor.exceptions.*;
import javamentor.numbers.Numbers;
import javamentor.numbers.arabic.ArabicExceptionsChecker;
import javamentor.numbers.arabic.ArabicNumbers;
import javamentor.numbers.roman.RomanConverter;
import javamentor.numbers.roman.RomanExceptionsChecker;
import javamentor.numbers.roman.RomanNumbersEnum;
import javamentor.operation.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Класс для проверки входящей строки
public class StringValidation {

    // Использую этот паттерн для проверки знаков операции во входящей строке
    private static final Pattern pattern = Pattern.compile("[+\\-*/]");

    // Основной метод для проверки строки
    public static void validate(final String inputString) {

        checkOperations(inputString);

        checkSpaces(inputString);

        checkNumbers(inputString);

    }

    // Проверка присутствия знака операции и их количества
    private static void checkOperations(final String inputString) {

        int count = 0;
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            count++;
            Operation.setOperationIndex(matcher.start());
        }

        if (count > 1) {
            throw new ManyArithmeticOperationsException("Допустима лишь 1 арифметическая операция.");
        }
        if (count == 0) {
            throw new NotFoundArithmeticOperationException("Не найдена арифметическая операция.");
        }

        Operation.setOperationSign(inputString.charAt(Operation.getOperationIndex()));

    }

    // Проверка различных вариантов с пробелами в начале или в конце строки
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

    // Проверка двух введенных чисел
    private static void checkNumbers(final String inputString) {

        String firstNumber = inputString.substring(0, Operation.getOperationIndex() - 1);
        String secondNumber = inputString.substring(Operation.getOperationIndex() + 2);

        if (isRomanNumbers(firstNumber, secondNumber)) {
            RomanConverter.convertRomanToArabic();
            ArabicNumbers.setFirstNumber(RomanConverter.romanToArabic.get(firstNumber));
            ArabicNumbers.setSecondNumber(RomanConverter.romanToArabic.get(secondNumber));
            RomanExceptionsChecker.checkOnExceptions(
                    ArabicNumbers.getFirstNumber(),
                    ArabicNumbers.getSecondNumber());
            Numbers.isRoman = true;
        } else {
            try {
                ArabicNumbers.setFirstNumber(Integer.parseInt(firstNumber));
                ArabicNumbers.setSecondNumber(Integer.parseInt(secondNumber));
            } catch (NumberFormatException e) {
                throw new ArabicNumbersException("Введите только арабские или римские числа от 1 до 10.");
            }
            ArabicExceptionsChecker.checkOnExceptions(
                    ArabicNumbers.getFirstNumber(),
                    ArabicNumbers.getSecondNumber()
            );
            Numbers.isArabic = true;
        }

    }

    // Проверка являются ли 2 числа римскими
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

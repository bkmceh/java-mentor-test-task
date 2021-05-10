package javamentor.calculation;

import javamentor.numbers.Numbers;
import javamentor.numbers.arabic.ArabicNumbers;
import javamentor.numbers.roman.RomanConverter;
import javamentor.operation.Operation;

// Класс который производит вычисления и выводит ответ
public class Calculation {

    // Основной метод в котором происходит вычисление
    public static void calculate() {

        if (Numbers.isRoman) {
            romanCalculate();
        }
        if (Numbers.isArabic) {
            arabicCalculate();
        }

    }

    private static void romanCalculate() {

        switch (Operation.getOperationSign()) {
            case '+':
                System.out.format("%s\n",
                        RomanConverter.convertArabicToRoman(
                                ArabicNumbers.getFirstNumber() + ArabicNumbers.getSecondNumber()));
                break;

            case '-':
                System.out.format("%s\n",
                        RomanConverter.convertArabicToRoman(
                                ArabicNumbers.getFirstNumber() - ArabicNumbers.getSecondNumber()));
                break;

            case '*':
                System.out.format("%s\n",
                        RomanConverter.convertArabicToRoman(
                                ArabicNumbers.getFirstNumber() * ArabicNumbers.getSecondNumber()));
                break;

            case '/':
                System.out.format("%s\n",
                        RomanConverter.convertArabicToRoman(
                                ArabicNumbers.getFirstNumber() / ArabicNumbers.getSecondNumber()));
                break;
        }
    }

    private static void arabicCalculate() {

        switch (Operation.getOperationSign()) {
            case '+':
                System.out.format("%s\n",
                        ArabicNumbers.getFirstNumber() + ArabicNumbers.getSecondNumber());
                break;

            case '-':
                System.out.format("%s\n",
                        ArabicNumbers.getFirstNumber() - ArabicNumbers.getSecondNumber());
                break;

            case '*':
                System.out.format("%s\n",
                        ArabicNumbers.getFirstNumber() * ArabicNumbers.getSecondNumber());
                break;

            case '/':
                System.out.format("%s\n",
                        ArabicNumbers.getFirstNumber() / ArabicNumbers.getSecondNumber());
                break;
        }
    }
}

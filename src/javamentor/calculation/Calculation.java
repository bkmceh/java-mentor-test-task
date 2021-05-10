package javamentor.calculation;

import javamentor.numbers.Numbers;
import javamentor.numbers.arabic.ArabicNumbers;
import javamentor.operation.Operation;

public class Calculation {

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
                System.out.format("\nAnswer: %s\n",
                        ArabicNumbers.getFirstNumber() + ArabicNumbers.getSecondNumber());
                break;

            case '-':
                System.out.format("\nAnswer: %s\n",
                        ArabicNumbers.getFirstNumber() - ArabicNumbers.getSecondNumber());
                break;

            case '*':
                System.out.format("\nAnswer: %s\n",
                        ArabicNumbers.getFirstNumber() * ArabicNumbers.getSecondNumber());
                break;

            case '/':
                System.out.format("\nAnswer: %s\n",
                        ArabicNumbers.getFirstNumber() / ArabicNumbers.getSecondNumber());
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

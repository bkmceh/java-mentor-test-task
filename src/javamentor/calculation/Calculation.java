package javamentor.calculation;

import javamentor.numbers.Numbers;
import javamentor.numbers.arabic.ArabicNumbers;
import javamentor.validation.Operation;

public class Calculation {

    public static void calculate() {

        if (Numbers.isRoman) {
            romanCalculate();
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
}

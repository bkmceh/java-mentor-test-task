package javamentor.numbers.arabic;

// Хранит 2 числа в виде арабских чисел для последующих вычислений
public class ArabicNumbers {

    private static int firstNumber;

    private static int secondNumber;

    public static int getFirstNumber() {
        return firstNumber;
    }

    public static void setFirstNumber(final int firstNumber) {
        ArabicNumbers.firstNumber = firstNumber;
    }

    public static int getSecondNumber() {
        return secondNumber;
    }

    public static void setSecondNumber(final int secondNumber) {
        ArabicNumbers.secondNumber = secondNumber;
    }
}

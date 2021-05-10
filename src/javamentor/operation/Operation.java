package javamentor.operation;

// Класс хранит расположение арифметического знака и какой он конкретно
public class Operation {

    private static int operationIndex;

    private static char operationSign;

    public static int getOperationIndex() {
        return operationIndex;
    }

    public static void setOperationIndex(final int operationIndex) {
        Operation.operationIndex = operationIndex;
    }

    public static char getOperationSign() {
        return operationSign;
    }

    public static void setOperationSign(final char operationSign) {
        Operation.operationSign = operationSign;
    }
}

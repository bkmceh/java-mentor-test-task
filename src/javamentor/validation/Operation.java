package javamentor.validation;

public class Operation {

    private static int operationIndex;

    private static char operationSign;

    public static int getOperationIndex() {
        return operationIndex;
    }

    public static void setOperationIndex(int operationIndex) {
        Operation.operationIndex = operationIndex;
    }

    public static char getOperationSign() {
        return operationSign;
    }

    public static void setOperationSign(char operationSign) {
        Operation.operationSign = operationSign;
    }
}

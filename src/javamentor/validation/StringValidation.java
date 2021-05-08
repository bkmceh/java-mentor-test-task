package javamentor.validation;

import javamentor.exceptions.ManyArithmeticOperationsException;
import javamentor.exceptions.NotFoundArithmeticOperationException;
import javamentor.exceptions.SpaceExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {

    private static Pattern pattern = Pattern.compile("[+\\-*/]");

    public static void validate(String inputString) {

        Operation operation;
        operation = checkOperations(inputString);

        if (operation.isOneOperation()) {

            if (inputString.indexOf(' ') == 0
                    || inputString.lastIndexOf(' ') == inputString.length() - 1)
                throw new SpaceExceptions("Пробел в начале или в конце выражения, уберите");

            try {

                System.out.format("First: %s", inputString.substring(0, operation.getOperationIndex()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Operation checkOperations(final String inputString) {

        Operation operation = new Operation();
        operation.setOneOperation(false);

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

        operation.setOneOperation(true);

        return operation;
    }
}

package javamentor.validation;

import javamentor.exceptions.ManyArithmeticOperationsException;
import javamentor.exceptions.NotFoundArithmeticOperationException;
import javamentor.exceptions.SpaceExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {

    private static final Pattern pattern = Pattern.compile("[+\\-*/]");


    public static void validate(String inputString) {

        Operation operation;
        operation = checkOperations(inputString);

        checkSpaces(inputString, operation);



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
            throw new SpaceExceptions("Уберите лишние пробелы в начале или в конце.");
        }

        if (operation.getOperationIndex() - inputString.indexOf(' ') != 1) {
            throw new SpaceExceptions("Проверьте пробелы в выражении перед оператором.");
        }

        if (inputString.lastIndexOf(' ') - operation.getOperationIndex() != 1) {
            throw new SpaceExceptions("Проверьте пробелы в выражении после оператора.");
        }
    }

    private static void getNumbers(final String inputString, final Operation operation) {

    }
}

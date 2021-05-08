package javamentor.validation;

import javamentor.exceptions.ManyArithmeticOperationsException;
import javamentor.exceptions.NotFoundArithmeticOperationException;
import javamentor.exceptions.SpaceExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {

    private static Pattern pattern = Pattern.compile("[+\\-*/]");

    public static boolean validate(String inputString) {
        if (checkNumberOfOperations(inputString)) {

            if (inputString.indexOf(' ') == 0
                    || inputString.lastIndexOf(' ') == inputString.length() - 1)
                throw new SpaceExceptions("Пробел в начале или в конце выражения, уберите");

            Matcher matcher = pattern.matcher(inputString);
            try {
                if (matcher.find());
                System.out.format("First: %s", inputString.substring(0, matcher.start()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkNumberOfOperations(final String inputString) {
        int count = 0;
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            count++;
        }
        System.out.format("Совпадений %s\n", count);

        if (count > 1) {
            throw new ManyArithmeticOperationsException("Число арифметических операций чет много");
        }
        if (count == 0) {
            throw new NotFoundArithmeticOperationException("Не найдена арифметическая операция.");
        }

        return true;
    }
}

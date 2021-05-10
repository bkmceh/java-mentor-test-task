package javamentor;

import javamentor.calculation.Calculation;
import javamentor.validation.StringValidation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считывание строки
        String inputString = scanner.nextLine();

        // Проверка строки на валидность
        StringValidation.validate(inputString);

        // Само вычисление если строка прошла проверку
        Calculation.calculate();
    }
}

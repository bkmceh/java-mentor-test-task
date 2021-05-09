package javamentor;

import javamentor.calculation.Calculation;
import javamentor.validation.StringValidation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        Calculation.calculate(inputString);
    }
}

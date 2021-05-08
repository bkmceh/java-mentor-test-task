package javamentor;

import javamentor.validation.StringValidation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        StringValidation.validate(inputString);
    }
}

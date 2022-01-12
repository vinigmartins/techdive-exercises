package modulo1.semana8.extra;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] validNumber  = {false, false};
        boolean validOperation = false;
        int[] numbers = new int[2];
        int answer = 0;
        String operator = "";

        System.out.printf("-------------- BASIC CALCULATOR -------------- %n");

        for (int i = 0; i < 2; i++){
            while (!validNumber[i]){
                System.out.print("Enter the "         +
                        (i == 0 ? "first" : "second") +
                        " integer number: "
                );
                try {
                    numbers[i] = Integer.parseInt(input.nextLine());
                    validNumber[i] = true;
                } catch (NumberFormatException e) {
                    System.out.println("The input must be integer");
                }
            }
        }
        while (!validOperation) {
            System.out.println(
                    "A: " + numbers[0] + "\n" +
                    "B: " + numbers[1]
            );
            System.out.print("""
                        + -> addition
                        - -> subtraction
                        * -> multiplication
                        / -> division
                        Choose the operation:\040"""
            );
            try {
                operator = input.nextLine();
                answer   = switch (operator) {
                    case "+" -> numbers[0] + numbers[1];
                    case "-" -> numbers[0] - numbers[1];
                    case "*" -> numbers[0] * numbers[1];
                    case "/" -> numbers[0] / numbers[1];
                    default  -> throw new ArithmeticException("Invalid operator");
                };
                validOperation = true;
            } catch (ArithmeticException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.printf("%d %s %d = %d", numbers[0], operator, numbers[1], answer);
    }
}

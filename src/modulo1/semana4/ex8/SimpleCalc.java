package modulo1.semana4.ex8;

import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] numbers = new float[2];
        float answer;
        String operator;

        System.out.printf("-------------- CALCULADORA SIMPLES -------------- %n");
        System.out.print("Digite o primeiro numero: ");
        numbers[0] = sc.nextFloat();

        System.out.print("Digite o segundo numero: ");
        numbers[1] = sc.nextFloat();

        System.out.print("Digite a operação: ");
        sc.nextLine();
        operator = sc.nextLine();

        answer = switch (operator) {
            case "+" -> numbers[0] + numbers[1];
            case "-" -> numbers[0] - numbers[1];
            case "*" -> numbers[0] * numbers[1];
            case "/" -> numbers[0] / numbers[1];
            default  -> throw new ArithmeticException("Operação invalida");
        };

        System.out.printf("O resultado é: %.2f", answer);
    }
}

package modulo1.semana4.ex9;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int factorial = 1;

        System.out.printf("-------------- FATORIAL DE 0 - 10 -------------- %n");
        System.out.print("Digite um numero de 0 a 10: ");
        number = sc.nextInt();

        if (number > 10 || number < 0) {
            System.out.printf("Numero invalido%n");
            return;
        }

        for (int i = number; i >= 2 ; i--) factorial *= i;
        System.out.printf("O fatorial de %d é %d%n", number, factorial );
    }
}

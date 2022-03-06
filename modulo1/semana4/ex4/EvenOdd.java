package modulo1.semana4.ex4;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
        int number;

        System.out.print("Digite um numero: ");
        number = sc.nextInt();
        answer = number % 2 == 0 ? "par" : "impar";

        System.out.printf("O numero %d é %s.", number, answer);
    }
}

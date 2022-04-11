package modulo1.semana4.ex5;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
        int number, guess;

        System.out.println("Adivinhe qual número de 1 a 5 eu estou pensando");
        guess = sc.nextInt();
        number = (int) (Math.random() * (6 - 1) + 1);

        answer = number == guess ? "Voce acertou" :
                String.format("Voce errou, o número correto era %d", number);

        System.out.print(answer);
    }
}

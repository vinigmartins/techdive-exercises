package modulo1.semana9.ex4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numbers   = new int[2];
        int r = 0;
        boolean[] tudoCerto = {false, false};

        System.out.println("Eu sei dividir");
        for (int i = 0; i < 2; i++){
            while (!tudoCerto[i]){
                System.out.print("Informe o " + (i == 0 ? "primeiro" : "segundo") + " valor: ");
                try {
                    numbers[i]   = teclado.nextInt();
                    tudoCerto[i] = true;
                } catch (InputMismatchException e) {
                    System.out.println("só numeros por favor");
                    teclado.nextLine();
                }
            }
        }
        try {
            r = numbers[0] / numbers[1];
            System.out.println("Resultado da divisão: " + r);
        } catch (ArithmeticException e) {
            System.out.println("não pode ser feito divisão por ZERO");
        }
    }
}

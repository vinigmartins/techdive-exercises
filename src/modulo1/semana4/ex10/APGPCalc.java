package modulo1.semana4.ex10;

import java.util.Scanner;

public class APGPCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequence = new int[10];
        int start, d; // d = common difference

        System.out.printf("--------- PA e PG - 10 Digitos Seguintes ---------%n");
        System.out.print("Digite um valor inicial: ");
        start = sc.nextInt();

        System.out.print("Digite um valor para a raiz: ");
        d = sc.nextInt();

        System.out.print("Digite 1 para PA e 2 para PG: ");

        int      option = sc.nextInt();
        if      (option == 1) for (int i = 0; i < 10; i++) sequence[i] = start + d * i;
        else if (option == 2) for (int i = 0; i < 10; i++) sequence[i] = (int) (start * Math.pow(d, i));
        else    { System.out.println("Opcao invalida"); return; }

        for (int i : sequence) System.out.println(i);
    }
}

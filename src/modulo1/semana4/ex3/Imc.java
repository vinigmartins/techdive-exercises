package modulo1.semana4.ex3;

import java.util.Scanner;

public class Imc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height, weight, imc;

        System.out.print("Digite sua altura com 2 ou mais casas decimais: ");
        height = sc.nextDouble();
        System.out.print("Digite seu peso: ");
        weight = sc.nextDouble();
        imc = weight / (height * height);

        System.out.printf("%nSeu IMC é de: %.1f", imc);
    }
}

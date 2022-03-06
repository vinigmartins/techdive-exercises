package modulo1.semana4.ex2;

import java.util.Scanner;

public class Name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();

        String fullName = name.trim() + " " + lastName.trim();
        int qtfLetters = fullName.replaceAll("[^A-Za-z]", "").length();

        System.out.printf("%nSeu nome completo é %s. E possui %d letras. %n", fullName, qtfLetters);
    }
}

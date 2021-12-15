package modulo1.semana4.ex6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua data de nascimento (dd/mm/aaaa): ");

        String[] birthDate = sc.nextLine().split("/");

        LocalDate start = LocalDate.of(Integer.parseInt(birthDate[2]),
                                       Integer.parseInt(birthDate[1]),
                                       Integer.parseInt(birthDate[0])),
                    now = LocalDate.now();

        long yearsBetween = ChronoUnit.YEARS.between(start, now);
        System.out.println(yearsBetween < 18 ? "você é menor de idade" : "você é maior de idade");
    }
}

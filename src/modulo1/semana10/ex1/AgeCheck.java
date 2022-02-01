package modulo1.semana10.ex1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCheck {
    public static void main(String[] args) {
        System.out.println("Digite sua data de nascimento (dd/mm/aaaa): ");

        try(Scanner sc   = new Scanner(System.in);
            Scanner date = new Scanner(sc.nextLine()).useDelimiter("/")){
            int day   = date.nextInt();
            int month = date.nextInt();
            int year  = date.nextInt();

            LocalDate start = LocalDate.of(year, month, day);
            LocalDate now   = LocalDate.now();

            long yearsBetween = ChronoUnit.YEARS.between(start, now);
            System.out.println("Você tem " + yearsBetween + " anos, portanto voce" +
                                            (yearsBetween < 18 ? " não " : " " + "pode entrar no site"));
        }
        /*try (Scanner sc = new Scanner(System.in)){
            System.out.println(ChronoUnit.YEARS.between(
                            LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalDate.now()) < 18 ? "você é menor de idade" : "você é maior de idade");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}

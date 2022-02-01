package modulo1.semana10.ex4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FridayThirteen {
    public static void main(String[] args) {
        System.out.println("Digite uma data (dd/mm/aaaa): ");

        try(Scanner sc = new Scanner(System.in)) {
            LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            boolean isThirteen = date.getDayOfMonth() == 13;
            boolean isFriday = date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
            System.out.println("Esse dia " + (isFriday && isThirteen ? "" : "não ") + "é uma sexta-feira 13.");
        } catch (DateTimeParseException e) {
            System.out.println("Data invalida");
        }
    }
}

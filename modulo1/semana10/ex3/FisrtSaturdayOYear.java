package modulo1.semana10.ex3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class FisrtSaturdayOYear {
    public static void main(String[] args) {
        System.out.println("Digite um ano aaaa: ");

        try(Scanner sc = new Scanner(System.in)) {
            LocalDate start = LocalDate.of(sc.nextInt(), 1 , 1);
            LocalDate end = start.plusMonths(12);
            TemporalAdjuster nextOrSameSaturday = TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY);

            while (start.isBefore(end)){
                LocalDate firstSaturday = start.with(nextOrSameSaturday);
                System.out.println(firstSaturday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                start = start.plusMonths(1);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Data invalida");
        }
    }
}

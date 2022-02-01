package modulo1.semana10.ex5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class MondaysOfMonth {
    public static void main(String[] args) {
        System.out.println("Digite o mes e o ano (mm/aaaa): ");

        try(Scanner sc = new Scanner(System.in)) {
            LocalDate start = YearMonth.parse(sc.nextLine(), DateTimeFormatter.ofPattern("MM/yyyy")).atDay(1);
            LocalDate end = start.plusMonths(1);
            LocalDate nextMonday = start.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

            while (nextMonday.isBefore(end)) {
                System.out.println(nextMonday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                nextMonday = nextMonday.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }
        } catch (DateTimeParseException e) {
            System.out.println("Data invalida");
        }
    }
}

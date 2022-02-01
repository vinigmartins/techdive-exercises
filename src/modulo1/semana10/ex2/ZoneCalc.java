package modulo1.semana10.ex2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

public class ZoneCalc {
    public static void main(String[] args) {
        ZoneId[] zones = ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).toArray(ZoneId[]::new);
        Random random  = new Random();

        LocalDateTime departure     = LocalDateTime.of(2022, 4, 4, 22, 30);
        LocalDateTime arrival       = LocalDateTime.of(2022, 4, 4, 20, 30);
        ZonedDateTime departureZone = ZonedDateTime.of(departure, zones[random.nextInt(600)]);
        ZonedDateTime arrivalZone   = ZonedDateTime.of(arrival, zones[random.nextInt(600)]);
        System.out.format("%-11s%s%n", "departure:",departureZone);
        System.out.format("%-11s%s%n", "arrival:",arrivalZone);
        Duration durationZone = Duration.between(departureZone, arrivalZone);
        System.out.printf("O voo durou " + durationZone.toHours() + " horas e " + durationZone.toMinutesPart() + " minutos");
    }
}

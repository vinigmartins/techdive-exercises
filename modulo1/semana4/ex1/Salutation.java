package modulo1.semana4.ex1;

import java.time.LocalTime;

public class Salutation {
    public static void main(String[] args) {
        int hour = LocalTime.now().getHour();
        int minute = LocalTime.now().getMinute();
        String salutation = hour >= 18 ? "boa noite" :
                            hour >= 12 ? "boa tarde" :
                            hour >= 6  ? "bom dia"   :
                                         "para de programar e vai dormir";

        System.out.printf("%s, no momento são %02d:%02d %n", salutation, hour, minute);
    }
}

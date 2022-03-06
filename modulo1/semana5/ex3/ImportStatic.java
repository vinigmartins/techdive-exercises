package modulo1.semana5.ex3;

import static java.lang.Math.PI;
import static java.time.LocalDateTime.now;
import static java.util.Currency.getAvailableCurrencies;

public class ImportStatic {
    public static void main(String[] args) {
        System.out.println(PI);
        System.out.println(now());
        System.out.println(getAvailableCurrencies());
    }
}

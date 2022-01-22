package modulo1.semana9.hotelInhouse;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    static ArrayList<Quarto> quartos = new ArrayList<>();
    static Map<Quarto, Map<LocalDate, Hospede>> reserva = new HashMap<>();

    static void reservar(Hospede hospede, LocalDate inicio, LocalDate fim, Quarto quarto) {
        if (inicio.isAfter(fim))
            throw new IllegalArgumentException("Inicio esta depois do fim");
        else if (LocalDate.now().plusMonths(2).isBefore(inicio))
            throw new IllegalArgumentException("Tentativa de reserva com mais de 60 dias de antecedência");
        else if (LocalDate.now().isAfter(inicio))
            throw new IllegalArgumentException("Inicio esta antes de hoje");


        Map<LocalDate, Hospede> diasReservados = new HashMap<>();
        for (LocalDate dia = inicio; dia.isBefore(fim.plusDays(1)); dia = dia.plusDays(1)) {
            diasReservados.put(dia, hospede);
        }

        if (quartoOcupado(quarto, new ArrayList(inicio.datesUntil(fim.plusDays(1)).collect(Collectors.toList()))))
            throw new IllegalArgumentException("Ja esta reservado");
        quarto.adicionarNoHistorico(hospede);
        reserva.put(quarto, diasReservados);
    }

    static Boolean quartoOcupado(Quarto quarto, ArrayList<LocalDate> dias) {
        if (reserva.get(quarto) == null) return false;

        for (LocalDate dia : dias) {
            if (reserva.get(quarto).containsKey(dia))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        quartos.add(new Quarto(TipoDeQuarto.SIMPLES));
        reservar(
                new Hospede("612354897"),
                LocalDate.of(2022, 2, 6),
                LocalDate.of(2022, 2, 20),
                quartos.get(0)
        );
        reservar(
                new Hospede("612354897"),
                LocalDate.of(2022, 2, 1),
                LocalDate.of(2022, 2, 7),
                quartos.get(0)
        );
        System.out.println(quartoOcupado(quartos.get(0), new ArrayList(List.of(LocalDate.of(2022, 2, 1)))));
    }
}

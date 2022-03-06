package modulo1.semana9.hotelInhouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quarto {
    TipoDeQuarto tipo;
    ArrayList<Hospede> historicoHospedes = new ArrayList<>();

    public Quarto(TipoDeQuarto tipo) {
        this.tipo = tipo;
    }

    void adicionarNoHistorico(Hospede hospede){
        historicoHospedes.add(hospede);
    }
}

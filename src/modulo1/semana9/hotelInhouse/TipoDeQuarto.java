package modulo1.semana9.hotelInhouse;

//Baixa e Alta temporada variam o preço
public enum TipoDeQuarto {
    SUPREMA(500, 800),
    LUXO(150, 400),
    SIMPLES(90, 140);

    private final double precoAltaTemporada;
    private final double precoBaixaTemporada;

    TipoDeQuarto(double baixa, double alta) {
        this.precoAltaTemporada  = alta;
        this.precoBaixaTemporada = baixa;
    }
}

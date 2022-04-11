package modulo1.semana8.jogo.personagem;

import modulo1.semana8.jogo.personagem.inimigo.Armadilha;
import modulo1.semana8.jogo.personagem.inimigo.Lider;

public enum Arma {
    ARCO(5, Arqueiro.class),
    BESTA(5, Arqueiro.class),
    CLAVA(5, Paladino.class),
    CAJADO(5, Mago.class),
    ESPADA(5, Guerreiro.class),
    MACHADO(5, Guerreiro.class),
    MARTELO(5, Paladino.class),
    GRIMORIO(5, Mago.class),
    ARMADILHA(2, Armadilha.class),
    MACHADODUPLO(7, Lider.class);

    private final int dano;
    private final Class<?> portador;

    Arma(int dano, Class<?> portador) {
        this.dano = dano;
        this.portador = portador;
    }

    public int getDano() {
        return dano;
    }

    public Class<?> getPortador() {
        return portador;
    }
}

package modulo1.semana8.jogo.personagem.inimigo;

import modulo1.semana8.jogo.personagem.Arma;
import modulo1.semana8.jogo.personagem.Atacante;
import modulo1.semana8.jogo.personagem.Personagem;
import modulo1.semana8.jogo.util.Dado;

public class Armadilha implements Atacante {
    final Arma arma = Arma.ARMADILHA;
    final int pontosAtaque = 5;

    public Armadilha() {
    }

    @Override
    public void atacar(Personagem alvo) {
        int d10 = Dado.rolarDado(10);
        int dano = Math.max(d10 + arma.getDano() + pontosAtaque - alvo.getPontosDefesa(), 0);

        if (d10 == 1) {
            System.out.println("O ataque da armadilha pegou de raspão e você não sofreu dano.");
        } else {
            alvo.setPontosSaude(alvo.getPontosSaude() - dano);
            System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida%n", dano, alvo.getPontosSaude());
        }
    }
}

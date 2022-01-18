package modulo1.semana8.jogo.personagem.inimigo;

import modulo1.semana8.jogo.personagem.*;
import modulo1.semana8.jogo.util.Dado;

public abstract class Inimigo extends Personagem {
    Arma arma;
    final int saudeMaxima;

    public Inimigo(int saudeMaxima, int pontosSaude, int pontosAtaque, int pontosDefesa, Arma arma) {
        super(pontosSaude, pontosAtaque, pontosDefesa);
        this.arma = arma;
        this.saudeMaxima = saudeMaxima;
    }

    @Override
    public void atacar(Personagem alvo) {
        int d20 = Dado.rolarDado(20);
        int dano = Math.max(d20 + arma.getDano() + super.getPontosAtaque()
                - (d20 == 20 ? 0 : alvo.getPontosDefesa()), 0);

        if (d20 == 1) {
            System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
        } else {
            alvo.setPontosSaude(Math.max(alvo.getPontosSaude() - dano, 0));
            System.out.println(d20 == 20 ?
                    "O inimigo acertou um ataque crítico!" :
                    "O inimigo atacou!");

            System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida%n", dano, alvo.getPontosSaude());
        }
    }
}

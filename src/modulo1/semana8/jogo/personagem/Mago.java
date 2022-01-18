package modulo1.semana8.jogo.personagem;

public class Mago extends Jogador {
    public Mago(String nome,
                char sexo,
                Arma arma,
                Motivacao motivacao
    ) {
        super(Jogador.saudeMaxima, 19, 11, nome, sexo);
        if (arma.getPortador() != this.getClass()) throw new IllegalArgumentException("Arma não corresponde a classe");

        super.setArma(arma);
        super.setMotivacao(motivacao);
    }

    public Mago(String nome, char sexo) {
        super(Jogador.saudeMaxima, 19, 11, nome, sexo);
    }
}

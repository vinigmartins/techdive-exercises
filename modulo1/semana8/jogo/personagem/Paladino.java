package modulo1.semana8.jogo.personagem;

public class Paladino extends Jogador {
    public Paladino(String nome,
                    char sexo,
                    Arma arma,
                    Motivacao motivacao
    ) {
        super(Jogador.saudeMaxima, 13, 18, nome, sexo);
        if (arma.getPortador() != this.getClass()) throw new IllegalArgumentException("Arma não corresponde a classe");

        super.setArma(arma);
        super.setMotivacao(motivacao);
    }

    public Paladino(String nome, char sexo) {
        super(Jogador.saudeMaxima, 13, 18, nome, sexo);
    }
}

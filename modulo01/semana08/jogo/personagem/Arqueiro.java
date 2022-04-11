package modulo1.semana8.jogo.personagem;

public class Arqueiro extends Jogador {
    public Arqueiro(String nome,
                    char sexo,
                    Arma arma,
                    Motivacao motivacao
    ) {
        super(Jogador.saudeMaxima, 18, 13, nome, sexo);
        if (arma.getPortador() != this.getClass()) throw new IllegalArgumentException("Arma não corresponde a classe");

        super.setArma(arma);
        super.setMotivacao(motivacao);
    }

    public Arqueiro(String nome, char sexo) {
        super(Jogador.saudeMaxima, 18, 13, nome, sexo);
    }
}

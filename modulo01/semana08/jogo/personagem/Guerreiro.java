package modulo1.semana8.jogo.personagem;

public class Guerreiro extends Jogador {
    public Guerreiro(String nome,
                     char sexo,
                     Arma arma,
                     Motivacao motivacao
    ) {
        super(Jogador.saudeMaxima, 15, 15, nome, sexo);
        if (arma.getPortador() != this.getClass()) throw new IllegalArgumentException("Arma não corresponde a classe");

        super.setArma(arma);
        super.setMotivacao(motivacao);
    }

    public Guerreiro(String nome, char sexo) {
        super(Jogador.saudeMaxima, 15, 15, nome, sexo);
    }

//    @Override
//    public void setArma(Arma arma) {
//        super.setArma(arma);
//    }
//
//    @Override
//    public void setMotivacao(Motivacao motivacao) {
//        super.setMotivacao(motivacao);
//    }
}

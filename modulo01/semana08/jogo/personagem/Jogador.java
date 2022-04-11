package modulo1.semana8.jogo.personagem;

import modulo1.semana8.jogo.util.Dado;

public abstract class Jogador extends Personagem {
    protected String nome;
    protected char sexo;
    protected Arma arma;
    protected Motivacao motivacao;
    public static final int saudeMaxima = 200;

    protected Jogador(int pontosSaude,
                      int pontosAtaque,
                      int pontosDefesa,
                      String nome,
                      char sexo
    ) {
        super(pontosSaude, pontosAtaque, pontosDefesa);

        this.nome = nome;
        this.sexo = sexo;
    }

    @Override
    public void atacar(Personagem alvo) {
        int d20 = Dado.rolarDado(20);
        int dano = Math.max(d20 + arma.getDano() + super.getPontosAtaque()
                - (d20 == 20 ? 0 : alvo.getPontosDefesa()), 0);

        if (d20 == 1) {
            System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
        } else {
            alvo.setPontosSaude(Math.max(alvo.getPontosSaude() - dano, 0));
            System.out.println(d20 == 20 ?
                    "Você acertou um ataque crítico! " :
                    "Você atacou ");

            System.out.println(
                    switch (arma) {
                        case ESPADA, CLAVA -> "com sua " + arma.name();
                        case MACHADO, MARTELO -> "com seu " + arma.name();
                        case ARCO -> "com seu " + arma.name() + ", a flecha atingiu";
                        case BESTA -> "com sua " + arma.name() + ", o virote atingiu";
                        case CAJADO -> "com seu " + arma.name() + ", lançando uma bola de fogo";
                        case GRIMORIO -> "absorvendo energia do livro com uma mão e liberando com a outra";
                        default -> throw new IllegalStateException("Que arma é essa amigo?" + arma);
                    } + String.format(" e causou %d de dano no inimigo!", dano)
            );
        }
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public Arma getArma() {
        return arma;
    }

    public Motivacao getMotivacao() {
        return motivacao;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setMotivacao(Motivacao motivacao) {
        this.motivacao = motivacao;
    }
}

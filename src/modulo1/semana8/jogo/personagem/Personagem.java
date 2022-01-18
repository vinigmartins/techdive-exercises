package modulo1.semana8.jogo.personagem;

public abstract class Personagem implements Atacante {
    int pontosDefesa;
    int pontosSaude;
    int pontosAtaque;

    protected Personagem(int pontosSaude, int pontosAtaque, int pontosDefesa) {
        this.pontosSaude = pontosSaude;
        this.pontosAtaque = pontosAtaque;
        this.pontosDefesa = pontosDefesa;
    }

    public int getPontosDefesa() {
        return pontosDefesa;
    }

    public void setPontosDefesa(int pontosDefesa) {
        this.pontosDefesa = pontosDefesa;
    }

    public int getPontosSaude() {
        return pontosSaude;
    }

    public void setPontosSaude(int pontosSaude) {
        this.pontosSaude = pontosSaude;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }
}

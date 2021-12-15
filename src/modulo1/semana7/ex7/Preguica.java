package modulo1.semana7.ex7;

public class Preguica extends Animal{

    public Preguica(int idade, String nome) {
        super(idade, nome);
    }

    @Override
    public void emitirSom(){
        if (getNome().equalsIgnoreCase("sid"))
            System.out.println(getNome() + ": a gente vai viveeer!!!, A gente vai Morrer!!!");
        else
            System.out.println(getNome() + ": .......zzz");
    }

    public void subirArvore(){
        System.out.println(getNome() + ": Subindo uma arvore a com velocidade de 1/x km/h, lim x -> ∞");
    }
}

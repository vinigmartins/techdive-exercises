package modulo1.semana7.ex7;

public class Cavalo extends Animal{

    public Cavalo(int idade, String nome) {
        super(idade, nome);
    }

    @Override
    public void emitirSom(){
        System.out.println(getNome() + ": iiirrrrí");
    }

    public void correr(){
        System.out.println(getNome() + ": Galopando");
    }
}

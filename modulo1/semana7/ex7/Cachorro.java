package modulo1.semana7.ex7;

public class Cachorro extends Animal{

    public Cachorro(int idade, String nome) {
        super(idade, nome);
    }

    @Override
    public void emitirSom(){
        System.out.println(getNome() + ": au au");
    }

    public void correr(){
        System.out.println(getNome() + ": Correndo");
    }
}

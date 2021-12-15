package modulo1.semana7.ex10;

import modulo1.semana7.ex7.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Zoologico {
    private static class Jaula{
        public Animal animal;

        public Jaula(Animal animal) {
            this.animal = animal;
        }

    }
    public static ArrayList<Jaula> jaulas = new ArrayList<Jaula>();

    public static void adicionarAnimal(Animal animal){
        jaulas.add(new Jaula(animal));
    }

    public static void percorrerJaulas(){
        for (Jaula jaula : jaulas) {
            jaula.animal.emitirSom();
            try {
                jaula.animal.getClass().getMethod("correr").invoke(jaula.animal);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {}
        }
    }

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro(5, "Rex");
        Preguica preguica = new Preguica(8,"Sid");
        Cavalo cavalo   = new Cavalo  (7, "Pangaré");

        Cachorro cachorro1 = new Cachorro(5, "Rex");
        Preguica preguica1 = new Preguica(8,"Sid");
        Cavalo   cavalo1   = new Cavalo  (7, "Pangaré");

        Cachorro cachorro2 = new Cachorro(5, "Rex");
        Preguica preguica2 = new Preguica(8,"Sid");
        Cavalo   cavalo2   = new Cavalo  (7, "Pangaré");

        Zoologico.adicionarAnimal(cachorro);
        Zoologico.adicionarAnimal(preguica);
        Zoologico.adicionarAnimal(cavalo);

        Zoologico.adicionarAnimal(cachorro1);
        Zoologico.adicionarAnimal(preguica1);
        Zoologico.adicionarAnimal(cavalo1);

        Zoologico.adicionarAnimal(cachorro2);
        Zoologico.adicionarAnimal(preguica2);
        Zoologico.adicionarAnimal(cavalo2);

        Zoologico.percorrerJaulas();
    }
}

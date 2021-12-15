package modulo1.semana7.ex9;

import modulo1.semana7.ex7.Animal;
import modulo1.semana7.ex7.Cachorro;
import modulo1.semana7.ex7.Cavalo;
import modulo1.semana7.ex7.Preguica;

public class Veterinario {
    public static void examinar(Animal animal){
        animal.emitirSom();
    }

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro(5, "Rex");
        Preguica preguica = new Preguica(8,"Sid");
        Cavalo   cavalo   = new Cavalo  (7, "Pangaré");

        examinar(cachorro);
        examinar(cavalo);
        examinar(preguica);
    }
}

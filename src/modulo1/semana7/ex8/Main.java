package modulo1.semana7.ex8;

import modulo1.semana7.ex7.*;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro(5, "Rex");
        Preguica preguica = new Preguica(8,"Sid");
        Cavalo cavalo   = new Cavalo  (7, "Pangaré");

        cachorro.emitirSom();
        cavalo.emitirSom();
        preguica.emitirSom();

        cachorro.correr();
        cavalo.correr();
        preguica.subirArvore();
    }
}

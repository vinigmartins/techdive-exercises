package modulo1.semana8.jogo.util;

public class Dado {
    public static int rolarDado(int faces) {
        return (int) (Math.random() * faces) + 1;
    }
}


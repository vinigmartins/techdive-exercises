package modulo1.semana9.ex3;

public class TesteException {
    public static void main(String[] args) {
        System.out.println("inicio do main");
        metodo1();
        System.out.println("fim do main");
    }

    static void metodo1() {
        System.out.println("inicio do metodo1");
        metodo2();
        System.out.println("fim do metodo1");
    }

    static void metodo2() {
        System.out.println("inicio do metodo2");
        int[] array = new int[10];
        for (int i = 0; i < 15 ; i++) {
            try {
                array[i] = i;
                System.out.println(i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("index inexistente");
            }
        }
        System.out.println("fim do metodo2");
    }
}

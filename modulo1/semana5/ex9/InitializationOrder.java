package modulo1.semana5.ex9;

public class InitializationOrder {
    static {
        System.out.println("dentro do bloco static");
    }

    {
        System.out.println("dentro do bloco de instancia");
    }

    InitializationOrder() {
        System.out.println("dentro do construtor");
    }

    public static void main(String[] args) {
        new InitializationOrder();
    }
}

package modulo1.semana5.ex2;

public class ConstructorOverload {
    int foo;

    ConstructorOverload() {this(10);}
    ConstructorOverload(int bar) {foo = bar;}

    public static void main(String[] args) {
        new ConstructorOverload();
        new ConstructorOverload(10);
    }
}

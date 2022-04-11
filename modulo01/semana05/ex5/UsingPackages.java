package modulo1.semana5.ex5;

import modulo1.semana5.ex5.foo.Bar;

public class UsingPackages {
    public static void main(String[] args) {
        Bar.staticMethod();
        new Bar().instanceMethod();
    }
}

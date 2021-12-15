package modulo1.semana5.ex8;

public class Class2 {

    public static void accessClass1(){
        new Class1().setPrivateVar(10);
    }

    public static void main(String[] args) {
        Class2.accessClass1();
    }
}
package modulo1.semana5.ex10;

public class Enclosing {
     class Inner {
        Inner () {
            System.out.println("Inner instantiated");
        }
        public void method () {
            System.out.println("method from Inner");
        }
    }

    Inner innerAnonymous = new Inner() {
        public void method() {
            System.out.println("method from Inner Anonymous");
        }
    };

    public static class InnerStatic {
        InnerStatic () {
            System.out.println("InnerStatic instantiated");
        }

    }

    public void method () {
        class InnerLocal {
            InnerLocal () {
                System.out.println("InnerLocal instantiated");
            }
        }
        new InnerLocal();
    }

    public static void main(String[] args) {
        Enclosing.InnerStatic innerStatic = new Enclosing.InnerStatic(); // classe interna estatica instanciada

        Enclosing enclosing = new Enclosing();                           // classe interna anonima instanciada
        enclosing.innerAnonymous.method();

        Inner inner = enclosing.new Inner();                                     // classe interna instanciada

        enclosing.method();                                                      // classe interna local instanciada
    }
}

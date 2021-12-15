package modulo1.semana5.ex4;

public class FinalAttributes {
    private final int FINAL_ATTRIBUTE1;
    private final static int FINAL_ATTRIBUTE2;

    static            {FINAL_ATTRIBUTE2 = 1;}
    FinalAttributes() {FINAL_ATTRIBUTE1 = 1;}

    public static void main(String[] args) {
        new FinalAttributes();
    }
}

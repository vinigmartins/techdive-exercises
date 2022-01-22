package modulo1.semana9.banco;

public abstract class Conta {
    Cliente titular;

    public Conta(Cliente titular) {
        this.titular = titular;
    }

    @Override
    public boolean equals(Object obj) {
        return titular.nome.equals((String) obj);
    }
}

package modulo1.semana9.banco;

public class ContaCorrente extends Conta {
    public ContaCorrente(String nomeTitular) {
        super(new Cliente(nomeTitular));
    }
}

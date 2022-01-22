package modulo1.semana9.banco;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(String nomeTitular) {
        super(new Cliente(nomeTitular));
    }
}

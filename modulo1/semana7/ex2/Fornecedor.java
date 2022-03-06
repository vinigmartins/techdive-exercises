package modulo1.semana7.ex2;

import modulo1.semana7.ex1.Pessoa;

public class Fornecedor extends Pessoa {
    private double valorCredito;
    private double valorDivida;

    public Fornecedor(String nome, String endereço, String telefone, double valorCredito, double valorDivida) {
        super(nome, endereço, telefone);
        this.valorCredito = valorCredito;
        this.valorDivida = valorDivida;
    }

    public double obterSaldo(){
        return getValorCredito() - getValorDivida();
    }
    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public static void main(String[] args) {
        Fornecedor ze = new Fornecedor(
                                "ze",
                                "rua dos bobos numero 0",
                                "999445522",
                                2000,
                                1500);

        System.out.println(
                            ze.getNome()     + "\n" +
                            ze.getTelefone() + "\n" +
                            ze.getEndereço() + "\n" +
                            "Saldo: " + ze.obterSaldo()
        );
    }
}

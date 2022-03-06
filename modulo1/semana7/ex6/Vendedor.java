package modulo1.semana7.ex6;

import modulo1.semana7.ex3.Empregado;

public class Vendedor extends Empregado {
    private double valorVendas;
    private double comissao;

    public Vendedor(
            String nome,
            String endereço,
            String telefone,
            int codigoSetor,
            int vencimentoBase,
            double salarioBase,
            double imposto
    ) {
        super(nome, endereço, telefone, codigoSetor, vencimentoBase, salarioBase, imposto);
    }

    @Override
    public double calcularSalario(){
        return  getSalarioBase()  + getComissao() -
                getSalarioBase()  * getImposto() / 100;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double porcentagem) {
        this.comissao = getValorVendas() * porcentagem / 100;
    }

    public static void main(String[] args) {
        Vendedor ze = new Vendedor(
                "ze",
                "rua dos bobos numero 0",
                "999445522",
                1,
                15,
                1000,
                10
        );

        ze.setValorVendas(10000);
        ze.setComissao(10);

        System.out.println(
                ze.getNome()       + "\n" +
                ze.getTelefone()   + "\n" +
                ze.getEndereço()   + "\n" +
                "Setor: "          + ze.getCodigoSetor()  + "\n" +
                "SalarioBase: "    + ze.getSalarioBase()  + "\n" +
                "Imposto: "        + ze.getImposto()      + "%\n"+
                "Valor vendido: "  + ze.getValorVendas()  + "\n" +
                "Comissao: "       + ze.getComissao()     + "\n" +
                "Salario: "        + ze.calcularSalario() + "\n"
        );
    }
}

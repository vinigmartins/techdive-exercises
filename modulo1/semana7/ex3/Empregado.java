package modulo1.semana7.ex3;

import modulo1.semana7.ex1.Pessoa;

public class Empregado extends Pessoa {
    private int    codigoSetor;
    private int    vencimentoBase;
    private double salarioBase;
    private double imposto;

    public Empregado(String nome, String endereço, String telefone, int codigoSetor, int vencimentoBase, double salarioBase, double imposto) {
        super(nome, endereço, telefone);
        this.codigoSetor    = codigoSetor;
        this.vencimentoBase = vencimentoBase;
        this.salarioBase    = salarioBase;
        this.imposto        = imposto;
    }

    public double calcularSalario(){
        return salarioBase - salarioBase * imposto / 100;
    }

    public int getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(int codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public int getVencimentoBase() {
        return vencimentoBase;
    }

    public void setVencimentoBase(int vencimentoBase) {
        this.vencimentoBase = vencimentoBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public static void main(String[] args) {
        Empregado ze = new Empregado(
                "ze",
                "rua dos bobos numero 0",
                "999445522",
                1,
                15,
                1000,
                10
        );

        System.out.println(
                ze.getNome()     + "\n" +
                ze.getTelefone() + "\n" +
                ze.getEndereço() + "\n" +
                "Setor: "        + ze.getCodigoSetor()  + "\n" +
                "SalarioBase: "  + ze.getSalarioBase()  + "\n" +
                "Imposto: "      + ze.getImposto()      + "%\n"+
                "Salario: "      + ze.calcularSalario() + "\n"
        );
    }
}

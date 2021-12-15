package modulo1.semana7.ex4;

import modulo1.semana7.ex3.Empregado;

public class Administrador extends Empregado {
    private double ajudaDeCusto;

    public Administrador(
                String nome,
                String endereço,
                String telefone,
                int codigoSetor,
                int vencimentoBase,
                double salarioBase,
                double imposto,
                double ajudaDeCusto
    ) {
        super(nome, endereço, telefone, codigoSetor, vencimentoBase, salarioBase, imposto);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public double calcularSalario(){
        return  getSalarioBase()  + getAjudaDeCusto() -
                getSalarioBase()  * getImposto() / 100;
    }

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }

    public static void main(String[] args) {
        Administrador ze = new Administrador(
                "ze",
                "rua dos bobos numero 0",
                "999445522",
                1,
                15,
                1000,
                10,
                150
        );

        System.out.println(
                ze.getNome()      + "\n" +
                ze.getTelefone()  + "\n" +
                ze.getEndereço()  + "\n" +
                "Setor: "         + ze.getCodigoSetor()  + "\n" +
                "SalarioBase: "   + ze.getSalarioBase()  + "\n" +
                "Imposto: "       + ze.getImposto()      + "%\n"+
                "Ajuda de custo: "+ ze.getAjudaDeCusto() + "\n" +
                "Salario: "       + ze.calcularSalario() + "\n"
        );
    }
}

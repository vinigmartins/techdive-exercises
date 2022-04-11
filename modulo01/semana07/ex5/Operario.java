package modulo1.semana7.ex5;

import modulo1.semana7.ex3.Empregado;

public class Operario extends Empregado {
    private double valorProducao;
    private double comissao;

    public Operario(
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

    public double getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(double valorProducao) {
        this.valorProducao = valorProducao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double porcentagem) {
        this.comissao = getValorProducao() * porcentagem / 100;
    }

    public static void main(String[] args) {
        Operario ze = new Operario(
                "ze",
                "rua dos bobos numero 0",
                "999445522",
                1,
                15,
                1000,
                10
        );

        ze.setValorProducao(2000);
        ze.setComissao(10);

        System.out.println(
                ze.getNome()       + "\n" +
                ze.getTelefone()   + "\n" +
                ze.getEndereço()   + "\n" +
                "Setor: "          + ze.getCodigoSetor()  + "\n" +
                "SalarioBase: "    + ze.getSalarioBase()  + "\n" +
                "Imposto: "        + ze.getImposto()      + "%\n"+
                "Valor produzido: "+ ze.getValorProducao()+ "\n" +
                "Comissao: "       + ze.getComissao()     + "\n" +
                "Salario: "        + ze.calcularSalario() + "\n"
        );
    }
}

package modulo1.semana9.banco;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    List<Conta> contas = new ArrayList<>();

    void adiciona(Conta c) {
        contas.add(c);
    }
    int getQuantidadeDeContas(){
       return contas.size();
    }

    Conta buscaPorTitular(String nomeDoTitular) {
        for (Conta conta : contas) {
            if (conta.equals(nomeDoTitular)) return conta;
        }
        return null;
    }

    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        agencia.adiciona(new ContaCorrente("vinicius"));
        agencia.adiciona(new ContaPoupanca("Josué"));
        System.out.println(agencia.buscaPorTitular("vinicis"));
    }
}

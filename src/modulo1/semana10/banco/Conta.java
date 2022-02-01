package modulo1.semana10.banco;

import modulo1.semana10.banco.exceptions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta implements TextDataBase{
    private String cliente;
    private double saldo;
    private int numero;
    List<Transacao> transacoes = new ArrayList<>();

    public Conta(String cliente, double saldo, int numero) {
        this.cliente = cliente;
        this.saldo   = saldo;
        this.numero  = numero;
    }
    public Conta(String[] args) {
        this.cliente = args[0];
        this.saldo   = Double.parseDouble(args[1]);
        this.numero  = Integer.parseInt(args[2]);
    }

    public void sacar(double valor, boolean isTransferencia) throws SaldoInsuficienteException,
                                                            ValorDeSaqueNegativoException {
        if(valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: " + this.getSaldo());
        }
        if (valor <= 0) {
            throw new ValorDeSaqueNegativoException();
        }

        this.saldo -= valor;
        String operação;


        if (isTransferencia) {
            System.out.printf("Transferência de R$%.2f efetuada.%n", valor);
            operação = "Transferencia";
        }
        else {
            System.out.printf("Saque de R$%.2f efetuado.%n", valor);
            operação = "Saque";
        }

        System.out.printf("Novo saldo: R$%.2f%n", this.getSaldo());

        Transacao transacao = new Transacao(operação, -valor, LocalDateTime.now());
        transacao.update(this.numero);
        transacoes.add(transacao);
        update();
    }

    public void depositar(double valor, boolean isTransferencia) throws ValorDeDepositoNegativoException {
        if(valor <= 0) {
            throw new ValorDeDepositoNegativoException();
        }

        this.saldo += valor;
        String operação;

        if (isTransferencia) {
            System.out.printf("Transferência de R$%.2f recebida.%n", valor);
            operação = "Transferencia";
        }
        else {
            System.out.printf("Depósito de R$%.2f efetuado.%n", valor);
            operação = "Deposito";
        }

        System.out.printf("Novo saldo: R$%.2f%n", this.getSaldo());

        Transacao transacao = new Transacao(operação, valor, LocalDateTime.now());
        transacao.update(this.numero);
        transacoes.add(transacao);
        update();
    }

    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException,
                                                        ValorDeDepositoNegativoException,
                                                        ValorDeSaqueNegativoException,
                                                        TransferenciaMesmaContaException{
        if (this.equals(destino))
            throw new TransferenciaMesmaContaException();

        this.sacar(valor, true);
        destino.depositar(valor, true);
    }

    public void importTransacoes() {
        String caminhoDados = "src/modulo1/semana10/banco/database/transacoes/" + this.numero +".csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDados))) {
            br.lines().map(line -> new Transacao(line.split(";"))).forEach(transacao -> {
                transacoes.add(transacao);
            });

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        Path caminhoDados = Path.of("src/modulo1/semana10/banco/database/contas.csv");
        try{
            List<String> lines = Files.readAllLines(caminhoDados);

            int count = 0;  //Encontrar o index da conta
            for (String line : lines) {
                if (Integer.parseInt(line.split(";")[2]) == this.numero) break;
                count++;
            }

            lines.set(count, this.getCliente() + ';' + this.getSaldo() + ';' + this.getNumero());
            Files.write(caminhoDados, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void export() {
        try (PrintStream ps = new PrintStream(
                new FileOutputStream("src/modulo1/semana10/banco/database/contas.csv", true))) {
            ps.println(this.getCliente() + ';' + this.getSaldo() + ';' + this.getNumero());
            Transacao.create(this.numero); //cria o arquivo de transacoes
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "cliente='" + cliente + '\'' +
                ", saldo=" + saldo +
                ", numero da conta=" + numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Conta))
            return false;

        return ((Conta) obj).getNumero() == this.getNumero();
    }

    @Override
    public int hashCode() {
        return ((Integer) this.numero).hashCode();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}

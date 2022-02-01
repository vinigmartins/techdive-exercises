package modulo1.semana10.banco;

import modulo1.semana10.banco.exceptions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Banco {
    static Set<Conta> contas = new HashSet<>();

    static void adicionarConta(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o nome do cliente");
            String cliente = scanner.nextLine();

            System.out.println("Digite o saldo da conta");
            double saldo = scanner.nextDouble();

            System.out.println("Digite o numero da conta");
            int numero = scanner.nextInt();

            Conta conta = new Conta(cliente, saldo, numero);

            if (contas.contains(conta))
                throw new ContaJaCadastradaException("Numero da conta ja esta associado à uma conta");

            contas.add(conta);
            conta.export();
        } catch (InputMismatchException e) {
            System.out.println("O valor deve ser um numero");
        } catch (ContaJaCadastradaException e) {
            System.out.println(e.getMessage());
        }
    }

    static void sacar() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o numero da conta");
            int numero = scanner.nextInt();

            System.out.println("Digite o valor para sacar");
            double valor = scanner.nextDouble();

            contas.stream().filter(c -> c.getNumero() == numero)
                           .findAny()
                           .orElseThrow(ContaInexistenteException::new)
                           .sacar(valor, false);

        } catch (InputMismatchException e) {
            System.out.println("O valor deve ser um numero");
        } catch (ContaInexistenteException | SaldoInsuficienteException | ValorDeSaqueNegativoException e) {
            System.out.println(e.getMessage());
        }
    }

    static void depositar() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o numero da conta");
            int numero = scanner.nextInt();

            System.out.println("Digite o valor para depositar");
            double valor = scanner.nextDouble();

            contas.stream().filter(c -> c.getNumero() == numero)
                           .findAny()
                           .orElseThrow(ContaInexistenteException::new)
                           .depositar(valor, false);

        } catch (InputMismatchException e) {
            System.out.println("O valor deve ser um numero");
        } catch (ContaInexistenteException | ValorDeDepositoNegativoException e) {
            System.out.println(e.getMessage());
        }
    }

    static void transferir() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o numero da conta de origem");
            int numeroOrigem = scanner.nextInt();
            Conta origem = contas.stream()
                                 .filter(c -> c.getNumero() == numeroOrigem)
                                 .findAny()
                                 .orElseThrow(() -> new ContaInexistenteException("Conta de origem inexistente"));

            System.out.println("Digite o numero da conta de destino");
            int numeroDestino = scanner.nextInt();
            Conta destino = contas.stream()
                                  .filter(c -> c.getNumero() == numeroDestino)
                                  .findAny()
                                  .orElseThrow(() -> new ContaInexistenteException("Conta de destino inexistente"));

            System.out.println("Digite o valor para transferir");
            double valor = scanner.nextDouble();

            origem.transferir(destino, valor);

        } catch (InputMismatchException e) {
            System.out.println("O valor deve ser um numero");
        } catch (ContaInexistenteException    |
                SaldoInsuficienteException    |
                ValorDeSaqueNegativoException |
                TransferenciaMesmaContaException e) {
            System.out.println(e.getMessage());
        }
    }

    static void listarContas(){
        contas.forEach(System.out::println);
    }

    static void listarTransacoes() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o numero da conta");
            int numero = scanner.nextInt();

            contas.stream().filter(c -> c.getNumero() == numero)
                           .findAny()
                           .orElseThrow(ContaInexistenteException::new)
                           .getTransacoes()
                           .forEach(System.out::println);

        } catch (InputMismatchException e) {
            System.out.println("O valor deve ser um numero");
        } catch (ContaInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }

    static void importContas() {
        String path = "src/modulo1/semana10/banco/database/contas.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            br.lines().map(line -> new Conta(line.split(";"))).forEach(conta -> {
                contas.add(conta);
                conta.importTransacoes();
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        importContas();
        int opcao = 9;
        String menu = """
                                          
                0  Sair
                1  Adicionar conta
                2  Sacar
                3  Depositar
                4  Transferência
                5  Listar contas
                6  Listar transações da conta
                                            
                Opcao:""";

        System.out.println("Bem vindo ao Banco TechDive");

        try (Scanner sc = new Scanner(System.in)) {
            while (opcao != 0) {
                System.out.print(menu);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        adicionarConta();
                        break;
                    case 2:
                        sacar();
                        break;
                    case 3:
                        depositar();
                        break;
                    case 4:
                        transferir();
                        break;
                    case 5:
                        listarContas();
                        break;
                    case 6:
                        listarTransacoes();
                        break;
                    default:
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("O valor deve ser um numero");
        }
    }
}

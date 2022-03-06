package modulo1.semana8.jogo.main;

import modulo1.semana8.jogo.personagem.*;
import modulo1.semana8.jogo.personagem.inimigo.*;
import modulo1.semana8.jogo.util.Dialogo;

import java.util.ArrayList;
import java.util.Scanner;

public class BatalhaFinal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        String nome = "";
        char sexo = ' ';
        Jogador jogador = null;

        Dialogo.println(Dialogo.BOASVINDAS);

        Dialogo.println(Dialogo.PEDIRNOME);
        while (nome.isEmpty()) {
            nome = input.nextLine();
            if (nome.isEmpty()) Dialogo.println(Dialogo.NOMEVAZIO);
        }

        Dialogo.println(Dialogo.PEDIRSEXO);
        while (sexo != 'M' && sexo != 'F') {
            try {
                sexo = input.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException ignored) {
            }
            if (sexo != 'M' && sexo != 'F') Dialogo.println(Dialogo.SEXOINVALIDO);
        }

        //Pedir Classe
        while (opcao < 1 || opcao > 4) {
            try {
                Dialogo.println(Dialogo.PEDIRCLASSE);
                opcao = Integer.parseInt(input.nextLine());
                jogador = switch (opcao) {
                    case 1 -> new Arqueiro(nome, sexo);
                    case 2 -> new Paladino(nome, sexo);
                    case 3 -> new Guerreiro(nome, sexo);
                    case 4 -> new Mago(nome, sexo);
                    default -> throw new IllegalStateException("Opção invalida" + opcao);
                };
            } catch (IllegalStateException e) {
                Dialogo.println(Dialogo.CLASSEINVALIDA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        opcao = 0;

        //Pedir Arma
        while (opcao < 1 || opcao > 2) {
            Dialogo.println(Dialogo.PEDIRARMA);
            ArrayList<Arma> armasDisponiveis = new ArrayList<Arma>();
            int contador = 1;
            for (Arma arma : Arma.values()) {
                if (arma.getPortador() == jogador.getClass()) {
                    armasDisponiveis.add(arma);
                    System.out.println(contador++ + " - " + arma);
                }
            }
            try {
                opcao = Integer.parseInt(input.nextLine());
                jogador.setArma(armasDisponiveis.get(opcao - 1));
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Opção inexistente");
            }
        }
        opcao = 0;
        Dialogo.printlnDigitando(Dialogo.INTRODUCAO);

        while (opcao < 1 || opcao > 2) {
            Dialogo.println(Dialogo.PEDIRMOTIVACAO);
            try {
                opcao = Integer.parseInt(input.nextLine());
                jogador.setMotivacao(opcao == 1 ? Motivacao.VINGANCA : Motivacao.GLORIA);
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida");
            }
        }
        opcao = 0;

        if (jogador.getMotivacao() == Motivacao.VINGANCA)
            Dialogo.printlnDigitando(Dialogo.VINGANCA);
        else
            Dialogo.printlnDigitando(Dialogo.GLORIA);

        Dialogo.printlnDigitando(Dialogo.INICIO);

        while (opcao < 1 || opcao > 2) {
            Dialogo.println(Dialogo.DECISAOINICIAL);
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida");
            }
        }

        if (opcao == 2) {
            Dialogo.printlnDigitando(Dialogo.DESISTIR);
            System.exit(0);
        } else {
            Dialogo.printlnDigitando(Dialogo.EMFRENTE);
            opcao = 0;
        }

        while (opcao < 1 || opcao > 3) {
            Dialogo.println(Dialogo.PORTAINICIAL);
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida");
            } finally {
                if (opcao < 1 || opcao > 3) {
                    System.out.println("Opção invalida");
                }
            }
        }

        switch (opcao) {
            case 1:
                Dialogo.printlnDigitando(Dialogo.CONSEQUENCIAANDANDO);
                new Armadilha().atacar(jogador);
                break;
            case 2:
                Dialogo.printlnDigitando(Dialogo.CONSEQUENCIACORRENDO);
                break;
            case 3:
                Dialogo.printlnDigitando(Dialogo.CONSEQUENCIASALTANDO);
                break;
        }
        opcao = 0;

        Dialogo.printlnDigitando(Dialogo.SALAARMEIRO);

        combate(jogador, new Armeiro(), 2);

        Dialogo.printlnDigitando(Dialogo.DERROTOUARMEIRO);

        while (opcao < 1 || opcao > 2) {
            Dialogo.println(Dialogo.PEGARARMADURAS);
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida");
            }
        }

        if (opcao == 1) {
            Dialogo.printlnDigitando(Dialogo.PEGOUARMADURAS);
            jogador.setPontosDefesa(jogador.getPontosDefesa() + 5);
        } else {
            Dialogo.printlnDigitando(Dialogo.NAOPEGOUARMADURAS);
        }
        opcao = 0;

        Dialogo.printlnDigitando(Dialogo.SALAALQUIMISTA);

        combate(jogador, new Alquimista(), 2);

        Dialogo.printlnDigitando(Dialogo.DERROTOUALQUIMISTA);

        while (opcao < 1 || opcao > 2) {
            Dialogo.println(Dialogo.BEBERPOCAO);
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida");
            }
        }

        if (opcao == 1) {
            Dialogo.printlnDigitando(Dialogo.BEBEUPOCAO);
            jogador.setPontosSaude(Jogador.saudeMaxima);
        } else {
            Dialogo.printlnDigitando(Dialogo.NAOBEBEUPOCAO);
        }
        opcao = 0;

        Dialogo.printlnDigitando(Dialogo.SALALIDER);

        while (opcao < 1 || opcao > 2) {
            Dialogo.println(Dialogo.ESPERARLIDER);
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida");
            }
        }

        combate(jogador, new Lider(), opcao);

        if (jogador.getMotivacao() == Motivacao.GLORIA)
            Dialogo.printlnDigitando(Dialogo.VITORIAGLORIA);
        else
            Dialogo.printlnDigitando(Dialogo.VITORIAVINGANCA);

        Dialogo.printlnDigitando(Dialogo.FINAL);
    }

    private static void combate(Jogador jogador, Inimigo inimigo, int iniciativa) {
        Scanner input = new Scanner(System.in);
        boolean acabou = false;
        int opcao = 0;

        while (!acabou) {
            while (opcao < 1 || opcao > 2) {
                Dialogo.println(Dialogo.OPCAOCOMBATE);
                try {
                    opcao = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opção invalida");
                }
            }
            if (opcao == 2) {
                Dialogo.printlnDigitando(Dialogo.FUGIUCOMBATE);
                System.exit(0);
            } else if (iniciativa % 2 == 0) {
                inimigo.atacar(jogador);
                if (jogador.getPontosSaude() == 0) {
                    if (jogador.getMotivacao() == Motivacao.VINGANCA)
                        Dialogo.printlnDigitando(Dialogo.MORREUVINGANCA);
                    else if (jogador.getSexo() == 'M')
                        Dialogo.printlnDigitando(Dialogo.MORREUGLORIAMASCULINO);
                    else
                        Dialogo.printlnDigitando(Dialogo.MORREUGLORIAFEMININO);
                    System.exit(0);
                }
            } else {
                jogador.atacar(inimigo);
                if (inimigo.getPontosSaude() == 0) {
                    Dialogo.printlnDigitando(Dialogo.INIMIGOMORREU);
                    acabou = true;
                }
            }
            iniciativa++;
        }
    }
}

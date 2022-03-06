package modulo1.semana10.banco;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao implements TextDataBase{
    String operacao;
    double valor;
    LocalDateTime horario;

    public Transacao(String operacao, double valor, LocalDateTime horario) {
        this.operacao = operacao;
        this.valor    = valor;
        this.horario  = horario;
    }

    public Transacao(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.operacao = args[0];
        this.valor    = Double.parseDouble(args[1]);
        this.horario  = LocalDateTime.parse(args[2], formatter);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return  "operacao='" + operacao + '\'' +
                ", valor=" + valor +
                ", horario=" + horario.format(formatter);
    }

    @Override
    public void update(int numero) {
        String caminhoDados = "src/modulo1/semana10/banco/database/transacoes/" + numero +".csv";

        try (PrintStream ps = new PrintStream(
                new FileOutputStream(caminhoDados, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            ps.println(this.operacao + ';' + this.valor + ';' + this.horario.format(formatter));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void create(int numero) {
        String caminhoDados = "src/modulo1/semana10/banco/database/transacoes/" + numero +".csv";

        try (PrintStream ps = new PrintStream(
                new FileOutputStream(caminhoDados, true))) {
            ps.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

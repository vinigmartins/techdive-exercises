package modulo1.semana10.ex7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class CoutChar {
    public static void main(String[] args) {
        System.out.print("Digite o caminho do arquivo: ");

        try (Scanner sc = new Scanner(System.in);){
            try(Stream<String> stream = Files.lines(Paths.get("src/modulo1/semana10/ex7/" + sc.nextLine()))){
                System.out.print("Digite um caractere: ");
                char character = sc.next().charAt(0);
                Optional<String> concatenated = stream.map(s -> s.replaceAll("[^" + character +"]", ""))
                                                      .reduce(String::concat);

                System.out.println(concatenated.orElse("").length());
            } catch (NoSuchFileException e){
                System.out.println("caminho invalido");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

package modulo1.semana10.ex6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SizeFile {
    public static void main(String[] args) {
        Path path = Paths.get("src/modulo1/semana10/ex6/test.txt");
        try {
            double bytes = Files.size(path);
            System.out.println(bytes + " bytes");
            System.out.println(bytes/10e2 + " kilobytes");
            System.out.println(bytes/10e5 + " Megabytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

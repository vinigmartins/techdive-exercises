package modulo1.semana4.ex7;

import java.util.Scanner;

public class AvgCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] grades = new float[3];

        for (int i = 1; i <= 3 ; i++) {
            System.out.printf("Digite sua nota do semestre %d: ",i);
            grades[i - 1] = sc.nextFloat();
        }
        float average = (grades[0] + grades[1] + grades[2]) / 3;

        System.out.printf("%nSua média final é: %.2f", average);
    }
}

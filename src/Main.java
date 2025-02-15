import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Criba criba = new Criba();

        int vectorLength = getVectorLength(teclado);
        int[] vector = new int[vectorLength];

        System.out.println("\nVector inicial hasta :" + vectorLength);
        getVector(vector);

        vector = criba.generarPrimos(vectorLength);

        System.out.println("\nVector de primos hasta:" + vectorLength);
        getVector(vector);
    }

    public static int getVectorLength(Scanner teclado) {
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        return teclado.nextInt();
    }

    public static void getVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class Ratespiel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        int eingabe, zufallszahl;

        zufallszahl = rnd.nextInt(10) + 1;

        System.out.println("Raten Sie eine Zahl zwischen 1 und 10 (3 Versuche)");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Versuch " + i);
            eingabe = in.nextInt();
            if (eingabe == zufallszahl) {
                System.out.println("Richtig!\nSie haben das Spiel gewonnen");
                System.exit(0);
            } else {
                System.out.println("Falsch");
            }
        }
    }
}

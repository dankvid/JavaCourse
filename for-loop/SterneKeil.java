import java.util.Scanner;

public class SterneKeil {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "*";
        int eingabe, i;
        System.out.print("Eingabe Anfangszahl: ");
        eingabe = in.nextInt();
        while (eingabe > 0) {
            for (i = 0; i < eingabe; i++) {
                System.out.print(str);
            }
            System.out.println("");
            eingabe--;
        }
    }
}

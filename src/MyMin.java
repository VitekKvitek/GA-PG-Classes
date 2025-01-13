import java.util.Scanner;

public class MyMin {

    // vrati min
    public static int min(int x, int y) {
        return x < y ? x : x;
    }

    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int vysledek = min(a,b);
        System.out.println(vysledek);
    }
}

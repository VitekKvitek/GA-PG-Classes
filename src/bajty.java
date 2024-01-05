import java.util.ArrayList;
import java.util.Scanner;

public class bajty {
    public static ArrayList read_byte() {
        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList<>();

        String input = sc.nextLine();
        sc.close();
        String[] numbersAsString = input.split("\\s+");
        for (String str_number :
                numbersAsString) {
            int int_number = Integer.parseInt(str_number);
            list.add((byte)int_number);
        }
        return list;
    }

    private static void print_byte() {
        byte[] input = new byte[10];
        for (int i = 0; i < 10; i++) {
            input[i] = (byte) (i + 2);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println(read_byte());
    }
}
package tretak;

import java.util.ArrayList;

public class Trojkova {
    public static String convert(int a){
        String out = "";
        while (a > 0){
            int b = a % 3;
            a /= 3;
            out = b + out;

        }
        return out ;
    }

    public static void main(String[] args) {
        System.out.println(convert(255));
    }
}

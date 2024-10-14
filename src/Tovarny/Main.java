package Tovarny;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tovarna tovarna = new DobraTovarna();
        ArrayList<Jidlo> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Jidlo j = tovarna.vyrobJidlo("jogurt");
        arr.add(j);
        for(;;){
            String slovo = sc.next();
            if (slovo.equals("konec")){
                break;
            }
            arr.add(tovarna.vyrobJidlo(slovo));
        }
        int cena = 0;
        for (Jidlo jidlo : arr){
            cena += jidlo.dejCenu();
            System.out.println(j.getClass().getSimpleName());
        }
        System.out.println(j.getClass().getSimpleName());
        System.out.println(j.dejCenu());
        System.out.println(j.ingredience());



        BingChillingFactory redSun = new BingChillingFactory();

        Jidlo smakulada = redSun.vyrobJidlo("spekacek");
        System.out.println(smakulada.ingredience());
        System.out.println(smakulada.getNixIndex());

    }
}

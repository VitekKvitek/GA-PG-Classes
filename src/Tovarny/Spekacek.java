package Tovarny;

public class Spekacek implements Jidlo {
    public int dejCenu() {
        return 30;
    }

    public String ingredience() {
        return "veprove maso, hovezi maso, koreni";
    }

    @Override
    public int getNixIndex() {
        return 1;
    }
}

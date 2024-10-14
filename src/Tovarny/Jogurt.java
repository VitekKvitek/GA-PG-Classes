package Tovarny;

public class Jogurt implements Jidlo {
    public int dejCenu() {
        return 19;
    }

    public String ingredience() {
        return "mleko";
    }

    @Override
    public int getNixIndex() {
        return 3;
    }

}

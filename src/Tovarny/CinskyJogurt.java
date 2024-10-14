package Tovarny;

public class CinskyJogurt implements Jidlo{
    public int dejCenu() {
        return 4;
    }

    public String ingredience() {
        return "omitka, mleko";
    }

    @Override
    public int getNixIndex() {
        return 1;
    }
}

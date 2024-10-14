package Tovarny;

public class CinskySpekacek implements Jidlo{
    public int dejCenu() {
        return 3;
    }

    public String ingredience() {
        return "holinka, kureci, meloun";
    }

    @Override
    public int getNixIndex() {
        return 78;
    }
}

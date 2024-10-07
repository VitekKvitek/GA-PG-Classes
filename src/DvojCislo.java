import javax.swing.*;

public class DvojCislo {
    @Override
    public String toString() {
        return "DvojCislo{" +
                "prvni=" + prvni +
                ", druhy=" + druhy +
                '}';
    }

    public DvojCislo(int prvni, int druhy) {
        this.prvni = prvni;
        this.druhy = druhy;
    }

    public int getPrvni() {
        return prvni;
    }

    public int getDruhy() {
        return druhy;
    }

    private final int prvni;
    private final int druhy;

    public DvojCislo add(DvojCislo b){
        int added_prvni = prvni + b.getPrvni();
        int added_druhy = druhy + b.getDruhy();

        DvojCislo added = new DvojCislo(added_prvni, added_druhy);
        return added;
    }
    public DvojCislo mulitply(DvojCislo b){
        int multiplied_prvni = prvni * b.getPrvni() - druhy * b.getDruhy();
        int mulitplied_druhy = prvni * b.getDruhy() + druhy * b.getPrvni();

        DvojCislo multiplied = new DvojCislo(multiplied_prvni, mulitplied_druhy);
        return multiplied;
    }
}
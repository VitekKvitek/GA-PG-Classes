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

    private final int prvni;
    private final int druhy;

    public DvojCislo add(DvojCislo b){
        int added_prvni = prvni + b.prvni;
        int added_druhy = druhy + b.druhy;

        DvojCislo added = new DvojCislo(added_prvni, added_druhy);
        return added;
    }
    public DvojCislo mulitply(DvojCislo b){
        int multiplied_prvni = prvni * b.prvni - druhy * b.druhy;
        int mulitplied_druhy = prvni * b.druhy + druhy * b.prvni;

        DvojCislo multiplied = new DvojCislo(multiplied_prvni, mulitplied_druhy);
        return multiplied;
    }
}
class  Main{
    public static void main(String[] args) {
        DvojCislo a = new DvojCislo(1,1);
        DvojCislo b = new DvojCislo(68,68);

        System.out.println(a.add(b));
        System.out.println(a.mulitply(b));
    }
}
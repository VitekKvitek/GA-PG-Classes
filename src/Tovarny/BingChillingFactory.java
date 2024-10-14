package Tovarny;

public class BingChillingFactory implements Tovarna{
    public Jidlo vyrobJidlo(String jmenoJidla) {
        if (jmenoJidla == null) {
            return null;
        } else if (jmenoJidla.equals("spekacek")) {
            return new CinskySpekacek();
        } else if (jmenoJidla.equals("jogurt")) {
            return new Jogurt();
        } else {
            throw new IllegalArgumentException("Nezname jidlo.");
        }
    }
}

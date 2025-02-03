// Graf.java
import java.io.*;
import java.util.*;

public class Graf implements Serializable {
    private Map<String, Vrchol> vrcholy;

    public Graf() {
        vrcholy = new HashMap<>();
    }

    public Graf(String jmenoSouboru) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jmenoSouboru))) {
            Graf nactenyGraf = (Graf) ois.readObject();
            this.vrcholy = nactenyGraf.vrcholy;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Chyba při načítání grafu: " + e.getMessage());
            vrcholy = new HashMap<>();
        }
    }

    public Vrchol dejVrchol(String jmeno) {
        return vrcholy.computeIfAbsent(jmeno, k -> new Vrchol(k));
    }

    public void ulozGrafDoSouboru(String jmenoSouboru) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(jmenoSouboru))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Chyba při ukládání grafu: " + e.getMessage());
        }
    }
}
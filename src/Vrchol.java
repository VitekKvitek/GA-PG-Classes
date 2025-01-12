import java.io.Serializable;
import java.util.*;

public class Vrchol implements Serializable {
    private String jmeno;
    private Set<Vrchol> sousedi;

    Vrchol(String jmeno) {
        this.jmeno = jmeno;
        this.sousedi = new HashSet<>();
    }

    public void pridejSouseda(Vrchol v) {
        if (v != null && !jeSousedem(v)) {
            sousedi.add(v);
            // Přidáme hranu i v opačném směru pro neorientovaný graf
            v.sousedi.add(this);
        }
    }

    public boolean jeSousedem(Vrchol v) {
        return sousedi.contains(v);
    }

    public boolean existujeCestaDo(Vrchol v) {
        Set<Vrchol> navstivene = new HashSet<>();
        return existujeCestaDFS(v, navstivene);
    }

    private boolean existujeCestaDFS(Vrchol cil, Set<Vrchol> navstivene) {
        if (this == cil) return true;
        navstivene.add(this);

        for (Vrchol soused : sousedi) {
            if (!navstivene.contains(soused)) {
                if (soused.existujeCestaDFS(cil, navstivene)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vrchol vrchol = (Vrchol) o;
        return Objects.equals(jmeno, vrchol.jmeno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmeno);
    }
}
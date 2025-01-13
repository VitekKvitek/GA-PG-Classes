package Tovarny;

import org.junit.Test;

import static org.junit.Assert.*;
public class DobraTovarnaTest {

    @Test
    public void vyrobJidlo() {
        DobraTovarna t = new DobraTovarna();
        Jidlo j = t.vyrobJidlo("ofk");

        assertTrue(Spekacek.class.isInstance(j));

    }
    @Test
    public void vyrobJidlo2() {
        DobraTovarna t = new DobraTovarna();
        Jidlo j = t.vyrobJidlo("spekacek");

        assertTrue(Spekacek.class.isInstance(j));

    }
}
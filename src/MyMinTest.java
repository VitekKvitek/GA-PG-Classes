import org.junit.Test;

import static org.junit.Assert.assertEquals;
// oznaceni pro prekladac a ostanti lidi
// ze tahle meta nebude brzy fungovat
@Deprecated
public class MyMinTest {

    @Test
    public void nejmensiTest1() {
        int vysledek = MyMin.min(1,2);
        assertEquals(1, vysledek);
    }
    @Test
    public void nejmensiTest2() {
        int vysledek = MyMin.min(-1,-2);
        assertEquals(-2, vysledek);
    }
}
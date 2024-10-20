import java.util.Iterator;

public class MujRetezec implements Iterable <Character>{
    String str;
    @Override
    public Iterator<Character> iterator() {

        return new IteratorRetezec(this);
    }
}

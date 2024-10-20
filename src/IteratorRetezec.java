import java.util.Iterator;

public class IteratorRetezec implements Iterator<Character> {
    MujRetezec mujretezec;
    int i;

    public IteratorRetezec(MujRetezec mujretezec) {
        this.mujretezec = mujretezec;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Character next() {
        return mujretezec.str.charAt(i);
    }
}

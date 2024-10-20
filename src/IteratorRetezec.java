import java.util.Iterator;

public class IteratorRetezec implements Iterator<Character> {
    MujRetezec mujretezec;
    int i = -1;

    public IteratorRetezec(MujRetezec mujretezec) {
        this.mujretezec = mujretezec;
    }

    @Override
    public boolean hasNext() {

        if (i < mujretezec.str.length()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Character next() {
        i++;
        return mujretezec.str.charAt(i);

    }
}

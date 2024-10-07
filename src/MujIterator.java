import java.util.Iterator;

public class MujIterator implements Iterator<Integer> { // jaky typ to ma vracet
    int index = 0;
    Trojice trojice;
    public boolean hasNext(){
        return index < 3;
    }

    public MujIterator(Trojice trojice) {
        this.trojice = trojice;
    }

    public Integer next(){ // jaky typ to ma vracet
        switch (index++){
            case 0: return trojice.a;
            case 1: return trojice.b;
            default: return trojice.c;
        }
    }

}

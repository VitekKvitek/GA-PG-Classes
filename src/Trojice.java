import java.util.Iterator;
// implements Iterable je extra, nahrada za MujIterator
//musime mit metodu iterator
//ta vrati objekt co implementuje Iterator
public class Trojice implements Iterable<Integer> { // jaky typ to ma vracet

    int a, b, c;

    public Trojice(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // kdyz implemetns Iterable, musi mit tuhle funkci
    public Iterator<Integer> iterator() {
        //return new InterniIterator();

        return new Iterator<Integer>() {
            int index = 0;

            public boolean hasNext() {
                return index < 3;
            }

            public Integer next() { // jaky typ to ma vracet
                switch (index++) {
                    case 0:
                        return a;
                    case 1:
                        return b;
                    default:
                        return c;
                }
            }
        };
    }

    public static void main(String[] args) {
        Trojice t = new Trojice(3,5,7);

        // iterator je basically for each - je to zabudovane v Jave
        // dvojice
        // random note - 4 objekty iteratoru
        for (int x: t){
            for (int y: t){
                System.out.println(Integer.toString(x) + Integer.toString(y));
            }
        }
    }
}

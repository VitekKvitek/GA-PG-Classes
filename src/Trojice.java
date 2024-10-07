import java.util.Iterator;
// implements Iterable je extra, nahrada za MujIterator
//musime mit metodu iterator
//ta vrati objekt co implementuje Iterator
public class Trojice implements Iterable<Integer>{ // jaky typ to ma vracet
    int a,b,c;
    int index = 0;
    public boolean hasNext(){
        return index <= 2;
    }
    public int next(){
        switch (index++){
            case 0: return a;
            case 1: return b;
            default: return c;
        }
    }
    public Trojice(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // kdyz implemetns Iterable, musi mit tuhle funkci
    public MujIterator iterator(){
        return new MujIterator(this);
    }
    // nase fake custom funkce - takhle ne
    public MujIterator dejMiIteraotr(){
        return new MujIterator(this);
    }
    public static void main(String[] args) {
        Trojice t = new Trojice(3,5,7);
        MujIterator it = t.dejMiIteraotr();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        // nelze pres stejny iterator iterovat znova
        // musel by se vytvorit novy
        while (it.hasNext()){
            System.out.println(it.next());
        }
        // iterator je basically for each - je to zabudovane v Jave
        // dvojice
        for (int x: t){
            for (int y: t){
                System.out.println(Integer.toString(x) + Integer.toString(y));
            }
        }
    }
}

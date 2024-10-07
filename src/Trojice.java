
public class Trojice {
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

    public static void main(String[] args) {
        Trojice t = new Trojice(3,5,7);
    }
}

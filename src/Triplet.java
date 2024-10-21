//muze to byt jaka koliv trida co extenduje Comparable
public class Triplet <T extends Comparable<T>>{
    T par1;
    T par2;
    T par3;

    public Triplet(T par1, T par2, T par3) {
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "par1='" + par1 + '\'' +
                ", par2='" + par2 + '\'' +
                ", par3='" + par3 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Triplet<String> balls = new Triplet<>("n","i","x");
        Triplet<Integer> balls2 = new Triplet<>(4,2,0);

        System.out.println(balls);
        System.out.println(balls2);
    }
}

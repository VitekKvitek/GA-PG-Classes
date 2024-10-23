public class ZasobnikPole<T> implements Zasobnik<T>{
    // nenavidim pole v jave
    private T[] pole;
    @Override
    public void push(T prvek) {
        // nevim
        T [] nove_pole = (T[]) new Object[pole.length + 1];
        for (int i = 0; i < pole.length; i++) {
            nove_pole[i] = pole [i];
        }
        nove_pole[nove_pole.length] = prvek;
    }

    @Override
    public T pop() {
        T prvek = pole[pole.length];
        //nevim
        T [] nove_pole = (T[]) new Object[pole.length-1];;

        for (int i = 0; i < pole.length; i++) {
            nove_pole[i] = pole [i];
        }
        pole = nove_pole;

        return prvek;
    }

    @Override
    public boolean isEmpty() {
        return (pole.length > 0);
    }
}

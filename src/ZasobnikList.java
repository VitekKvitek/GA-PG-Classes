import java.util.ArrayList;

public class ZasobnikList<T> implements Zasobnik<T>{
    private ArrayList<T> list = new ArrayList<>();
    @Override
    public void push(T prvek) {
        list.add(prvek);
    }

    @Override
    public T pop() {

        T prvek = list.get(list.size());
        list.remove(list.size());

        return prvek;
    }

    @Override
    public boolean isEmpty() {
        return (list.size()>0);
    }
}

public interface Zasobnik<T> {
    void push(T prvek);
    T pop();
    boolean isEmpty();
}

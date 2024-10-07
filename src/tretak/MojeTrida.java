package tretak;

import java.lang.reflect.Method;

public class MojeTrida {
    public static void main(String[] args) {
        Object m = new MojeTrida();
        Class<?> cls = m.getClass();
        Class<?> predek = cls.getSuperclass();
        Class<?> prdek2 = predek.getSuperclass();
        for (Method metoda:
             cls.getMethods()) {
            System.out.println("metoda " + metoda.getName());
        }
        System.out.println("pocet metod" + cls.getMethods().length);

        System.out.println("Predek " + predek.getName());
        System.out.println("Jmeno " + cls.getName());
        System.out.println("Simple jmeno " + cls.getSimpleName());
        rodokmen(m);
    }
    public static Object rodokmen(Object o){
        Class<?> c = o.getClass();
        Class<?> predek = c.getSuperclass();
        if (predek != null){
            return rodokmen(o);
        }else {
        return o;
        }
    }
}

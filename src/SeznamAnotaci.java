import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SeznamAnotaci {
    public static void main(String[] args) {

        MyMinTest m = new MyMinTest();

        Class<?> cl = m.getClass(); // neurcity typ

        System.out.println(cl.getSimpleName());
        System.out.println(Arrays.toString(cl.getAnnotations()));

        Method[] allMehtods = cl.getMethods();
        Annotation[] allAnots = cl.getAnnotations();

        for (Method method : allMehtods){

            Annotation[] methodAnots = method.getAnnotations();
            System.out.println(method.getName()+ ": ");

            for (Annotation anot : methodAnots){
                System.out.println(" " + anot.annotationType().getSimpleName() + " ");
            }
        }

        System.out.println(allAnots.length);

    }
}

import java.util.HashMap;
// T tam je proto, ze chci mit multiton pro genericky oběkt
public class MujMultiton<T> {
    // private constructor - jde vyrobit jen jednou

    private MujMultiton(){}
    static HashMap<String, T> instances = new HashMap<>();

    public static T getInstance(String id){

        // kdyz tam neni, dam ho tam
        if (!instances.containsKey(id)){
            instances.put(id, new T(id)); // tady Lana troli, neco nefungi
        }
        // ziskam ho
        return instances.get(id);
    }

    public static void main(String[] args) {
        UserProfile user1 = MujMultiton<UserProfile>.getInstance("user123");
        UserProfile user2 = MujMultiton<UserProfile>.getInstance("user123");
        UserProfile user3 = MujMultiton<UserProfile>.getInstance("ofk");

        System.out.println(user1 == user2);
        System.out.println(user2 == user3);
    }

}

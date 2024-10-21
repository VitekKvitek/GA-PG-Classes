import java.util.HashMap;

public class UserProfile {
    static HashMap<String, UserProfile> profiles = new HashMap<>();


    private final String userId;
    private String jmeno;
    private String prijmeni;
    private String email;



    public UserProfile(String userId) {
        this.userId = userId;
        profiles.put(userId, this);
    }
public static UserProfile getInstance(String id){
    if (profiles.containsKey(id)){
        return profiles.get(id);
    }else{
        return new UserProfile(id);
    }
}
    public static void main(String[] args) {
        UserProfile user1 = UserProfile.getInstance("user123");
        UserProfile user2 = UserProfile.getInstance("user123");
        UserProfile user3 = UserProfile.getInstance("ofk");

        System.out.println(user1 == user2);
        System.out.println(user2 == user3);
    }
}
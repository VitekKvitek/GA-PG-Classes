public class Jedinacek {
    private static Jedinacek singletonInstance;
    private Jedinacek() { }
    int counter = 0;
    public static Jedinacek getInstance() {
        if (null == singletonInstance) {
            singletonInstance = new Jedinacek();
        }
        return singletonInstance;
    }
}

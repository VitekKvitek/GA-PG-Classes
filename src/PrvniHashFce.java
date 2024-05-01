public class PrvniHashFce {
    private static void  fromHashToMsg(int hash){
        String msg = "";
        int new_hash = 0;
        for (int i = 0;i <= 10000;i++){
            if (countHash(String.valueOf((char)i)) == 456)
            System.out.println((char)i);
        }
    }
    private static int countHash(String msg) {
        int x = 0;
        for (int i = 0; i < msg.length(); i++){
            char ch = msg.charAt(i);
            x += (int)ch;
        }
        return (x * (x+3)%1013);
    }
    public static void main(String[] args) {
        String msg = "Programovani 3";
        //System.out.println(fromHashToMsg(countHash(msg)));
        fromHashToMsg(countHash(msg));
    }

}

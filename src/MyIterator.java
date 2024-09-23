import java.util.ArrayList;

public class MyIterator {
    int cisla[] = {0,1,2,3,4,5,6,7,9,9};
    int index = 0 ;
    public boolean hasNext() {
        try {
            int pokus = cisla[index];
            return true;
        }catch (Exception e){
            return false;
        }
//        if (index > cisla.length - 1){
//            return false;
//        } else {
//            return true;
//        }
    };
    public int next() {
        int old_index = index;
        index ++;
        return cisla [old_index];
    };

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String >();
        arr.add("pondeli");
        arr.add("utery");
        arr.add("streda");
        arr.add("ctvrtek");
        arr.add("patek");

        MyIterator ofk = new MyIterator();
        for (int i = 0; i < 15; i++) {
            System.out.println(ofk.hasNext());
            System.out.println(ofk.next());
        }
    }
}
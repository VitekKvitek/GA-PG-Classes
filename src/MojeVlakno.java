public class MojeVlakno implements Runnable{

    public void run() {
        for(int i = 0; i<100; i++)
            System.out.println(i);
    }
    public static void main(String[] args) {
        Runnable v1 = new MojeVlakno();
        Thread t1 = new Thread(v1);

        //nemuze mit constructor
        // anonymni trida
        Runnable v2 = new Runnable(){
            public void run() {
                for(int i = 'a'; i<'z'; i++)
                    System.out.println((char)i);
            }
        };
        Thread t2 = new Thread(v2);
        // lambda expression
        Thread t3 = new Thread(()->{
            // Runnable ma jen jednu metodu
            //takze staci napsat jen telo metody
            {
                for(int i = -1; i>-100; i--)
                    System.out.println(i);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

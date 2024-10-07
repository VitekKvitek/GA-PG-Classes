import java.math.BigInteger;

public class UkolA {
    public void metodaA(int n) {
        BigInteger i = BigInteger.valueOf(n);

        while(i.compareTo(BigInteger.ONE) > 0) {
            if (i.isProbablePrime(1)) {
                UkolB b = new UkolB(n);
            }
            i = i.subtract(BigInteger.ONE);
        }

        /* sem muzete pridat svuj kod.
         * TODO: je potreba, aby se counter v jedinackovi zvetsil o jedna
         */
        Jedinacek j = Jedinacek.getInstance();
        j.counter +=1;
    }
}

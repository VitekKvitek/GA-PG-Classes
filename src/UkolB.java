public class UkolB {
    public UkolB(int n) {
        for(int i = n; i > 0; i = i/2) {
            metodaB(i);
        }
    }

    public void metodaB(int n) {
        if (n > 2) {
            metodaC();
        }
        /* sem muzete pridat svuj kod!
         * TODO: je potreba, aby se counter v jedinackovi zvetsil o jedna
         */
        Jedinacek j = Jedinacek.getInstance();
        j.counter +=1;

    }

    public void metodaC() {
        /* sem muzete pridat svuj kod!
         * TODO: je potreba, aby se counter v jedinackovi zvetsil o jedna
         */
        Jedinacek j = Jedinacek.getInstance();
        j.counter +=1;
    }
}

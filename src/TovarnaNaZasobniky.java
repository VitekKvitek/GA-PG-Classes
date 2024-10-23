public class TovarnaNaZasobniky<T> {

    public Zasobnik<T> vyrobZasobnik(String typ) {
        if (typ == "list"){
            return new ZasobnikList<T>();
        }else {
            return new ZasobnikPole<T>();
        }
    }

}

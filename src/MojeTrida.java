@Autor(jmeno = "Pepa z Depa")
public class MojeTrida {

    @Zpracuj
    public void metoda1() {
        System.out.println("Zpracovávám metodu 1");
    }

    @Zpracuj()
    public void metoda2() {
        System.out.println("Zpracovávám metodu 2");
    }

    public void metoda3() {
        System.out.println("Metoda 3 není označena anotací");
    }
}

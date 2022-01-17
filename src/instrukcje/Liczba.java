package instrukcje;

/**
 * Klasa reprezentująca instrukcję (wyrażenie) Liczba.
 * @author Adam Al-Hosam
 */
public class Liczba extends Wyrazenie implements CanBeReturned {
    /**
     * Atrybut wg specyfikacji
     */
    private final double wartosc;

    /**
     * Domyślny konstruktor.
     * @param wartosc : wartość liczbowa wyrażenia
     */
    public Liczba(double wartosc) {
        this.wartosc = wartosc;
    }

    /**
     * @return wartość liczbowa tego wyrażenia
     */
    @Override
    public double wykonaj() {
        return wartosc;
    }

    /**
     * @param indent_level stopień indentacji
     * @return napis reprezentujący liczbę
     */
    @Override
    public String toJava(int indent_level) {
        return indent(indent_level) + wartosc + "";
    }
}

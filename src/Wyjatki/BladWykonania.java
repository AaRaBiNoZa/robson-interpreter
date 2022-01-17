package Wyjatki;

/**
 * Klasa reprezentująca wyjątek "BladWykonania"
 * @author Adam Al-Hosam
 */
public class BladWykonania extends Exception {
    /**
     * Domyślny konstruktor, wywołuje odpowiedni konstruktor z nadklasy
     * @param tresc_wyjatku : treść jaką ma zawierać wyjątek
     */
    public BladWykonania(String tresc_wyjatku) {
        super("Błąd wykonania w instrukcji " + tresc_wyjatku);
    }
}

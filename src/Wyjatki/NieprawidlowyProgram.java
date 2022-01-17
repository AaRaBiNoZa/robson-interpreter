package Wyjatki;

/**
 * Klasa reprezentująca wyjątek "NieprawidłowyProgram"
 * @author Adam Al-Hosam
 */
public class NieprawidlowyProgram extends Exception{
    /**
     * Domyślny konstruktor, wywołuje odpowiedni konstruktor z nadklasy
     * @param tresc_wyjatku : treść jaką ma zawierać wyjątek
     */
    public NieprawidlowyProgram(String tresc_wyjatku) {
        super(tresc_wyjatku);
    }
}
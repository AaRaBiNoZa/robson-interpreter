package instrukcje.operacjearytmetyczne;

import Wyjatki.BladWykonania;
import instrukcje.Wyrazenie;

/**
 * Klasa reprezentująca Dzielenie.
 * @author Adam Al-Hosam
 */
public class Dzielenie extends OperacjaArytmetyczna {
    /**
     * Domyślny konstruktor dla klasy Dzielenie - tworzy obiekt reprezentujący
     * operację dzielenia z dwoma argumentami
     * @param argument1 : dzielna
     * @param argument2 : dzielnik
     */
    public Dzielenie(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }

    /**
     * @return symbol reprezentujący dzielenie
     */
    @Override
    public String symbol() {
        return "/";
    }

    /**
     * Wykonuje operację dzielenia. Zgłasza błąd wykonania, gdy wystąpi
     * dzielenie przez 0.
     * Nie obługuję np. braku któregoś z argumentów i innych niepoprawnych
     * (zwłaszcza nullowych) sytuacji, ponieważ specyfikacja zakłada programy
     * poprawne składniowo
     * @return wartość liczbową wyniku operacji
     * @throws BladWykonania gdy wystąpi dzielenie przez 0
     */
    @Override
    public double wykonaj() throws BladWykonania {
        double dzielnik = argument2().wykonaj();
        if (dzielnik == 0) {
            throw new BladWykonania("DZIELENIE PRZEZ 0");
        }
        else {
            return argument1().wykonaj() / dzielnik;
        }
    }
}

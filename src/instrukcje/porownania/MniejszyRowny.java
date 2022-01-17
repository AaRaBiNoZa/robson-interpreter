package instrukcje.porownania;

import Wyjatki.BladWykonania;
import instrukcje.Wyrazenie;

/**
 * Klasa reprezentująca porównanie "<=".
 * @author Adam Al-Hosam
 */
public class MniejszyRowny extends Porownanie {
    /**
     * Domyślny konstruktor dla klasy "<=" - tworzy obiekt reprezentujący
     * porównanie "<="  z dwoma argumentami
     * @param argument1 : wyraz pierwszy
     * @param argument2 : wyraz drugi
     */
    public MniejszyRowny(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }

    /**
     * @return symbol reprezentujący porównanie "<="
     */
    @Override
    public String symbol() {
        return "<=";
    }

    /**
     * Wykonuje porównanie "<=".
     * Nie obługuję np. braku któregoś z argumentów i innych niepoprawnych
     * (zwłaszcza nullowych) sytuacji, ponieważ specyfikacja zakłada programy
     * poprawne składniowo
     * @return wartość liczbową wyniku porównania "<="  (1 - true, 0 - false)
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi ten wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        if (argument1().wykonaj() <= argument2().wykonaj()) {
            return 1;
        }
        else {
            return 0;
        }
    }

}

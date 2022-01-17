package instrukcje.operacjearytmetyczne;

import Wyjatki.BladWykonania;
import instrukcje.Wyrazenie;

/**
 * Klasa reprezentująca Mnożenie.
 * @author Adam Al-Hosam
 */
public class Razy extends OperacjaArytmetyczna {
    /**
     * Domyślny konstruktor dla klasy Razy - tworzy obiekt reprezentujący
     * operację mnożenia z dwoma argumentami
     * @param argument1 : czynnik pierwszy
     * @param argument2 : czynnik drugi
     */
    public Razy(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }

    /**
     * @return symbol reprezentujący mnożenie
     */
    @Override
    public String symbol() {
        return "*";
    }

    /**
     * Wykonuje operację mnożenia.
     * Nie obługuję np. braku któregoś z argumentów i innych niepoprawnych
     * (zwłaszcza nullowych) sytuacji, ponieważ specyfikacja zakłada programy
     * poprawne składniowo
     * @return wartość liczbową wyniku operacji
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi ten wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        return argument1().wykonaj() * argument2().wykonaj();
    }

}

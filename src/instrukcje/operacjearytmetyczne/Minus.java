package instrukcje.operacjearytmetyczne;

import Wyjatki.BladWykonania;
import instrukcje.Wyrazenie;

/**
 * Klasa reprezentująca Odejmowanie.
 * @author Adam Al-Hosam
 */
public class Minus extends OperacjaArytmetyczna {
    /**
     * Domyślny konstruktor dla klasy Minus - tworzy obiekt reprezentujący
     * operację dzielenia z dwoma argumentami
     * @param argument1 : odjemna
     * @param argument2 : odjemnik
     */
    public Minus(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }

    /**
     * @return symbol reprezentujący odejmowanie
     */
    @Override
    public String symbol() {
        return "-";
    }

    /**
     * Wykonuje operację odejmowania.
     * Nie obługuję np. braku któregoś z argumentów i innych niepoprawnych
     * (zwłaszcza nullowych) sytuacji, ponieważ specyfikacja zakłada programy
     * poprawne składniowo
     * @return wartość liczbową wyniku operacji
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi ten wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        return argument1().wykonaj() - argument2().wykonaj();
    }


}

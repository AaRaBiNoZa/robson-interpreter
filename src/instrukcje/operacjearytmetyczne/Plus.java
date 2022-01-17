package instrukcje.operacjearytmetyczne;

import Wyjatki.BladWykonania;
import instrukcje.Wyrazenie;

/**
 * Klasa reprezentująca Dodawanie.
 * @author Adam Al-Hosam
 */
public class Plus extends OperacjaArytmetyczna {
    /**
     * Domyślny konstruktor dla klasy Plus - tworzy obiekt reprezentujący
     * operację dodawania z dwoma argumentami
     * @param argument1 : wyraz pierwszy
     * @param argument2 : wyraz drugi
     */
    public Plus(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }

    /**
     * @return symbol reprezentujący dodawanie
     */
    @Override
    public String symbol() {
        return "+";
    }

    /**
     * Wykonuje operację dodawania.
     * Nie obługuję np. braku któregoś z argumentów i innych niepoprawnych
     * (zwłaszcza nullowych) sytuacji, ponieważ specyfikacja zakłada programy
     * poprawne składniowo
     * @return wartość liczbową wyniku operacji
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi ten wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        return argument1().wykonaj() + argument2().wykonaj();
    }

}

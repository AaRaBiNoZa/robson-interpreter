package instrukcje.operacjelogiczne;

import Wyjatki.BladWykonania;
import instrukcje.Wyrazenie;

/**
 * Klasa reprezentująca operację logiczną and.
 * @author Adam Al-Hosam
 */
public class And extends OperacjaLogiczna {
    /**
     * Domyślny konstruktor dla klasy And - tworzy obiekt reprezentujący
     * operację logiczną and z dwoma argumentami
     * @param argument1 : wyraz pierwszy
     * @param argument2 : wyraz drugi
     */
    public And(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }

    /**
     * @return symbol reprezentujący operację and
     */
    @Override
    public String symbol() {
        return "&&";
    }

    /**
     * Wykonuje operację logiczną and.
     * Nie obługuję np. braku któregoś z argumentów i innych niepoprawnych
     * (zwłaszcza nullowych) sytuacji, ponieważ specyfikacja zakłada programy
     * poprawne składniowo
     * @return wartość liczbową wyniku operacji and  (1 - true, 0 - false)
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi ten wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        double wartosc_arg_1, wartosc_arg_2;
        wartosc_arg_1 = argument1().wykonaj();
        wartosc_arg_2 = argument2().wykonaj();
        if (wartosc_arg_1 == 0 || wartosc_arg_2 == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }


}

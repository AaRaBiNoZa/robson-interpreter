package instrukcje.operacjearytmetyczne;

import instrukcje.CanBeReturned;
import instrukcje.OperacjaDwuargumentowa;
import instrukcje.Wyrazenie;

/**
 * Klasa abstrakcyjna reprezentująca operację arytmetyczną (dodawanie, odejmowanie,
 * dzielenie, mnożenie). Służy tylko do zwiększenia czytelności struktury
 * programu.
 * @author Adam Al-Hosam
 */
public abstract class OperacjaArytmetyczna extends OperacjaDwuargumentowa {

    /**
     * Domyślny konstruktor, pobiera oba argumenty danej operacji
     * @param argument1 : pierwszy argument
     * @param argument2 : drugi argument
     */
    public OperacjaArytmetyczna(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }
}

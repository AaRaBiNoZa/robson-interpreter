package instrukcje.operacjelogiczne;

import instrukcje.CanBeReturned;
import instrukcje.OperacjaDwuargumentowa;
import instrukcje.Wyrazenie;

/**
 * Klasa abstrakcyjna reprezentująca operację logiczną (and, or).
 * Służy tylko do zwiększenia czytelności struktury programu.
 * @author Adam Al-Hosam
 */
public abstract class OperacjaLogiczna extends OperacjaDwuargumentowa {

    /**
     * Domyślny konstruktor, pobiera oba argumenty danej operacji
     * @param argument1 : pierwszy argument
     * @param argument2 : drugi argument
     */
    public OperacjaLogiczna(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }
}

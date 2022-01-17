package instrukcje.porownania;

import instrukcje.CanBeReturned;
import instrukcje.OperacjaDwuargumentowa;
import instrukcje.Wyrazenie;

/**
 * Klasa abstrakcyjna reprezentująca porównanie (<,<=,>,>=).
 * Służy tylko do zwiększenia czytelności struktury programu.
 * @author Adam Al-Hosam
 */
public abstract class Porownanie extends OperacjaDwuargumentowa {
    /**
     * Domyślny konstruktor, pobiera oba argumenty danej operacji
     * @param argument1 : pierwszy argument
     * @param argument2 : drugi argument
     */
    public Porownanie(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
    }
}

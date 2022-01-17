package instrukcje.operacjelogiczne;

import Wyjatki.BladWykonania;
import instrukcje.CanBeReturned;
import instrukcje.Wyrazenie;
// no bo not jest jedyny
/**
 * Klasa reprezentująca operację logiczną Not.
 * Nie jest podklasą żadnej innej bardziej ogólnej klasy, bo not
 * jest swego rodzaju unikalną operacją; ciężko sobie wyobrazić, żeby ktoś
 * nagle wymyślił kolejną operację logiczną jednoargumentową.
 * Korzysta z interfejsu CanBeReturned, ponieważ instrukcja not może być
 * wynikiem bloku.
 * @author Adam Al-Hosam
 */
public class Not extends Wyrazenie implements CanBeReturned {
    /**
     * argument do zanegowania
     */
    private final Wyrazenie argument;

    /**
     * Domyślny konstruktor dla klasy Not - tworzy obiekt reprezentujący
     * operację logiczną not z jej argumentem
     * @param argument : argument operacji not
     */
    public Not(Wyrazenie argument) {
        this.argument = argument;
    }

    /**
     * Wykonuje operację logiczną not.
     * Nie obługuję np. braku argumentu i innych niepoprawnych
     * (zwłaszcza nullowych) sytuacji, ponieważ specyfikacja zakłada programy
     * poprawne składniowo
     * @return wartość liczbową wyniku operacji
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi ten wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        if (argument.wykonaj() == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy. W zależności
     * od zadanego stopnia indentacji zwraca "*odpowiednia przerwa* wyrażenie"
     * @param indent_level : stopień indentacji
     * @return napis reprezentujący tę operację w formacie Javy
     */
    @Override
    public String toJava(int indent_level) {
        return indent(indent_level) + "!" + argument.toJava();
    }
}

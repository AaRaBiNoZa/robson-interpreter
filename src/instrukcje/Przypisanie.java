package instrukcje;

import Wyjatki.BladWykonania;
import robson.Robson;

/**
 * Klasa reprezentująca operację przypisania.
 * @author Adam Al-Hosam
 */
public class Przypisanie extends Wyrazenie {
    private final String nazwa;
    private final Wyrazenie wartosc;

    /**
     * Domyślny konstruktor.
     * @param nazwa : nazwa zmiennej do przypisania
     * @param wartosc : wyrażenie, do przypisania zmiennej
     */
    public Przypisanie(String nazwa, Wyrazenie wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    /**
     * Wykonanie operacji przypisania. Ze względu na ogólną logikę programu
     * zakładam, że zmienne są raczej liczbowe. (inaczej mogą się tworzyć
     * nieskończone rekurencje)
     * @return wartość zmiennej po przypisaniu
     * @throws BladWykonania gdy metoda wykonaj() na wartosc się nie powiedzie
     * (np. dzielenie przez 0)
     */
    @Override
    public double wykonaj() throws BladWykonania {
        double result = wartosc.wykonaj();
        Robson.zmienne.put(nazwa, new Liczba(result));
        return result;
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy. Sprawdza czy kiedyś
     * wcześniej podczas konwersji korzystała z danej zmiennej, jeśli tak,
     * to po prostu zwraca napis (z odpowiednią indentacją) w postaci
     * "nazwa = wartosc"
     * w przeciwnym wypadku (korzystam tu z założenia, że zmienne są liczbowe)
     * zwraca (z odpowiednią indentacją) "double nazwa = wartosc"
     * @param indent_level
     * @return
     */
    @Override
    public String toJava(int indent_level) {
        if (Robson.zmienneDoToJava.contains(nazwa)) {
            return indent(indent_level) + nazwa + " = " + wartosc.toJava() + ";";
        }
        else {
            Robson.zmienneDoToJava.add(nazwa);
            return  indent(indent_level) + "double " + nazwa + " = " + wartosc.toJava() + ";";
        }
    }
}

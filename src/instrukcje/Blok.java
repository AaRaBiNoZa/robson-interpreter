package instrukcje;

import Wyjatki.BladWykonania;

import java.util.List;

/**
 * Klasa reprezentująca blok instrukcji (wyrażeń).
 * @author Adam Al-Hosam
 */
public class Blok extends Wyrazenie {
    /**
     * Lista instrukcji - wg treści
     */
    private final List<Wyrazenie> instrukcje;

    /**
     * Domyślny konstruktor.
     * @param instrukcje : lista wyrażeń składających się na blok
     */
    public Blok(List<Wyrazenie> instrukcje) {
        this.instrukcje = instrukcje;
    }

    /**
     * Wywołuje metodę wykonaj() dla każdej instrukcji z listy instrukcje.
     * @return wynik wywołania wykonaj() na ostatniej instrukcji z listy lub
     * 0 jeśli blok jest pusty
     * @throws BladWykonania gdy metoda wykonaj() któregoś z elementów listy
     * się nie powiedzie i zgłosi ten wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        double wynik = 0;
        for (Wyrazenie wyr : instrukcje) {
            wynik = wyr.wykonaj();
        }
        return wynik;
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy.
     * Po kolei konkatenuje kolejne wywołania toJava() wyrażeń z listy
     * (odpowiednio sformatowanych)
     * Jeśli trafi na jakieś wyrażenie, które jest swego rodzaju "atomowym"
     * wyrażeniem, czyli nie może występować samodzielnie bez zagłębienia w
     * innej instrukcji, to dodaje słowo return i średnik na końcu.
     * @param indent_level : stopień indentacji
     * @return napis reprezentujący to wyrażenie w formacie Javy
     */
    @Override
    public String toJava(int indent_level) {
        StringBuilder wynik = new StringBuilder();
        for (Wyrazenie wyr : instrukcje) {
            if (wyr instanceof CanBeReturned) {
                wynik
                        .append(indent(indent_level))
                        .append("return ")
                        .append(wyr.toJava())
                        .append(";\n");
            }
            else {
                wynik.append(wyr.toJava(indent_level)).append("\n");
            }
        }
        return wynik.toString();
    }
}

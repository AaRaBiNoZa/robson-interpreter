package instrukcje;

import Wyjatki.BladWykonania;

/**
 * Klasa reprezentująca instrukcję (wyrażenie) While.
 * @author Adam Al-Hosam
 */
public class While extends Wyrazenie {
    /**
     * Atrybuty wg specyfikacji
     */
    private final Wyrazenie warunek, blok;

    /**
     * Domyślny konstruktor
     * @param warunek : warunek pętli
     * @param blok : blok, który wykonuje się, dopóki warunek daje true (!=0)
     */
    public While(Wyrazenie warunek, Wyrazenie blok) {
        this.warunek = warunek;
        this.blok = blok;
    }

    /**
     * Standardowa instrukcja while - dopóki warunek daje true - kontynuuję
     * wykonywanie instrukcji z bloku
     * @return 0 wg specyfikacji
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        while (warunek.wykonaj() == 1) {
            blok.wykonaj();
        }

        return 0;
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy.
     * Korzystam ze StringBuilder dla wygody zapisu
     * @param indent_level : stopień indentacji
     * @return napis reprezentujący to wyrażenie w formacie Javy
     */
    @Override
    public String toJava(int indent_level) {
        String external_indent = indent(indent_level);
        StringBuilder wynik = new StringBuilder();
        wynik
                .append(external_indent)
                .append("while (")
                .append(warunek.toJava())
                .append(") {\n")
                .append(blok.toJava(indent_level + 1))
                .append(external_indent)
                .append("}\n");
        return  wynik.toString();
    }

}

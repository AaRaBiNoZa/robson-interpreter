package instrukcje;


import Wyjatki.BladWykonania;
/**
 * Klasa reprezentująca instrukcję (wyrażenie) If.
 * @author Adam Al-Hosam
 */
public class If extends Wyrazenie {
    /**
     * Atrybuty wg specyfikacji
     */
    private final Wyrazenie warunek, blok_prawda, blok_falsz;

    /**
     * Domyślny konstruktor
     * @param warunek : warunek logiczny
     * @param blok_prawda : blok, który wykona się jeśli warunek da true
     * @param blok_falsz : blok, który wykona się, jeśli warunek da false
     *                   (opcjonalny)
     */
    public If(Wyrazenie warunek, Wyrazenie blok_prawda, Wyrazenie blok_falsz) {
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_falsz = blok_falsz;
    }

    /**
     * W zależności od wyniku operacji wykonaj, na wyrażeniu w warunek,
     * zwraca wartość wynikową wykonaj() na blok_prawda lub blok_falsz (jeśli
     * blok_falsz nie istnieje, to zwraca 0 - wg forum)
     * @return wynik wywołania wykonaj() dla wyrażenia if
     * @throws BladWykonania gdy metoda wykonaj() któregoś z argumentów się
     * nie powiedzie i zgłosi wyjątek
     */
    @Override
    public double wykonaj() throws BladWykonania {
        if (warunek.wykonaj() == 1) {
            return blok_prawda.wykonaj();
        }
        else {
            if (blok_falsz == null) {
                return 0;
            }
            return blok_falsz.wykonaj();
        }
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy.
     * @param indent_level : stopień indentacji
     * @return napis reprezentujący to wyrażenie w formacie Javy
     */
    @Override
    public String toJava(int indent_level) {
        String external_indent = indent(indent_level);
        StringBuilder wynik = new StringBuilder();
        wynik
                .append(external_indent)
                .append("if (")
                .append(warunek.toJava())
                .append(") {\n")
                .append(blok_prawda.toJava(indent_level + 1))
                .append("\n")
                .append(external_indent)
                .append("}\n");
                if (blok_falsz != null) {
                wynik
                        .append(external_indent)
                        .append("else {\n")
                        .append(blok_falsz.toJava(indent_level + 1))
                        .append("\n")
                        .append(external_indent)
                        .append("}\n");

                }
        return wynik.toString();
    }

}

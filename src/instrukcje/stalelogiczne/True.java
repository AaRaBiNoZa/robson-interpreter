package instrukcje.stalelogiczne;

/**
 * Klasa reprezentująca stałą logiczną true.
 * @author Adam Al-Hosam
 */
public class True extends StalaLogiczna {
    /**
     * Zwraca wartość true (1)
     * @return 1
     */
    @Override
    public double wykonaj() {
        return 1;
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy. W zależności
     * od zadanego stopnia indentacji zwraca "*odpowiednia przerwa* true"
     * @param indent_level : stopień indentacji
     * @return napis reprezentujący tę stałą w formacie Javy
     */
    @Override
    public String toJava(int indent_level) {
        return indent(indent_level) + "true";
    }
}

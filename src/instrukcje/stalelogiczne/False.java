package instrukcje.stalelogiczne;

/**
 * Klasa reprezentująca stałą logiczną false.
 * @author Adam Al-Hosam
 */
public class False extends StalaLogiczna {
    /**
     * Zwraca wartość false (0)
     * @return 0
     */
    @Override
    public double wykonaj() {
        return 0;
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy. W zależności
     * od zadanego stopnia indentacji zwraca "*odpowiednia przerwa* false"
     * @param indent_level : stopień indentacji
     * @return napis reprezentujący tę stałą w formacie Javy
     */
    @Override
    public String toJava(int indent_level) {
        return indent(indent_level) + "false";
    }
}

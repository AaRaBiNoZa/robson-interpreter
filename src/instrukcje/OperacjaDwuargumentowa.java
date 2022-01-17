package instrukcje;

/**
 * Klasa abstrakcyjna, po której dziedziczą wszystkie operacje dwuargumentowe.
 * (może być wynikiem - zwrócona przez return)
 */
public abstract class OperacjaDwuargumentowa
        extends Wyrazenie
        implements CanBeReturned {
    /**
     * Wolałem zadeklarować argument1 i argument2 jako private i dodać
     * gettery, ale to kwestia preferencji, możnaby zadeklarować je jako np
     * protected
     */
    private final Wyrazenie argument1, argument2;

    /**
     * Domyślny konstruktor tworzy obiekt reprezentujący operację
     * dwuargumentową
     * @param argument1 : argument pierwszy
     * @param argument2 : argument drugi
     */
    public OperacjaDwuargumentowa(Wyrazenie argument1, Wyrazenie argument2) {
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    /**
     * Wymaganie, żeby każda podklasa miała swój "identyfikator"; potrzebny
     * do toJava.
     * @return symbol wyrażenia
     */
    public abstract String symbol();

    /**
     * Ogólna implementacja toJava dla każdego wyrażenia dwuargumentowego
     * @param indent_level : stopień indentacji; zagłębienia
     * @return napis reprezentujący daną operację w formacie Java
     */
    @Override
    public String toJava(int indent_level) {
        return indent(indent_level) + "(" + argument1.toJava() + " " + symbol() + " " + argument2.toJava() + ")";
    }

    public Wyrazenie argument1() {
        return argument1;
    }

    public Wyrazenie argument2() {
        return argument2;
    }

}

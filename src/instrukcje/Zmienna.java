package instrukcje;

import Wyjatki.BladWykonania;

import static robson.Robson.zmienne;

/**
 * Klasa reprezentująca wyrażenie Zmienna.
 * @author Adam Al-Hosam
 */
public class Zmienna extends Wyrazenie implements CanBeReturned {
    /**
     * Atrybuty wg specyfikacji
     */
    private final String nazwa;

    /**
     * Domyślny konstruktor.
     * @param nazwa : nazwa zmiennej
     */
    public Zmienna(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Ma obliczyć wartość zmiennej. Jeśli zmienna pojawia się pierwszy raz, to
     * dodaje jej nazwę z wartością 0 do mapy stale z klasy Robson.
     * W przeciwnym wypadku pobiera z mapy wartość pod kluczem nazwa
     * @return wartość zmiennej (0 jeśli zmienna nie istnieje)
     * @throws BladWykonania jeśli operacja .wykonaj() się nie powiedzie
     * (aktualnie nie do końca ma to sens, skoro to zmienne liczbowe mają sens,
     * ale zawarłem tu dla ewentualnych zmian/rozszerzeń)
     */
    @Override
    public double wykonaj() throws BladWykonania {
        if (zmienne.containsKey(nazwa)) {
            return zmienne.get(nazwa).wykonaj();
        }
        else {
            zmienne.put(nazwa, new Liczba(0));
            return 0; // zeby nie marnowac czasu biorac z mapy
        }
    }

    /**
     * Metoda do konwersji tego wyrażenia do formatu Javy
     * @param indent_level : stopień indentacji
     * @return napis reprezentujący to wyrażenie w formacie Javy
     */
    @Override
    public String toJava(int indent_level) {
        return indent(indent_level) + nazwa;
    }
}

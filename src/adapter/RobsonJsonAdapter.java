package adapter;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import instrukcje.*;
import instrukcje.operacjearytmetyczne.Dzielenie;
import instrukcje.operacjearytmetyczne.Minus;
import instrukcje.operacjearytmetyczne.Plus;
import instrukcje.operacjearytmetyczne.Razy;
import instrukcje.operacjelogiczne.And;
import instrukcje.operacjelogiczne.Not;
import instrukcje.operacjelogiczne.Or;
import instrukcje.porownania.*;
import instrukcje.stalelogiczne.False;
import instrukcje.stalelogiczne.True;

/**
 * Klasa, która reprezentuje adapter JSON, pasujący do specyfikacji zadania
 * ROBSON przy użyciu biblioteki Moshi.
 * Jest to klasa abstrakcyjna z klasowymi atrybutami - wyjaśnienie:
 * - dobra dla struktury projektu - oddzielenie kawałku kodu, który ma tylko
 * jeden cel
 * - adapter będzie tylko i wyłącznie jeden, stąd widoczność publiczna oraz
 * "static", absolutnie nie będą potrzebne żadne obiekty z tej klasy
 * - final zapewnia jakiś poziom bezpieczeństwa
 * @author Adam Al-Hosam
 */
public abstract class RobsonJsonAdapter {
    /**
     * Specyfikacja struktury projektu do stworzenia adaptera.
     * Pozwala na umieszczenie w formacie JSON dodatkowego pola "typ", które
     * będzie odpowiadało za odpowiednią podklasę klasy Wyrażenie
     */
    public static final Moshi customMoshi = new Moshi.Builder()
            .add (
                    PolymorphicJsonAdapterFactory
                            .of(Wyrazenie.class, "typ")
                            .withSubtype(Dzielenie.class, "Dzielenie")
                            .withSubtype(Minus.class, "Minus")
                            .withSubtype(Razy.class, "Razy")
                            .withSubtype(Plus.class, "Plus")
                            .withSubtype(And.class, "And")
                            .withSubtype(Or.class, "Or")
                            .withSubtype(Not.class, "Not")
                            .withSubtype(JestRowne.class, "==")
                            .withSubtype(Mniejszy.class, "<")
                            .withSubtype(MniejszyRowny.class, "<=")
                            .withSubtype(Wiekszy.class, ">")
                            .withSubtype(WiekszyRowny.class, ">=")
                            .withSubtype(False.class, "False")
                            .withSubtype(True.class, "True")
                            .withSubtype(Blok.class, "Blok")
                            .withSubtype(If.class, "If")
                            .withSubtype(Liczba.class, "Liczba")
                            .withSubtype(Przypisanie.class, "Przypisanie")
                            .withSubtype(While.class, "While")
                            .withSubtype(Zmienna.class, "Zmienna")
            )
            .build();
    /**
     * Adapter właściwy, stworzony na podstawie zdefiniowanej wcześniej
     * struktury projektu.
     */
    public static final JsonAdapter<Wyrazenie> customJsonAdapter = customMoshi
            .adapter(Wyrazenie.class);
}

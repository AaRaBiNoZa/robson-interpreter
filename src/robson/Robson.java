package robson;

import Wyjatki.BladWykonania;
import Wyjatki.NieprawidlowyProgram;
import adapter.RobsonJsonAdapter;
import instrukcje.Wyrazenie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Główna klasa drugiego programu zaliczeniowego - ROBSON
 * @author Adam Al-Hosam
 */
public class Robson {
    /**
     * Mapa zawierająca pary klucz-wartość odpowiadające zmiennym w programie.
     * public static - tłumaczenie:
     * Jest w specyfikacji zadania wyraźnie napisane, że są dostępne zmienne
     * globalne - oczywiście mógłbym w metodzie wykonaj() klasy wyrażenie
     * przekazywać jako argument referencję do tej mapy, ale wprowadziłoby to
     * niepotrzebne "zamieszanie" to implementacji, użytkownik byłby zmuszony
     * każdorazowo przekazywać referencję do mapy, co nie jest wyygodne ani
     * intuicyjne.
     * Ponadto mapa ta jest każdorazowo "czyszczona" przed i po każdym wykonaniu
     * programu, co zapewnia w jakiś sposób bezpieczeństwo, że ma się "kontrolę"
     * nad zawartością.
     * Ostatecznie znacząco upraszcza logikę programu.
     * Uznałem ŚWIADOMIE, że te powody są wystarczające do skorzystania z public static.
     */
    public static Hashtable<String, Wyrazenie> zmienne;

    /**
     * Lista napisów reprezentujących zmienne pojawiające się w programie (na
     * potrzeby metody toJava - ułatwiają one rozpoznanie czy zmienna jest
     * deklarowana, czy już wystąpiła w programie.
     * public static - tłumaczenie:
     * Mógłbym oczywiście, podobnie jak w przypadku mapy zmienne, przekazywać
     * referencję do tego atrybutu bezpośrednio w każdym wywołaniu toJava,
     * ale wprowadziłoby to niepotrzebne zamieszanie do kodu. Podobnie jak w
     * wymienionej wyżej metodzie użytkownik byłby zmuszony
     * każdorazowo przekazywać referencję do tej listy, co nie jest ani
     * wyygodne ani intuicyjne.
     * Dodatkowo lista jest każdorazowo "czyszczona" przed i po każdym wywołaniu
     * toJava, zatem zapewnia to pewny stopień bezpieczeństwa co do zawartości.
     * Ostatecznie, podobnie jak uprzednio, takie rozwiązanie upraszcza logikę
     * programu.
     * Uznałem ŚWIADOMIE takie powody, za wystarczające uzasadnienie.
     */
    public static Collection<String> zmienneDoToJava;

    /**
     * Wyrażenie, pod którym będzie zapisany program
     */
    private Wyrazenie program;

    /**
     * Domyślny konstruktor.
     */
    public Robson() {
        zmienne = new Hashtable<>();
        program = null;
        zmienneDoToJava = new ArrayList<>();
    }

    /**
     * Typowy setter dla atrybutu program
     * @param program : program do przypisania
     */
    public void setProgram(Wyrazenie program) {
        this.program = program;
    }

    /**
     * Metoda ze specyfikacji, wczytuje do zmiennej json zawartość pliku o
     * ścieżce filename. (jeśli to się nie powiedzie, to zgłasza wyjątek
     * FileNotFoundException)
     * Następnie ustawia atrybut program na wczytane poprzez RobsonJsonAdapter
     * wyrażenie (jeśli to się nie powiedzie, zgłasza IOException)
     * @param filename : nazwa lub ścieżka do pliku
     * @throws NieprawidlowyProgram : *na potrzeby przyszłych rozszerzeń*
     * zgłoszony zostałby jeśli zawartość pliku miałaby nieprawidłową składnię
     */
    public void fromJSON(String filename) throws NieprawidlowyProgram {
        String json;
        try {
            json = new Scanner(new File(filename)).useDelimiter("\\Z").next();
            setProgram(RobsonJsonAdapter.customJsonAdapter.fromJson(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda ze specyfikacji, najpierw do zmiennej result zapisuje wynik
     * przekształcenia wyrażenia pod zmienną program w format JSON
     * (.indent("  ") zapewnia ładne formatowanie tekstu)
     * Następnie w bloku try/catch próbuje zapisać wynik do pliku o ścieżce
     * filename - jeśli plik nie istnieje, stworzy go, jeśli istnieje, nadpisze
     * go, ale jeśli ścieżka jest niepoprawna (np. katalog, który nie istnieje)
     * zgłosi wyjątek
     * @param filename : ścieżka do pliku
     */
    public void toJSON(String filename) {
        String result = RobsonJsonAdapter.customJsonAdapter
                .indent("  ")
                .toJson(program);
        try {
            Files.writeString(Path.of(filename),result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metoda ze specyfikacji, tworzy napis, który reprezentuje wyrażenie
     * pod zmienną program, ale w formacie kompilującego się programu .java.
     * Następnie próbuje go zapisać pod plik o ścieżce filename - jeśli plik
     * nie istnieje, stworzy go, jeśli istnieje, nadpisze go, ale jeśli ścieżka
     * jest niepoprawna (np. katalog, który nie istnieje), zgłosi wyjątek.
     * Przed i po wygenerowaniu napisu usuwa zawartość  zmienneDoToJava, dla
     * zapewnienia bezpieczeństwa.
     * @param filename : ścieżka do pliku
     */
    public void toJava(String filename) {
        zmienneDoToJava.clear();
        StringBuilder javaCode = new StringBuilder();
        javaCode
                .append("public class Program {\n")
                .append("\n")
                .append("    public double wykonaj() {\n")
                .append(program.toJava(2))
                .append("    }\n\n")
                .append("    public static void main(String [] args) {\n")
                .append("        Program robson = new Program();\n")
                .append("        System.out.println(robson.wykonaj());\n")
                .append("    }\n")
                .append("}");
        try {
            Files.writeString(Path.of(filename),javaCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            zmienneDoToJava.clear();
        }
    }

    /**
     * Wykonuje metodę wykonaj() na wczytanym programie.
     * Przed i po wszystkim czyści mapę zmienne dla bezpieczeństwa
     * @return wynik programu
     * @throws BladWykonania gdy metoda wykonaj() się nie powiedzie
     */
    public double wykonaj() throws BladWykonania {
        zmienne.clear();
        double wynik = program.wykonaj();
        zmienne.clear();

        return wynik;
    }
}

package instrukcje;

import Wyjatki.BladWykonania;

/**
 * Główna klasa abstrakcyjna, po której dziedziczy każdy rodzaj wyrażenia.
 */
public abstract class Wyrazenie {
    /**
     * Wymóg implementacji "wykonaj"
     * @return wartość danego wyrażenia
     * @throws BladWykonania gdy metoda wykonaj() się nie powiedzie
     */
    public abstract double wykonaj() throws BladWykonania;

    /**
     * Metoda właściwie pomocnicza, służy do kontrolowania odstępów w programie
     * @param indent_level : stopień odstępu
     * @return ilość spacji w zależności od stopnia (jeden stopień to 4 spacje)
     */
    public String indent(int indent_level) {
        return new String(new char[indent_level * 4]).replace("\0"," ");
    }

    /**
     * Wymóg implementacji w podklasach.
     * Ma zwrócić napis reprezentujący dane wyrażenie w formacie Javy.
     * @param indent_level : stopień odstępu
     * @return napis reprezentujący to wyrażenie w formacie Javy z odpowiednim
     * odstępem.
     */
    public abstract String toJava(int indent_level);

    /**
     * Korzystam z method overload, żeby uprościć zapis gdy stopień = 0;
     * @return napis reprezentujący to wyrażenie w formacie Javy bez odstępu.
     */
    public String toJava() {
        return toJava(0);
    }
}

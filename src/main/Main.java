package main;

import Wyjatki.BladWykonania;
import Wyjatki.NieprawidlowyProgram;
import robson.Robson;

public class Main {

    public static void main(String[] args) {
	// przykłady użycia wymaganych funkcji
        Robson test = new Robson();
        try {
            test.fromJSON("src/euklides.txt");
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            System.out.println(test.wykonaj());
        } catch (BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
        test.toJSON("src/wynik.txt");
        test.toJava("Program.java");
    }

}

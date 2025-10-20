package at.itkolleg.Singleton.liveexample;

/**
 * 1. Stellt sicher, dass von einer Klasse nur eine Instanz erzeugt werden kann.
 *      (Geht nicht mit normalem Konstruktor, stattdessen statische Methode)
 * 2. Globaler Zugriffspunkt auf diese eine Instanz der Klasse
 *      (Über die statische getInstance-Methode)
 */
public class Singleton {

    private static Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        if (instance == null) {
            instance = new Singleton(data);
        }
        return instance;
    }
}

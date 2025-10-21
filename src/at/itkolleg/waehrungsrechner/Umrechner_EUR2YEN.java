package at.itkolleg.waehrungsrechner;

/**
 * Rechnet EUR in YEN um unter Verwendung der Template Method in der abstrakten
 * Superklasse WR.
 *
 * Concrete Component im Sinne des Decorator patterns
 */
public class Umrechner_EUR2YEN extends WR {
    // Builder pattern
    protected double faktor = 177.395; // Default-Wert

    public Umrechner_EUR2YEN() {super();}

    public Umrechner_EUR2YEN(IUmrechnen nextUmrechner) { super(nextUmrechner); }

    @Override
    public double getFaktor() {
        return this.faktor; // ein Euro entspricht 177.395 japanischen Yen
    }

    @Override
    public boolean zustaendig(String variante) {
        return variante.equals("YEN");
    }
}

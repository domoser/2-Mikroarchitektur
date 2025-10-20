package at.itkolleg.waehrungsrechner;

/**
 * Rechnet EUR in USD um unter Verwendung der Template Method in der abstrakten
 * Superklasse WR.
 *
 * Concrete Component im Sinne des Decorator patterns
 */
public class Umrechner_EUR2USD extends WR {

    public Umrechner_EUR2USD() {
        super(null);
    }

    public Umrechner_EUR2USD(IUmrechnen nextUmrechner) {
        super(nextUmrechner);
    }

    @Override
    public double getFaktor() {
        return 1.16; // ein Euro entspricht 1.16 US-Dollar
    }

    @Override
    public boolean zustaendig(String variante) {
        return variante.equals("USD");
    }
}

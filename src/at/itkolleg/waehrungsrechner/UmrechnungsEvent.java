package at.itkolleg.waehrungsrechner;

/**
 * OBSERVER
 */
public class UmrechnungsEvent {
    public final double betrag;
    public final String zielwaehrung;
    public final double ergebnis;
    public final String quelle = "EUR"; // fix laut Aufgabenstellung
    public final long timestamp;

    public UmrechnungsEvent(double betrag, String zielwaehrung, double ergebnis) {
        this.betrag = betrag;
        this.zielwaehrung = zielwaehrung;
        this.ergebnis = ergebnis;
        this.timestamp = System.currentTimeMillis();
    }
}

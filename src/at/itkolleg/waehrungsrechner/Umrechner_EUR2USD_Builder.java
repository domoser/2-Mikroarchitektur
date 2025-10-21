package at.itkolleg.waehrungsrechner;

/**
 * Der Builder ermöglicht es den Umrechnungsfaktor sowie das nächste Kettenglied in der Chain of Responsibility
 * zu setzen.
 *
 * Er enthält alle Datenfelder, die für einen Umrechner relevant sind,
 * also den Umrechnungsfaktor und den nächsten Umrechner in der Kette.
 *
 */
public class Umrechner_EUR2USD_Builder {
    private double faktor = 1.16;
    private IUmrechnen nextUmrechner = null;

    /**
     * Setzt den Umrechnungsfaktor auf den Parameter faktor.
     * @param faktor Umrechnungsfaktor für Umrechner
     * @return das Builder-Objekt im aktuellen Zustand
     */
    public Umrechner_EUR2USD_Builder setFaktor(double faktor) {
        this.faktor = faktor;
        return this;
    }

    /**
     * Setzt den Umrechnungsfaktor auf den Parameter faktor.
     * @param nextUmrechner der nachfolgende Umrechner in der Chain of Responsibility
     * @return das Builder-Objekt im aktuellen Zustand
     */
    public Umrechner_EUR2USD_Builder setNextUmrechner(IUmrechnen nextUmrechner) {
        this.nextUmrechner = nextUmrechner;
        return this;
    }

    /**
     * Erzeugt einen neuen EUR2USD Umrechner mit den im aktuellen Objekt befindlichen Daten
     * und gibt eine Referenz auf dieses Objekt zurück.
     * @return Umrechner_EUR2USD-Objekt
     */
    public Umrechner_EUR2USD build() {
        Umrechner_EUR2USD umrechner = new Umrechner_EUR2USD();
        umrechner.setFaktor(faktor);
        umrechner.setNextUmrechner(nextUmrechner);
        return umrechner;
    }
}

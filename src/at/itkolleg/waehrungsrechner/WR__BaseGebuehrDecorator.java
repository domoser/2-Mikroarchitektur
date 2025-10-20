package at.itkolleg.waehrungsrechner;

public abstract class WR__BaseGebuehrDecorator extends WR {

    private IUmrechnen nextDecoratedUmrechner;
    protected double gebuehr;

    public WR__BaseGebuehrDecorator(IUmrechnen nextDecoratedUmrechner, IUmrechnen nextUmrechner) {
        super(nextUmrechner); // nextUmrechner im Sinne des Chain of responsibility patterns
        this.nextDecoratedUmrechner = nextDecoratedUmrechner;
    }


    @Override
    public double umrechnen(String variante, double betrag) {
        double betragMitGebuehr = berechneBetragMitGebuehr(betrag);
        // Lass den nächsten Decorator evtl. weiter dekorieren
        // oder gib den Betrag mit Gebühren weiter an den nächsten konkreten Umrechner
        return this.nextDecoratedUmrechner.umrechnen(variante, betragMitGebuehr); // Decorator pattern
    }

    /**
     * Je nach konkretem GebuehrDecorator wird die Gebuehr z.B. relativ oder absolut zum Betrag ermittelt.
     * @param betrag auf Basis dessen Umrechen-Gebuehr ermittelt werden soll
     * @return Summe des Betrags und der ermittelten Gebuehr
     */
    protected abstract double berechneBetragMitGebuehr(double betrag);

    /**
     * Der Dekorator gibt die Aufgabe des zu bestimmenden Faktors an den nächsten konkreten Umrechner weiter.
     * @return Faktor des nächsten konkreten Umrechners
     */
    @Override
    public double getFaktor() {
        return this.nextDecoratedUmrechner.getFaktor();
    }

    /**
     * Der Dekorator gibt die Bestimmung der Zuständigkeit an den nächsten konkreten Umrechner weiter.
     * @return Faktor des nächsten konkreten Umrechners
     */
    @Override
    public boolean zustaendig(String variante) {
        return this.nextDecoratedUmrechner.zustaendig(variante);
    }
}

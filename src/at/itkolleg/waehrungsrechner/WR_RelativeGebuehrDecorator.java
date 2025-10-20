package at.itkolleg.waehrungsrechner;


public class WR_RelativeGebuehrDecorator extends WR__BaseGebuehrDecorator {
    private double gebuehr;

    /**
     * Erzeugt einen neuen Währungsrechner mit zusätzlichem relativen Gebühren-Aufschlag von
     * gebuehr %.
     * @param nextDecoratedUmrechner auf das Ergebnis der Umrechnung wird der Aufschlag prozentuell hinzugezählt
     * @param nextUmrechner nächster Umrechner im Sinne der Chain of responsibility
     * @param gebuehr Aufschlag in % für den Betrag, der umgerechnet wird.
     */
    public WR_RelativeGebuehrDecorator(IUmrechnen nextDecoratedUmrechner, IUmrechnen nextUmrechner, double gebuehr) {
        super(nextDecoratedUmrechner, nextUmrechner);
        this.gebuehr = gebuehr;
    }

    @Override
    protected double berechneBetragMitGebuehr(double betrag) {
        return betrag + betrag * this.gebuehr / 100;
    }
}

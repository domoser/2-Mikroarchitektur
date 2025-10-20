package at.itkolleg.waehrungsrechner;


public class WR_AbsoluteGebuehrDecorator extends WR__BaseGebuehrDecorator {
    /**
     * Erzeugt einen neuen Währungsrechner mit zusätzlichem absoluten Gebühren-Aufschlag von
     *
     * @param gebuehr
     * @param nextDecoratedUmrechner auf das Ergebnis der Umrechnung wird der Aufschlag absolut hinzugezählt
     * @param nextUmrechner nächster Umrechner im Sinne der Chain of responsibility
     * @param gebuehr   Aufschlag in EUR für den Betrag, der umgerechnet wird.
     */
    public WR_AbsoluteGebuehrDecorator(IUmrechnen nextDecoratedUmrechner, IUmrechnen nextUmrechner, double gebuehr) {
        super(nextDecoratedUmrechner, nextUmrechner);
        this.gebuehr = gebuehr;
    }

    @Override
    protected double berechneBetragMitGebuehr(double betrag) {
        return betrag + this.gebuehr;
    }
}

package at.itkolleg.waehrungsrechner;


public class WR_AbsoluteGebuehrDecorator extends WR__BaseGebuehrDecorator {
    /**
     * Erzeugt einen neuen Währungsrechner mit zusätzlichem absoluten Gebühren-Aufschlag von
     *
     * @param nextUmrechner nächster Umrechner im Sinne der Chain of responsibility
     * @param gebuehr   Aufschlag in EUR für den Betrag, der umgerechnet wird.
     */
    public WR_AbsoluteGebuehrDecorator(IUmrechnen nextUmrechner, double gebuehr) {
        super(nextUmrechner);
        this.gebuehr = gebuehr;
    }

    @Override
    protected double berechneBetragMitGebuehr(double betrag) {
        return betrag + this.gebuehr;
    }
}

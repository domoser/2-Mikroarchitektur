package at.itkolleg.waehrungsrechner;


public class WR_RelativeGebuehrDecorator extends WR__BaseGebuehrDecorator {
    private double gebuehr;

    /**
     * Erzeugt einen neuen Währungsrechner mit zusätzlichem relativen Gebühren-Aufschlag von
     * gebuehr %.
     * @param nextUmrechner nächster Umrechner im Sinne der Chain of responsibility
     * @param gebuehr Aufschlag in % für den Betrag, der umgerechnet wird.
     */
    public WR_RelativeGebuehrDecorator(IUmrechnen nextUmrechner, double gebuehr) {
        super(nextUmrechner);
        this.gebuehr = gebuehr;
    }

    @Override
    protected double berechneBetragMitGebuehr(double betrag) {
        return betrag + betrag * this.gebuehr / 100;
    }
}

package at.itkolleg.waehrungsrechner;

public abstract class WR implements IUmrechnen {

    // Chain of responsibility (nextHandler)
    protected IUmrechnen nextUmrechner;

    public WR(IUmrechnen nextUmrechner) {
        this.nextUmrechner = nextUmrechner;
    }

    /**
     * Verantwortlichkeitskette (Chain of responsibility)
     * Die Methode umrechnen implementiert die Ketten-Weiterleitung ("handle()").
     *
     * Template Method
     * Sie delegiert nur die für die jeweiligen Umrechner spezifischen Methoden (zustaendig(), faktor()).
     * Sogenannte Hook-Methoden der Unterklassen.
     * @param variante
     * @param betrag
     * @return
     */
    public double umrechnen(String variante, double betrag) {
        if(this.zustaendig(variante)) {
            return betrag * this.getFaktor();
        } else if (nextUmrechner != null) {
            return this.nextUmrechner.umrechnen(variante, betrag);
        } else {
            System.out.println("Das Umrechnen in die Währung \"" + variante + "\" ist nicht möglich!");
            return -1.0;
        }
    }
    /**
     * Setzt den nächsten Handler der Verantwortlichkeitskette.
     * Könnte man auch weglassen.
     * @param nextUmrechner
     */
    public void setNextUmrechner(IUmrechnen nextUmrechner) {
        this.nextUmrechner = nextUmrechner;
    }
}

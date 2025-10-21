package at.itkolleg.waehrungsrechner;

import java.util.ArrayList;
import java.util.List;

public abstract class WR implements IUmrechnen {

    // Chain of responsibility (nextHandler)
    protected IUmrechnen nextUmrechner;

    // Builder pattern
    protected double faktor;

    // Observer pattern
    private List<WR_Observer> observers = new ArrayList<>();

    public WR() {
        this.nextUmrechner = null;
    }

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
     * @return umgerechneter Betrag in neuer Währung je nach Variante
     */
    public double umrechnen(String variante, double betrag) {
        if (this.zustaendig(variante)) {
            double ergebnis = betrag * this.getFaktor();
            notifyObservers(betrag, variante, ergebnis); // Observer Pattern
            return ergebnis;
        } else if (nextUmrechner != null) {
            return this.nextUmrechner.umrechnen(variante, betrag);
        } else {
            //System.out.println("Das Umrechnen in die Währung \"" + variante + "\" ist nicht möglich!");
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

    /**
     * Ermöglicht das Setzen des Umrechnungsfaktors für den Builder Pattern.
     * @param faktor
     */
    public void setFaktor(double faktor) {
        this.faktor = faktor;
    }

    public void addObserver(WR_Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(WR_Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(double betrag, String variante, double ergebnis) {
        UmrechnungsEvent event = new UmrechnungsEvent(betrag, variante, ergebnis);
        for (WR_Observer observer : observers) {
            observer.update(event);
        }

    }


}

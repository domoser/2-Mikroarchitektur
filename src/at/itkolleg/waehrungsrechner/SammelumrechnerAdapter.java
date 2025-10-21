package at.itkolleg.waehrungsrechner;

public class SammelumrechnerAdapter implements ISammelumrechnung {

    private IUmrechnen umrechner;

    /**
     * Setzt den zu verwendenden Umrechner bzw. eine Kette von Umrechnern für die Sammelumrechnung.
     * @param umrechner
     */
    public SammelumrechnerAdapter(IUmrechnen umrechner) {
        this.umrechner = umrechner;
    }

    /**
     * Rechnet alle Beträge nach vorgegebener Variante um und gibt die Summe zurück.
     * @param betraege
     * @param variante
     * @return
     */
    public double sammelumrechnen(double[] betraege, String variante) {
        double summe = 0;
        for (double betrag : betraege) {
            double umgerechnet = this.umrechner.umrechnen(variante, betrag);
            if (umgerechnet > 0) {
                summe += umgerechnet;
            } else {
                System.out.println("Fehler beim Umrechnen des Betrags " + betrag);
            }
        }
        return summe;
    }
}

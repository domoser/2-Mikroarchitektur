package at.itkolleg.waehrungsrechner;

public class Main {

    public static void main(String[] args) {
        // Erzeugung der Chain of responsibility
        IUmrechnen umrechner = new Umrechner_EUR2YEN(new Umrechner_EUR2USD());

        double euro = 1;
        double yen = umrechner.umrechnen("YEN", euro);
        double usd = umrechner.umrechnen("USD", euro);
        double kuna = umrechner.umrechnen("KUNA", euro); // Rückgabewert von -1.0 ist ein Fehler!

        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA");


        System.out.println();

        euro += 5;
        yen = umrechner.umrechnen("YEN", euro);
        usd = umrechner.umrechnen("USD", euro);
        kuna = umrechner.umrechnen("KUNA", euro); // Rückgabewert von -1.0 ist ein Fehler!

        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA");
        euro -= 5;

        System.out.println();
        System.out.println("################################################");
        System.out.println();

        IUmrechnen umrechnerMitGebuehr = new WR_RelativeGebuehrDecorator(new WR_AbsoluteGebuehrDecorator(umrechner, null, 0.5), null, 2.0);
        // falsche Ergebnisse

        yen = umrechnerMitGebuehr.umrechnen("YEN", euro);
        usd = umrechnerMitGebuehr.umrechnen("USD", euro);
        kuna = umrechnerMitGebuehr.umrechnen("KUNA", euro);

        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA (inkl. Gebühren!)");

        IUmrechnen umrechner2 = new Umrechner_EUR2USD();
        IUmrechnen mitRelativerGebuehr = new WR_RelativeGebuehrDecorator(umrechner2, null, 0.5);
        IUmrechnen mitAbsoluterGebuehr = new WR_AbsoluteGebuehrDecorator(mitRelativerGebuehr, null, 5);

        System.out.println("Umrechner2: " + umrechner2.umrechnen("USD", 10)); // korrekt
        System.out.println("Umrechner2 mit relativer Gebühr: " + mitRelativerGebuehr.umrechnen("USD", 10)); // korrekt
        System.out.println("Umrechner2 mit absoluter Gebühr: " + mitAbsoluterGebuehr.umrechnen("USD", 10)); // (10+5)*1,005 * 1,16 statt wie gedacht (10*1,005 + 5) * 1,16

    }
}

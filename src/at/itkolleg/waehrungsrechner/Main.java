package at.itkolleg.waehrungsrechner;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("CHAIN OF RESPONSIBILITY (OHNE DECORATOR)");
        IUmrechnen umrechner = new Umrechner_EUR2YEN(new Umrechner_EUR2USD());

        double euro = 1;
        double yen = umrechner.umrechnen("YEN", euro);
        double usd = umrechner.umrechnen("USD", euro);
        double kuna = umrechner.umrechnen("KUNA", euro); // Rückgabewert von -1.0 ist ein Fehler!

        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA");

        euro += 5;
        yen = umrechner.umrechnen("YEN", euro);
        usd = umrechner.umrechnen("USD", euro);
        kuna = umrechner.umrechnen("KUNA", euro); // Rückgabewert von -1.0 ist ein Fehler!

        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA");
        euro -= 5;

        System.out.println("################################################");
        System.out.println("CHAIN OF RESPONSIBILITY (MIT REL-GEBÜHREN-DECORATOR)");
        double relGebuehr = 2.0;
        IUmrechnen umrechnerMitRelativerGebuehr = new WR_RelativeGebuehrDecorator(umrechner, relGebuehr);

        yen = umrechnerMitRelativerGebuehr.umrechnen("YEN", euro);
        usd = umrechnerMitRelativerGebuehr.umrechnen("USD", euro);
        kuna = umrechnerMitRelativerGebuehr.umrechnen("KUNA", euro);

        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA (inkl. relativen Gebühren von " + relGebuehr + "!)");
        System.out.println("Probe USD: " + (euro * (1+relGebuehr/100) * 1.16));

        System.out.println("################################################");
        System.out.println("CHAIN OF RESPONSIBILITY (MIT ABS-GEBÜHREN-DECORATOR)");
        double absGebuehr = 5.0;
        IUmrechnen umrechnerMitAbsoluterGebuehr = new WR_AbsoluteGebuehrDecorator(umrechner, absGebuehr);

        yen = umrechnerMitAbsoluterGebuehr.umrechnen("YEN", euro);
        usd = umrechnerMitAbsoluterGebuehr.umrechnen("USD", euro);
        kuna = umrechnerMitAbsoluterGebuehr.umrechnen("KUNA", euro);

        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA (inkl. absoluten Gebühren von " + absGebuehr + "!)");
        System.out.println("Probe USD: " + ((euro + absGebuehr) * 1.16));

        System.out.println("################################################");
        System.out.println("CHAIN OF RESPONSIBILITY (MIT ABS+REL-GEBÜHREN-DECORATOR)");

        IUmrechnen absRel = new WR_AbsoluteGebuehrDecorator(umrechnerMitRelativerGebuehr, absGebuehr);
        IUmrechnen relAbs = new WR_RelativeGebuehrDecorator(umrechnerMitAbsoluterGebuehr, relGebuehr);

        System.out.println("Absolute Gebühr: " + absGebuehr + ", Relative Gebühr: " + relGebuehr);
        System.out.println("AbsRel: " + euro + " EUR = " + absRel.umrechnen("USD", euro)); // korrekt
        System.out.println("Probe (zuerst abs, dann rel, dann umrechnen): " + ((euro+absGebuehr)*(1+relGebuehr/100) * 1.16) + " USD");
        System.out.println("RelAbs: " + euro + " EUR = " + relAbs.umrechnen("USD", euro)); // korrekt // (10+5)*1,005 * 1,16 statt wie gedacht (10*1,005 + 5) * 1,16
        System.out.println("Probe (zuerst rel, dann abs, dann umrechnen): " + (((euro*(1+relGebuehr/100))+absGebuehr) * 1.16) + " USD");

        System.out.println("Wichtig ist nur zuerst die Chain-of-Responsibility zu bauen und diese dann Schritt für Schritt zu dekorieren.");


        System.out.println("################################################");
        System.out.println("BUILDER PATTERN AM BEISPIEL EUR2USD");

        Umrechner_EUR2USD builder = new Umrechner_EUR2USD_Builder()
                .setFaktor(1.16)
                .setNextUmrechner(new Umrechner_EUR2YEN())
                .build();

        yen = builder.umrechnen("YEN", euro);
        usd = builder.umrechnen("USD", euro);
        kuna = builder.umrechnen("KUNA", euro);
        System.out.println(euro + " EUR = " + yen + " YEN = " + usd + " USD = " + kuna + " KUNA (mit Builder)");

        System.out.println("################################################");
        System.out.println("ADAPTER PATTERN");

        double[] betraege = { 1, 5, 10, 20, 30 };
        for (double betrag : betraege) {
            System.out.print(betrag + " ");
        }
        System.out.println();

        ISammelumrechnung sammelAdapter = new SammelumrechnerAdapter(umrechner);
        double gesamtUSD = sammelAdapter.sammelumrechnen(betraege, "USD");
        double gesamtYEN = sammelAdapter.sammelumrechnen(betraege, "YEN");

        System.out.println("Gesamtsumme in USD: " + gesamtUSD);
        System.out.println("Gesamtsumme in YEN: " + gesamtYEN);

        sammelAdapter = new SammelumrechnerAdapter(absRel);
        gesamtUSD = sammelAdapter.sammelumrechnen(betraege, "USD");
        gesamtYEN = sammelAdapter.sammelumrechnen(betraege, "YEN");

        System.out.println("Absolute Gebühr: " + absGebuehr + ", Relative Gebühr: " + relGebuehr);
        System.out.println("Gesamtsumme in USD: " + gesamtUSD);
        System.out.println("Gesamtsumme in YEN: " + gesamtYEN);

        System.out.println("################################################");
        System.out.println("OBSERVER PATTERN");

        Umrechner_EUR2USD umrechner1 = new Umrechner_EUR2USD();

        umrechner1.addObserver(new LogObserver());

        double result = umrechner1.umrechnen("USD", euro);
        System.out.println(euro + " EUR = " + result + " USD");
    }
}

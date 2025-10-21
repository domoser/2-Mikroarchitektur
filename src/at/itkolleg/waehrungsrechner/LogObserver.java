package at.itkolleg.waehrungsrechner;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogObserver implements WR_Observer {
    private final String logDateiPfad = "waehrungsrechner.log";

    @Override
    public void update(UmrechnungsEvent event) {
        System.err.println("Log wird geschrieben...");
        String zeit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(event.timestamp));
        String eintrag = String.format("[%s] %f %s → %f %s\n", zeit, event.betrag, event.quelle, event.ergebnis, event.zielwaehrung);
        try (FileWriter writer = new FileWriter(logDateiPfad, true)) {
            writer.write(eintrag);
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben ins Log: " + e.getMessage());
        }
    }
}

package at.itkolleg.einarbeitung.ChainOfResponsibility1;

/**
 * Konkreter Handler
 */
public class Level2Support extends SupportHandler {
    @Override
    public void handleRequest(int difficulty) {
        if (difficulty <= 2) {
            System.out.println("Level 2 Support bearbeitet Anfrage mit Schwierigkeit " + difficulty);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(difficulty);
        } else {
            System.out.println("Keine Bearbeiung möglich für Schwierigkeit " + difficulty);
        }
    }
}

package at.itkolleg.einarbeitung.ChainOfResponsibility1;

public class SupportSystem {
    public static void main(String[] args) {
        SupportHandler level1Support = new Level1Support();
        SupportHandler level2Support = new Level2Support();

        level1Support.setNextHandler(level2Support);

        level1Support.handleRequest(1); // Level 1 bearbeitet
        level1Support.handleRequest(2); // Level 2 bearbeitet
        level1Support.handleRequest(3); // Keine Bearbeitung möglich
    }
}

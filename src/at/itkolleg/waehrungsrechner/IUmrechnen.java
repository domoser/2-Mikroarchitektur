package at.itkolleg.waehrungsrechner;

/**
 * Interface für die Chain of responsibility
 * Component des Decorator Patterns
 */
public interface IUmrechnen {
    double umrechnen(String variante, double betrag);
    double getFaktor();
    boolean zustaendig(String variante);
}

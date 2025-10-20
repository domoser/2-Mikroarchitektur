package at.itkolleg.Decorator_Notifications;

/** DECORATOR PATTERN
 *
 * Gehört zu den strukturellen Entwurfsmustern.
 *
 * Kann bestehenden Objekten zusätzliche Verhaltensweisen hinzufügen, indem man diese
 * Objekte in einen speziellen Wrapper kapselt, der dieses Verhalten implementiert.
 * Dabei muss die Struktur des ursprünglichen Objekts nicht verändert werden.
 *
 * Statt Vererbung wird beim Decorator Pattern auf Komposition gesetzt.
 * Das hat viele Vorteile hinsichtlich Flexibilität, insbesondere während der Laufzeit.
 * Man kann schnell Objekte austauschen, da sie alle dasselbe Interface (hier INotifier)
 * implementieren. Man kann also während der Laufzeit das Verhalten von Objekten ändern.
 *
 * DESIGN PRINCIPLES
 * -> SINGLE RESPONSIBILITY PRINCIPLE
 * -> OPEN-CLOSED-PRINCIPLE
 *
 * Wenn man statt nur per Mail benachrichtigt zu werden auch per WhatsApp oder Facebook
 * benachrichtigen möchte, könnte man zwei Subklassen erstellen. Will man beide Dienste
 * parallel bedienen, müsste man eine weitere Kombi-Subklasse erstellen. Das skaliert
 * sehr schlecht.
 * Besser ist ein Interface zu erstellen, das mehrere Decorator-Klassen implementieren.
 * Diese sind dann während der Laufzeit flexibel austauschbar und beliebig miteinander
 * kombinierbar.

 */
public class Main {
    public static void main(String[] args) {
        INotifier notifier = new FacebookDecorator(
                new WhatsAppDecorator(
                        new Notifier("Testitest")
                )
        );
        notifier.send("\"Eine Nachricht...\"");

        INotifier a = new Notifier("Testitest");
        INotifier b = new FacebookDecorator(a);
        INotifier c = new WhatsAppDecorator(b);
        INotifier d = new BaseNotifierDecorator(c);
        d.send("\"Testnachricht\"");
    }
}

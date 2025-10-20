package at.itkolleg.Decorator_Notifications;

/**
 * Component Interface
 */

public interface INotifier {
    void send(String message);
    String getUsername();
}

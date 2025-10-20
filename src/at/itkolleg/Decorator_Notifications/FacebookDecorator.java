package at.itkolleg.Decorator_Notifications;

public class FacebookDecorator extends BaseNotifierDecorator {
    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message);
        String fbName = databaseService.getFBNameFromUsername(getUsername());
        System.out.println("Sending " + message + " by Facebook on " + fbName);
    }
}

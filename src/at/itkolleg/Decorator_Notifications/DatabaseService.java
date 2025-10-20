package at.itkolleg.Decorator_Notifications;

public class DatabaseService {
    public String getMailFromUsername(String username) {
        return username + "@tsn.at";
    }

    public String getPhoneNbrFromUsername(String username) {
        return username + "+43 123456" + username.length();
    }

    public String getFBNameFromUsername(String username) {
        return username + "@Facebook";
    }
}

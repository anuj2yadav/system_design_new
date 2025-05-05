package movieBooking;

public class User {
    private final long userId;
    private final String userName;
    private final String email;

    public User(long userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }
}

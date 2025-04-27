package TaskManagement;

public class User {
    public  String id;

    public User(String id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public String userName;
    public String email;

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }
}

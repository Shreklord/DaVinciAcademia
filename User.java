import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(UUID id, String username, String password, String firstName, String lastName) {
        this.setUUID(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void setUUID(UUID id) {
        // it is my professional opinion that we will not be setting
        // the UUID outside of the contructor hence the function is private
        this.id = id;
    }

    public UUID getID() {
        return this.id;
    }

    public String getUsername() {
        return this.password;
    }

    public String getfirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}

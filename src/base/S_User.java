package base;

import java.time.LocalDateTime;
import java.util.Objects;

public class S_User implements User {
    protected String username;
    protected String password;
    protected boolean online_status;
    protected LocalDateTime last_access;

    public S_User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setOnline() {
        this.online_status = true;
    }

    public void setOffline() {
        this.online_status = false;
    }

    public void changePassword(Server s, String password) throws NullPointerException {
        Objects.requireNonNull(s);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean getOnline_status() {
        return online_status;
    }

    public LocalDateTime getLast_access() {
        return last_access;
    }

    public boolean checkPassword(String password) {
        return this.password.compareTo(password) == 0;
    }

    public int compareUsernames(String username) {
        return this.username.compareTo(username);
    }

    @Override
    public int compareTo(User u) {
        return this.username.compareTo(u.getUsername());
    }
}

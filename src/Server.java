import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Server {
    private String host_address;
    private int port;
    private ArrayList<S_User> users;
    private ArrayList<Chat> chats;
    public User create_user(String username, String password)
    {
        S_User new_user = new S_User( username, password);
        if (!users.contains(new_user))
        {
            users.add(new_user);
            new_user.setOnline();
            return new_user;
        }
        return null;
    }
    public User login(String username, String password)
    {
    }
    public void logout(String username)
    {
    }

    private class S_User implements User {
        protected String username;
        protected String password;
        protected boolean online_status;
        protected LocalDateTime last_access;
        public S_User(String username, String password)
        {
            this.username = username;
            this.password = password;
        }
        public void setOnline()
        {
            this.online_status = true;
        }
        public void setOffline()
        {
            this.online_status = false;
        }
        public void changePassword(Server s, String password) throws NullPointerException
        {
            Objects.requireNonNull(s);
            this.password = password;
        }
        public String getUsername() { return username; }
        public boolean getOnline_status() { return online_status; }
        public LocalDateTime getLast_access() { return last_access; }
        public boolean checkPassword(String password) { return this.password.compareTo(password) == 0; }
        @Override
        public int compareTo(User u)
        {
            return this.username.compareTo(u.getUsername());
        }
    }
}

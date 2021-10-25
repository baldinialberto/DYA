package base;

import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Server {
    private String host_address;
    private int port;
    private UserArrayList users;
    private ArrayList<GenericChat> chats;
    private ServerSocket server_socket;


    public Server() {
    }


    public User create_user(String username, String password) {
        S_User new_user = new S_User(username, password);
        if (!users.contains(new_user)) {
            users.add(new_user);
            new_user.setOnline();
            return new_user;
        }
        return null;
    }

    public User login(String username, String password) {
        if (!users.contains(username)) {
            System.out.println("username not registered");
            return null;
        } else {
            S_User u = users.get(username);
            Objects.requireNonNull(u).setOnline();
            return u;
        }
    }

    public void logout(String username) {
        if (!users.contains(username)) {
            System.out.println("username not registered");
        } else {
            Objects.requireNonNull(users.get(username)).setOffline();
        }
    }

    private class S_User implements User {
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

    private class UserArrayList extends ArrayList<S_User> {
        public boolean contains(String username) {
            for (S_User u : this) {
                if (u.compareUsernames(username) == 0) {
                    return true;
                }
            }
            return false;
        }

        public S_User get(String username) {
            for (S_User u : this) {
                if (u.compareUsernames(username) == 0) {
                    return u;
                }
            }
            return null;
        }
    }
}

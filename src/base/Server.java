package base;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javafx.concurrent.Task;

public class Server {
    private String host_address;
    private int port;
    private UserArrayList users;
    private ArrayList<GenericChat> chats;
    private ServerSocket server_socket;
    private boolean isAlive;
    private final Executor ThreadPoolEx = Executors.newCachedThreadPool();

    public Server() {
        this.isAlive = true;
        ThreadPoolEx.execute(new ServerListener(this));
    }

    private class ServerListener implements Runnable {
        private final Server server;
        public ServerListener(Server server) {
            this.server = server;
        }

        @Override
        public void run() {
            while (server.isAlive)
            {
                try {
                    Socket s = server.server_socket.accept();
                    server.ThreadPoolEx.execute(new ServerWorker(this.server, s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ServerWorker implements Runnable {

        private final Server server;
        private final Socket socket;
        public ServerWorker(Server server, Socket socket)
        {
            this.server = server;
            this.socket = socket;
        }
        @Override
        public void run() {
            while (server.isAlive && !this.socket.isClosed())
            {
                server.serve_client(socket);
            }
        }
    }

    private void serve_client(Socket client)
    {

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

}

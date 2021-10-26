package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
    private String host_address;
    private int port;
    private UserArrayList users;
    private ArrayList<GenericChat> chats;
    private ServerSocket server_socket;
    private boolean isAlive;
    private final Executor ThreadPoolEx = Executors.newCachedThreadPool();

    public Server() {
        try {
            server_socket = new ServerSocket(8080);
            this.isAlive = true;
            ThreadPoolEx.execute(new ServerListener(this));
            System.out.println(
                    "Server class initialized\n" +
                            "server address : " +
                            InetAddress.getLocalHost().getHostAddress() +
                            " at port : " +
                            server_socket.getLocalPort()
            );
        } catch (Exception e) {
            this.isAlive = false;
            e.printStackTrace();
        }

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
                    System.out.println( s.getInetAddress().getHostAddress() + " connected");
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
        BufferedReader b_reader;
        BufferedWriter b_writer;
        public ServerWorker(Server server, Socket socket)
        {
            this.server = server;
            this.socket = socket;
            try {
                b_reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                b_writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            String received;
            while (server.isAlive && !this.socket.isClosed() && this.socket.isConnected())
            {
                try {
                    if (server.serve_client(socket, b_writer, b_reader) == 1) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int serve_client(Socket client, BufferedWriter b_writer, BufferedReader b_reader) throws IOException {
        String message = b_reader.readLine();
        if (message == null) return 1;
        System.out.println(
                client.getInetAddress().getHostName() + " at " +
                client.getInetAddress().getHostAddress() + " sent request " +
                message
        );
        return 0;
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

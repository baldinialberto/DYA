package base;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class ClientMain {
    public static void main(String[] args) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("192.168.1.111", 8080));
            BufferedWriter b_writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            b_writer.write("TestClientString");
            b_writer.newLine();
            b_writer.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        };

    }
    public static void printNetwork() throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets)) {
            System.out.print("*****\n");
            System.out.printf("Display name: %s\n", netint.getDisplayName());
            System.out.printf("Name: %s\n", netint.getName());
            for (InetAddress inet : Collections.list(netint.getInetAddresses()))
                System.out.printf("L: %s\n", inet.getHostAddress());
        }
    }
}

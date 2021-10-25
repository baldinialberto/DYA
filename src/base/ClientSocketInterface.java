package base;

public interface ClientSocketInterface {
    void connect();
    void close();
    void sendMessage();
    void getMessage();
    void isMessageReady();
}

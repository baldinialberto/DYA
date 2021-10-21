import java.util.ArrayList;

public interface Chat {
    void add_message(Message m);
    ArrayList<Message> get_last_messages(int count);
}

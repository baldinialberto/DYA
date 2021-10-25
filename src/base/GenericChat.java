package base;

import java.net.Socket;
import java.util.ArrayList;

public class GenericChat implements Chat {
    private ArrayList<Pair<String, Socket>> users;
    private ArrayList<Message> messages;
    private int id;

    @Override
    public void add_message(Message m) {
        messages.add(m);
    }

    @Override
    public ArrayList<Message> get_last_messages(int count) {
        return (ArrayList<Message>) messages.subList(Math.max(messages.size() - count, 0), messages.size() - 1);
    }
}

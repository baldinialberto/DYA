package base;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MessagePackage {
    private ArrayList<ProtocolMessage> messages = new ArrayList<>();
    public MessagePackage()
    {
    }
    public void add_message(ProtocolMessage message)
    {
        messages.add(message);
    }
    public int getMessage_count() {
        return messages.size();
    }
    public ProtocolMessage getMessage(int index)
    {
        return messages.get(index);
    }
    public void send(Socket to) throws IOException {
        DataOutputStream os = new DataOutputStream(to.getOutputStream());
        os.writeInt(messages.size());
        for (ProtocolMessage message : messages) {
            ProtocolMessage.writeToDataStream(
                    os,
                    message.getHeader().type,
                    message.getHeader().data_len,
                    message.getData()
            );
        }
        os.close(); // automatic flush
    }
    public void receive(Socket from) throws IOException {
        DataInputStream is = new DataInputStream(from.getInputStream());
        int message_count = is.readInt();
        messages = new ArrayList<>();
        for (int i = 0; i < message_count; i++) {
            messages.add(ProtocolMessage.readFromDataStream(is));
        }
        is.close();
    }
}

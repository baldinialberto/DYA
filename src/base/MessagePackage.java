package base;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class MessagePackage {
    private int message_count;
    private ProtocolMessage[] messages;
    public MessagePackage()
    {
        this.message_count = 0;
        this.messages = new ProtocolMessage[]{};
    }
    public MessagePackage(int message_count, ProtocolMessage[] messages)
    {
        this.message_count = message_count;
        this.messages = messages;
    }
    public void add_message(ProtocolMessage message)
    {
        this.message_count++;
        List<ProtocolMessage> list = Arrays.asList(this.messages);
        list.add(message);
        messages = list.toArray(messages);
    }
    public int getMessage_count() {
        return this.message_count;
    }
    public ProtocolMessage[] getMessages()
    {
        return this.messages;
    }
    public ProtocolMessage getMessage(int index)
    {
        return this.messages[index];
    }
    public void send(Socket to) throws IOException {
        DataOutputStream os = new DataOutputStream(to.getOutputStream());
        os.writeInt(message_count);
        for (int i = 0; i < message_count; i++)
        {
            os.writeInt(messages[i].getHeader().type);
            os.writeLong(messages[i].getHeader().data_len);
            os.write(messages[i].getData());
        }
        os.close(); // automatic flush
    }
    public void receive(Socket from) throws IOException {
        DataInputStream is = new DataInputStream(from.getInputStream());
        message_count = is.readInt();
        messages = new ProtocolMessage[message_count];
        for (int i = 0; i < message_count; i++) {
            messages[i] = ProtocolMessage.readFromDataStream(is);
        }
        is.close();
    }
}

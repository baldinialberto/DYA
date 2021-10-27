package base;

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
}

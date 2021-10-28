package base;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProtocolMessage {
    private final ProtocolMessageHeader header;
    private final byte[] data;

    public ProtocolMessage(int type, byte[] data)
    {
        this.header = new ProtocolMessageHeader(type, data.length);
        this.data = data;
    }
    public ProtocolMessage(int type)
    {
        this.header = new ProtocolMessageHeader(type, 0);
        this.data = null;
    }

    public byte[] getData() {
        return data;
    }
    public ProtocolMessageHeader getHeader() {
        return header;
    }

    public static ProtocolMessage readFromDataStream(DataInputStream inputStream) throws IOException {
        int type = inputStream.readInt();
        int len = inputStream.readInt();
        byte[] data = new byte[len];
        inputStream.readFully(data, 0, len);
        return new ProtocolMessage(type, data);
    }

    @Override
    public String toString()
    {
        String res = "type : ";
        switch (this.header.type) {
            case ProtocolMessageHeader.Types._message -> res += "message\n";
            case ProtocolMessageHeader.Types._login -> res += "login\n";
            case ProtocolMessageHeader.Types._logout -> res += "logout\n";
            case ProtocolMessageHeader.Types._string -> res += "string\n";
            case ProtocolMessageHeader.Types._int -> res += "int\n";
            case ProtocolMessageHeader.Types._long -> res += "long\n";
            default -> res += "unknown\n";
        }
        res += "content : ";
        if (this.data == null)
        {
            res += "none";
        } else {
            try {
                switch (this.header.type) {
                    case ProtocolMessageHeader.Types._message,
                            ProtocolMessageHeader.Types._login,
                            ProtocolMessageHeader.Types._logout -> res += "none";
                    case ProtocolMessageHeader.Types._string -> {
                        res += (java.lang.String) new ObjectInputStream(new ByteArrayInputStream(this.data)).readObject();
                    }
                    case ProtocolMessageHeader.Types._int -> {
                        res += new ObjectInputStream(new ByteArrayInputStream(this.data)).readInt();
                    }
                    case ProtocolMessageHeader.Types._long -> {
                        res += new ObjectInputStream(new ByteArrayInputStream(this.data)).readLong();
                    }
                    default -> res += "unknown";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res += "unknown";
            }
        }
        return res;
    }
}

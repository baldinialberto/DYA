package base;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
        if (len > 0) {
            byte[] data = new byte[len];
            inputStream.readFully(data, 0, len);
            return new ProtocolMessage(type, data);
        } else {
            return new ProtocolMessage(type);
        }
    }
    public static void writeToDataStream(DataOutputStream outputStream, int type, int len, byte[] data) throws IOException
    {
        outputStream.writeInt(type);
        outputStream.writeInt(len);
        if (len > 0) outputStream.write(data, 0, len);
    }

    @Override
    public String toString()
    {
        String res = "type : ";
        switch (this.header.type) {
            case ProtocolMessageHeader.Types._message:
                res += "message\n";
                break;
            case ProtocolMessageHeader.Types._login:
                res += "login\n";
                break;
            case ProtocolMessageHeader.Types._logout:
                res += "logout\n";
                break;
            case ProtocolMessageHeader.Types._string:
                res += "string\n";
                break;
            case ProtocolMessageHeader.Types._int:
                res += "int\n";
                break;
            case ProtocolMessageHeader.Types._long:
                res += "long\n";
                break;
            default:
                res += "unknown\n";
                break;
        }
        res += "content : ";
        if (this.data == null)
        {
            res += "none";
        } else {
            try {
                switch (this.header.type) {
                    case ProtocolMessageHeader.Types._message:
                    case ProtocolMessageHeader.Types._login:
                    case ProtocolMessageHeader.Types._logout:
                        res += "none";
                        break;
                    case ProtocolMessageHeader.Types._string:
                        res += new String(this.data);
                        break;
                    case ProtocolMessageHeader.Types._int:
                        res += new ObjectInputStream(new ByteArrayInputStream(this.data)).readInt();
                        break;
                    case ProtocolMessageHeader.Types._long:
                        res += new ObjectInputStream(new ByteArrayInputStream(this.data)).readLong();
                        break;
                    default:
                        res += "unknown";
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}

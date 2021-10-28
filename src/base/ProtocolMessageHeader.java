package base;

public class ProtocolMessageHeader {
    public int type;
    public int data_len;
    public static class Types {
        public final static int _message = -3;
        public final static int _logout = -2;
        public final static int _login = -1;
        public final static int _string = 0;
        public final static int _int = 1;
        public final static int _long = 2;
    }
    public ProtocolMessageHeader(int type, int data_len)
    {
        this.type = type;
        this.data_len = data_len;
    }
}

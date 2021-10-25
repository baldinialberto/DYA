package base;

public abstract class MessageContent {
    protected Object content;

    protected enum types {TEXT, FILE}

    ;
    protected int type;

    public abstract Object get();
}

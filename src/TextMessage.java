public class TextMessage extends MessageContent {

    public TextMessage(String text)
    {
        this.content = text;
        this.type = types.TEXT.ordinal();
    }
    @Override
    public Object get() {
        return null;
    }
}

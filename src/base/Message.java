package base;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Message {
    private final String from;
    private MessageContent content;
    private final LocalDateTime time;

    public Message(User u, MessageContent content) throws NullPointerException {
        Objects.requireNonNull(u);
        from = u.getUsername();
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public String getFrom() {
        return this.from;
    }

    public MessageContent getContent() {
        return this.content;
    }

    public LocalDateTime getTime() {
        return this.time;
    }
}

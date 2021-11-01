package api;

import java.time.LocalDateTime;

public class ChatMessage {
	public final Chat.Id chat;
	public final User sender;
	public final MessageData data;
    public final LocalDateTime time;
    
    ChatMessage(Chat.Id chat, User sender, MessageData data, LocalDateTime time) {
    	this.chat = chat.clone();
    	this.sender = sender.clone();
    	this.data = data.clone();
    	this.time = time;
    }    
}

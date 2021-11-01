package api;

import java.util.*;

public interface ClientAPIInterface {
    void login(String user, String password);
    void logout();
    
    void registerMessageExecutor(MessageExecutorInterface executor);
    void unregisterMessageExecutor(MessageExecutorInterface executor);
    
    HashSet<User> getUsers();
    TreeSet<Chat> getChats();
    List<ChatMessage> getNewMessages();
    
    Chat requestNewChat();
    void requestAddToChat(Chat.Id chat, User user);
    void requestRemoveFromChat(Chat.Id chat, User user);
    void requestDeleteChat(Chat.Id chat);
    void sendMessage(Chat.Id chat, ChatMessage message);
}

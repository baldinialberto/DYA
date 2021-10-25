package api;


import base.Chat;
import base.Message;
import base.User;

public interface ClientAPIInterface {
    void login(String user, String password);
    void logout();
    void registerMessageExecutor(MessageExecutorInterface executor);
    void unregisterMessageExecutor(MessageExecutorInterface executor);
    void getUsers() throws Exception;
    void getChats() throws Exception;
    void getNewMessage() throws Exception;
    void requestNewChat();
    void requestAddToChat(Chat chat, String user);
    void requestRemoveFromChat(Chat chat, String user);
    void requestDeleteChat(Chat chat);
    void sendMessage(Chat chat, Message message);
}

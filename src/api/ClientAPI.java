package api;

import base.Chat;
import base.Message;

public class ClientAPI implements ClientAPIInterface {
    @Override
    public void login(String user, String password) {

    }

    @Override
    public void logout() {

    }

    @Override
    public void registerMessageExecutor(MessageExecutorInterface executor) {

    }

    @Override
    public void unregisterMessageExecutor(MessageExecutorInterface executor) {

    }

    @Override
    public void getUsers() throws Exception {

    }

    @Override
    public void getChats() throws Exception {

    }

    @Override
    public void getNewMessage() throws Exception {

    }

    @Override
    public void requestNewChat() {

    }

    @Override
    public void requestAddToChat(Chat chat, String user) {

    }

    @Override
    public void requestRemoveFromChat(Chat chat, String user) {

    }

    @Override
    public void requestDeleteChat(Chat chat) {

    }

    @Override
    public void sendMessage(Chat chat, Message message) {

    }
}

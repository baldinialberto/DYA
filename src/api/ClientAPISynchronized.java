package api;

import java.util.*;

public class ClientAPISynchronized implements ClientAPIInterface {

	@Override
	public void login(String user, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerMessageExecutor(MessageExecutorInterface executor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterMessageExecutor(MessageExecutorInterface executor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashSet<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Chat> getChats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChatMessage> getNewMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public api.Chat requestNewChat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void requestAddToChat(Chat.Id chat, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestRemoveFromChat(Chat.Id chat, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestDeleteChat(Chat.Id chat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(Chat.Id chat, ChatMessage message) {
		// TODO Auto-generated method stub
		
	}
    
}

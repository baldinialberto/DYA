package base;

public class ProtocolMessageFactory implements ProtocolMessageFactoryInterface{

    @Override
    public MessagePackage MakeLoginRequest(String username, String password) {
        MessagePackage mp = new MessagePackage();
        mp.add_message(new ProtocolMessage(ProtocolMessageHeader.Types._login));
        mp.add_message(new ProtocolMessage(ProtocolMessageHeader.Types._string, username.getBytes()));
        mp.add_message(new ProtocolMessage(ProtocolMessageHeader.Types._string, password.getBytes()));
        return mp;
    }

    @Override
    public MessagePackage MakeLogoutRequest(String username) {
        MessagePackage mp = new MessagePackage();
        mp.add_message(new ProtocolMessage(ProtocolMessageHeader.Types._logout));
        mp.add_message(new ProtocolMessage(ProtocolMessageHeader.Types._string, username.getBytes()));
        return mp;
    }

    @Override
    public MessagePackage MakeGetUserRequest(String username) {
        return null;
    }

    @Override
    public MessagePackage MakeGetChatsRequests(String username) {
        return null;
    }

    @Override
    public MessagePackage MakeGetMessagesRequest(String username, long chat_id) {
        return null;
    }

    @Override
    public MessagePackage MakeSendMessageRequest(String username, String message, long chat_id) {
        return null;
    }

    @Override
    public MessagePackage MakeNewChatRequest(String username) {
        return null;
    }

    @Override
    public MessagePackage MakeAddToChatRequest(String username, long chat_id, String username_add) {
        return null;
    }

    @Override
    public MessagePackage MakeRemoveFromChatRequest(String username, long chat_id, String username_rmv) {
        return null;
    }

    @Override
    public MessagePackage MakeDeleteChatRequest(String username, long chat_id) {
        return null;
    }

    @Override
    public MessagePackage MakeSubscribeRequest(String username, String password) {
        return null;
    }

    @Override
    public MessagePackage MakeUnsubscribeRequest(String username) {
        return null;
    }
}

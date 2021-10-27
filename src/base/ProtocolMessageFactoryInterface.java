package base;

public interface ProtocolMessageFactoryInterface {
    MessagePackage MakeLoginRequest(String username, String password);
    MessagePackage MakeLogoutRequest(String username);
    MessagePackage MakeGetUserRequest(String username);
    MessagePackage MakeGetChatsRequests(String username);
    MessagePackage MakeGetMessagesRequest(String username, long chat_id);
    MessagePackage MakeSendMessageRequest(String username, String message, long chat_id);
    MessagePackage MakeNewChatRequest(String username);
    MessagePackage MakeAddToChatRequest(String username, long chat_id, String username_add);
    MessagePackage MakeRemoveFromChatRequest(String username, long chat_id, String username_rmv);
    MessagePackage MakeDeleteChatRequest(String username, long chat_id);
    MessagePackage MakeSubscribeRequest(String username, String password);
    MessagePackage MakeUnsubscribeRequest(String username);
}

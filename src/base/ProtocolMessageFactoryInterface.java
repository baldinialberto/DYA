package base;

public interface ProtocolMessageFactoryInterface {
    void MakeLoginRequest();
    void MakeLogoutRequest();
    void MakeGetUserRequest();
    void MakeGetChatsRequests();
    void MakeGetMessagesRequest();
    void MakeSendMessageRequest();
    void MakeNewChatRequest();
    void MakeAddToChatRequest();
    void MakeRemoveFromChatRequest();
    void MakeDeleteChatRequest();
    void MakeSubscribeRequest();
    void MakeUnsubscribeRequest();
}

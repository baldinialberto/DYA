package api;

import base.Message;

public interface MessageExecutorInterface {
    void onIncomingMessage(Message message);
}

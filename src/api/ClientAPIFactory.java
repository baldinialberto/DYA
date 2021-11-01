package api;

public class ClientAPIFactory
{
    static ClientAPI newClient() {
        return new ClientAPI();
    }
    
    static ClientAPISynchronized newSyncClient() {
        return new ClientAPISynchronized();
    }
}

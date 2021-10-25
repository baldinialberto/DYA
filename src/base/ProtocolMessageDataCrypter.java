package base;

public interface ProtocolMessageDataCrypter {
    void cryptMessage(ProtocolMessage message);
    void decryptMessage(ProtocolMessage message);
}

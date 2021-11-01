package api;

public class TerminalMessagePrinterExecutor implements MessageExecutorInterface
{
	public TerminalMessagePrinterExecutor() { }
	
    @Override
    public void onIncomingMessage(ChatMessage message) {
    	System.out.println(message.data.readAsString());
    }
}

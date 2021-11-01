package api;

import java.nio.charset.StandardCharsets;

public class MessageData {
	private final int type;
	private final byte[] bytes;
	
	MessageData(int type, byte[] bytes)
	{
		this.type = type;
		this.bytes = bytes.clone();
	}
	
	@Override
	public MessageData clone()
	{
		return new MessageData(type, bytes);
	}
	
	public String readAsString()
	{
		return new String(bytes, StandardCharsets.UTF_8);
	}
}

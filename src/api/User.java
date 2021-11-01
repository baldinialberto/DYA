package api;

public class User {
	public final String username;
	
	User(String username)
	{
		this.username = username;
	}
	
	@Override
	public User clone()
	{
		return new User(username);
	}
}
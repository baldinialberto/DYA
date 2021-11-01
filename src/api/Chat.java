package api;

import java.util.*;

public class Chat implements Comparable<Chat> {
	public final Id id;
	public final User owner;
	public final List<User> users;
	
	Chat(long id, User owner, List<User> users)
	{
		this.id = new Id(id);
		this.owner = owner;
		this.users = new LinkedList<User>();
		this.users.addAll(users);
	}

	@Override
	public int compareTo(Chat r) {
		return id.compareTo(r.id);
	}
	
	public class Id implements Comparable<Id> {
		public final long id;
		
		public Id(long id)
		{
			this.id = id;
		}
		
		@Override
		public Id clone()
		{
			return new Id(id);    			
		}

		@Override
		public int compareTo(Id r) {
			return Long.compare(this.id, r.id);
		}    		
	}
}
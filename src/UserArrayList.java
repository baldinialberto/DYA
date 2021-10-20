import java.util.ArrayList;

public class UserArrayList extends ArrayList<User> {
    public boolean contains(String username)
    {
        for (User u : this)
        {
            if (u.compareTo(username) == 0)
            {
                return true;
            }
        }
        return false;
    }
    public User get(String username)
    {
        for (User u : this)
        {
            if (u.compareTo(username) == 0)
            {
                return u;
            }
        }
        return null;
    }
}

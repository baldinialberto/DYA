package base;

import java.util.ArrayList;

public class UserArrayList extends ArrayList<S_User> {

    public boolean contains(String username) {
        for (S_User u : this) {
            if (u.compareUsernames(username) == 0) {
                return true;
            }
        }
        return false;
    }

    public S_User get(String username) {
        for (S_User u : this) {
            if (u.compareUsernames(username) == 0) {
                return u;
            }
        }
        return null;
    }
}
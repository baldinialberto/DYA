package base;

import java.time.LocalDateTime;

public interface User extends Comparable<User> {
    public String getUsername();

    public boolean getOnline_status();

    public LocalDateTime getLast_access();

    public boolean checkPassword(String password);
}

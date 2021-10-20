import java.time.LocalDateTime;
import java.util.Objects;

public interface User extends Comparable<User> {
    public String getUsername();
    public boolean getOnline_status();
    public LocalDateTime getLast_access();
    public boolean checkPassword(String password);
}

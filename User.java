import java.util.*;

public class User {
    private String username;
    private String password;

    private static final Map<String, User> USERS = new HashMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void register() {
        if (USERS.containsKey(username))
            throw new IllegalStateException("User đã tồn tại: " + username);
        USERS.put(username, this);
    }

    public static User login(String username, String password) {
        User user = USERS.get(username);
        if (user != null && user.password.equals(password))
            return user;
        throw new IllegalArgumentException("Sai thông tin đăng nhập");
    }
}

// Authentication.java
public class Authentication {
    public static boolean validate(String username, String password) {
        return username != null && !username.isEmpty() && password != null && password.length() >= 6;
    }
}
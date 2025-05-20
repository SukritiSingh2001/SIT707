package web.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Business logic to handle login functions.
 */
public class LoginService {

    static class User {
        String password;
        String dob;

        User(String password, String dob) {
            this.password = password;
            this.dob = dob;
        }
    }

    // Simulated user store
    private static final Map<String, User> userStore = new HashMap<>();

    static {
        userStore.put("ahsan", new User("ahsan_pass", "2001-09-30"));
        userStore.put("john", new User("john123", "1995-01-01"));
        userStore.put("emma", new User("emma456", "2000-12-31"));
    }

    /**
     * Returns true for successful login, false otherwise.
     */
    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) return false;

        User user = userStore.get(username);
        if (user != null && user.password.equals(password) && user.dob.equals(dob)) {
            return true;
        }
        return false;
    }
}

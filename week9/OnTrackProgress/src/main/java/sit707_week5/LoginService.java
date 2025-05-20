package sit707_week5;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private static final Map<String, String> userDB = new HashMap<>();

    static {
        userDB.put("s123456", "password123");
        userDB.put("s789012", "securepass");
    }

    public boolean validateStudentLogin(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false;
        }
        return password.equals(userDB.get(username));
    }
}
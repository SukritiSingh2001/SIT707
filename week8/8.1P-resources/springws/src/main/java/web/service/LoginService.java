package web.service;

/**
 * Business logic to handle login functions.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     */
    public static boolean login(String username, String password, String dob) {
        return "sukriti".equals(username) && "12345".equals(password);
    }
}

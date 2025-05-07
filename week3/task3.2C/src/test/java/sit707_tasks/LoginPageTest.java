package sit707_tasks;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTest {

    // Simulate login validation method
    public boolean isValidLogin(String username, String password) {
        return username != null && username.matches("^[\\w.-]+@student\\.deakin\\.edu\\.au$")
               && password != null && password.length() >= 8 && !password.trim().isEmpty();
    }

    // Valid login test
    @Test
    public void testValidLogin() {
        Assert.assertTrue(isValidLogin("john@student.deakin.edu.au", "Password123"));
    }

    // Invalid email format
    @Test
    public void testInvalidEmailFormat() {
        Assert.assertFalse(isValidLogin("john@deakin", "Password123"));
    }

    // Invalid domain
    @Test
    public void testInvalidEmailDomain() {
        Assert.assertFalse(isValidLogin("john@gmail.com", "Password123"));
    }

    // Empty email
    @Test
    public void testEmptyEmail() {
        Assert.assertFalse(isValidLogin("", "Password123"));
    }

    // Short password
    @Test
    public void testShortPassword() {
        Assert.assertFalse(isValidLogin("john@student.deakin.edu.au", "12345"));
    }

    // Empty password
    @Test
    public void testEmptyPassword() {
        Assert.assertFalse(isValidLogin("john@student.deakin.edu.au", ""));
    }

    // Password with only spaces
    @Test
    public void testPasswordOnlySpaces() {
        Assert.assertFalse(isValidLogin("john@student.deakin.edu.au", "        "));
    }
}

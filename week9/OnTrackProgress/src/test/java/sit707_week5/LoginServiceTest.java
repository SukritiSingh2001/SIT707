package sit707_week5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {

    private final LoginService loginService = new LoginService();

    @Test
    public void testValidLogin() {
        assertTrue(loginService.validateStudentLogin("s123456", "password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(loginService.validateStudentLogin("s123456", "wrongpass"));
    }

    @Test
    public void testUnknownUser() {
        assertFalse(loginService.validateStudentLogin("unknown", "pass"));
    }

    @Test
    public void testEmptyCredentials() {
        assertFalse(loginService.validateStudentLogin("", ""));
    }

    @Test
    public void testNullCredentials() {
        assertFalse(loginService.validateStudentLogin(null, null));
    }
}
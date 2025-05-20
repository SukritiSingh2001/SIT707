package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginUnitTest {

    // Valid equivalence class
    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", "2001-09-30"));
    }

    // Invalid username
    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("invalid", "ahsan_pass", "2001-09-30"));
    }

    // Invalid password
    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("ahsan", "wrong_pass", "2001-09-30"));
    }

    // Invalid DOB
    @Test
    public void testInvalidDOB() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }

    // Null parameters (boundary case)
    @Test
    public void testNullInputs() {
        assertFalse(LoginService.login(null, "pass", "2001-09-30"));
        assertFalse(LoginService.login("ahsan", null, "2001-09-30"));
        assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
    }

    // Empty string inputs (boundary case)
    @Test
    public void testEmptyInputs() {
        assertFalse(LoginService.login("", "", ""));
    }

    // Case sensitivity check
    @Test
    public void testCaseSensitivity() {
        assertFalse(LoginService.login("Ahsan", "ahsan_pass", "2001-09-30"));
    }

    // Valid login with other users
    @Test
    public void testOtherUsers() {
        assertTrue(LoginService.login("john", "john123", "1995-01-01"));
        assertTrue(LoginService.login("emma", "emma456", "2000-12-31"));
    }
}

package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
	    String studentId = "220369846";
	    Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
	    String studentName = "Sukriti";
	    Assert.assertNotNull("Student name is null", studentName);
	}
	
	
	 //Test Case 1: Empty Username and Empty Password
    @Test
    public void testEmptyUsernameAndPassword() {
        LoginStatus status = LoginForm.login("", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    //Test Case 2: Empty Username, Correct Password
    @Test
    public void testEmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    //Test Case 3: Wrong Username, Correct Password
    @Test
    public void testWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("wrong_user", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    //Test Case 4: Correct Username, Empty Password
    @Test
    public void testCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    //Test Case 5: Correct Username, Wrong Password
    @Test
    public void testCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "wrong_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    //Test Case 6: Correct Username, Correct Password, Empty Validation Code
    @Test
    public void testCorrectUsernameCorrectPasswordEmptyValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean isValidCode = LoginForm.validateCode("");
        Assert.assertFalse(isValidCode);
    }

    //Test Case 7: Correct Username, Correct Password, Wrong Validation Code
    @Test
    public void testCorrectUsernameCorrectPasswordWrongValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean isValidCode = LoginForm.validateCode("000000");
        Assert.assertFalse(isValidCode);
    }

    //Test Case 8: Correct Username, Correct Password, Correct Validation Code
    @Test
    public void testCorrectUsernameCorrectPasswordCorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean isValidCode = LoginForm.validateCode("123456");
        Assert.assertTrue(isValidCode);
    }
}

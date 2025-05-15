package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    @Before
    public void setup() {
        System.out.println("Starting Selenium registration tests...");
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "223456789"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Preeyanshi Shivangekar"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testRegistration_TC1_InvalidEmailAndPassword() {
        boolean result = SeleniumOperations.bunningswarehouse(
            "https://www.bunnings.com.au/register",
            "invalid",
            "wrongpass"
        );
        Assert.assertFalse("Registration should fail for invalid email and password", result);
    }

    @Test
    public void testRegistration_TC2_ValidEmailInvalidPassword() {
        boolean result = SeleniumOperations.bunningswarehouse(
            "https://www.bunnings.com.au/register",
            "pree@gmail.com",
            "wrongpass"
        );
        Assert.assertFalse("Registration should fail for valid email and invalid password", result);
    }

    @Test
    public void testRegistration_TC3_InvalidEmailValidPassword() {
        boolean result = SeleniumOperations.bunningswarehouse(
            "https://www.bunnings.com.au/register",
            "wrongemail@gmail.com",
            "hello"
        );
        Assert.assertFalse("Registration should fail for invalid email and valid password", result);
    }

    @Test
    public void testRegistration_TC4_ValidEmailAndPassword() {
        boolean result = SeleniumOperations.bunningswarehouse(
            "https://www.bunnings.com.au/register",
            "pree@gmail.com",
            "hello"
        );
        Assert.assertTrue("Registration should succeed for valid credentials", result);
    }
}

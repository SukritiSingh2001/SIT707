package sit707_week2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BunningLogicTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe/");
        driver = new ChromeDriver();
        driver.get("https://www.bunnings.com.au/login");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void login(String email, String password) {
        WebElement emailField = driver.findElement(By.id("okta-signin-username"));
        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        WebElement submitBtn = driver.findElement(By.id("okta-signin-submit"));

        emailField.clear();
        passwordField.clear();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitBtn.click();

        try { Thread.sleep(3000); } catch (InterruptedException e) {}
    }

    @Test
    public void testValidLogin() {
        login("valid@example.com", "correctPass123");
        assertFalse(driver.getCurrentUrl().contains("login")); // URL should change on success
    }

    @Test
    public void testInvalidEmail() {
        login("invalid@example.com", "correctPass123");
        assertTrue(driver.getCurrentUrl().contains("login")); // Still on login page
    }

    @Test
    public void testWrongPassword() {
        login("valid@example.com", "wrongPass");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testEmptyEmail() {
        login("", "somePassword");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testEmptyPassword() {
        login("valid@example.com", "");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testEmptyBoth() {
        login("", "");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }
}

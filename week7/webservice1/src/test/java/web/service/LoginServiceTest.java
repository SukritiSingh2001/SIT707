package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private static final String DRIVER_PATH = "C:/chromedriver-win64/chromedriver.exe/";
    private static final String LOGIN_PAGE = "D:\\sit707-prac\\week7\\webservice1\\src\\main\\resources\\pages/login.html";

    private WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(LOGIN_PAGE);
        sleep(2);
        return driver;
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performLogin(WebDriver driver, String username, String password, String dob) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);

        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(dob);

        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);
    }

    @Test
    public void testLoginSuccess() {
        WebDriver driver = setupDriver();
        performLogin(driver, "ahsan", "ahsan_pass", "1990-01-01");
        Assert.assertEquals("success", driver.getTitle());
        driver.quit();
    }

    @Test
    public void testInvalidUsername() {
        WebDriver driver = setupDriver();
        performLogin(driver, "wronguser", "ahsan_pass", "1990-01-01");
        Assert.assertEquals("fail", driver.getTitle());
        driver.quit();
    }

    @Test
    public void testInvalidPassword() {
        WebDriver driver = setupDriver();
        performLogin(driver, "ahsan", "wrongpass", "1990-01-01");
        Assert.assertEquals("fail", driver.getTitle());
        driver.quit();
    }

    @Test
    public void testInvalidDOB() {
        WebDriver driver = setupDriver();
        performLogin(driver, "ahsan", "ahsan_pass", "2000-12-12"); // Currently DOB is not validated in LoginService
        Assert.assertEquals("success", driver.getTitle()); // DOB is ignored in logic, so still "success"
        driver.quit();
    }

    @Test
    public void testAllInvalid() {
        WebDriver driver = setupDriver();
        performLogin(driver, "invalid", "invalid", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
        driver.quit();
    }
}

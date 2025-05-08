package web.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestViewQ1 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/yourAppName/viewq1");
    }

    @Test
    public void testAdditionSuccess() {
        driver.findElement(By.name("number1")).sendKeys("5");
        driver.findElement(By.name("number2")).sendKeys("10");
        driver.findElement(By.name("submit")).click();

        WebElement result = driver.findElement(By.id("result"));
        assertTrue(result.getText().contains("15"));
    }

    @Test
    public void testAdditionFailure_InvalidInput() {
        driver.findElement(By.name("number1")).sendKeys("abc");
        driver.findElement(By.name("number2")).sendKeys("10");
        driver.findElement(By.name("submit")).click();

        WebElement error = driver.findElement(By.id("error"));
        assertTrue(error.getText().contains("Invalid"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

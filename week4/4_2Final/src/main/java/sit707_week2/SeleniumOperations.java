package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean bunningswarehouse(String url, String email, String password) {
        System.setProperty("webdriver.chrome.driver", "/Users/preeyanshivangekar/Documents/chromedriver-mac-arm64/chromedriver"); 
        WebDriver driver = new ChromeDriver();

        try {
            System.out.println("Opening URL: " + url);
            driver.get(url);
            sleep(2);

            WebElement emailField = driver.findElement(By.id("uid"));
            emailField.clear();
            emailField.sendKeys(email);

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys(password);

            WebElement firstNameField = driver.findElement(By.id("firstName"));
            firstNameField.clear();
            firstNameField.sendKeys("Pree");

            WebElement lastNameField = driver.findElement(By.id("lastName"));
            lastNameField.clear();
            lastNameField.sendKeys("Pree");

            WebElement submitBtn = driver.findElement(By.cssSelector("button[data-locator='input_CreateAccount']"));
            submitBtn.click();

            sleep(3);

            String currentUrl = driver.getCurrentUrl();
            System.out.println("Post-registration URL: " + currentUrl);
            return !currentUrl.contains("register");  

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            takeScreenshot(driver, "/Users/preeyanshivangekar/Documents/SIT707/task4_2C/bunnings_test.png");
            driver.quit();
        }
    }

    public static void takeScreenshot(WebDriver driver, String filePath) {
        System.out.println("Taking screenshot at: " + filePath);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);

        File parentDir = destFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                System.out.println("Failed to create directory: " + parentDir.getAbsolutePath());
            }
        }

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved.");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}

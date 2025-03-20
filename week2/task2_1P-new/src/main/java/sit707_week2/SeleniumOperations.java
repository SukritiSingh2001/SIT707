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

    public static void officeworks_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        sleep(2);

        try {
            // Fill out the registration form
            driver.findElement(By.id("firstname")).sendKeys("Sukriti");
            driver.findElement(By.id("lastname")).sendKeys("Singh");
            WebElement phoneField = driver.findElement(By.id("phoneNumber"));
            phoneField.sendKeys("00000000");

            driver.findElement(By.id("email")).sendKeys("sukriti@gmail.com");
            
            
            driver.findElement(By.id("password")).sendKeys("123"); // Fails password requirement intentionally
            
            WebElement confirmPassword = driver.findElement(By.cssSelector("input[name='confirm-password']"));
            confirmPassword.sendKeys("123");
//            
//            driver.findElement(By.id("phoneNumber")).sendKeys("1234567890");


            // Click 'Create Account' button
            WebElement createAccountBtn = driver.findElement(By.xpath("//button[contains(text(),'Create account')]") );
            createAccountBtn.click();
            sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Take a screenshot
            captureScreenshot(driver, "officeworks_registration.png");
            driver.close();
        }
    }
    
    
    
    
    public static void zara_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        sleep(2);

        try {
            // Fill out the registration form
        	driver.findElement(By.id("email")).sendKeys("sukriti@gmail.com");
        	driver.findElement(By.id("password68")).sendKeys("123"); // Fails password requirement intentionally
        	driver.findElement(By.id("firstNaame72")).sendKeys("Sukriti");
            driver.findElement(By.id("lastName76")).sendKeys("Singh");
            
            WebElement phoneField = driver.findElement(By.id("phone.number84"));
            phoneField.sendKeys("00000000");
            
            // Click 'Create Account' button
            WebElement createAccountBtn = driver.findElement(By.xpath("//button[contains(text(),'Create account')]") );
            createAccountBtn.click();
            sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Take a screenshot
            captureScreenshot(driver, "zara_registration.png");
            driver.close();
        }
    }
    
 
    
    private static void captureScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
            System.out.println("Screenshot saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
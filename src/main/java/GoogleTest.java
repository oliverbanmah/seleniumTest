import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleTest {

    private static WebElement WebElement;

    public static void main(String[] args) {
        // 1. Set up ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 2. Open Sauce Demo website
        driver.get("https://www.google.com/");


        // 3. Locate elements using cssSelector
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("jumia");
        driver.findElement(By.name("btnK")).click();
//        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

//        usernameField.sendKeys("standard_user");
//        passwordField.sendKeys("secret_sauce");


    }

    }

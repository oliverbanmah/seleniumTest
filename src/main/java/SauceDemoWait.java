import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SauceDemoWait {
    private static WebElement WebElement;

    public static void main(String[] args) {
        // 1. Set up ChromeDriver
        WebDriver driver = new ChromeDriver();

// Set a global implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// Open SauceDemo
        driver.get("https://www.saucedemo.com");

// Locate elements (Selenium will wait up to 10 seconds if needed)
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // explicit wait for page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait until the Products page title is visible after login
        WebElement productsTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );

        System.out.println("Page Title: " + productsTitle.getText());

        //fluentwait to click on shopping cart
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))     // total wait time
                .pollingEvery(Duration.ofSeconds(5))     // check every 5 seconds
                .ignoring(NoSuchElementException.class); // ignore errors while waiting

// Wait until the shopping cart icon is present
        WebElement cartIcon = fluentWait.until(d ->
                d.findElement(By.className("shopping_cart_link"))
        );

        cartIcon.click();
    }

}

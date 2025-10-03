import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SauceDemoLogout {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Go to SauceDemo and login
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // 2. Open the side menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // explicit wait for logout click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait until the logout button is clickable
        WebElement productsTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );

        System.out.println("Page Title: " + productsTitle.getText());
                ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"));

//         4. Click logout
//        logoutButton.click();

        // 5. Verify: After logout, the login button should be back on screen
        WebElement loginBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );
        if (loginBtn.isDisplayed()) {
            System.out.println("✅ Logout successful – back on login page.");
        } else {
            System.out.println("❌ Logout failed – still inside the app.");
        }

        driver.quit();
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FacebookTest {
    private static WebElement WebElement;

    public static void main(String[] args) {
        // 1. Set up ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 2. Open Sauce Demo website
        driver.get("https://www.facebook.com/");

        // 3. Locate elements using cssSelector
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("+2349024648998");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("oiseseme1234");
        driver.findElement(By.name("login")).click();

//explicit wait
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait until the Products page title is visible after login
WebElement productsTitle = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount_0_0_OU\"]/div/div[1]/div/div[2]/div[5]/div[1]/span/div/div[1]/div/svg/g/image"))
);
        driver.findElement(By.xpath("//*[@id=\"mount_0_0_OU\"]/div/div[1]/div/div[2]/div[5]/div[1]/span/div/div[1]/div/svg/g/image")).click();

//System.out.println("Page Title: " + productsTitle.getText());
// Locate elements (Selenium will wait up to 10 seconds if needed)
        //driver.findElement(By.xpath("//*[@id=\"mount_0_0_OU\"]/div/div[1]/div/div[2]/div[5]/div[1]/span/div/div[1]/div/svg/g/image")).click();
//        driver.findElement(By.xpath("//*[@id=\"mount_0_0_OU\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/span")).click();
        //driver.findElement(By.id("login-button")).click();

//
//       6. open side menu and click logout
//        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();


    }
}

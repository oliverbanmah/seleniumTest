import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SauceDemoLogin {
    private static WebElement WebElement;

    public static void main(String[] args) {
        // 1. Set up ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 2. Open Sauce Demo website
        driver.get("https://www.saucedemo.com/");


//        // Find all elements with tag <input>
//        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
//        System.out.println("Total input fields: " + inputFields.size());
//
//        List<WebElement> buttons = driver.findElements(By.tagName("input"));
//        for (WebElement button : buttons) {
//            System.out.println("Button text: " + button.getText());



    // 3. Locate elements using cssSelector
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // 5. Click the login button
        loginButton.click();
//
//       6. open side menu and click logout
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();


    }
}
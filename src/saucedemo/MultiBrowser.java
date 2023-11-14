package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    // 1. Setup Chrome browser
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("You have entered invalid browser");
        }

        // 2. Open URL
        driver.get(baseUrl);
        driver.manage().window().maximize(); // Maximise the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); ////Implicit wait timing to driver

        // 3. Print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // 4. Print the current url
        System.out.println("The current URL: " + driver.getCurrentUrl());

        // 5. Print the page source
        System.out.println(driver.getPageSource());

        // 6. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");

        // 7. Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        // 8. Click on Login Button
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        // 9. Print the current url
        System.out.println("The current URL: " + driver.getCurrentUrl());

        // 10. Navigate to baseUrl
        driver.navigate().back();

        // 11. Refresh the page
        driver.navigate().refresh();

        // 12. Close the browser
        driver.quit();

    }


}

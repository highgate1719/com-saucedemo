package saucedemo;
/**
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Project_04_SauceDemo {
    //Multi Browser
    static String browser = "Chrome";
    //static String browser = "Firefox";
    //static String browser = "Edge";

    static String baseUrl = "https://www.saucedemo.com/";

    //launch the browser
    static WebDriver driver;

    public void multiBrowserTest() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
    }

    public static void main(String[] args) {
        //object creation for multiBrowserTest
        Project_04_SauceDemo obj = new Project_04_SauceDemo();
        obj.multiBrowserTest();

        //Open the URL into the browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //We give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print the title of the page
        System.out.println("Print the title of the page: " + driver.getTitle());

        //Print the current URL
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //Print the page source
        System.out.println("Print the page source: " + driver.getPageSource());

        //Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");

        //Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        //Click on Login Button.
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();

        //Print the current url.
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //Navigate to the baseURL
        driver.navigate().to(baseUrl);
        System.out.println("Navigate to the baseUrl: " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page: " + driver.getCurrentUrl());

        //close the browser
        driver.quit();
    }

}

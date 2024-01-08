package org.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void getPageTitleTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");
    }

    @Test(priority = 2)
    public void verifyLoginTest() {
        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

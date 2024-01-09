package org.testng.listerners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;


@Listeners(org.testng.listerners.CustomListernersTestNg.class)
public class TakeScreenshotUsingTestNgListerners {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void testGoogleTitleTest()
    {
        System.out.println("Google Title Test");
        Assert.assertEquals("Google", "Google");
    }


    @Test(priority = 2)
    public void testGoogleLinkTest()
    {
        System.out.println("Google Link Test");
        Assert.assertEquals("Link","LinkText");
    }

    @Test(priority = 3)
    public void testGoogleLogoTest()
    {
        System.out.println("Google Logo Test");
        Assert.assertEquals("Logo","Logo");
    }

    @AfterMethod
    public void  tearDown()
    {
        driver.quit();
    }

    public int generateRandomInt()
    {
        Random random = new Random();
        int num=random.nextInt(1000);
        return num;
    }
}

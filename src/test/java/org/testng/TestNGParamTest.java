package org.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestNGParamTest {

    public static WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setUp(String browser, String app) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(app);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().deleteAllCookies();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new FirefoxDriver();
            driver.get(app);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().deleteAllCookies();
        }
    }

    @Test(priority = 1)
    public void getfaceBookTitleTest()
    {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Facebook – log in or sign up");
    }


    @Test(priority = 2)
    public void verifyLogoTest()
    {
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Facebook\"]"));
        Assert.assertEquals(logo.isDisplayed(),true);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

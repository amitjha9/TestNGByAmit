package org.testng.parallelExecution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestNGParallelExecutionTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void getGoogleTitleTest()
    {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Google");
    }


    @Test(priority = 2)
    public void getGoogleLogoTest()
    {
        WebElement logo = driver.findElement(By.xpath("//img[@class=\"lnXdpd\"]"));
        Assert.assertEquals(logo.isDisplayed(),true);
    }

    @Test(priority = 3)
    public void verifySearchFieldDisplayTest()
    {
        WebElement searchField=driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        Assert.assertEquals(searchField.isDisplayed(),true);
    }

    @Test(priority = 4)
    public void verifySignInButtonDisplayTest()
    {
        WebElement signIn = driver.findElement(By.xpath("//span[text()=\"Sign in\"]"));
        Assert.assertEquals(signIn.isDisplayed(),true);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

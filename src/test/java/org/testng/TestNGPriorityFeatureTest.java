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

public class TestNGPriorityFeatureTest {

    /*
    Note: Normally if we don't define the priority at the test level , TestNG will pick the test in alphabetical order
    and then execute it.

    We can set the priority at the test level so that a particular test will get executed based on the priority defined
    We use "Priority" keyword to set the priority of the test cases.
     */

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
    public void googleTitleTest()
    {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Google");
    }

    @Test(priority = 2)
    public void googleLogoTest()
    {
        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Google\"]"));
        Assert.assertEquals(logo.isDisplayed(),true);
    }


    @Test(priority = 3)
    public void gmailLinkCheckTest()
    {
        WebElement isLinkPresent = driver.findElement(By.xpath("//a[text()=\"Gmail\"]"));
        Assert.assertEquals(isLinkPresent.isDisplayed(),true);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

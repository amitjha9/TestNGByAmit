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
import java.util.List;

public class TestNgDependsOnFeatureTest {

    /*
    TestNG DependsOnMethod means one method execution is totally depends on another methods where ever dependsOnMethods used.
    if Immediate method will fail , then method which depends on previous will be skipped from execution.
     */

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
    public void loginTest()
    {
        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");

        driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();

        WebElement logout = driver.findElement(By.xpath("//ul[@role=\"menu\"]//li[4]"));
        logout.click();
    }

    @Test(dependsOnMethods = {"loginTest"},priority = 2)
    public void orangeHRMTitleTest()
    {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");
    }

    //We can give more than one method as well
    @Test(dependsOnMethods = {"loginTest","orangeHRMTitleTest"},priority = 3)
    public void verifyTextTimeAtWorkTest()
    {
        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        WebElement timeAtWork = driver.findElement(By.xpath("//p[text()=\"Time at Work\"]"));
        Assert.assertEquals(timeAtWork.isDisplayed(),true);

        driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();

        WebElement logout = driver.findElement(By.xpath("//ul[@role=\"menu\"]//li[4]"));
        logout.click();
    }

    @Test(dependsOnMethods = {"loginTest"},priority = 4)
    public void verifyTextMyActionsTest()
    {
        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        WebElement myActios = driver.findElement(By.xpath("//p[text()=\"My Actions\"]"));
        Assert.assertEquals(myActios.isDisplayed(),true);

        driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();

        WebElement logout = driver.findElement(By.xpath("//ul[@role=\"menu\"]//li[4]"));
        logout.click();
    }

    @Test(dependsOnMethods = {"loginTest"},priority = 5)
    public void verifyTextQuickLaunchTest()
    {
        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        WebElement quickLaunch = driver.findElement(By.xpath("//p[text()=\"Quick Launch\"]"));
        Assert.assertEquals(quickLaunch.isDisplayed(),true);

        driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();

        WebElement logout = driver.findElement(By.xpath("//ul[@role=\"menu\"]//li[4]"));
        logout.click();
    }

    @Test(dependsOnMethods = {"loginTest"},priority = 6)
    public void getAllOrangeHRMenuTest()
    {
        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        List<WebElement> totalMenuItem = driver.findElements(By.xpath("//ul[@class=\"oxd-main-menu\"]//li//span"));
        Assert.assertEquals(totalMenuItem.size(),12);

        driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();

        WebElement logout = driver.findElement(By.xpath("//ul[@role=\"menu\"]//li[4]"));
        logout.click();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

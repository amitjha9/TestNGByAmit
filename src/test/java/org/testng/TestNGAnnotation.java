package org.testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;

public class TestNGAnnotation {

    /*
    Starting with pre condition annotations
     */

    /*
    This is out of the run
    1.Setup the system property
    2.Launch the chrome browser here
    3.Login into the application
    4.Enter the url to access the page
    5.Google title test
    6.Closed the opened tab
    7.Logout from the application
    8.Closed Chrome browser
    9.Closed prop
     */
    @BeforeSuite //1
    public void setUp() {
        System.out.println("Setup the system property");
    }

    @BeforeTest //2
    public void launchChrome() {
        System.out.println("Launch the chrome browser here");
    }

    @BeforeClass //3
    public void login() {
        System.out.println("Login into the application");
    }

    @BeforeMethod //4
    public void enterURL() {
        System.out.println("Enter the url to access the page");
    }

    @Test //5
    public void googleTitleTest() {
        System.out.println("Google title test");
    }

    @Test
    public void addEmployee()
    {
        System.out.println("Employee added into the system successfully");
    }

    @Test
    public void searchEmployee()
    {
        System.out.println("Search employee from the system");
    }

    @Test
    public void updateEmployee()
    {
        System.out.println("Employee details updated successfully");
    }

    @Test
    public void deleteEmployee()
    {
        System.out.println("Employee details deleted successfully");
    }

    /*
    Starting with post condition annotations
     */

    @AfterMethod //6
    public void closeTab() {
        System.out.println("Closed the opened tab");
    }

    @AfterClass //7
    public void logout() {
        System.out.println("Logout from the application");
    }

    @AfterTest //8
    public void closeChrome() {
        System.out.println("Closed Chrome browser");
    }

    @AfterSuite //9
    public void closeProp() {
        System.out.println("Closed prop");
    }
}

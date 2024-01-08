package org.testng;

import org.testng.annotations.Test;

public class TestNGEnableDisableFeatureTest {

    /*
    In TestNG if we don't want to run a particular test we can disable that test using below keyword
    1. Enable = false
    2. Enable = true (This is default from TestNG)
     */

    @Test(priority = 1,groups = {"Sanity"})
    public void createEmployeeTest()
    {
        System.out.println("Employee Created");
    }

    @Test(enabled = false)
    public void updateEmployeeTest()
    {
        System.out.println("Employee Updated");
    }

    @Test(groups = {"Regression"},priority = 2)
    public void deleteEmployee()
    {
        System.out.println("Employee Deleted");
    }

    @Test(priority = 3,groups = {"Sanity"})
    public void searchEmployee()
    {
        System.out.println("Employee Searched");
    }
}

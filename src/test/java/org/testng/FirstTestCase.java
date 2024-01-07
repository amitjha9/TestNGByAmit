package org.testng;

import org.testng.annotations.Test;

public class FirstTestCase {

    /*
    This is the first TestNG class where I have written all the test method by defining the priority such that
    test will be executing based on the set priority
     */

    @Test(priority = 1)
    public void setup()
    {
        System.out.println("Launching the application");
    }

    @Test(priority = 2)
    public void login()
    {
        System.out.println("Login into the application");
    }

    @Test(priority = 3)
    public void tearDown()
    {
        System.out.println("Close the application");
    }
}

package org.testng;

import org.testng.annotations.Test;

public class TestNGGroupingFeatureTest {

    @Test(priority = 1,groups = {"Sanity"})
    public void groupOneTest()
    {
        System.out.println("This is group one test");
    }

    @Test(priority = 2,groups = {"Sanity"})
    public void groupTwoTest()
    {
        System.out.println("This is group two test");
    }

    @Test(priority = 3,groups = {"Sanity"})
    public void groupThreeTest()
    {
        System.out.println("This is group three test");
    }


    @Test(priority = 4,groups = {"Sanity"})
    public void groupFourTest()
    {
        System.out.println("This is group four test");
    }
}

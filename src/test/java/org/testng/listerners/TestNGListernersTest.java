package org.testng.listerners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(org.testng.listerners.TestNgListerners.class)
public class TestNGListernersTest {

    @Test(priority = 1)
    public void createProduct()
    {
        System.out.println("Product created");
        Assert.assertEquals("Created","Created");
    }

    @Test(priority = 2)
    public void reviewProduct()
    {
        System.out.println("Product reviewed");
        Assert.assertEquals("Revviewed","Revviewed");
    }

    @Test(priority = 3)
    public void publishProduct()
    {
        System.out.println("Product publish");
        Assert.assertEquals("publish","publis");
    }

    @Test(priority = 4)
    public void liveProduct()
    {
        System.out.println("Product Live");
        throw new SkipException("Skipped");
    }
}

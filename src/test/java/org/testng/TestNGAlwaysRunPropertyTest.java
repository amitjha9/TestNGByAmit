package org.testng;

import org.testng.annotations.Test;

public class TestNGAlwaysRunPropertyTest {

    /*
    With this : alwaysRun = true
    If a method with above annotation , even though the dependent method has failed , with above annotation test will
    always be run and passed.
     */

    @Test(priority = 1)
    public void loginIntoAppTest()
    {
        System.out.println("Login into the system is success");
        Assert.assertEquals(true,false);
    }

    @Test(priority = 2,dependsOnMethods = {"loginIntoAppTest"})
    public void searchProductTest()
    {
        System.out.println("Product Search is success");
        Assert.assertEquals(true,true);
    }

    @Test(priority = 3,dependsOnMethods = {"loginIntoAppTest","searchProductTest"})
    public void addProductToCartTest()
    {
        System.out.println("Add Product to cart success");
        Assert.assertEquals(true,true);
    }

    @Test(priority = 4,dependsOnMethods = {"loginIntoAppTest","searchProductTest"})
    public void makePaymentTest()
    {
        System.out.println("Make Payment is success");
        Assert.assertEquals(true,true);
    }

    @Test(priority = 5,dependsOnMethods = {"loginIntoAppTest","searchProductTest"})
    public void getOrderConfirmationTest()
    {
        System.out.println("Order is success");
        Assert.assertEquals(true,true);
    }

    @Test(priority = 6,dependsOnMethods = {"loginIntoAppTest"},alwaysRun = true)
    public void receivedOrderTest()
    {
        System.out.println("Order received success");
        Assert.assertEquals(true,true);
    }
}

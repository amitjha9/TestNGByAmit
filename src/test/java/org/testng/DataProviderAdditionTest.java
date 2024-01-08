package org.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAdditionTest {


    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = {{10,10},{15,20},{12,14}};
        return data;
    }


    @Test(dataProvider = "getData")
    public void addTest(int a, int b)
    {
        int c = a+b;
        System.out.println("Sum:" +c);
    }
}

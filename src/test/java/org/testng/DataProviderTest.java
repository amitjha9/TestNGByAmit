package org.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {


    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = {{"amit@gmail.com","amit"},{"gudiya@gmail.com","gudiya"},{"aadvik@gmail.com","aadvik"}};
        return data;
    }


    @Test(dataProvider = "getData")
    public void printDetailTest(String email, String password)
    {
        System.out.println("Email:" +email+ " Password:" +password);
    }
}

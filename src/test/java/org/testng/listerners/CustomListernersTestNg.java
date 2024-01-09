package org.testng.listerners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CustomListernersTestNg extends TakeScreenshotUsingTestNgListerners implements ITestListener {

    public void onTestStart(ITestResult result)
    {
        System.out.println("Test Started -------");
    }

    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test Passed ------------");
    }

    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test Failed -------------");
        int randomInt = generateRandomInt();
        String fileName = "Test1"+randomInt+".jpg";

        String destinationPath = System.getProperty("user.dir");
        String destPath = destinationPath+"/screenshots/";

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(destPath+fileName);
        try {
            FileUtils.copyFile(source,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test Skipped ------------");
    }
}

package org.testng.listerners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListerners implements ITestListener {

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
    }

    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test Skipped ------------");
    }
}

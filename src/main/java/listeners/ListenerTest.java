package listeners;

import com.google.common.collect.ImmutableMap;
import driver.DriverManager;
import io.qameta.allure.Attachment;
import logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class ListenerTest implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("2433242");
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("App_name", "ukrnet")
                        .put("Environment", System.getProperty("environment"))
                        .build(), System.getProperty("user.dir")
                        +"/build/allure-results/");
        System.out.println("Run test for: " + context.getSuite().getName());


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {
        System.out.println("The name of the testcase failed is :"+Result.getName());
        screenshot();
        Log.log("Result","TEST FAILED") ;
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("The name of the testcase Skipped is :"+Result.getName());
        Log.log("Result","TEST SKIPPED") ;

    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result)
    {
        System.out.println(Result.getName()+" test case started");
      //  Log.log("Start test"+ Result.getName()) ;

    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is :"+Result.getName());

        Log.log("Result","TEST PASSED") ;
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

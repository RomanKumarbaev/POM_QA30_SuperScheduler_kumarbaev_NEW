package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestNG implements ITestListener, ISuiteListener {
    Logger logger= LoggerFactory.getLogger(ListenerTestNG.class);

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("LTNG: Start test ---->"+result.getStatus());
        logger.info("LTNG: Start test ---->"+result.getTestName());
        logger.info("LTNG: Start test ---->"+result.getTestClass());
        logger.info("LTNG: Start test ---->"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("LTNG: Error ---->"+result.getThrowable().getMessage());
        logger.info("LTNG: Error ---->"+result.getThrowable().getStackTrace().toString());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);

        logger.info("LTNG: Start test ---->"+context.getOutputDirectory());
        logger.info("LTNG: Start test ---->"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}

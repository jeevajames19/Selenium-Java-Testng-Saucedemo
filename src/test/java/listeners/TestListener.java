package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.jeeva.automation.base.BaseTest;
import com.jeeva.automation.config.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        BaseTest baseTest = (BaseTest) testClass;

        ScreenshotUtils.takeScreenshot(
                baseTest.driver,
                result.getName()
        );
    }
}
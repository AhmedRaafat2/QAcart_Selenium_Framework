package com.qacart.testcases;


import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qacart.base.TestBase;
import com.qacart.utils.TestUtil;
import com.relevantcodes.extentreports.LogStatus;


public class Test_Page_One extends TestBase {
	
	
	public Test_Page_One() {
		super();
	}
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		logger = extent.startTest(method.getName());
		initialization(prop.getProperty("local"));
		
	}
	
	
	@Test(priority = 17)
	public void Test_Case_1() throws InterruptedException {
		System.out.println("Hello world!");
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));
			

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

		} else {
			logger.log(LogStatus.PASS, "Test passed");
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));
			
		}

		extent.endTest(logger);
		driver.quit();
	}
	
	
	

}

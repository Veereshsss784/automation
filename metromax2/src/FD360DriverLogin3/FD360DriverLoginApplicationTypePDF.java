package FD360DriverLogin3;

import java.awt.AWTException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import FD360SignUp.Registration;
import sample.ExtentReportsClass;

public class FD360DriverLoginApplicationTypePDF {
	public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;

	@BeforeTest
	public void StartReport() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/AutomationReports/FD360DriverLoginApplicationTypePDF.html", true);
		extent.addSystemInfo("Host name", "software testing material");
		extent.addSystemInfo("Environment name", "Automation testing");
		extent.addSystemInfo("User name", "Veeresh");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
      
	
	// Enter the Driver Login details
	@SuppressWarnings("unused")
	@Test(priority = 1)
	public void UserDetails() throws AWTException, InterruptedException {
		

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");		
		
		                                                                              test = extent.startTest("Verify Opened Browser and Enter Driver Login details");
		test.log(LogStatus.INFO, "OpenBrowser test is intiated.");

		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "Browser is opned and window is maximized");
		                                                                               extent.endTest(test);

		driver.get("http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply/");
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		test.log(LogStatus.PASS, "String Url is open in firefox browser");
	
		extent.flush();

		String Expected = driver.getTitle();
		String Actual = "FleetDrive 360 - Smart Compliance Services";
		System.out.println(Expected);
		if (Expected.equals(Actual)) {
			test.log(LogStatus.PASS, "Signup page is open successfully");
			System.out.println("Signup page is open successfully");
		}

		else {
			test.log(LogStatus.FAIL, "Signup page is not able to open.");
			System.out.println("Signup page is not able to open.");
		}
		
		
		                                                                                  logger = extent.startTest("Enter Login Details");
		WebElement Username = driver.findElement(By.xpath("//*[@id='username']"));
		wait.until(ExpectedConditions.visibilityOf(Username));
		Username.sendKeys("veeresh123");
		WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
		Password.sendKeys("Ib1c@W#9Yl");
		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/form/button"));
		Login.click();
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Successfully Submited the Driver Login details ");
		System.out.println("Successfully Submited the Driver Login details");
		extent.endTest(logger);

		WebElement OnlineApplication = driver.findElement(By.xpath("//input[@value='Online_Application']"));

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOf(OnlineApplication));
		OnlineApplication.click();

		WebElement submit = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		submit.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "PopUp-Online application selected");
		System.out.println("PopUp-Online application selected successfully");
		extent.endTest(logger);  
	}
		@AfterTest
		public void endReport() {
			extent.flush();
			extent.close();  
		}   

		@AfterMethod

		public void getResult(ITestResult result) throws Exception {
			if (result.getStatus() == ITestResult.SUCCESS) {
				logger.log(LogStatus.PASS, "Test case is pass : " + result.getName());
				logger.log(LogStatus.PASS, "Test case is pass : " + result.getThrowable());
				String screenshotPath = Registration.getScreenshot(driver, result.getName());
				logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
			}
			

		
			else if (result.getStatus() == ITestResult.FAILURE) {
					logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
					logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

					String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

					logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
				}

			else if (result.getStatus() == ITestResult.SKIP) {
				logger.log(LogStatus.SKIP, "Test case is skipped" + result.getName());
			}
}
}

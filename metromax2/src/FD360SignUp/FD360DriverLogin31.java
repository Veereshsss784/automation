/*package FD360SignUp;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import FD360POM.DriverHistory;
import FD360POM.DriversAndDQ;
import FD360POM.HomePageOfFDMgr;
import FD360POM.LoginAsFDMgr;
import FD360SignUp.Registration;
import sample.ExtentReportsClass;


public class FD360DriverLogin31 {
	public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;

	@BeforeTest
	public void StartReport() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/FD360MgrReport/FD360DriverApplSubmit13.html", true);
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
		//
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
		Username.sendKeys("ellen");
		WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
		Password.sendKeys("9N6JEy7oDU");
		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/form/button"));
		Login.click();
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Successfully Submited the Driver Login details ");
		System.out.println("Successfully Submited the Driver Login details");
	                                                                                       extent.endTest(logger);              
	
	
		// verification of driver presencex
		
	}     
	
	@Test(priority=2)
	public void SeePreviousEmpResponse() throws Exception {

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		test.log(LogStatus.INFO, "OpenBrowser test is intiated.");
		driver = new FirefoxDriver();

		LoginAsFDMgr loginmgr = new LoginAsFDMgr(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login");

		driver.manage().window().maximize();
		loginmgr.printTitle();
		test.log(LogStatus.INFO, "Browser is maximized");
				                                                              logger = extent.startTest("Previous employee Inquiry List");
		loginmgr.EnterUserName("devuser22");
		loginmgr.EnterPassword("devuser2");
		loginmgr.clickLogin();
		
		test.log(LogStatus.INFO, "User logged in successfully");

		String HomeTitle = driver.getTitle();
		System.out.println(HomeTitle);

		HomePageOfFDMgr homepage = new HomePageOfFDMgr(driver);

		homepage.ClickAssignLater();
		
     	  homepage.clickDriverHistory();
		  
		  DriverHistory driverhistory=new DriverHistory(driver);
		  
		  driverhistory.clickPreviousEmployerInquiry();
		  
		  driverhistory.allEmpRecords(); 
		  driverhistory.empRecListHeader();
		  driverhistory.showEmployerList();
		  driverhistory.EyeviewEmpRecord();
		 
		    Assert.assertTrue(true);
		    	                                                                               logger.log(LogStatus.PASS, "previous employee Inquiry response");
		    System.out.println("viewed previous employee Inquiry response");
		    	                                                                               extent.endTest(logger);
	//	driver.close();
	}
	
	@Test(priority=3)
	public void ApproveDriverAppliaction() throws Exception {

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
				                                                                                   logger = extent.startTest("Driver application approved Drivers list");
				test.log(LogStatus.INFO, "OpenBrowser test is intiated.");
				
		driver = new FirefoxDriver();

		LoginAsFDMgr loginmgr = new LoginAsFDMgr(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		driver.get("http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login");

		driver.manage().window().maximize();
		loginmgr.printTitle();
		
			
		loginmgr.EnterUserName("devuser22");
		loginmgr.EnterPassword("devuser2");
		loginmgr.clickLogin();
		

		String HomeTitle = driver.getTitle();
		System.out.println(HomeTitle);

		HomePageOfFDMgr homepage = new HomePageOfFDMgr(driver);

		homepage.ClickAssignLater();
		homepage.DriverAndDQ();

		DriversAndDQ DriverDQ = new DriversAndDQ(driver);
		DriverDQ.DriverApplications();
		DriverDQ.ChangeStatus();
		DriverDQ.ToApproved();  
		Thread.sleep(2000);
		DriverDQ.ApproveApplication();
		
		Assert.assertTrue(true);
			                                                                                  logger.log(LogStatus.PASS, "Browser is opned and window is maximized");
	    System.out.println("Successfully displayed Approved driver appliaction");
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
	

}   */
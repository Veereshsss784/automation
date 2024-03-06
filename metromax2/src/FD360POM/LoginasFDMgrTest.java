package FD360POM;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import FD360SignUp.Registration;
import sample.ExtentReportsClass;

public class LoginasFDMgrTest {
	public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;

/*	@BeforeTest
	public void StartReport() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/FD360MgrReport/FD360Fleet2.html", true);
		extent.addSystemInfo("Host name", "software testing material");
		extent.addSystemInfo("Environment name", "Automation testing");
		extent.addSystemInfo("User name", "Veeresh");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}
*/
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	@Test(priority = 1,enabled=false)
	public void ApproveDriverAppliaction() throws Exception {

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
				test = extent.startTest("Verify Opened Browser and Enter Fleet Login details");
				test.log(LogStatus.INFO, "OpenBrowser test is intiated.");
		WebDriver driver = new FirefoxDriver();

		LoginSVP LoginFleet = new LoginSVP(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		driver.get("https://dev.fleetdrive360.com/login");

		driver.manage().window().maximize();
		LoginFleet.printTitle();
		
			
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[0], passwords[0]);
		
		String HomeTitle = driver.getTitle();
		System.out.println(HomeTitle);
		
	}
	}
/*
		HomePageOfFDMgr homepage = new HomePageOfFDMgr(driver);

		homepage.ClickAssignLater();
		homepage.DriverAndDQ();

		DriversAndDQ DriverDQ = new DriversAndDQ(driver);
		DriverDQ.DriverApplications();
		DriverDQ.ChangeStatus();
		DriverDQ.ToApproved();  
		Thread.sleep(2000);
		DriverDQ.ApproveApplication();
		
			test.log(LogStatus.PASS, "Browser is opned and window is maximized");
			extent.endTest(test);
		
		System.out.println("Successfully Approved the driver appliaction");
		
	//	driver.close();   

	}  */

/*	@Test(priority=2)
	public void SeePreviousEmpResponse() throws Exception {

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		test = extent.startTest("Verify Opened Browser and Enter Fleet Login details");
		test.log(LogStatus.INFO, "OpenBrowser test is intiated.");
		WebDriver driver = new FirefoxDriver();

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
		
     	  homepage.clickDriverHistory();
		  
		  DriverHistory driverhistory=new DriverHistory(driver);
		  
		  driverhistory.clickPreviousEmployerInquiry();
		  
	//	  driverhistory.allEmpRecords(); 
	//	  driverhistory.empRecListHeader();
		  driverhistory.showEmployerList();
		  driverhistory.EyeviewEmpRecord();
		 
		    test.log(LogStatus.PASS, "Browser is opned and window is maximized");
			extent.endTest(test);
			
	//	driver.close();
	}
	
	*/
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
	
	

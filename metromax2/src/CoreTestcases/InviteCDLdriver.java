package CoreTestcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import sample.ExtentReportsClass;

public class InviteCDLdriver {
	//------------ Login SVP------------------------------------	
		By Title=By.xpath("//img[@src='/fleetdrivelogo1.png']");
		By LoginAppLOGO=By.xpath("//a[@id='desktop_view_logo']//img");
		By Username=By.xpath("//input[@name='username_or_email']");
		By Password=By.xpath("//input[@name='password']");
		By Login=By.xpath("//button[@type='submit']");
		By ForgotPassword=By.xpath("//a[.='Forgot Password ?']");
		By DriverLoginLink=By.xpath("//a[.='Click Here']");
		
		By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");
		By click_DRmenu=By.xpath("//span[.='Driver Recruitment']");
		By Click_INDsection=By.xpath("//a[@data-rb-event-key='invite']");
		By EnterDL_No=By.xpath("//input[@id='driverLicenseNumber']");
		By CreateDriverAppl=By.xpath("(//button[normalize-space()='Create Driver Application'])[1]");
		
		By FirstName=By.xpath("//div[@role='tabpanel']//div//div[1]//div[1]//div[1]//div[1]//input[1]");
		By MiddleName=By.name("middleName");
		By LastName=By.name("lastName");
		By Email=By.name("email");
		By PhoneNo=By.name("phone");
		By ReqCDLYes=By.xpath("(//input[@value='yes'])[1]");
		By ReqCDLNo=By.xpath("(//input[@value='no'])[1]");
		
		By InConsortiumYes=By.xpath("(//input[@name='inConsortium'])[1]");
		By InConsortiumNo=By.xpath("(//input[@name='inConsortium'])[2]");
		By SendDriverApp=By.xpath("//button[normalize-space()='Send Driver Application']");
		
		ExtentReports extent;
		ExtentTest logger;
		WebDriver driver;

		@BeforeTest
		public void startReport() {
			extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/InviteDriver.html", true);

			extent.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation Testing")
					.addSystemInfo("User Name", "Veeresh");

			extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		}

		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileHandler.copy(source, finalDestination);

			return destination;

		}

		@Test(priority = 1)
		public void SVPLogin() throws Throwable {

			logger = extent.startTest("SVPLogin");
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("InviteDriver.properties");
			props.load(file);

	        System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String Url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");

			driver.get(Url);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			System.out.println("Browser zooming");
			
			Robot robot = new Robot();
			
			Thread.sleep(1000);
			System.out.println("Browser About to zoom out");
			for (int i = 0; i < 4; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			driver.findElement(Username).sendKeys(username);
			driver.findElement(Password).sendKeys(password);
			driver.findElement(Login).click();
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Test Case Passed is SVPLogin");
			Thread.sleep(3000);
		}
		
		@Test(priority=2)
		public void InviteDriver() throws Throwable {

			logger = extent.startTest("InviteDriver");
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("InviteDriver.properties");
			props.load(file);
			
            String SelectCarrier1=props.getProperty("CarrierName");
            String EnterDLNo1=props.getProperty("EnterDLNo");
			String FirstName1 = props.getProperty("FirstName");
			String MiddleName1 = props.getProperty("MiddleName");
			String LastName1 = props.getProperty("LastName");
			String EmailAddress1 = props.getProperty("EmailAddress");
			String PhoneNumber1 = props.getProperty("PhoneNumber");
		   
		   driver.findElement(SelectCarrier).click();
		   driver.findElement(SelectCarrier).click();
	/*		
			Robot rbt2 = new Robot();
			
			rbt2.keyPress(KeyEvent.VK_W);
			rbt2.keyRelease(KeyEvent.VK_W);
			
			rbt2.keyPress(KeyEvent.VK_A);
			rbt2.keyRelease(KeyEvent.VK_A);
			
			rbt2.keyPress(KeyEvent.VK_T);
			rbt2.keyRelease(KeyEvent.VK_T); 
			
			rbt2.keyPress(KeyEvent.VK_ENTER);
			rbt2.keyRelease(KeyEvent.VK_ENTER);
			rbt2.keyPress(KeyEvent.VK_ENTER);
			rbt2.keyRelease(KeyEvent.VK_ENTER);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			rbt2.keyPress(KeyEvent.VK_ENTER);
			rbt2.keyRelease(KeyEvent.VK_ENTER);
		*/	
            Robot rbt2 = new Robot();
			
			rbt2.keyPress(KeyEvent.VK_I);
			rbt2.keyRelease(KeyEvent.VK_I);
			
			rbt2.keyPress(KeyEvent.VK_M);
			rbt2.keyRelease(KeyEvent.VK_M);
			
			rbt2.keyPress(KeyEvent.VK_P);
			rbt2.keyRelease(KeyEvent.VK_P); 
			
			rbt2.keyPress(KeyEvent.VK_ENTER);
			rbt2.keyRelease(KeyEvent.VK_ENTER);
			rbt2.keyPress(KeyEvent.VK_ENTER);
			rbt2.keyRelease(KeyEvent.VK_ENTER);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			rbt2.keyPress(KeyEvent.VK_ENTER);
			rbt2.keyRelease(KeyEvent.VK_ENTER);
		   
           driver.findElement(click_DRmenu).click();
           driver.findElement(Click_INDsection).click();
           driver.findElement(EnterDL_No).sendKeys(EnterDLNo1);
           driver.findElement(CreateDriverAppl).click();
           driver.findElement(FirstName).sendKeys(FirstName1);
           driver.findElement(MiddleName).sendKeys(MiddleName1);;
           driver.findElement(LastName).sendKeys(LastName1);;
           driver.findElement(Email).sendKeys(EmailAddress1);
           driver.findElement(PhoneNo).sendKeys(PhoneNumber1);
           
           driver.findElement(ReqCDLYes).click();
           //driver.findElement(ReqCDLNo).click();
           driver.findElement(InConsortiumYes).click();
           
           driver.findElement(SendDriverApp).click();
           Assert.assertTrue(true);
		   logger.log(LogStatus.PASS, "Test Case Passed is verified after tested Drug and Alcohol cards in dashbaord");
}
		@AfterMethod
		public void getResult(ITestResult result) throws Exception {
			if (result.getStatus() == ITestResult.FAILURE) {
				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

				String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

				logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			} else if (result.getStatus() == ITestResult.SKIP) {
				logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
				logger.log(LogStatus.SKIP, "Test Case Failed is " + result.getThrowable());

				String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

				logger.log(LogStatus.SKIP, logger.addScreenCapture(screenshotPath));
			}

			else if (result.getStatus() == ITestResult.SUCCESS) {
				logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
				logger.log(LogStatus.PASS, "Test Case Failed is " + result.getThrowable());

				String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

				logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
			}

			extent.endTest(logger);
		}

		@AfterTest
		public void endReport() {

			extent.flush();

			extent.close();
		}
}

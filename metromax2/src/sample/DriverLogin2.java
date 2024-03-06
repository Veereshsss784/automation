package sample;

import java.awt.AWTException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

public class DriverLogin2 {

	public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;

	@BeforeTest
	public void StartReport() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/FD360DriverLogin.html", true);
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
	@Test()
	public void UserDetails() throws AWTException, InterruptedException {
		logger = extent.startTest("Enter Login Details");

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "OpenBrowser test is intiated.");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "Browser is opned and window is maximized");
		

		driver.get("http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply/");
		
		
		test.log(LogStatus.PASS, "String Url is open in firefox browser");
		extent.endTest(test);
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

		WebElement Username = driver.findElement(By.xpath("//*[@id='username']"));
		
		Username.sendKeys("veeresh1");
		WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
		Password.sendKeys("2@I5TCYHwr");
		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/form/button"));
		Login.click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Successfully Submited the Driver Login details ");
		System.out.println("Successfully Submited the Driver Login details");
	  Thread.sleep(3000);
	/*	WebElement forms = driver.findElement(By.xpath("//div[@class='MuiAccordionSummary-content MuiAccordionSummary-contentGutters css-17o5nyn']"));
		
		List<WebElement> allOptions =	driver.findElements(By.xpath("//div[@class='MuiAccordionSummary-content MuiAccordionSummary-contentGutters css-17o5nyn']"));
		
		for(WebElement opt:allOptions)
		{
			opt.click();
			
			Thread.sleep(4000);
			
  		//	driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-9l3uo3']")).click();
		    opt.click();
		    
			
	/*		List<WebElement> check1 = driver.findElements(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @type='checkbox']"));
			for (WebElement choose : check1) {
				Thread.sleep(3000);
				choose.click();
				break;        
			}               */
	  
	  
	  WebElement Agree1 = driver
				.findElement(By.xpath("(//div[@class='MuiAccordionSummary-content MuiAccordionSummary-contentGutters css-17o5nyn'])[4]"));
		Agree1.click();
		WebElement check1 = driver.findElement(By.xpath(
				"(//input[@type='checkbox'])[5]"));
		check1.click();
			
		
		
		}
	}


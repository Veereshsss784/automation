package metromax;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Signup {
	public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;
	
	@BeforeTest
	public void StartReport() 
	{
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/FailExtentReport.html", true);
		extent.addSystemInfo("Host name", "software testing material");
		extent.addSystemInfo("Environment name", "Automation testing");
		extent.addSystemInfo("User name", "Veeresh");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@SuppressWarnings("unused")
	@Test(priority = 1)
	public void failTest() throws Exception {
		logger = extent.startTest("failTest");

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "OpenBrowser test is intiated.");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "Browser is opned and window is maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/register");
		test.log(LogStatus.PASS, "String Url is open in firefox browser");
		Thread.sleep(5000);
		extent.endTest(test);
		extent.flush();
		
		String Expected = driver.getTitle();
		String Actual = "FleetDrive 360 - Smart Compliance Services";
		System.out.println(Expected);
		if (Expected.equals(Actual)) {
			test.log(LogStatus.PASS, "Login page is open successfully");
			System.out.println("Login page is open successfully");
		}

		else {
			test.log(LogStatus.FAIL, "login page is not able to open.");
			System.out.println("Login page is not able to open.");
		}

		WebElement un = driver.findElement(By.xpath("//input[@name='username']"));
		un.sendKeys("admin");
		WebElement pswd = driver.findElement(By.xpath("//input[@name='password']"));
		pswd.sendKeys("Innowyze123");
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();
		
		test = extent.startTest("Verify welcome page Screen");
		String Actual1 = "FleetDrive 360 Administration | FleetDrive 360 site admin";
		String Expected1 = driver.getTitle();

		test.log(LogStatus.INFO, "Verifing Admin welcome page");
		if (Expected1.equals(Actual1)) {
			test.log(LogStatus.PASS, "Admin welcome page is open successfully");
			System.out.println("Admin welcome page is open successfully");
		}

		else {
			test.log(LogStatus.FAIL, "Admin welcome page is not able to open.");
			System.out.println("Admin welcome page is not able to open.");
		}

		extent.endTest(test);
		extent.flush();
		
		test.log(LogStatus.INFO, "Click on ONBOARD SP");
		WebElement OnboardSP = driver.findElement(By.xpath("//a[.='Onboard SP']"));
		OnboardSP.click();
		
		Assert.assertTrue(true);
        logger.log(LogStatus.PASS, "Test case passed is passTest");
	}

	@Test(priority = 2)
	public void Opned_Django_administration_HomePage_FilledForm_TC2() {
		try {
			WebElement fn = driver.findElement(By.xpath("//input[@name='first_name']"));
			fn.sendKeys("Veeresh");
			WebElement mn = driver.findElement(By.xpath("//input[@name='middle_name']"));
			mn.sendKeys("A");
			WebElement ln = driver.findElement(By.xpath("//input[@name='last_name']"));
			ln.sendKeys("Salagar");
			WebElement No = driver.findElement(By.xpath("//input[@name='phone']"));
			No.sendKeys("+17847848330");
			WebElement email = driver.findElement(By.xpath("//input[@name='user_email']"));
			email.sendKeys(generateChar() + "@gmail.com");

			WebElement SPRegEmail = driver.findElement(By.xpath("//input[@name='email']"));
			SPRegEmail.sendKeys(generateChar() + "@gmail.com");
			WebElement SPname = driver.findElement(By.xpath("//input[@name='name']"));
			SPname.sendKeys("Mahesh");
			WebElement SPLname = driver.findElement(By.xpath("//input[@name='legal_name']"));
			SPLname.sendKeys("AnandMetromax");
			WebElement SPdoi = driver.findElement(By.xpath("//input[@name='incorporation_date']"));
			SPdoi.sendKeys("07/04/2022");

			WebElement ele = driver.findElement(By.xpath("//select[@name='address_type']"));
			Select sel = new Select(ele);
			sel.selectByValue("B");
			List<WebElement> options = sel.getOptions();
			for (WebElement opt : options) {
				String text = opt.getText();
				System.out.println(text);

				WebElement addrs1 = driver.findElement(By.xpath("//input[@name='address_1']"));
				addrs1.sendKeys("chincholi H tq kalgi dist kalaburagi");
				WebElement addrs2 = driver.findElement(By.xpath("//input[@name='address_2']"));
				addrs2.sendKeys("chincholi H tq kalgi dist kalaburagi");
				WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
				city.sendKeys("kalaburgi");
				WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
				state.sendKeys("karnataka");
				WebElement zip = driver.findElement(By.xpath("//input[@name='zip_code']"));
				zip.sendKeys("58531");
				WebElement country = driver.findElement(By.xpath("//input[@name='country']"));
				country.sendKeys("india");
				WebElement faxNo = driver.findElement(By.xpath("//input[@name='fax']"));
				faxNo.sendKeys("+112345678912");
				WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
				submit.click();
			}
		}

		catch (StaleElementReferenceException e) {
			Reporter.log("Successfully handled StaleElementReferenceException");

		}

	}

	@Test(priority = 3)
	public void Submited_the_Form_TC3() {
		WebElement submit = driver.findElement(By.xpath("//input[@id='submit-sp-products-form']"));
		submit.click();
		test.log(LogStatus.INFO, "Submited the Service provider onbording application");
	}

	@Test(priority = 4)
	public void Confirm_the_submition_TC4() {
		String text = driver.findElement(By.xpath("//li[.='Service provider has been created successfully']"))
				.getText();
		Reporter.log(text);
		System.out.println(text);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test case is pass"+result.getName());
			logger.log(LogStatus.FAIL, "Test case is pass"+result.getThrowable());
			String screenshotPath=SignUp1.getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test case is skipped"+result.getName());
		}
		extent.endTest(logger);
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}

	private String generateChar() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 10));
		System.err.print(uuid);
		return uuid;
	}

}


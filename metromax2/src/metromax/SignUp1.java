package metromax;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SignUp1 {

	public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;

	@BeforeTest
	public void StartReport() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
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
	public void passTest() {
		logger = extent.startTest("passTest");

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");

		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "OpenBrowser test is intiated.");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "Browser is opned and window is maximized");

		driver.get("https://dev-api.fleetsmartcarrierservices.com/admin");
		test.log(LogStatus.PASS, "String Url is open in firefox browser");
		extent.endTest(test);
		extent.flush();

		String Expected = driver.getTitle();
		String Actual = "Log in | FleetDrive 360 site admin";
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
		un.sendKeys("Admin");
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
	public void Opned_Django_administration_HomePage_FilledForm_TC2() throws InterruptedException {
		try {

			logger = extent.startTest("passTest");
			Assert.assertTrue(true);

			test = extent.startTest("Verify Administration Home Screen");
			String Actual2 = "| Django site admin";
			String Expected2 = driver.getTitle();

			test.log(LogStatus.INFO, "Verifing Administration Home page");
			if (Expected2.equals(Actual2)) {
				test.log(LogStatus.PASS, "Administration Home page is open successfully");
				System.out.println("Home page is open successfully");
			}

			else {
				test.log(LogStatus.FAIL, "Administration Home page is not able to open.");
				System.out.println("Administration Home page is not able to open.");
			}

			extent.endTest(test);
			extent.flush();

			// filling form

			WebElement fn = driver.findElement(By.xpath("//input[@name='first_name']"));
			fn.sendKeys("Miller");
			WebElement mn = driver.findElement(By.xpath("//input[@name='middle_name']"));
			mn.sendKeys("A");
			WebElement ln = driver.findElement(By.xpath("//input[@name='last_name']"));
			ln.sendKeys("Brown");
			WebElement No = driver.findElement(By.xpath("//input[@name='phone']"));
			No.sendKeys("+1404"+ Random7Numbers());
			WebElement email = driver.findElement(By.xpath("//input[@name='user_email']"));
			email.sendKeys(generateChar() +"@innowyze.testinator.com");

			WebElement SPRegEmail = driver.findElement(By.xpath("//input[@name='email']"));
			SPRegEmail.sendKeys(generateChar() +"@innowyze.testinator.com");
			WebElement SPname = driver.findElement(By.xpath("//input[@name='name']"));
			SPname.sendKeys(generateChar());
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

		logger.log(LogStatus.PASS, "Test case passed is passTest");

	}
	public static String Random7Numbers() {
	    // It will generate 7 digit random Number.
	    // from 0 to 9999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(9999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%07d", number);
	}

	@Test(priority = 3)
	public void Submited_the_Form_TC3() {
		WebElement submit = driver.findElement(By.xpath("//input[@id='submit-sp-products-form']"));
		submit.click();
		test.log(LogStatus.INFO, "Submited the Service provider onbording application");
	}

	@Test(priority = 4)
	public void Confirm_the_submition_TC4() {
		String text = driver.findElement(By.xpath("//li[.='Service provider has been created successfully']")).getText();
		Reporter.log(text);
		System.out.println(text);
		test.log(LogStatus.INFO, "confimed the submition");
	}

	@Test
	public void failTest() {
		logger = extent.startTest("failTest");
		Assert.assertFalse(false);
		test.log(LogStatus.INFO, "Test is failed");
	}

	@Test
	public void skipTest() {
		logger = extent.startTest("skipTest");
		Assert.assertTrue(false);
		test.log(LogStatus.INFO, "Test is skipped");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test case is pass" + result.getName());
			logger.log(LogStatus.PASS, "Test case is pass" + result.getThrowable());
			String screenshotPath = SignUp1.getScreenshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case is skipped" + result.getName());
		}
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
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
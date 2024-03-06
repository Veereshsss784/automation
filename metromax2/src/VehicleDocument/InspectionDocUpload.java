package VehicleDocument;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import FD360POM.DashboardSVP;
import FD360POM.LoginSVP;
import sample.ExtentReportsClass;

public class InspectionDocUpload {

	By DocumentMenu = By.xpath("//span[normalize-space()='Documents']");
	By VehicleSection = By.xpath("//a[@id='filecabinets.vehicledocuments']");
	By UploadDocButton = By.xpath("//button[@id='documents.vehicledocuments.upload']//i[@class='fa fa-upload']");
	By DocType = By.xpath("//div[@id='documentType']");
	By Inspection = By.xpath("//li[normalize-space()='Annual Inspection Document']");
	// By.xpath("//div[@role='dialog']");
	By InspectionNumber = By.xpath("//input[@id='inspectionNumber']");
	By IssueDate = By.xpath("//input[@id='issueDate']");
	By ExpDate = By.xpath("//input[@id='expirationDate']");
	By UploadInspectionDoc= By.xpath("//input[@id='document']");
	By UnitNumber=By.xpath("//div[@name='vehicle']//button[@title='Open']//span[@class='MuiIconButton-label']//*[name()='svg']");
	By Submit=By.xpath("//button[normalize-space()='Submit']");
	By Cancle=By.xpath("//button[normalize-space()='Cancel']");
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/UploadVehicleInspLDoc.html", true);

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
	@Test(priority = 1, groups = "login")
	public void SVPLogin() throws Throwable {
		String FleetDev="https://dev.fleetdrive360.com/login";
		String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
		String FleetProd="https://app.fleetdrive360.com/login";
		logger = extent.startTest("SVPLogin");
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("Config.properties");
		props.load(file);

        System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(FleetBeta);
		
		LoginSVP LoginFleet=new LoginSVP(driver);
	    DashboardSVP SVPDB=new DashboardSVP(driver);
		logger = extent.startTest("Switch Carrier");
		
		
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "svp1","sp","testing"};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "tpw7@mr02ei", "7847848330", "umnkx96aep"};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);                 //oliver_1  AdhEJRXtN9:  
        	Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Browser zooming");
		
		Robot robot = new Robot();
		
		Thread.sleep(1000);
		System.out.println("Browser About to zoom out");
		for (int i1 = 0; i1 < 4; i1++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
        }
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is SVPLogin");
		Thread.sleep(10000);
        
	}
	@Test(priority=2, groups = "CarrierSwitch")
	public void Selecting_CarrierBeta() throws AWTException, InterruptedException 
	{
		 DashboardSVP SVPDB=new DashboardSVP(driver);
		
        //Switching Carrier
        SVPDB.Selecting_CarrierProd("SPLENDID");
        Thread.sleep(10000);
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test(priority=3, groups = "Documents")
	public void Locate_DocumentsMenu() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		logger = extent.startTest("Open 'Documents' menu");
		driver.findElement(DocumentMenu).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=4, groups = "Vehicle Documents")
	public void Navigate_DriverDocumentsSection() throws Throwable
	{
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger = extent.startTest("Click on 'Vehicle Documents' Section");
		driver.findElement(VehicleSection).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=5, groups = "Upload Document")
	public void ClickOn_UploadDocument()
	{
		logger = extent.startTest("Click on 'Upload Document' button");
		driver.findElement(UploadDocButton).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	
	@Test(priority=6, groups = "Vehicle Doc")
    public void EnterMVRInformation() throws Throwable
    {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("Vehicle.properties");
		props.load(file);
		
		
		String InspNo=props.getProperty("InspNum");
		String LeaseCompany=props.getProperty("LeaseCompanyname");
		String UploadLease=props.getProperty("UploadRegDoc");
    
    	logger = extent.startTest("Enter the Vehicle lease Details");
    	driver.findElement(DocType).click();
    	driver.findElement(Inspection).click();
    	driver.findElement(InspectionNumber).sendKeys(InspNo);
    	
    	Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }
	@Test(priority=7, groups = "IssueDate ExpDate")
    public void EnterIssueAndExpDate()
    {
    	logger = extent.startTest("Enter the Driver License Details");
		driver.findElement(IssueDate).sendKeys(IssueDateBefore2Months());
		driver.findElement(ExpDate).sendKeys(ExpDateAfter2Months());
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }
	 @Test(priority=8, groups = "UploadVehicleInspection")
   public void UploadtheMVRDoc() throws Throwable
    {
    	Properties props = new Properties();
		FileInputStream file = new FileInputStream("Vehicle.properties");
		props.load(file);
		
		String UploadInspDoc=props.getProperty("UploadInspDoc");
		
		logger = extent.startTest("Enter the MVR Details");
		driver.findElement(UploadInspectionDoc).sendKeys(UploadInspDoc);
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }
	 @Test(priority=9, groups = "unit Number")
    public void SelectDriver() throws Throwable
	{
    	Properties props = new Properties();
		FileInputStream file = new FileInputStream("Vehicle.properties");
		props.load(file);
		
		String UnitNo=props.getProperty("UnitNum");
		
		logger = extent.startTest("Select Driver Name from dropdown");
		
		
		driver.findElement(UnitNumber).click();
		Robot robot = new Robot();

        // Wait for a moment before starting
        Thread.sleep(2000);

        String wordToType = UnitNo;
        
        // Iterate through each character and simulate key presses
        for (char c : wordToType.toCharArray()) 
        {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        // Simulate pressing Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
}
	 @Test(priority=10, groups = "Submit")
    public void SubmitInformation()
    {
    	logger = extent.startTest("Enter the Driver License Details");
    	driver.findElement(Submit).click();
    	Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }

    
    public String IssueDateBefore2Months()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.minusMonths(2);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;  	        
	}
	
	public String ExpDateAfter2Months()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.plusDays(1);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;      	        
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

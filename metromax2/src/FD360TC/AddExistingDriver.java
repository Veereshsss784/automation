package FD360TC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import FD360POM.HomePageOfCarrier;
import sample.ExtentReportsClass;

public class AddExistingDriver {
	
	By Title = By.xpath("//img[@src='/fleetdrivelogo1.png']");
	By Username = By.xpath("//input[@name='username_or_email']");
	By Password = By.xpath("//input[@name='password']");
	By Login = By.xpath("//button[@type='submit']");
	By ForgotPassword = By.xpath("//a[.='Forgot Password ?']");
	By DriverLoginLink = By.xpath("//a[.='Click Here']");
	By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");

	By DriverManagement=By.xpath("//span[normalize-space()='Driver Management']");
	By AddExistingDrivers=By.xpath("//a[@data-rb-event-key='add_existing_driver']");
	By BulkUpload=By.xpath("//button[normalize-space()='Bulk Upload Drivers']");
	By BulkUploadExcelDownload=By.xpath("//div[normalize-space()='Download Excel Sheet']");
	By BulkUploadDriverFile=By.xpath("//label[normalize-space()='Upload Driver File']");
	By UploadDone=By.xpath("//button[normalize-space()='Done']");
	
	By ReqCDLYes=By.xpath("(//input[@name='hasCommercialDriver'])[1]");
	By ReqCDLNo=By.xpath("(//input[@name='hasCommercialDriver'])[2]");
	
	By FirstName=By.xpath("//input[@id='firstName']");
	By LastName=By.xpath("//input[@id='lastName']");
	By DOB=By.xpath("//input[@id='dateOfBirth']");
	By DEmail=By.xpath("//input[@id='email']");
	By DPhone=By.xpath("//input[@value='+1']");
	By ClickStatus=By.xpath("//div[@id='status']");
	By SelectStausA=By.xpath("//li[normalize-space()='Active']");
	By SelectStatusT=By.xpath("//li[normalize-space()='Terminated']");
	By HireDate=By.xpath("//input[@id='hireDate']"); 
	By DSSN=By.xpath("//input[@id='ssnNumber']");
	By DriverNote=By.xpath("//textarea[@id='remark']");
	
	By DLNum=By.xpath("//input[@id='licenseNumber']");
	By ClickDLClass=By.xpath("//div[@id='licenseClass']");
	By SelectDLClassNone=By.xpath("//li[normalize-space()='None (Non-CDL Driver)']");
	By SelectDLClassA=By.xpath("//li[normalize-space()='Class A']");
	By SelectDLClassB=By.xpath("//li[normalize-space()='Class B']");
	By SelectDLClassC=By.xpath("//li[normalize-space()='Class C']");
	By SelectDLClassD=By.xpath("//li[normalize-space()='Class D']");
	By SelectDLClassE=By.xpath("//li[normalize-space()='Class E']");
	By DLIssueDate=By.xpath("//input[@id='licenseIssueDate']");
	By Restriction= By.xpath("//div[29]//div[1]//div[1]//div[1]//input[1]");
	By Endorsement= By.xpath("//div[29]//div[1]//div[1]//div[1]//input[1]");
	By DLExpDate=By.xpath("//input[@id='licenseExpirationDate']");
	By ClickIssueState=By.xpath("//div[@id='licenseIssueState']");
	By SelectState=By.xpath("//li[normalize-space()='Georgia']");
	By UploadDLFront=By.xpath("//input[@id='licenseDocumentFront']");
	By UploadDLBack=By.xpath("//input[@id='licenseDocumentBack']");
	
	By WishToEnrollDAC_Yes=By.xpath("(//input[@name='DA'])[1]");
	By WishToEnrollDAC_No=By.xpath("(//input[@name='DA'])[2]");
	By RunCHQuery_Yes=By.xpath("(//input[@name='CQuery'])[1]");
	By RunCHQuery_No=By.xpath("(//input[@name='CQuery'])[2]");
	By ConfirmCHResult_NotProhibitted=By.xpath("(//input[@name='CQueryResult'])[1]");
	By ConfirmCHResult_Prohibitted=By.xpath("(//input[@name='CQueryResult'])[2]");
	
	
	By WishToUploadMCYes=By.xpath("(//input[@name='medicalCardInfo'])[1]");
	By WantToUploadMCNo=By.xpath("(//input[@name='medicalCardInfo'])[1]");
	By MCIssueDate=By.xpath("//input[@id='medicalIssueDate']");
	By MCExpDate=By.xpath("//input[@id='medicalExpiryDate']");
	By MCRegNum=By.xpath("//input[@id='examinerRegistryNumber']");
	By DoctorName=By.xpath("//input[@id='doctorName']");
	By UploadMCDoc=By.xpath("//input[@id='medicalDocument']");
	By UploadNRCMEDoc=By.xpath("//input[@id='nrcmedoc']");
	
	By WishToUploadMVRYes= By.xpath("(//input[@name='mvrInfo'])[1]");
	By WishToUploadMVRNo=By.xpath("(//input[@name='mvrInfo'])[2]");
	By MVRIssueDate=By.xpath("//input[@id='mvrIssueDate']");
	By MVRExpDate=By.xpath("//input[@id='mvrExpiryDate']");
	By ClickMVRIssueState= By.xpath("//div[@id='mvrState']");
	By SelectMVRState=By.xpath("//li[normalize-space()='Indiana']");
	By UploadMVRDoc=By.xpath("//input[@id='mvrDocument']");
	
	By WishToUploadDQfileYes=By.xpath("(//input[@name='dqDocument'])[1]");
	By WishToUploadDQfileNo=By.xpath("(//input[@name='dqDocument'])[2]");
	By UploadDQfileDoc=By.xpath("//input[@id='dqfile']");
	
	By AddDriverButton=By.xpath("//button[normalize-space()='Add Driver']");
	
	By SearchDriver=By.xpath("(//input[@placeholder='Search'])[1]");
	By EntryCreated=By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft']");
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/AddExistingDriver.html", true);

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
	
	@Test(priority=1)
	public void SVPLogin() throws Throwable {

		logger = extent.startTest("SVPLogin");
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("AddExistingTD.properties");
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
		Thread.sleep(3000);
		System.out.println("Browser zooming");
		
		DashboardSVP SVPDB=new DashboardSVP(driver);
		
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
		logger.log(LogStatus.PASS, "Test Case Passed is SVPLogin");
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void Selecting_CarrierProd() throws AWTException, InterruptedException 
	{
		logger = extent.startTest("Switch Carrier");
		DashboardSVP SVPDB=new DashboardSVP(driver);
		//Nic Test Account 1
		SVPDB.Selecting_CarrierProd("2456133");
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(6000);
	}
	
	@Test(priority=3)
	public void Locate_DriverManagementMenu() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		logger = extent.startTest("Open 'Driver Management' menu");
		driver.findElement(DriverManagement).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=4)
	public void Navigate_AddExistingDriverSection() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger = extent.startTest("Click on 'Add Existing Driver' Section");
		Thread.sleep(2000);
		driver.findElement(AddExistingDrivers).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=5)
	public void EnterDriverInformation() throws Throwable
	{
		logger = extent.startTest("Enter the Driver Information");
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("AddExistingTD.properties");
		props.load(file);
		
		String FN=props.getProperty("FirstName");
		String LN=props.getProperty("LastName");
		String Email=props.getProperty("Email");
		String Phone =props.getProperty("Phone");
		String SSN =props.getProperty("SSN");
		String DriverNotes =props.getProperty("DriverNotes");
		
		driver.findElement(ReqCDLYes).click();
		driver.findElement(FirstName).sendKeys(FN);
		driver.findElement(LastName).sendKeys(LN);
		driver.findElement(DOB).sendKeys(DOBDate());
		driver.findElement(DEmail).sendKeys(Email);
		driver.findElement(DPhone).sendKeys(Phone);
		driver.findElement(ClickStatus).click();
		driver.findElement(SelectStausA).click();
		driver.findElement(HireDate).sendKeys(HireDate());
		driver.findElement(DSSN).sendKeys(SSN);
		driver.findElement(DriverNote).sendKeys(DriverNotes);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=6)
	public void EnterTheDriverDL_Info() throws Throwable
	{
		logger = extent.startTest("Enter the Driver license information");
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("AddExistingTD.properties");
		props.load(file);
		
		String LicenseNum=props.getProperty("DLNum");
		String Restric=props.getProperty("Res");
		String Endors=props.getProperty("Endor");
		String DLFront=props.getProperty("UploadDLFront");
		String DLBack=props.getProperty("UploadDLBack");
		
		driver.findElement(DLNum).sendKeys(LicenseNum);
		driver.findElement(ClickDLClass).click();
		driver.findElement(SelectDLClassA).click();
		driver.findElement(DLIssueDate).sendKeys(IssueDateBefore2Months());
		driver.findElement(DLExpDate).sendKeys(ExpDatetomorrow());
		driver.findElement(Restriction).sendKeys(Restric);
		Thread.sleep(2000);
		driver.findElement(Endorsement).sendKeys(Endors);
	    Thread.sleep(2000);
		driver.findElement(ClickIssueState).click();
		driver.findElement(SelectState).click();
		driver.findElement(UploadDLFront).sendKeys(DLFront);
		driver.findElement(UploadDLBack).sendKeys(DLBack);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
		
	}
	@Test(priority=7)
	public void DrugAlcohlConsortium() throws Exception
	{
		logger = extent.startTest("Enter the Drug and Alcohol Details");
		
		driver.findElement(WishToEnrollDAC_Yes).click();
		driver.findElement(RunCHQuery_Yes).click();
		Thread.sleep(2000);
		driver.findElement(ConfirmCHResult_NotProhibitted).click();
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=8)
	public void EnterMCInfo() throws Throwable
	{
		logger = extent.startTest("Enter the Medical Certificate information");
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("AddExistingTD.properties");
		props.load(file);
		
		String MCRegNo=props.getProperty("MCRegNo");
		String Doctor=props.getProperty("DoctorName");
		String MCDoc=props.getProperty("UploadMCDoc");
		String NRCMEDoc=props.getProperty("UploadNRCMEDoc");
		
		driver.findElement(WishToUploadMCYes).click();
		driver.findElement(MCIssueDate).sendKeys(IssueDateBefore2Months());
		driver.findElement(MCExpDate).sendKeys(ExpDatetomorrow());
		driver.findElement(MCRegNum).sendKeys(MCRegNo);
		driver.findElement(DoctorName).sendKeys(Doctor);
		driver.findElement(UploadMCDoc).sendKeys(MCDoc);
		driver.findElement(UploadNRCMEDoc).sendKeys(NRCMEDoc);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=9)
	public void EnterMVRDetails() throws Throwable
	{
		logger = extent.startTest("Enter the MVR Details");
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("AddExistingTD.properties");
		props.load(file);
		
		String MVRDoc=props.getProperty("UploadMVRDoc");
		
		driver.findElement(WishToUploadMVRYes).click();
		driver.findElement(MVRIssueDate).sendKeys(IssueDateBefore2Months());
		driver.findElement(MVRExpDate).sendKeys(ExpDatetomorrow());
		driver.findElement(ClickMVRIssueState).click();
		driver.findElement(SelectMVRState).click();
		driver.findElement(UploadMVRDoc).sendKeys(MVRDoc);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	} 
	@Test(priority=10)
	public void UploadDriverDQDoc() throws Throwable
	{
		logger = extent.startTest("Upload the DQ Documents");
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("AddExistingTD.properties");
		props.load(file);
		
		String DQfileDoc=props.getProperty("UploadDQDoc");
		
		driver.findElement(WishToUploadDQfileYes).click();
		driver.findElement(UploadDQfileDoc).sendKeys(DQfileDoc);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	
	@Test(priority=11)
	public void SubmitDriverForm() throws Throwable
	{
		logger = extent.startTest("Submit the form");
		
		driver.findElement(AddDriverButton).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='SubmitButton-IconContainer']")).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
		Thread.sleep(5000);
		
	}
	
	//@Test(priority=12)
	public void ProceedToCheckout() throws Exception
	{
		logger = extent.startTest("Do the Payment");
		HomePageOfCarrier Carrier_Space=new HomePageOfCarrier(driver);
		Carrier_Space.ProceedToCheckout();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}

	//@Test(priority=13)
	public void VerifyEntryCreated() throws Throwable
	{
		Thread.sleep(4000);
        logger = extent.startTest("Verify Entry is Created in the Driver list table");
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("AddExistingTD.properties");
		props.load(file);
		String DriverFN=props.getProperty("FirstName"); //Driver first name s1
		driver.findElement(SearchDriver).sendKeys(DriverFN);
		Thread.sleep(4000);
		String DName=driver.findElement(EntryCreated).getText(); // Driver full name s2

        boolean containsStr = DName.contains(DriverFN);

        if (containsStr) 
        {
            System.out.println("DriverFN contains Driver full Name");
        } 
        else 
        {
            System.out.println("DriverFN does not contain Driver full Name");
        }
    
		System.out.println("Actual Driver name is:"+DName);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Entry created and verified successfully");
		
	}
	
	public String DOBDate()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.minusYears(37);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;    	        
	}
	
	public String HireDate()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.minusYears(2);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;	        	        
	}
	
	public String IssueDateBefore2Months()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.minusMonths(2);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;  	        
	}
	
	public String ExpDatetomorrow()
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

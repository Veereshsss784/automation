package DriverDocuments;

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

import sample.ExtentReportsClass;

public class License {
	By Title = By.xpath("//img[@src='/fleetdrivelogo1.png']");
	By Username = By.xpath("//input[@name='username_or_email']");
	By Password = By.xpath("//input[@name='password']");
	By Login = By.xpath("//button[@type='submit']");
	By ForgotPassword = By.xpath("//a[.='Forgot Password ?']");
	By DriverLoginLink = By.xpath("//a[.='Click Here']");
	By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");
	
	By DocumentsMenu=By.xpath("//span[normalize-space()='Documents']");
	By DriverDocumentsSection=By.xpath("//a[@data-rb-event-key='DriverDocuments']");
	By UploadDriverDoc=By.xpath("(//i[@class='fa fa-upload'])[1]");
	By SelectDriver=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[2]");//(//*[name()='svg'][@focusable='false'])[11]
	By ClickDocType=By.xpath("//div[@id='documentType']");
	By SelectDocTypeLicense=By.xpath("//li[normalize-space()='License Document']");
	By SelectDocTypeMVR=By.xpath("//li[normalize-space()='MVR Document']");
	By SelectDocTypeMC=By.xpath("//li[normalize-space()='Medical Document']");
	By SelectDocTypeMisc=By.xpath("//li[normalize-space()='Miscellaneous Document']");
	By SelectDocTypeROD=By.xpath("//li[normalize-space()='Record of Duty Document']");
	By SelectDocTypeRT=By.xpath("//li[normalize-space()='Road Test Document']");
	By SelectDocTypeED=By.xpath("//li[normalize-space()='Existing Driver Application']");
	By SelectDocTypeDriverTraining=By.xpath("//li[normalize-space()='Driver Training Document']");
	By SelectDocTypeAddPreviousDL=By.xpath("//li[normalize-space()='Add Previous License']");
	
	By ClickIssueState=By.xpath("//div[@id='issueState']");
	By SelectIssueState=By.xpath("//li[normalize-space()='California']");
	By ClickLicenseClass=By.xpath("//div[@id='licenseClass']");
	By SelectLicenseClass=By.xpath("//li[normalize-space()='None (Non-CDL Driver)']");
	By SelectDLClassA=By.xpath("//li[normalize-space()='Class A']");
	By SelectDLClassB=By.xpath("//li[normalize-space()='Class B']");
	By SelectDLClassC=By.xpath("//li[normalize-space()='Class C']");
	By SelectDLClassD=By.xpath("//li[normalize-space()='Class D']");
	By SelectDLClassE=By.xpath("//li[normalize-space()='Class E']");
	By LicenseNum=By.xpath("//input[@id='licenseNumber']");
	By DLIssueDate=By.xpath("//input[@id='issueDate']");
	By DLExpDate=By.xpath("//input[@id='expirationDate']");
	
	By UploadDLFront=By.xpath("(//input[@id='document'])[1]");
	By UploadDLBack=By.xpath("(//input[@id='licenseDocumentBack'])[1]");
	
	
	
	By Submit=By.xpath("//button[normalize-space()='Submit']");
	By Cancel=By.xpath("//button[normalize-space()='Cancel']");
	
	By SearchDriver=By.xpath("//div[@role='tabpanel']//div//div//div//div//div//div//div//div//div//input[@placeholder='Search']");//By.xpath("(//input[@placeholder='Search'])[1]");
	By DriverDocPDF=By.xpath("(//i)[30]");
	By DriverDocExcel=By.xpath("(//i)[31]");
	// Drop down options in 'Driver Documents list' table
	By DocType=By.xpath("(//div[@role='button'])[7]");
	By PreviousDL=By.xpath("//span[normalize-space()='Previous License']");
	By DriverTraining=By.xpath("//span[normalize-space()='Previous License']");
	By Misc=By.xpath("(//span[contains(text(),'Miscellaneous Document')])[1]");
	By LicenseFront=By.xpath("//span[normalize-space()='License (Front Side)']");
	By LicenseBack=By.xpath("//span[normalize-space()='License (Back Side)']");
	By MVR=By.xpath("//span[normalize-space()='MVR Document']");
	By Medical=By.xpath("//span[normalize-space()='Medical Document']");
	By NRCME=By.xpath("//span[normalize-space()='NRCME Document']");
	By ROD=By.xpath("//span[normalize-space()='Record of Duty Document']");
	By RoadTest=By.xpath("//span[normalize-space()='Road Test Certificate']");
	By Misc2=By.xpath("(//span[contains(text(),'Miscellaneous Document')])[2]");
	By DriverApplication=By.xpath("//span[normalize-space()='Driver Application']");
	By ClickOutside=By.xpath("//div[@id='menu-']//div[@aria-hidden='true']");
	
	By VerifyDriverName=By.xpath("(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft'])[1]");
	By DownloadDoc=By.xpath("(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft'])[6]");
	By DocStatus=By.xpath("(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft'])[5]");
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/UploadDriverLicense.html", true);

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
	
	@Test(priority=2, groups = "CarrierSwitch")
	public void Selecting_CarrierBeta() throws AWTException, InterruptedException 
	{
		logger = extent.startTest("Switch Carrier");
		driver.findElement(SelectCarrier).click();
		Thread.sleep(2000);
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_I);
		rbt2.keyRelease(KeyEvent.VK_I);
		
		rbt2.keyPress(KeyEvent.VK_M);
		rbt2.keyRelease(KeyEvent.VK_M);
		
		rbt2.keyPress(KeyEvent.VK_P);
		rbt2.keyRelease(KeyEvent.VK_P); 
		
		rbt2.keyPress(KeyEvent.VK_ENTER);
		rbt2.keyRelease(KeyEvent.VK_ENTER);  
		
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
		driver.findElement(DocumentsMenu).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=4, groups = "Driver Documents")
	public void Navigate_DriverDocumentsSection() throws Throwable
	{
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger = extent.startTest("Click on 'Driver Documents' Section");
		driver.findElement(DriverDocumentsSection).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	
	@Test(priority=5, groups = "Upload Document")
	public void ClickOn_UploadDocument()
	{
		logger = extent.startTest("Click on 'Upload Document' button");
		driver.findElement(UploadDriverDoc).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	
	
	
    @Test(priority=6, groups = "License Doc")
    public void EnterDLInformation() throws Throwable
    {
    	Properties props = new Properties();
		FileInputStream file = new FileInputStream("Documents.properties");
		props.load(file);
		
		String DLNumber=props.getProperty("LicenseNumber");
		
    	logger = extent.startTest("Enter the Driver License Details");

		driver.findElement(ClickDocType).click();
		driver.findElement(SelectDocTypeLicense).click();
		driver.findElement(ClickIssueState).click();
		driver.findElement(SelectIssueState).click();
		driver.findElement(ClickLicenseClass).click();
		driver.findElement(SelectDLClassA).click();
		driver.findElement(LicenseNum).sendKeys(DLNumber);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }
    
    @Test(priority=7, groups = "IssueDate ExpDate")
    public void EnterIssueAndExpDate()
    {
    	logger = extent.startTest("Enter the Driver License issue and Exp Date");
		driver.findElement(DLIssueDate).sendKeys(IssueDateBefore2Months());
		driver.findElement(DLExpDate).sendKeys(ExpDateAfter2Months());
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }
    
    @Test(priority=8, groups = "UploadDL")
    public void UploadtheDLFrontAndBackDoc() throws Throwable
    {
    	Properties props = new Properties();
		FileInputStream file = new FileInputStream("Documents.properties");
		props.load(file);
		
		String DLFrontDoc=props.getProperty("DLFront");
		String DLBackDoc=props.getProperty("DLBack");
		
		logger = extent.startTest("Upload the Driver DL Front and DL Back Documents");
		driver.findElement(UploadDLFront).sendKeys(DLFrontDoc);
		driver.findElement(UploadDLBack).sendKeys(DLBackDoc);
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }
    
    @Test(priority=9, groups = "Driver Name")
	public void SelectDriver() throws Throwable
	{
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("Documents.properties");
		props.load(file);
		
		String DName=props.getProperty("DriverName");
		
		logger = extent.startTest("Select Driver Name from dropdown");
		
		Robot rbt3 = new Robot();
		Thread.sleep(2000);
		driver.findElement(SelectDriver).sendKeys(DName);
		driver.findElement(SelectDriver).click();
		rbt3.keyPress(KeyEvent.VK_ENTER);
	    rbt3.keyRelease(KeyEvent.VK_ENTER);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
    
    @Test(priority=10, groups = "Submit")
    public void SubmitInformation() throws Throwable
    {
    	logger = extent.startTest("Submit the Driver License Details");
    	driver.findElement(Submit).click();
    	Thread.sleep(4000);
    	Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
    }
    
   // @Test(priority=11)
    public void SearchAndVerifyInTable() throws Throwable
    {
    	Properties props = new Properties();
		FileInputStream file = new FileInputStream("Documents.properties");
		props.load(file);
		
		String DName=props.getProperty("DriverName");
		Thread.sleep(2000);
    	logger = extent.startTest("Enter the Driver name and verify Entry created in table");
    	//driver.findElement(SearchDriver).click();
    	driver.findElement(SearchDriver).sendKeys(DName);
    	Thread.sleep(4000);
    	driver.findElement(DocType).click();
    	Thread.sleep(4000);
    	driver.findElement(LicenseFront).click();
    	Thread.sleep(4000);
    	driver.findElement(ClickOutside).click();
    	Thread.sleep(4000);
    	String Name=driver.findElement(VerifyDriverName).getText();
    	System.out.println("Driver Name is: "+Name);
    	String DocumentStatus=driver.findElement(DocStatus).getText();
    	System.out.println("Driver document Status: "+DocumentStatus);
    	driver.findElement(DownloadDoc).click();
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

	        LocalDate nextDay = currentDate.plusMonths(2);

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

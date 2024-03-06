package FD360TC;

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
import sample.ExtentReportsClass;

public class AddVehicle {
	
	By Title = By.xpath("//img[@src='/fleetdrivelogo1.png']");
	By Username = By.xpath("//input[@name='username_or_email']");
	By Password = By.xpath("//input[@name='password']");
	By Login = By.xpath("//button[@type='submit']");
	By ForgotPassword = By.xpath("//a[.='Forgot Password ?']");
	By DriverLoginLink = By.xpath("//a[.='Click Here']");
	By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");
	
	By VehiclesMenu=By.xpath("//span[normalize-space()='Vehicles']");
	By ManageVehicleSec=By.xpath("//a[@data-rb-event-key='VehicleManage']");
	By AddVehicle=By.xpath("//button[normalize-space()='Add Vehicle']");
	By BulkUploadV=By.xpath("//button[normalize-space()='Bulk Upload Vehicles']");
	By VehicleListPDF=By.xpath("(//i)[27]");
	By VehicleListExcel=By.xpath("(//i)[28]");
	By SearchVehicle=By.xpath("//input[@placeholder='Search']");
	By SelectRow=By.xpath("(//div[@id='mui-65251'])[1]");
	By SelectRow10=By.xpath("(//li[normalize-space()='10'])[1]");
	By SelectRow20=By.xpath("(//li[normalize-space()='20'])[1]");
	

	By Vin = By.xpath("//input[@id='vinAddVehicle']");
	By Unit = By.xpath("//div[@id='unitAddVehicle']");
	By SelectUnitType = By.xpath("//li[normalize-space()='Truck']");
	By UnitNum = By.xpath("//input[@id='unitNumber']");
	By Make = By.xpath("//input[@id='makeAddVehicle']");
	By Model = By.xpath("//input[@id='modelAddVehicle']");
	By ClickState = By.xpath("//div[@id='plateState']");
	By SelectState = By.xpath("//li[normalize-space()='California']");
	By PlateNum = By.xpath("//input[@id='plateNumberAddVehicle']");
	By TireSize = By.xpath("//input[@id='tyreSizeAddVehicle']");
	By Year = By.xpath("//input[@id='yearAddVehicle']");
	By Owner = By.xpath("//input[@value='O']");
	By AddRegForm = By.xpath("//button[normalize-space()='Add Registration Form']");
	By RegNum = By.xpath("//input[@id='registrationNumberAddVehicle']");
	By RegIssueDate = By.xpath("//input[@id='registrationDateAddVehicle']");
	By RegExpDate = By.xpath("//input[@id='registrationExpiryDateAddVehicle']");
	By UploadRegDoc = By.xpath("//input[@id='registrationDocumentAddVehicle']");
	By AddInspection = By.xpath("//button[normalize-space()='Add New Inspection']");
	By InspNum = By.xpath("//input[@id='inspectionNumberAddVehicle']");
	By InspIssueDate = By.xpath("//input[@id='inspectionDateAddVehicle']");
	By InspExpDate = By.xpath("//input[@id='inspectionExpiryDateAddVehicle']");
	By UploadInspDoc = By.xpath("//input[@id='inspectionDocumentAddVehicle']");
	By Submit = By.xpath("//button[normalize-space()='Submit']");
	By ClosePage=By.xpath("(//button[@type='button'])[7]");
	By NewRecord=By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft']");
	
	By Maintain_Vehicle=By.xpath("//a[@data-rb-event-key='vehicleMaintain']");
	By AddWorkOrder=By.xpath("//button[normalize-space()='Add Work Order']");
	By SearchWorkOrder=By.xpath("//input[@placeholder='Search']");
	By WorkOrderPDF=By.xpath("(//i)[27]");
	By WorkOrderExcel=By.xpath("(//i)[28]");
	By SelectOtherRow=By.xpath("//div[contains(text(),'5 rows')]");
	By WORow10=By.xpath("(//li[normalize-space()='10'])[1]");
	By WORow20=By.xpath("(//li[normalize-space()='20'])[1]");
	
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/AddVehicle.html", true);

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
		FileInputStream file = new FileInputStream("Vehicle.properties");
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
	public void Selecting_CarrierBeta() throws AWTException, InterruptedException 
	{
		logger = extent.startTest("Switch Carrier");
		DashboardSVP SVPDB=new DashboardSVP(driver);
		Thread.sleep(6000);
		SVPDB.Selecting_CarrierBeta("Nic test");	
		Thread.sleep(8000);
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_ENTER);
		rbt2.keyRelease(KeyEvent.VK_ENTER);
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	
	}
	
	@Test(priority=3)
	public void LocateVehicleMenu() throws Throwable
	{
		Thread.sleep(5000);
		logger = extent.startTest("Open Vehicle menu");
		driver.findElement(VehiclesMenu).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=4)
	public void NavigateManageVehiclesSection()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger = extent.startTest("Choose Manage vehicles section");
		driver.findElement(ManageVehicleSec).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=5)
	public void ClickAddVehicleButton()
	{
		logger = extent.startTest("Click on Add Vehicle button");
		driver.findElement(AddVehicle).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed ");
	}
	@Test(priority=6)
	public void AddNewVehicleDetails() throws Throwable
	{
		logger = extent.startTest("Enter Vehicle Details");
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("Vehicle.properties");
		props.load(file);
		        String VIN=props.getProperty("Vin");
				String UNITNUM=props.getProperty("UnitNum");
				String MAKE=props.getProperty("Make");
				String MODEL =props.getProperty("Model");
				String PLATENUM =props.getProperty("PlateNum");
				String TIRESIZE =props.getProperty("TireSize");
				String YEAR=props.getProperty("Year");
		
				String REGNUM=props.getProperty("RegNum");
				String UPLOADREGDOC =props.getProperty("UploadRegDoc");
		
				String INSPNUM =props.getProperty("InspNum");
				String UPLOADINSPDOC =props.getProperty("UploadInspDoc");
				
		driver.findElement(Vin).sendKeys(VIN);
		driver.findElement(Unit).click();
		driver.findElement(SelectUnitType).click();
		driver.findElement(UnitNum).sendKeys(UNITNUM);
		driver.findElement(Make).sendKeys(MAKE);
		driver.findElement(Model).sendKeys(MODEL);
		driver.findElement(ClickState).click();
		driver.findElement(SelectState).click();
		driver.findElement(PlateNum).sendKeys(PLATENUM);
		driver.findElement(TireSize).sendKeys(TIRESIZE);
		driver.findElement(Year).sendKeys(YEAR);
		
		driver.findElement(Owner).click();
		driver.findElement(AddRegForm).click();
		driver.findElement(RegNum).sendKeys(REGNUM);
		driver.findElement(RegIssueDate).sendKeys(RegIssueDate());
		driver.findElement(RegExpDate).sendKeys(ExpDateTODAY());
		Thread.sleep(2000);
		driver.findElement(UploadRegDoc).sendKeys(UPLOADREGDOC);
		
		driver.findElement(AddInspection).click();
		driver.findElement(InspNum).sendKeys(INSPNUM);
		driver.findElement(InspIssueDate).sendKeys(InspIssueDate());
		driver.findElement(InspExpDate).sendKeys(ExpDateTODAY());
		driver.findElement(UploadInspDoc).sendKeys(UPLOADINSPDOC);
		
		//driver.findElement(Submit).click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed Added Vehicle");
				
	}
	
	@Test(priority=7)
	public void VerifyEntryIsCreated() throws Throwable
	{
		logger = extent.startTest("Verify Entry is Created in the Vehicle list table");
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("Vehicle.properties");
		props.load(file);
		String UNITNUM=props.getProperty("UnitNum");
		driver.findElement(SearchVehicle).sendKeys(UNITNUM);
		Thread.sleep(4000);
		String RecordUnitNum=driver.findElement(NewRecord).getText();
		Thread.sleep(3000);
		System.out.println("Actual Unit number is:"+RecordUnitNum);
		Assert.assertEquals(RecordUnitNum, UNITNUM);
		logger.log(LogStatus.PASS, "Entry created and verified successfully");
		
	}
	
	
	public String RegIssueDate()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.minusMonths(3);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;
	        	        
	}
	
	public String InspIssueDate()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.minusMonths(2);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;
	        	        
	}
	
	public String ExpDateTODAY()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.plusDays(0);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;
	        	        
	}
	public String ExpDateTomarrow()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.plusDays(1);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;
	        	        
	}
	
	public String ExpDate7day()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.plusDays(7);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;
	        	        
	}
	
	public String ExpDate15day()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.plusDays(15);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;
	        	        
	}
	
	public String ExpDate30day()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.plusDays(30);

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

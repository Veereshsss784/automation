package FD360TC;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.TextReporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;
import FD360POM.HomePageOfCarrier.RandomNameGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import sample.ExtentReportsClass;


public class SubmitClientForm
{	 

	By ManageClients=By.xpath("//span[.='Manage Clients']");  //(//span[normalize-space()='Manage Clients'])[1]
	By Client_list=By.xpath("//div[@class='card card1']");  
	By Setup_client=By.xpath("//a[@data-rb-event-key='SetupClient']");
	By EnterDOT=By.xpath("//input[@id='dot_number']");
	By CheckDotNumber=By.xpath("//button[.='Check Dot Number']");

// Enter Company Details	
	By LegalName=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[3]");
	By legalnametext = By.xpath("//input[@id='legalNameProfile']");
	By ComapnyName=By.xpath("//input[@id='companyName']"); 
	
	By CompEmail=By.xpath("//input[@name='companyEmail']");      
	By MC_No=By.xpath("//input[@name='mcNumber']");
	
// Enters Address Details 	
	By Address1= By.xpath("//input[@name='address1']");
	By Address2= By.xpath("//input[@name='address2']");
	By City=By.xpath("//input[@name='city']");
	By Zipcode=By.xpath("//input[@name='zipCode']");
	By State=By.xpath("//div[@id='companyState']");
	
// Enter Owner Information	
	By FirstName=By.xpath("//input[@name='firstName']");
	By MiddleName=By.xpath("//input[@name='middleName']");
	By LastName=By.xpath("//input[@name='lastName']");
	By PhoneNumber=By.xpath("//input[@name='phone']");
	By Emailaddrs=By.xpath("//input[@name='email']");
	
	
// Enter General Information
	By Sales_Person=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[2]");  
	By Account_Manager=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[3]");
	
//	Please Choose Any one Option CDL Packages and Non Non CDL Packages 
	By CDL_Package=By.xpath("//p[.='CDL Packages:']");
	
	By CDL_FAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[1]");   //$1171
	By CDL_BAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[2]");   //$772
	By CDL_CP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[3]");    //$604
	
	By NonCDL_Package=By.xpath("//p[.='Non - CDL Packages:']");
	
	By NonCDL_FAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[4]");  //$997
	By NonCDL_BAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[5]");  //$372
	
// Please Choose Individual Products
	By MCReinstatemen_$180=By.xpath("(//li[@class='col-lg-4 col-md-6'])[1]");
	By MCUndismissal_$180=By.xpath("(//li[@class='col-lg-4 col-md-6'])[2]");
	By DOT_DOT_Pin_MC_$399=By.xpath("(//li[@class='col-lg-4 col-md-6'])[3]");
	By Supervisor_Training_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[4]");
	By DQ_File_$199=By.xpath("(//li[@class='col-lg-4 col-md-6'])[5]");
	By Drug_Alcohol_Consortium_$185=By.xpath("(//li[@class='col-lg-4 col-md-6'])[6]");
	By BOC3_Filing_$69=By.xpath("(//li[@class='col-lg-4 col-md-6'])[7]");
	By UCR_Filing_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[8]");
	By Filing_Fee_OrApp_Change_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[9]");
	By Clearinghouse_Registration_$215=By.xpath("(//li[@class='col-lg-4 col-md-6'])[10]");
	By Zero_Driver_Maintenance_Fee_$0=By.xpath("(//li[@class='col-lg-4 col-md-6'])[11]");
	
	
// Heavy Use Tax Products	
	By Oregon_WDT_$276=By.xpath("(//li[@class='col-lg-4 col-md-6'])[12]");
	By New_York_HUT_$150=By.xpath("(//li[@class='col-lg-4 col-md-6'])[13]");
	By New_Mexico_WDT_$150=By.xpath("(//li[@class='col-lg-4 col-md-6'])[14]");
	By Kentucky_KYU_$150=By.xpath("(//li[@class='col-lg-4 col-md-6'])[15]");
	By Federal_2290_HVUT_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[16]");
	
	
	
 //By Individual_products=By.xpath("//input[@value='Filing Fee / App Change']");  //$99
	
// Heavy Use tax Products
	By Heavy_Use_tax_Products=By.xpath("//input[@value='Federal 2290 (HVUT)']");   //$99
	
// Please Enter the Number of Drivers 
	By EnterNoOfDrivers=By.xpath("//input[@id='driverCountField']");
	
	By Package_fee=By.xpath("//div[@style='display: flex; justify-content: space-between; font-size: 18px; margin-top: 10px;']");
	By Addtional_Individual_Product=By.xpath("(//div[@style='display: flex; justify-content: space-between; font-size: 18px;'])[1]");
	By Fee_per_driver_per_month=By.xpath("(//div[@style='display: flex; justify-content: space-between; font-size: 18px;'])[2]");
	
	By Total_Ammount_Payable=By.xpath("//div[@style='display: flex; justify-content: space-between;']");
	
	By Proceed_To_Checkout=By.xpath("(//button[@type='submit'])[2]");
	
	
	By FleetLogout=By.xpath("//i[@class='icon-power']");    
	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 9999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%06d", number);
	}
	
	
	private String generateChar1() 
	{
		String uuid1 = UUID.randomUUID().toString();
		uuid1 = uuid1.substring(0, Math.min(uuid1.length(), 2));
		System.err.print(uuid1);
		return uuid1;
	}	
	   

	private String generateChar() 
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 5));
		System.err.print(uuid);
		return uuid;
	}
	
//-------------------------------------------------------------------------------------------------------------------------------
	ExtentReports extent;
	ExtentTest logger;
	//WebDriver driver;
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/VS02CarrierOnboarded.html", true);

		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Veeresh");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);

		return destination;

	}
	
	WebDriver driver;
	
	
	String FleetDev="https://dev.fleetdrive360.com/login";//http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";
	
	@Test(priority=1)
	@SuppressWarnings("unused")
	public void LoginSVP() throws AWTException, InterruptedException
	{
		logger = extent.startTest("carrieer register Page");
		logger.log(LogStatus.INFO, "To verify that SVP is able to onboard a Client/Carrier");
		String key="webdriver.chrome.driver";
		String value="./software/chromedriver.exe";
		System.setProperty(key,value);
		ChromeDriver driver =new ChromeDriver();
		
	
	//  Application classes
	    LoginSVP LoginFleet=new LoginSVP(driver);
	    DashboardSVP SVPDB=new DashboardSVP(driver);
	    HomePageOfCarrier Carrier_Space=new HomePageOfCarrier(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(FleetBeta);
	
	
	// Login as Service Provider
		LoginFleet.printTitle();
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);                 // oliver_1  : AdhEJRXtN9
		  
		Thread.sleep(2000);
		driver.findElement(ManageClients).click();
		driver.findElement(Client_list).getText();
		System.out.println(driver.findElement(Client_list).getText());
		driver.findElement(Setup_client).click();
		driver.findElement(EnterDOT).sendKeys(getRandomNumberString());
		System.out.println("DOT is:"+getRandomNumberString());
		driver.findElement(CheckDotNumber).click();
		Thread.sleep(10000);
		String CompanyName= RandomNameGenerator.generateRandomCompanyName();
		driver.findElement(ComapnyName).sendKeys(CompanyName);
		String CL_name= driver.findElement(legalnametext).getText();
		System.out.println("leagal name is : "+CL_name);
		String Company_legalName=driver.findElement(LegalName).getText();
		System.out.println("Company legal name is"+Company_legalName);
		driver.findElement(LegalName).sendKeys("_LN"+CompanyName);
		driver.findElement(CompEmail).sendKeys(CompanyName+"@innowyze.testinator.com");
		driver.findElement(MC_No).sendKeys(getRandomNumberString());
		
		//Thread.sleep(3000);
		
		driver.findElement(Address1).sendKeys("_address1 is "+generateChar1());
		driver.findElement(Address2).sendKeys("_address2 is "+generateChar1());
		driver.findElement(City).sendKeys("Los angeles");
		
		driver.findElement(Zipcode).click();
		Thread.sleep(1000);
		String zip=driver.findElement(Zipcode).getAttribute("value");
		if(zip.isEmpty())
		{
			driver.findElement(Zipcode).sendKeys("90001");
		}
		else
		{
		
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_CONTROL);
		rbt2.keyPress(KeyEvent.VK_A);
		rbt2.keyRelease(KeyEvent.VK_A);
		rbt2.keyRelease(KeyEvent.VK_CONTROL);
		rbt2.keyPress(KeyEvent.VK_DELETE);
		rbt2.keyRelease(KeyEvent.VK_DELETE);
		driver.findElement(Zipcode).sendKeys("90001");
		}
		
		driver.findElement(State).isEnabled();
		driver.findElement(State).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//li[.='California']")).click();
		
		String randomName = RandomNameGenerator.generateRandomName();
		String EmailName=randomName;
        String randomSurname = RandomNameGenerator.generateRandomSurname();
       
		driver.findElement(FirstName).sendKeys(randomName);
		System.out.println("VCarrier"+generateChar());
		driver.findElement(MiddleName).sendKeys(generateChar1());
		System.out.println(generateChar1());
		driver.findElement(LastName).sendKeys(randomSurname);
	    System.out.println(generateChar());
	    driver.findElement(PhoneNumber).sendKeys("4042"+getRandomNumberString());
	    driver.findElement(Emailaddrs).sendKeys("Veereshtestit3@gmail.com");
	    driver.findElement(Sales_Person).click();
	    driver.findElement(Sales_Person).sendKeys(Keys.ENTER);
		
	    driver.findElement(Account_Manager).click();
	    driver.findElement(Account_Manager).sendKeys(Keys.ENTER);
	    driver.findElement(CDL_FAP).click();
	    Thread.sleep(1000);
	    driver.findElement(EnterNoOfDrivers).clear();
	    Thread.sleep(1000);
	    driver.findElement(EnterNoOfDrivers).sendKeys("");
	    String Ammount=driver.findElement(Total_Ammount_Payable).getText();
    	System.out.println(Ammount+"Total Amount");
    	Thread.sleep(2000);
    	driver.findElement(Proceed_To_Checkout).click();
    	
    	String Expected = driver.getTitle();
		System.out.println(Expected);
		String Actual = "FleetDrive 360 Inc";
		System.out.println(Expected);
		
		
		WebElement amount = driver.findElement(By.xpath("//span[@id='OrderDetailsFooter-SubtotalAmount']/../span[2]"));
		String AmountInPaymentPage = amount.getText();
		System.out.println(AmountInPaymentPage);
		
	
		WebElement CardNo = driver.findElement(By.xpath("//*[@id='cardNumber']"));
		CardNo.sendKeys("4242424242424242");
		WebElement mmAndyy = driver.findElement(By.xpath("//*[@id='cardExpiry']"));
		mmAndyy.sendKeys("1132");
		WebElement cvcNo = driver.findElement(By.xpath("//*[@id='cardCvc']"));
		cvcNo.sendKeys("124");
		WebElement NameOfCard = driver.findElement(By.xpath("//*[@id='billingName']"));
		NameOfCard.sendKeys("VeereshSalagar");

		WebElement ele = driver.findElement(By.xpath("//select[@id='billingCountry']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("United States");

		WebElement zipCode = driver.findElement(By.xpath("//*[@id='billingPostalCode']"));
		zipCode.sendKeys("41235");
		WebElement subscribe = driver.findElement(By.xpath("//div[@class='SubmitButton-IconContainer']"));
		subscribe.click();
	    
		Thread.sleep(5000);
		driver.findElement(FleetLogout).click();
		logger.log(LogStatus.PASS, "Carrier onboarded successfully");
		
	}
	}
	@AfterMethod
	public void getResult(ITestResult result) throws Exception 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

			String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		
	    } 
		else if (result.getStatus() == ITestResult.SKIP) 
		{
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			logger.log(LogStatus.SKIP, "Test Case Failed is " + result.getThrowable());

			String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

			logger.log(LogStatus.SKIP, logger.addScreenCapture(screenshotPath));
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
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
}    //   Check Email of - Owner, Admin, Fleet Manager
               // for Dev SVP- 
               // for Dev USC-



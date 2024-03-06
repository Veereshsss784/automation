package FD360DriverLogin;

import java.awt.AWTException;
import java.awt.KeyEventPostProcessor;
import java.awt.Robot;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import FD360SignUp.Registration;

public class DriverLogin {

	
public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;

	@BeforeTest
	public void StartReport() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/360DriverLogin.html", true);
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
	@Test(priority = 1)
	public void UserDetails() throws AWTException, InterruptedException {
		logger = extent.startTest("Enter Login Details");

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "OpenBrowser test is intiated.");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "Browser is opned and window is maximized");
		

		driver.get("http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply/");
		WebDriverWait wait=new WebDriverWait(driver,10);
		
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
		wait.until(ExpectedConditions.visibilityOf(Username));
		Username.sendKeys("veeresh1");
		WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
		Password.sendKeys("2@I5TCYHwr");
		WebElement Login = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/form/button"));
		Login.click();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Successfully Submited the Driver Login details ");
		System.out.println("Successfully Submited the Driver Login details");
	
    	// Driver Application page
		Thread.sleep(3000);
		WebElement OnlineApplication = driver.findElement(By.xpath("//input[@value='Online_Application']"));
		wait.until(ExpectedConditions.visibilityOf(OnlineApplication));
		OnlineApplication.click();

		WebElement submit = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		submit.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "PopUp-Online application selected");
		System.out.println("PopUp-Online application selected successfully");  
	}

	@Test(priority = 2)
	public void DriverInfo() throws Exception {
		// 1 General information Form
		// 1.1 Driver information From
		
		WebDriverWait wait=new WebDriverWait(driver,10);

		test.log(LogStatus.INFO, "Filling Basic info of Driver");
		WebElement FirstName = driver.findElement(By.xpath("//*[@id='firstName']"));
		wait.until(ExpectedConditions.visibilityOf(FirstName));
		FirstName.clear();
		FirstName.sendKeys("smith");
		WebElement MiddleName = driver.findElement(By.xpath("//*[@id='middleName']"));
		MiddleName.clear();
		MiddleName.sendKeys("v");
		WebElement LastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		LastName.clear();
		LastName.sendKeys("will");
		WebElement DOB = driver.findElement(By.xpath("//input[@id='dateOfBirth']"));
		wait.until(ExpectedConditions.visibilityOf(DOB));
		DOB.click();
		
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_0);
		rbt.keyRelease(KeyEvent.VK_0);
		rbt.keyPress(KeyEvent.VK_4);
		rbt.keyRelease(KeyEvent.VK_4);
		rbt.keyPress(KeyEvent.VK_1);
		rbt.keyRelease(KeyEvent.VK_1);
		rbt.keyPress(KeyEvent.VK_4);
		rbt.keyRelease(KeyEvent.VK_4);
		rbt.keyPress(KeyEvent.VK_1);
		rbt.keyRelease(KeyEvent.VK_1);
		rbt.keyPress(KeyEvent.VK_9);
		rbt.keyRelease(KeyEvent.VK_9);
		rbt.keyPress(KeyEvent.VK_9);
		rbt.keyRelease(KeyEvent.VK_9);
		rbt.keyPress(KeyEvent.VK_6);
		rbt.keyRelease(KeyEvent.VK_6);
		WebElement SSNo = driver.findElement(By.xpath("//*[@id='ssnNumber']"));
		SSNo.sendKeys("784784833");
		WebElement Phone = driver.findElement(By.xpath("//input[@id='phone']"));
		Phone.sendKeys("2163547758");
		WebElement SaveAndNext = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndNext.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver information page is filled and submitted successfully");
		System.out.println("Driver information page is submitted successfully");

	}

	// 1.2 Enter past 3 years of residence address history
	@Test(priority = 3)
	public void ResidenceAddressHistory() throws InterruptedException {
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Filling Basic info of Driver");

		WebElement AddressLine1 = driver.findElement(By.xpath("//*[@id='driveraddress_10']"));
		AddressLine1.sendKeys("384 Northyards Blvd NW Bldg. 100 Suite 190, Atlanta GA 30313");

		WebElement AddressLine2 = driver.findElement(By.xpath("//*[@id='driveraddress_20']"));
		AddressLine2.sendKeys("384 Northyards Blvd NW Bldg. 100 Suite 190, Atlanta GA 30313");

		WebElement City = driver.findElement(By.xpath("//*[@id='drivercity']"));
		City.sendKeys("Atlanta");

		WebElement State = driver.findElement(By.xpath("//*[@id='driverstate']"));
		State.click();
		WebElement ele = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[12]"));
		ele.click();

		WebElement ZipCode = driver.findElement(By.xpath("//*[@id='driverzipCode']"));
		ZipCode.sendKeys("2163547");

		WebElement NOofYearsInThisAddress = driver.findElement(By.xpath("//*[@id='drivernoOfYears']"));
		NOofYearsInThisAddress.sendKeys("4");

		WebElement SaveAndNext = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndNext.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver Address information page is filled and submitted successfully");
		System.out.println("Driver Address information page is submitted successfully");
	} 

	// 1.3 Driver License details
	@Test(priority = 4)
	public void DriverLicenseDetails() throws AWTException, InterruptedException {
		Thread.sleep(3000);

		test.log(LogStatus.INFO, "Filling info of DriverLicense");
		Thread.sleep(2000);

		WebElement IssueState = driver.findElement(By.xpath("//div[@id='licenseissueState0']"));
		IssueState.click();
		WebElement state = driver.findElement(By.xpath("//li[.='California']"));
		state.click();

		Thread.sleep(2000); 

/*	 WebElement LicenseNO =driver.findElement(By.xpath("//*[@id='licensedriverLicenseNumber0']"));
		   LicenseNO.sendKeys("");  */
		

		WebElement LicenseClass = driver.findElement(By.xpath("//div[@id='licenselicenseClass0']"));
		LicenseClass.click();

		WebElement Class = driver.findElement(By.xpath("//li[.='Class C']"));
		Class.click();

		WebElement Endorsement = driver.findElement(By.xpath("//input[@id='licenseendorsement0']"));
		Endorsement.sendKeys("special2");

		Thread.sleep(3000);
		WebElement IssueDate = driver.findElement(By.xpath("//*[@id='licenseissueDate0']"));
		IssueDate.click();
		Robot rbt1 = new Robot();
		rbt1.keyPress(KeyEvent.VK_0);
		rbt1.keyRelease(KeyEvent.VK_0);
		rbt1.keyPress(KeyEvent.VK_3);
		rbt1.keyRelease(KeyEvent.VK_3);
		rbt1.keyPress(KeyEvent.VK_0);
		rbt1.keyRelease(KeyEvent.VK_0);
		rbt1.keyPress(KeyEvent.VK_1);
		rbt1.keyRelease(KeyEvent.VK_1);
		rbt1.keyPress(KeyEvent.VK_2);
		rbt1.keyRelease(KeyEvent.VK_2);
		rbt1.keyPress(KeyEvent.VK_0);
		rbt1.keyRelease(KeyEvent.VK_0);
		rbt1.keyPress(KeyEvent.VK_1);
		rbt1.keyRelease(KeyEvent.VK_1);
		rbt1.keyPress(KeyEvent.VK_6);
		rbt1.keyRelease(KeyEvent.VK_6);

		WebElement ExpDate = driver.findElement(By.xpath("//*[@id='licenseexpirationDate0']"));
		ExpDate.click();

		Thread.sleep(2000);
		Robot rbt2 = new Robot();
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_3);
		rbt2.keyRelease(KeyEvent.VK_3);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_4);
		rbt2.keyRelease(KeyEvent.VK_4);

		WebElement Restrictions = driver.findElement(By.xpath("//input[@id='licenserestrictions0']"));
		Restrictions.sendKeys("some restrictions");

		Thread.sleep(5000);
		WebElement UploadDLFrontside = driver.findElement(By.xpath("(//input[@id='driverLicenseDocument'])[1]"));
		Thread.sleep(3000);
		UploadDLFrontside.sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\License.png");
		Thread.sleep(3000);

		WebElement UploadDLBackside = driver.findElement(By.xpath("//input[@id='driverLicenseDocumentBack']"));
		Thread.sleep(3000);
		UploadDLBackside.sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\LicenseBackSide.png");

		WebElement SaveAndSubmit = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndSubmit.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver License datails page is filled and submitted successfully");
		System.out.println("Driver License info page is submitted successfully");  
	} 

	// 1.4 Driving Equipments
	@Test(priority = 5)
	public void DrivingEquipment() throws Exception {
		test.log(LogStatus.INFO, "Filling info of DriverLicense");

		WebElement DrivingExp = driver.findElement(By.xpath("//input[@id='previousEquipmentYes']"));
		DrivingExp.click();

		WebElement commercialDriverSince = driver.findElement(By.xpath("//input[@id='commercialDriverSince']"));
		commercialDriverSince.sendKeys("2019");
		WebElement commercialDriverExperience = driver.findElement(By.xpath("//input[@id='commercialDriverExperience']"));
		commercialDriverExperience.sendKeys("2");
		WebElement CheckBox = driver.findElement(By.xpath("//input[@value='Fire Truck']"));
		CheckBox.click();

		WebElement EquipmanetType = driver.findElement(By.xpath("//input[@id='equipmentequipmentType0']"));
		EquipmanetType.sendKeys("FireTruck");

		Thread.sleep(4000);
		WebElement From = driver.findElement(By.xpath("//input[@id='equipmentoperatedFrom0']"));
		From.click();

		Robot rbt3 = new Robot();
		rbt3.keyPress(KeyEvent.VK_0);
		rbt3.keyRelease(KeyEvent.VK_0);
		rbt3.keyPress(KeyEvent.VK_3);
		rbt3.keyRelease(KeyEvent.VK_3);
		rbt3.keyPress(KeyEvent.VK_0);
		rbt3.keyRelease(KeyEvent.VK_0);
		rbt3.keyPress(KeyEvent.VK_1);
		rbt3.keyRelease(KeyEvent.VK_1);
		rbt3.keyPress(KeyEvent.VK_2);
		rbt3.keyRelease(KeyEvent.VK_2);
		rbt3.keyPress(KeyEvent.VK_0);
		rbt3.keyRelease(KeyEvent.VK_0);
		rbt3.keyPress(KeyEvent.VK_1);
		rbt3.keyRelease(KeyEvent.VK_1);
		rbt3.keyPress(KeyEvent.VK_9);
		rbt3.keyRelease(KeyEvent.VK_9);

		WebElement To = driver.findElement(By.xpath("//input[@id='equipmentoperatedTo0']"));
		To.click();

		Robot rbt4 = new Robot();
		rbt4.keyPress(KeyEvent.VK_0);
		rbt4.keyRelease(KeyEvent.VK_0);
		rbt4.keyPress(KeyEvent.VK_3);
		rbt4.keyRelease(KeyEvent.VK_3);
		rbt4.keyPress(KeyEvent.VK_0);
		rbt4.keyRelease(KeyEvent.VK_0);
		rbt4.keyPress(KeyEvent.VK_1);
		rbt4.keyRelease(KeyEvent.VK_1);
		rbt4.keyPress(KeyEvent.VK_2);
		rbt4.keyRelease(KeyEvent.VK_2);
		rbt4.keyPress(KeyEvent.VK_0);
		rbt4.keyRelease(KeyEvent.VK_0);
		rbt4.keyPress(KeyEvent.VK_2);
		rbt4.keyRelease(KeyEvent.VK_2);
		rbt4.keyPress(KeyEvent.VK_1);
		rbt4.keyRelease(KeyEvent.VK_1);

		WebElement ApproximateNoOfTotalMiles = driver.findElement(By.xpath("//input[@id='equipmentmiles0']"));
		ApproximateNoOfTotalMiles.sendKeys("54321");

		WebElement SaveAndNext = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndNext.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver Equipment And Expirience datails page is filled and submitted successfully");
		System.out.println("Driver Equipment And Expirience info page is submitted successfully");

	}

	// 1.5 Accidents
	@Test(priority = 6)
	public void Accidents() {
		test.log(LogStatus.INFO, "Filling info of DriverAccsidents");

		WebElement No = driver.findElement(By.xpath("//input[@id='previousAccidentNo']"));
		No.click();
		WebElement SaveAndNext = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndNext.click();
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver DriverAccsidentssubmitted successfully");
		System.out.println("Driver DriverAccsidents submitted successfully");
	}

	// 1.6 Driver Traffic violations

	@Test(priority = 7)
	public void TrafficVoilations() {
		test.log(LogStatus.INFO, "Filling info of TrafficVoilations");

		WebElement No1 = driver.findElement(By.xpath("//input[@id='previousConvictionNo']"));
		No1.click();
		WebElement SaveAndNext = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndNext.click();
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver TrafficVoilations form submitted successfully");
		System.out.println("Driver TrafficVoilations submitted successfully");
	}

	// 1.7 Adverse Licensing Actions
	@Test(priority = 8)
	public void AdverseLicensingActions() {
		test.log(LogStatus.INFO, "Filling info of AdverseLicensingActions");

		WebElement No2 = driver.findElement(By.xpath("//input[@id='licenseSuspendedOrRevokedNo']"));
		No2.click();

		WebElement No3 = driver.findElement(By.xpath("//input[@id='licenseDeniedNo']"));
		No3.click();

		WebElement SaveAndNext = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndNext.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver AdverseLicensingActions form submitted successfully");
		System.out.println("Driver AdverseLicensingActions form submitted successfully");
	}

	// 1.8 EmploymentRecord
	@Test(priority = 9)
	public void EmploymentRecord() {
		test.log(LogStatus.INFO, "Filling info of EmploymentRecord");

		WebElement No4 = driver.findElement(By.xpath("//input[@id='priorExperienceNo']"));
		No4.click();

		WebElement No5 = driver.findElement(By.xpath("//input[@id='priorExperience10YearNo']"));
		No5.click();

		WebElement SaveAndNext = driver.findElement(By.xpath("//button[.='Save & Next']"));
		SaveAndNext.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver EmploymentRecord form submitted successfully");
		System.out.println("Driver EmploymentRecord form submitted successfully");

	}

	// 1.9 Physical History
	@Test(priority = 10)
	public void PhysicalHistory() throws InterruptedException, AWTException {
		test.log(LogStatus.INFO, "Filling info of Driver Physical History");
		WebElement MedicalCertificate = driver.findElement(By.xpath("//input[@id='medicalCertificateDocument']"));
		MedicalCertificate.sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\MedicalCertificates.png");

		WebElement MCIssueDate = driver.findElement(By.xpath("//input[@id='medicalissueDate']"));
		MCIssueDate.click();
		Robot rbt5 = new Robot();
		rbt5.keyPress(KeyEvent.VK_0);
		rbt5.keyRelease(KeyEvent.VK_0);
		rbt5.keyPress(KeyEvent.VK_3);
		rbt5.keyRelease(KeyEvent.VK_3);
		rbt5.keyPress(KeyEvent.VK_0);
		rbt5.keyRelease(KeyEvent.VK_0);
		rbt5.keyPress(KeyEvent.VK_1);
		rbt5.keyRelease(KeyEvent.VK_1);
		rbt5.keyPress(KeyEvent.VK_2);
		rbt5.keyRelease(KeyEvent.VK_2);
		rbt5.keyPress(KeyEvent.VK_0);
		rbt5.keyRelease(KeyEvent.VK_0);
		rbt5.keyPress(KeyEvent.VK_1);
		rbt5.keyRelease(KeyEvent.VK_1);
		rbt5.keyPress(KeyEvent.VK_9);
		rbt5.keyRelease(KeyEvent.VK_9);

		WebElement MCExpDate = driver.findElement(By.xpath("//input[@id='medicalexpirationDate']"));
		MCExpDate.click();

		Thread.sleep(2000);
		Robot rbt2 = new Robot();
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_3);
		rbt2.keyRelease(KeyEvent.VK_3);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_8);
		rbt2.keyRelease(KeyEvent.VK_8);

		WebElement No5 = driver.findElement(By.xpath("//input[@id='limitedPhysicalAbilityNo']"));
		No5.click();
		WebElement No6 = driver.findElement(By.xpath("//input[@id='testedPositiveDOANo']"));
		No6.click();
		WebElement No7 = driver.findElement(By.xpath("//input[@id='refusedToTestNo']"));
		No7.click();

		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver Physical history form submitted successfully");
		System.out.println("Driver Physical history form submitted successfully");
		
		Thread.sleep(4000);   

	}                     

	// 1.10 Consent Form
	@Test(priority=2)
	public void ConsentForm() throws InterruptedException, AWTException {
		test.log(LogStatus.INFO, "Filling info of Driver Physical History");

		Thread.sleep(3000);
		//	WebElement forms = driver.findElement(By.xpath("//div[@class='MuiAccordionSummary-content MuiAccordionSummary-contentGutters css-17o5nyn']"));
			
			/*List<WebElement> allOptions=	driver.findElements(By.xpath("//div[@class='MuiAccordionSummary-content MuiAccordionSummary-contentGutters css-17o5nyn']"));
			
			for(WebElement opt:allOptions)
			{
				opt.click();
				WebElement check1 = driver.findElement(By.xpath(
						"//span[.='I hereby agree to submit to required Substance Abuse Testing (drug and/or alcohol)']"));
				check1.click();
				
			}*/
		
		WebElement Agree1 = driver
				.findElement(By.xpath("//p[.='PRE-EMPLOYMENT DRUG/ALCOHOL TESTING NOTIFICATION & CONSENT']"));
		Agree1.click();
		
		
		WebElement check1 = driver.findElement(By.xpath(
				"//input[@type='checkbox' and @value='consent1Check']"));
		Thread.sleep(3000);
		check1.click();
		

		WebElement Agree2 = driver
				.findElement(By.xpath("//p[.='DOT SUBSTANCE ABUSE POLICY EMPLOYEE ACKNOWLEDGEMENT FORM']"));
		Agree2.click();
		WebElement check2 = driver.findElement(By.xpath(
				"//span[.='I understand and agree to the above terms and conditions of employment. I understand that the above in no way creates an obligation or contract of employment and that I, as well as the Company, have the right to end the employment relationship at any time.']"));
		check2.click();

		WebElement Agree3 = driver
				.findElement(By.xpath("//p[.='CONSENT FOR QUERIES OF THE FMCSA DRUG AND ALCOHOL TESTING']"));
		Agree3.click();
		WebElement check3 = driver.findElement(By.xpath("//span[.='I hereby give my Consent for the Above.']"));
		check3.click();

		WebElement Agree4 = driver
				.findElement(By.xpath("//p[.='DOT SUBSTANCE ABUSE POLICY CHEMICAL SCREENING CONSENT & RELEASE FORM']"));
		Agree4.click();
		WebElement check4 = driver.findElement(By.xpath(
				"//span[.='I hereby consent and allow the Company or its designated representative to verify and/or confirm the above information with the prescribing physician listed above. I certify that if I have been furnished a specimen kit, the bottle in that kit was personally given to me by the collection site or laboratory personnel and contained a specimen of my urine. Further, I attest that the specimen was sealed in my presence.']"));
		check4.click();

		WebElement Agree5 = driver
				.findElement(By.xpath("//p[.='CERTIFICATION OF COMPLIANCE WITH DRIVER LICENSE REQUIREMENTS']"));
		Agree5.click();
		WebElement check5 = driver
				.findElement(By.xpath("//span[.='I certify that I have read and understood the above requirements.']"));
		check5.click();

		WebElement Agree6 = driver.findElement(By.xpath(
				"//p[.='FMCSA PRE-EMPLOYMENT SCREENING PROGRAM (PSP) AUTHORIZATION IMPORTANT DISCLOSURE REGARDING BACKGROUND REPORTS FROM THE PSP ONLINE SERVICE']"));
		Agree6.click();
		WebElement check6 = driver.findElement(By.xpath(
				"//span[.='I have read the above Disclosure Regarding Background Reports provided to me by Prospective Employer and I understand that if I sign this Disclosure and Authorization, Prospective Employer may obtain a report of my crash and inspection history. I hereby authorize Prospective Employer and its employees, authorized agents, and/or affiliates to obtain the information authorized above.']"));
		check6.click();

		WebElement Agree7 = driver
				.findElement(By.xpath("//p[.='FleetDrive 360. FAIR CREDIT REPORTING ACT DISCLOSURE STATEMENT']"));
		Agree7.click();
		WebElement check7 = driver.findElement(By.xpath("(//span[.='I hereby give my Consent for the Above.'])[2]"));
		check7.click(); 
		
		Thread.sleep(2000);
		
		//signature 
		WebElement signatureele = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
		Actions act=new Actions(driver);
		Actions drawaction = act.moveToElement(signatureele, 50, 50);
		drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
		
		WebElement btn = driver.findElement(By.xpath("//button[.='Save & Next']"));
		btn.click();  
		driver.findElement(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
		
		WebElement signatureele2 = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
		
		Point loc = signatureele2.getLocation();
		int y = loc.getY();
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+y+")");
		Actions act2=new Actions(driver);
		Actions drawaction2 = act2.moveToElement(signatureele2, 50, 50);
		drawaction2.clickAndHold().moveByOffset(10, 30).release().perform(); 
		
		WebElement submitBtn2 = driver.findElement(By.xpath("//button[@id='SubmitDriverApplicationBtn']"));
		submitBtn2.click();
		
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Driver consent form submitted successfully");
		System.out.println("Driver Driver consent form submitted successfully");
		
		Thread.sleep(4000);   
	}
	
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

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case is skipped" + result.getName());
		}
		extent.endTest(logger);
	}

}
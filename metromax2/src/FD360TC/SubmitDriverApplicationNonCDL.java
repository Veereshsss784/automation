package FD360TC;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import FD360POM.DriverApplicationLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitDriverApplicationNonCDL 
{
	String FleetDev="https://dev.fleetdrive360.com/apply"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/apply";
	String FleetProd="https://app.fleetdrive360.com/apply";
	
	@Test
	public void Verify_Driver_login() throws Exception {

		String key = "webdriver.chrome.driver";
		String value = "./software/chromedriver.exe";
		System.setProperty(key, value);
		ChromeDriver driver = new ChromeDriver();
		
 /*
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");	
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
	*/	
		// Application Class
		DriverApplicationLogin DrApplnLogin = new DriverApplicationLogin(driver);

		driver.manage().window().maximize();
		Robot robot = new Robot();
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get(FleetDev);

		driver.get("https://usc-test.innowyze.in/login-check?token=85dba7a4d38b493ef");
		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login Page Opened successfully");

		// Form 1. Driver Information
		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.FillDriverinfo();
		Thread.sleep(3000);
		DrApplnLogin.SSN_Number("998900790");
		DrApplnLogin.click_Next();
		System.out.println("Form 1. Driver Information Stored successfully");

		// Form 2. Driver Address History
		// DrApplnLogin.Address1();
		// Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.Enter_Address_Line1();
		Thread.sleep(2000);
		DrApplnLogin.EnterCity();
		Thread.sleep(1000);
		DrApplnLogin.Select_State();
		DrApplnLogin.Zipcode("90001");
		DrApplnLogin.NoOfYrAtThisAddress();
		// DrApplnLogin.AllAddressDetailsinConsole();
		
		DrApplnLogin.AddressNext();
		System.out.println("Form 2. Driver Address History Stored successfully");
		
		// Form 3. Upload Front and Back of current Driver’s License / Permit
		// here
		Thread.sleep(5000);
		DrApplnLogin.DriverLicenseDetails();
		Thread.sleep(2000);
		DrApplnLogin.CurrentDL_Class();
	    //DrApplnLogin.CurrentDL_Class2();
		Thread.sleep(2000);
		DrApplnLogin.IssueDate();
		Thread.sleep(2000);
		DrApplnLogin.ExpDate();
		Thread.sleep(1000);
		DrApplnLogin.Restrictions();
		DrApplnLogin.Endorsements();
		DrApplnLogin.DLNextButton();
		System.out.println("Form 3. Upload Front and Back of current Driver’s License / Permit here Stored successfully");

		// Form 4.Commercial Driving and Equipment Experience
		Thread.sleep(5000);
		DrApplnLogin.CD_Experience();
		DrApplnLogin.From_Date();
		DrApplnLogin.ToDate();
		DrApplnLogin.Approximate_Total_Miles();
		DrApplnLogin.EquipmentExperienceNextButton();
		System.out.println("Form 4.Commercial Driving and Equipment Experience Stored successfully");

		// Form 5.Employment History
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.HaveCemmercialDrivingExpYes();
		DrApplnLogin.DriverEmplrInfo();
		DrApplnLogin.JoiningFromDate();
		DrApplnLogin.ResignedDate();
		DrApplnLogin.MoreInfoOfEmplyr();
		DrApplnLogin.EmpPhone();
		DrApplnLogin.EmplrEmail();
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		DrApplnLogin.SubjectToDrugAlcohol(); // Now dev
		DrApplnLogin.I_confirmConcentCheck();
		DrApplnLogin.AdditionalNonDriveExp();
		DrApplnLogin.AdditionalNonDriveExp();
		Thread.sleep(2000);
		DrApplnLogin.Employment_HistoryNext();
		Thread.sleep(3000);

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Form 5.Employment History Stored successfully");

		// Form 6.Traffic Violations
		Thread.sleep(3000);
		// DrApplnLogin.TrafficViolationsYes();
		DrApplnLogin.Traffic_ViolationNo();
		// DrApplnLogin.TrafficViolations_Location();
		// DrApplnLogin.TrafficViolationDate();
		// Thread.sleep(2000);//Issue with date
		// DrApplnLogin.ChargeAndPenalty();
		DrApplnLogin.TrafficViolations_Next();
		System.out.println("Form 6.Traffic Violations Stored successfully");

		// Form 7. Adverse Licensing Actions
		Thread.sleep(2000);
		DrApplnLogin.Operate_motor_vehicle_ever_been_suspended_No();
		// DrApplnLogin.Operate_motor_vehicle_ever_been_suspended_yes();
		driver.findElement(By.xpath("(//div[@class='radios_checkboxDiv__3WHHd'])[3]")).click();
		driver.findElement(By.xpath("(//div[@class='radios_checkboxDiv__3WHHd'])[3]")).click();

		DrApplnLogin.EverBeenDeniedLicence_yes();
		DrApplnLogin.Adverse_Licensing_Actions_Next();

		System.out.println("Form 7. Adverse Licensing Actions Stored successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Form 8.Accident History

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.involvedInAccidents_no();
		//driver.findElement(By.xpath("//input[@name='form.accidents.0.hazmatSpill']")).click();
		//driver.findElement(By.xpath("//input[@name='form.accidents.0.hazmatSpill']")).click();
		//DrApplnLogin.Hazmat_Spill_no(); // Hazmat Spill ? No
		// DrApplnLogin.AddEqipment();
	
		DrApplnLogin.Accident_HistoryNext();

		System.out.println("Form 8.Accident History Stored successfully");

		// Form 9. DOT Physical and Medical Certificate
		Thread.sleep(3000);
		DrApplnLogin.ValidDOTMC();
		DrApplnLogin.WishToUploadMC();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.UploadMedicalCertificate();
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		DrApplnLogin.MedicalCertificateIssueDate();
		DrApplnLogin.MedicalCertificateExpDate();
		DrApplnLogin.NameOfMedicalExaminer();
		DrApplnLogin.ExaminarNationalRegNumber();

		DrApplnLogin.LimitAbilityToPerformNo();

		DrApplnLogin.Past3YrsEverTestedPositiveNo();

		DrApplnLogin.Refused_to_take_TestNo();

		DrApplnLogin.DOT_Physical_and_Medical_Certificate_Next();
		System.out.println("Form 9. DOT Physical and Medical Certificate Stored successfully");
		Thread.sleep(5000);
		
        // Form 10. MVR Consent Forms
		DrApplnLogin.MVR_Consent_form();
		Thread.sleep(2000);
		DrApplnLogin.MVR_Sig();
		DrApplnLogin.MVR_Next();
		System.out.println("Form 11. MVR Consent Forms Stored successfully");

        // Form 11. Consent Forms
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.Consent_Forms();
		DrApplnLogin.signature();
		DrApplnLogin.ConsentForms_Next();
		Thread.sleep(3000);
		System.out.println("Form 11. Consent Forms Stored successfully");

		// Form 12.To Be Read and Signed By Applicant
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.ToBeReadAndSignedByApplicant();
		DrApplnLogin.signature();
		DrApplnLogin.ToBeReadAndSignedByApplicant_submit();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DrApplnLogin.ApplicationStatus();
		DrApplnLogin.downloadDriverApplication();
		System.out.println("Form 12.To Be Read and Signed By Applicant Stored successfully");
		System.out.println("Driver Application submitted successfully");
		Thread.sleep(6000);
		driver.close();
		
	}
 
} //   Check Email of - Owner, Admin, Fleet Manager
      // for Dev SVP- Driver  
      // for Dev USC- Driver 




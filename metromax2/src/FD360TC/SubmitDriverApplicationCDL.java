package FD360TC;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import FD360POM.DriverApplicationLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitDriverApplicationCDL 
{
	String FleetDev="https://dev.fleetdrive360.com/apply"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/apply";
	String FleetProd="https://app.fleetdrive360.com/apply";
	
	@Test
	public void Verify_Driver_login() throws Exception
	{
		
	/*	String key="webdriver.chrome.driver";
		String value="./software/chromedriver.exe";
		System.setProperty(key,value);
		ChromeDriver driver =new ChromeDriver();
	*/	
		String key="webdriver.chrome.driver";
		String value="./software/chromedriver.exe";
		System.setProperty(key,value);
		ChromeDriver driver =new ChromeDriver(); 
		//Application Class 
		DriverApplicationLogin DrApplnLogin=new DriverApplicationLogin(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://compliance.fleetsmartcarrierservices.com/login-check?token=e735707a1a811cf43ed237f7523"); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Login Page Opened successfully");
		//Driver application Login	
		//DrApplnLogin.DriverUN("marilynmonroe1");
		//DrApplnLogin.DriverPSWD("iz9yvmknqx");
		//DrApplnLogin.ClickLoginButton();
		System.out.println("Driver information page Opened");
		
// Form 1. Driver Information
	    Thread.sleep(5000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    DrApplnLogin.FillDriverinfo();
	    DrApplnLogin.SSN_Number("998900790");
	    DrApplnLogin.click_Next();
	    System.out.println("Form 1. Driver Information Stored successfully");   
//Form 2. Driver Address History
	    //DrApplnLogin.Address1();
	    //Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    DrApplnLogin.Enter_Address_Line1();
	    DrApplnLogin.EnterCity();
	    DrApplnLogin.Select_State();
	    DrApplnLogin.Zipcode("90001");
	    DrApplnLogin.NoOfYrAtThisAddress();
	    //DrApplnLogin.AllAddressDetailsinConsole();
	    DrApplnLogin.AddressNext();
	    Thread.sleep(2000);
	    System.out.println("Form 2. Driver Address History Stored successfully");  
	    
// Form 3. Upload Front and Back of current Driver’s License / Permit here	  
	    Thread.sleep(2000);
	    DrApplnLogin.DriverLicenseDetails();
	    //DrApplnLogin.CurrentDL_Class();
	    DrApplnLogin.CurrentDL_Class2();
	    DrApplnLogin.IssueDate();
	    DrApplnLogin.ExpDate();
	    DrApplnLogin.Restrictions();
	    DrApplnLogin.Endorsements();
	    DrApplnLogin.DLNextButton();
	    System.out.println("Form 3. Upload Front and Back of current Driver’s License / Permit here Stored successfully");  
	    
	   
// Form 4.Commercial Driving and Equipment Experience	
	    Thread.sleep(4000);https:
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    DrApplnLogin.CD_Experience();
	    DrApplnLogin.From_Date();
	    DrApplnLogin.ToDate();
	    DrApplnLogin.Approximate_Total_Miles();
	    DrApplnLogin.EquipmentExperienceNextButton();   
	    System.out.println("Form 4.Commercial Driving and Equipment Experience Stored successfully");
	    Thread.sleep(3000);  
	   
// Form 5.Employment History
	    Thread.sleep(4000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    DrApplnLogin.HaveCemmercialDrivingExpYes();
	    DrApplnLogin.DriverEmplrInfo();
	    DrApplnLogin.JoiningFromDate();
	    DrApplnLogin.ResignedDate();
	    DrApplnLogin.MoreInfoOfEmplyr();
	    DrApplnLogin.EmpPhone();
	    DrApplnLogin.EmplrEmail();    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    DrApplnLogin.SubjectToDrugAlcohol();      //Now dev
	    DrApplnLogin.I_confirmConcentCheck();
	    DrApplnLogin.AdditionalNonDriveExp();
	    DrApplnLogin.AdditionalNonDriveExp();
	    //Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    DrApplnLogin.Employment_HistoryNext();
	    Thread.sleep(1000);
	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    System.out.println("Form 5.Employment History Stored successfully");
	    
// Form 6.Traffic Violations	   
	    Thread.sleep(4000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    //DrApplnLogin.TrafficViolationsYes();
	    DrApplnLogin.Traffic_ViolationNo();
	    //DrApplnLogin.TrafficViolations_Location();
	    //DrApplnLogin.TrafficViolationDate();
	    //Thread.sleep(2000);//Issue with date
	    //DrApplnLogin.ChargeAndPenalty();
	    DrApplnLogin.TrafficViolations_Next();
	    Thread.sleep(1000);
	    System.out.println("Form 6.Traffic Violations Stored successfully");
	   
	    
	    
// Form 7. Adverse Licensing Actions
	    Thread.sleep(2000);
	    DrApplnLogin.Operate_motor_vehicle_ever_been_suspended_No();
	    //DrApplnLogin.Operate_motor_vehicle_ever_been_suspended_yes();
	    driver.findElement(By.xpath("(//div[@class='radios_checkboxDiv__3WHHd'])[3]")).click();
	    driver.findElement(By.xpath("(//div[@class='radios_checkboxDiv__3WHHd'])[3]")).click();
	   
	    DrApplnLogin.EverBeenDeniedLicence_yes();
	    DrApplnLogin.Adverse_Licensing_Actions_Next();
	    Thread.sleep(1000);
	    System.out.println("Form 7. Adverse Licensing Actions Stored successfully");   
	    
// Form 8.Accident History	
	    
		Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    DrApplnLogin.involvedInAccidents_yes();
	    driver.findElement(By.xpath("//input[@name='form.accidents.0.hazmatSpill']")).click();
	    driver.findElement(By.xpath("//input[@name='form.accidents.0.hazmatSpill']")).click();
	    DrApplnLogin.Hazmat_Spill_no();//Hazmat Spill ? No
	    //DrApplnLogin.AddEqipment();
	    DrApplnLogin.Accident_HistoryNext();
	    Thread.sleep(1000);
	    System.out.println("Form 8.Accident History Stored successfully");  
	    
// Form 9. DOT Physical and Medical Certificate	
	    Thread.sleep(2000);
		DrApplnLogin.ValidDOTMC();
		DrApplnLogin.WishToUploadMC();
	    Thread.sleep(1000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    DrApplnLogin.UploadMedicalCertificate();
	    Thread.sleep(3000);
	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    DrApplnLogin.MedicalCertificateIssueDate();
	    DrApplnLogin.MedicalCertificateExpDate();
	    DrApplnLogin.NameOfMedicalExaminer();
	    DrApplnLogin.ExaminarNationalRegNumber();
	   
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    DrApplnLogin.LimitAbilityToPerformNo();
	    //Thread.sleep(1000);
	    DrApplnLogin.Past3YrsEverTestedPositiveNo();
	   // Thread.sleep(1000);
	    DrApplnLogin.Refused_to_take_TestNo();
	    
	    DrApplnLogin.DOT_Physical_and_Medical_Certificate_Next(); 
	    System.out.println("Form 9. DOT Physical and Medical Certificate Stored successfully");
	    
	    Thread.sleep(10000);
	    
	    
// Form 10. Consent Forms
	    Thread.sleep(4000);
	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    DrApplnLogin.Consent_Forms();  
	    DrApplnLogin.signature();
	    DrApplnLogin.ConsentForms_Next();
	    Thread.sleep(3000);
	    System.out.println("Form 10. Consent Forms Stored successfully");
	    
// Form 11.To Be Read and Signed By Applicant
	    Thread.sleep(3000);
	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    DrApplnLogin.ToBeReadAndSignedByApplicant();
	    DrApplnLogin.signature();
	    DrApplnLogin.ToBeReadAndSignedByApplicant_submit();
	    //Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    DrApplnLogin.ApplicationStatus();
	    DrApplnLogin.downloadDriverApplication();
	   System.out.println("Form 11.To Be Read and Signed By Applicant Stored successfully");
	   System.out.println("Driver Application submitted successfully");
	}
 
}



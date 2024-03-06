package FD360POM;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TestDriverApplication 
{
	@Test
	public void Verify_Driver_login() throws InterruptedException, Exception
	{
		
		String key="webdriver.chrome.driver";
		String value="./software/chromedriver.exe";
		System.setProperty(key,value);
		ChromeDriver driver =new ChromeDriver();
		
		//Application Class 
		DriverApplicationLogin DrApplnLogin=new DriverApplicationLogin(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://compliance.fleetsmartcarrierservices.com/apply");
	   Thread.sleep(3000);
		//Driver application Login	
		DrApplnLogin.DriverUN("driver24");
		DrApplnLogin.DriverPSWD("xR4TCyA9Sr");
		DrApplnLogin.ClickLoginButton();
		
	// choose Option to fill Driver application Form	
	    DrApplnLogin.Choose_Option();
	    
// Form 1. Driver Information
	    DrApplnLogin.FillDriverinfo();
	    DrApplnLogin.SSN_Number("998873040");
	    DrApplnLogin.click_Next();
	    
//Form 2. Driver Address History
	    //DrApplnLogin.Address1();
	    DrApplnLogin.Enter_Address_Line1();
	    DrApplnLogin.EnterCity();
	    DrApplnLogin.Select_State();
	    DrApplnLogin.Zipcode("90001");
	    DrApplnLogin.NoOfYrAtThisAddress();
	    //DrApplnLogin.AllAddressDetailsinConsole();
	    DrApplnLogin.AddressNext();
	    
// Form 3. Upload Front and Back of current Driver’s License / Permit here	  
	    Thread.sleep(2000);
	    DrApplnLogin.DriverLicenseDetails();
	    DrApplnLogin.CurrentDL_Class2();
	    DrApplnLogin.IssueDate();
	    DrApplnLogin.ExpDate();
	    DrApplnLogin.Restrictions();
	    DrApplnLogin.Endorsements();
	    DrApplnLogin.DLNextButton();  

// Form 4.Commercial Driving and Equipment Experience	
	    Thread.sleep(3000);
	    DrApplnLogin.CD_Experience();
	    DrApplnLogin.From_Date();
	    DrApplnLogin.ToDate();
	    DrApplnLogin.Approximate_Total_Miles();
	    DrApplnLogin.EquipmentExperienceNextButton(); 
	    
	    
// Form 5.Employment History	 
	    Thread.sleep(3000);
	    DrApplnLogin.HaveCemmercialDrivingExpYes();
	    DrApplnLogin.DriverEmplrInfo();
	    DrApplnLogin.JoiningFromDate();
	    DrApplnLogin.ResignedDate();
	    //DrApplnLogin.MoreInfoOfEmplyr();
	   // DrApplnLogin.EmplrEmail();
	    DrApplnLogin.SubjectToDrugAlcohol();
	    DrApplnLogin.I_confirmConcentCheck();
	    DrApplnLogin.AdditionalNonDriveExp();
	    DrApplnLogin.Employment_HistoryNext();  
	    
	    
// Form 6.Traffic Violations	   
	    Thread.sleep(3000);
	    DrApplnLogin.TrafficViolationsYes();
	    //DrApplnLogin.Traffic_ViolationNo();
	    DrApplnLogin.TrafficViolations_Location();
	    DrApplnLogin.TrafficViolationDate();
	  //  DrApplnLogin.TrafficViolationDate();
	    DrApplnLogin.ChargeAndPenalty();
	    DrApplnLogin.TrafficViolations_Next();  
	   
// Form 7. Adverse Licensing Actions	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//input[@name='form.licenseSuspendedOrRevoked'])[2]")).click();  //No
	    //DrApplnLogin.Operate_motor_vehicle_ever_been_suspended_yes();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//input[@name='form.licenseDenied'])[2]")).click();     //No                      
	    //driver.findElement(By.xpath("(//div[@class='radios_checkboxDiv__3WHHd'])[3]")).click();  
	    //DrApplnLogin.EverBeenDeniedLicence_yes();
	    DrApplnLogin.Adverse_Licensing_Actions_Next();  
	    
	    
// Form 8.Accident History	
	    Thread.sleep(3000);
	    DrApplnLogin.involvedInAccidents_yes();
	    DrApplnLogin.Hazmat_SpillBeta_no(); //beta
	    DrApplnLogin.Hazmat_SpillBeta_no();
	    //DrApplnLogin.Hazmat_Spill_no();// dev
	    //DrApplnLogin.AddEqipment();
	    DrApplnLogin.Accident_HistoryNext();  
	    
// Form 9. DOT Physical and Medical Certificate	  
	    Thread.sleep(3000);
	    DrApplnLogin.UploadMedicalCertificate();
	    Thread.sleep(3000);
	    DrApplnLogin.MedicalCertificateIssueDate();
	    Thread.sleep(1000);
	    DrApplnLogin.MedicalCertificateExpDate();
	    DrApplnLogin.NameOfMedicalExaminer();
	    DrApplnLogin.ExaminarNationalRegNumber();
	    Thread.sleep(2000);
	    //driver.findElement(By.xpath("(//input[@name='form.limitedPhysicalAbility'])[1]")).click();
	    DrApplnLogin.LimitAbilityToPerformNoBeta(); 
	    DrApplnLogin.LimitAbilityToPerformNo();
	    Thread.sleep(2000);
	    DrApplnLogin.Past3YrsEverTestedPositiveNoBeta();
	    DrApplnLogin.Past3YrsEverTestedPositiveNo();
	    Thread.sleep(1000);
	    DrApplnLogin.Refused_to_take_TestNo();
	    Thread.sleep(2000);
	    DrApplnLogin.DOT_Physical_and_Medical_Certificate_Next();
	    
	    
// Form 10. Consent Forms	
	    Thread.sleep(3000);
	    DrApplnLogin.Consent_Forms();
	    WebElement signatureele = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		Actions drawaction = act.moveToElement(signatureele, 50, 50);
		Thread.sleep(3000);
		drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
		Thread.sleep(3000);
		
  
		Assert.assertTrue(true);
		//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
		System.out.println("Driver Driver consent form submitted successfully");
	    DrApplnLogin.ConsentForms_Next();                                                 
	    
	    
// Form 11.To Be Read and Signed By Applicant
	    Thread.sleep(3000);
	    DrApplnLogin.ToBeReadAndSignedByApplicant();
	    Thread.sleep(2000);
	    
	    WebElement signatureele1 = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
		Actions act1=new Actions(driver);
		Thread.sleep(3000);
		Actions drawaction1 = act1.moveToElement(signatureele1, 50, 50);
		Thread.sleep(3000);
		drawaction1.clickAndHold().moveByOffset(10, 30).release().perform();
		Thread.sleep(3000);
		
	    DrApplnLogin.ToBeReadAndSignedByApplicant_submit();
	    
	    DrApplnLogin.ApplicationStatus();
	    DrApplnLogin.downloadDriverApplication();
	   
	}

}

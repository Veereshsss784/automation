package metromax;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.DriverApplicationLogin;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.LoginTest;
import FD360POM.ManageClients;

public class Test_DriverApplnSubmition {

	@SuppressWarnings("unused")
	@Test
	public void DriverApplnLogin() throws Exception 
	{
	String key="webdriver.chrome.driver";
	String value="C:\\Users\\Veeresh Salagar\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe";
	System.setProperty(key,value);
	ChromeDriver driver =new ChromeDriver();
	
	//  Application classes
	LoginSVP LoginFleet=new LoginSVP(driver);
	DashboardSVP SVPDB=new DashboardSVP(driver);
	CompanyProfileSVP SVPCompanyProfile= new CompanyProfileSVP(driver);
	ManageClients Manage_Clients=new ManageClients(driver);
	HomePageOfCarrier Carrier_Space=new HomePageOfCarrier(driver);
	LoginTest SVPtestInviteDriver=new LoginTest();
	DriverApplicationLogin DrAppLogin= new DriverApplicationLogin(driver);
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply");
	
	//Enter Driver Credentials 
	DrAppLogin.DriverUN("driver02");  //drivercd, drivere3, vdrivernc01, vtestingncdl
	DrAppLogin.DriverPSWD("omLkVA39W#");  //sik1budj, wUPoyDfR#e, YbnrFaVmvj, QFn8g@61ku
	DrAppLogin.ClickLoginButton();

/*
		
// 1.Driver Choose Form
	
	DrAppLogin.Choose_Option(); 
	
// Enter general information
	
	DrAppLogin.FillDriverinfo();
	DrAppLogin.SSN_Number("784743742");
	DrAppLogin.Phone_Number();
	DrAppLogin.click_Next();  
	Thread.sleep(3000);
	
// 2.Enter Address information	
	
	DrAppLogin.Enter_Address_Line1();
	DrAppLogin.EnterCity();
	DrAppLogin.Select_State();
	DrAppLogin.Zipcode("90001");
	DrAppLogin.NoOfYrAtThisAddress();
	//DrAppLogin.AllAddressDetailsinConsole();
	DrAppLogin.AddressNext();  
	Thread.sleep(3000);
	
// 3.Enter Driver's License Details
	DrAppLogin.DriverLicenseDetails();
	Thread.sleep(3000);
	DrAppLogin.CurrentDL_Class();
	Thread.sleep(4000);
	DrAppLogin.IssueDate();
	Thread.sleep(3000);
	DrAppLogin.ExpDate();
	
	DrAppLogin.Restrictions();
	DrAppLogin.Endorsements();
	DrAppLogin.DLNextButton();
	Thread.sleep(3000);

// 4.Commercial Driving and Equipment Experience
	
	DrAppLogin.CD_Experience();
	DrAppLogin.From_Date();
	DrAppLogin.ToDate();
	DrAppLogin.Approximate_Total_Miles();
	DrAppLogin.EquipmentExperienceNextButton();
	Thread.sleep(3000);
	
// 5.Employment History
	Thread.sleep(3000);
	DrAppLogin.HaveCemmercialDrivingExpYes(); 
	DrAppLogin.DriverEmplrInfo();
	DrAppLogin.JoiningFromDate();
	DrAppLogin.ResignedDate();
	DrAppLogin.MoreInfoOfEmplyr();
	DrAppLogin.EmplrEmail();
	DrAppLogin.SubjectToDrugAlcohol();
	DrAppLogin.I_confirmConcentCheck();  
	Thread.sleep(3000);
	DrAppLogin.AdditionalNonDriveExp(); 
	DrAppLogin.Employment_HistoryNext();  */
	Thread.sleep(3000); 
	
// 6.Traffic Violations
	DrAppLogin.TrafficViolationsYes();
	DrAppLogin.TrafficViolations_Location();
	Thread.sleep(3000);
	DrAppLogin.TrafficViolationDate();
	DrAppLogin.ChargeAndPenalty();
	Thread.sleep(2000);
	DrAppLogin.TrafficViolations_Next();  
	Thread.sleep(3000);  
	
	
// 7.Adverse Licensing Actions
    DrAppLogin.Operate_motor_vehicle_ever_been_suspended_yes();
    driver.findElement(By.xpath("(//input[@name='form.licenseDenied'])[2]")).click();  // EverBeenDeniedLicence_no
    driver.findElement(By.xpath("(//input[@name='form.licenseDenied'])[2]")).click();
	//DrAppLogin.EverBeenDeniedLicence_no();
	DrAppLogin.Adverse_Licensing_Actions_Next();  
	
	Thread.sleep(3000);

// 8.Accident History	
	
	DrAppLogin.involvedInAccidents_yes();
	DrAppLogin.Hazmat_Spill_no();
	DrAppLogin.Hazmat_Spill_no();
	DrAppLogin.Accident_HistoryNext();  
	Thread.sleep(3000);
	
// 	9.DOT Physical and Medical Certificate
	
	DrAppLogin.UploadMedicalCertificate();  
	Thread.sleep(5000);
	DrAppLogin.MedicalCertificateIssueDate();
	Thread.sleep(3000);
	DrAppLogin.MedicalCertificateExpDate();
	Thread.sleep(3000);
	DrAppLogin.NameOfMedicalExaminer();
	DrAppLogin.ExaminarNationalRegNumber();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='form.limitedPhysicalAbility']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='form.limitedPhysicalAbility']")).click();  //error
	Thread.sleep(3000);
	DrAppLogin.LimitAbilityToPerformYes();  
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//input[@name='form.testedPositiveDOA'])[1]")).click();
	driver.findElement(By.xpath("(//input[@name='form.testedPositiveDOA'])[1]")).click();
	Thread.sleep(3000);
	DrAppLogin.Past3YrsEverTestedPositiveYes();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//input[@name='form.refusedToTest'])[1]"));
	driver.findElement(By.xpath("(//input[@name='form.refusedToTest'])[1]"));
	DrAppLogin.Refused_to_take_TestYes();
	DrAppLogin.DOT_Physical_and_Medical_Certificate_Next(); 
	Thread.sleep(4000); 
	
//	10.Concent_Form
	
	DrAppLogin.Consent_Forms();
	
	WebElement signatureele = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
	Actions act=new Actions(driver);
	Actions drawaction = act.moveToElement(signatureele, 50, 50);
	drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
	
	DrAppLogin.ConsentForms_Next();    
	Thread.sleep(3000);
// 11.To Be Read and Signed By Applicant
	DrAppLogin.ToBeReadAndSignedByApplicant();
	
	WebElement signatureele2 = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
	Actions act2=new Actions(driver);
	Actions drawaction2 = act2.moveToElement(signatureele2, 50, 50);
	drawaction2.clickAndHold().moveByOffset(10, 30).release().perform();
	Thread.sleep(3000);
	
	DrAppLogin.ToBeReadAndSignedByApplicant_submit();  
	
	DrAppLogin.ApplicationStatus();
	DrAppLogin.downloadDriverApplication();

	
	}	
	
	
}


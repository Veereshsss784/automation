package FD360TC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SubmitPreviousEmployerForm {
	
	// Verify Applicant Information
	
    By DidYouEmployAbove_Yes=By.xpath("(//input[@value='yes'])[1]");
    By DidYouEmployAbove_No=By.xpath("(//input[@value='no'])[1]");

    By EmploymentStartDate=By.xpath("(//input[@id='driverEmployedFrom'])[1]");
    By EmploymentEndDate=By.xpath("(//input[@id='driverEmployedTill'])[1]");	
    By DidYouEmployThisPersonForDrive_Yes= By.xpath("(//input[@name='applicantEnquire'])[1]");
    By TypeOfVehicle_StraightTruck =By.xpath("(//input[@name='Straight Truck'])[1]");
    By TypeOfVehicle_Tractor =By.xpath("(//input[@name='Tractor/Semitrailer'])[1]");
    By TypeOfVehicle_Bus =By.xpath("(//input[@name='Bus'])[1]");
    By TypeOfVehicle_CargoTank =By.xpath("(//input[@name='Cargo Tank'])[1]");
    By TypeOfVehicle_Doubles =By.xpath("(//input[@name='Doubles/Triples'])[1]");
    By TypeOfVehicle_Van =By.xpath("(//input[@name='Van'])[1]");
    By TypeOfVehicle_BoxTruck =By.xpath("(//input[@name='Box Truck'])[1]");
    By TypeOfVehicle_Other =By.xpath("(//input[@name='other'])[1]");
    
    By DidYouEmployThisPersonForDrive_No=By.xpath("(//input[@name='applicantEnquire'])[2]");
    By ReasonForLeavingYourEmploy_Discharged= By.xpath("(//input[@value='Discharged'])[1]");
    By ReasonForLeavingYourEmploy_Resignation= By.xpath("(//input[@value='Resignation'])[1]");
    By ReasonForLeavingYourEmploy_LayOff= By.xpath("(//input[@value='Lay Off'])[1]");
    By ReasonForLeavingYourEmploy_MilitaryDuty= By.xpath("(//input[@value='Military Duty'])[1]");
    By ReasonForLeavingYourEmploy_Other= By.xpath("(//input[@value='other'])[1]");
    By LeavingReasonNote= By.xpath("(//textarea[@id='leavingReasonNotes'])[1]");
    By EnterRemarks= By.xpath("(//textarea[@id='notes'])[1]");
    
    By ApplicantInformation_Next=By.xpath("(//button[normalize-space()='Next'])[1]");
    
    // Safety Performance History Record
    By PersonInvolvedInAnyAccidents_Yes = By.xpath("(//input[@name='previousAccident'])[1]");
    By PersonInvolvedInAnyAccidents_No = By.xpath("(//input[@name='previousAccident'])[2]");
    
    By reportedToGovernmentAgencies_Yes=By.xpath("(//input[@name='otherAccident'])[1]");
    By reportedToGovernmentAgencies_No=By.xpath("(//input[@name='otherAccident'])[2]");
    
    By SafetyPerformanceHistoryRecord_Next=By.xpath("(//button[normalize-space()='Next'])[1]");
    
    // Safety Performance History Record
    
    By personSubjectedToDOTDrugAlcoholTest_Yes= By.xpath("(//input[@value='yes'])[1]");
    By personSubjectedToDOTDrugAlcoholTest_No= By.xpath("(//input[@value='no'])[1]");
    
        //if No
    By NameOfEmployer =By.xpath("(//input[@id='filled-required'])[1]");
    By TitleOfEmployer = By.xpath("(//input[@id='filled-required'])[2]");

    By SafetyPerformanceHistoryRecord_Submit= By.xpath("(//button[normalize-space()='Submit'])[1]");
    
	String FleetDev="https://dev.fleetdrive360.com/apply"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/apply";
	String FleetProd="https://app.fleetdrive360.com/apply";
	
	@Test(priority=1)
	public void Verify_Previous_Employer_Verification_Page() throws InterruptedException
	{
		
		String key="webdriver.chrome.driver";
		String value="./software/chromedriver.exe";
		System.setProperty(key,value);
		ChromeDriver driver =new ChromeDriver();
		
		//Application Class
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://compliance.fleetsmartcarrierservices.com/dot-employment-verification?token=5640e27fa13");
	    Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Previous Employer Verification' Page Opened successfully");
		
		driver.findElement(DidYouEmployAbove_Yes).click();
		driver.findElement(EmploymentStartDate).sendKeys("01022016");
		driver.findElement(EmploymentEndDate).sendKeys("01022021");
		driver.findElement(DidYouEmployThisPersonForDrive_Yes).click();
	    driver.findElement(TypeOfVehicle_Van).click();
	    driver.findElement(ReasonForLeavingYourEmploy_Discharged).click();
	    driver.findElement(EnterRemarks).sendKeys("Good to go ,Driver is perfect");
	    driver.findElement(ApplicantInformation_Next).click();
	    
	    driver.findElement(PersonInvolvedInAnyAccidents_No).click();
	    driver.findElement(reportedToGovernmentAgencies_No).click();
	    driver.findElement(SafetyPerformanceHistoryRecord_Next).click();
	    
	    driver.findElement(personSubjectedToDOTDrugAlcoholTest_No).click();
	    driver.findElement(NameOfEmployer).sendKeys("VeereshEmp");
	    driver.findElement(TitleOfEmployer).sendKeys("Carrier owner");
 
	    System.out.println("Entered all information of Driver by Previous Employer");
		WebElement signatureele = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[2]/div/form/div[3]/div[5]/div/canvas"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		Actions drawaction = act.moveToElement(signatureele, 50, 50);
		drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
		Thread.sleep(2000);  
		Assert.assertTrue(true);
		
		driver.findElement(SafetyPerformanceHistoryRecord_Submit).click();
		
		System.out.println("Employer submitted form successfully");
	}
}

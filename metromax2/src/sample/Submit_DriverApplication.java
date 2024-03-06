package sample;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FD360POM.DriverApplicationLogin;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
import sample.ExtentReportsClass;


public class Submit_DriverApplication 
{
	
	By DrUN=By.xpath("//*[@id='username']");
	By DrPSWD=By.xpath("//*[@id='password']");
	By DrLoginButton=By.xpath("//button[@type='submit']");
	
//Confirm DriverID and CompanyName
	By Driver_ID=By.xpath("(//div[@class='col-lg-3 col-md-12'])[1]");
	By CompanyName=By.xpath("(//div[@class='col-lg-3 col-md-12'])[2]");
	
	By OnlineForm=By.xpath("//input[@name='Online_Application']");
	By PDF_Application =By.xpath("//input[@name='PDF_Application']");
	By Submit2=By.xpath("(//button[@type='button'])[4]");

// form 1 Driver onformation
	By DrDOB=By.xpath("//input[@name='form.dateOfBirth']");
	By SelectYear=By.xpath("//select[@class='react-datepicker__year-select']");
	
	By Year=By.xpath("//Option[@value='1990']");
	
	By SelectMonth=By.xpath("//select[@class='react-datepicker__month-select']");
	
	By Month=By.xpath("//option[@value='3']");
	
	By ClickOnDate=By.xpath("//div[.='14']");
	
	By SSN_Number=By.xpath("(//input[@id='form.ssnNumber'])[1]"); 
	By Phone_No=By.xpath("//input[@name='form.phone']");
	
	By Previous1=By.xpath("//button[@class='driverAppPrevBtn']");
	By Next=By.xpath("//button[.='Next']");
	
// Driver Address History
	
	By Form_1_Name=By.xpath("//h3[@id='driver_title_header']");
	By Address_1= By.xpath("//h5[.='Address 1']");
	
	By Address_Line1=By.xpath("//input[@name='form.driverAddresses.0.address_1']");
	By Address_Line2=By.xpath("//input[@name='form.driverAddresses.0.address_2']");
	By City=By.xpath("//input[@name='form.driverAddresses.0.city']");
	By State=By.xpath("//div[@id='mui-component-select-form.driverAddresses.0.state']");
	//By Select_State=By.xpath("//li[.='California']");
	By Zip_Code=By.xpath("//input[@name='form.driverAddresses.0.zipCode']");
	By No_ofYearsAtThisAddress=By.xpath("//input[@name='form.driverAddresses.0.noOfYears']");  // if less than 3 use below
	By Previous2=By.xpath("//button[@class='driverAppPrevBtn']");
	By Address_Next=By.xpath("//button[@type='submit']");
	
// 	Driver's License and Permit History
	
	By ChooseDLFront=By.xpath("//input[@id='driver_license_document']");
	
	By ChooseDLBack=By.xpath("//input[@id='driver_license_document_back']");
	By DL_IssueState=By.xpath("//div[@id='mui-component-select-form.license.0.issueState']");
	By ChooseState=By.xpath("//li[.='California']");
	By LicenseNumber=By.xpath("//input[@id='form.license.0.driverLicenseNumber']");
	
	By DL_Class=By.xpath("//div[@id='mui-component-select-form.license.0.licenseClass']");//(//div['/html/body/div[2]/div[3]/div[4]/form[2]/div[4]/div/div[1]/div/div[3]/div/div[1]/div/div'])[224]
	
	By Select_DLClass=By.xpath("//li[.='None (Non-CDL Driver)']");
	By Select_DLClass2=By.xpath("//li[.='Class A']");
	
	By DL_IssueDate=By.xpath("//input[@name='form.license.0.issueDate']");
	By ClickYear=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year=By.xpath("//option[.='2014']");
	
	By ClickMonth=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month=By.xpath("//option[.='April']");
    
	By Select_Date=By.xpath("(//div[.='11'])[3]");
			
	By DL_ExpDate=By.xpath("//input[@name='form.license.0.expirationDate']");
	By ClickYear1=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year1=By.xpath("//option[.='2030']");
	By ClickMonth1=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month1=By.xpath("//option[.='June']");
    By Select_Date1=By.xpath("(//div[.='14'])[3]");
   
	By Restrictions=By.xpath("//input[@id='form.license.0.restrictions']");
	By Endorsements=By.xpath("//input[@id='form.license.0.endorsement']");
	
	By Add_License=By.xpath("//button[.=' + Add License ']");
	
	By Previous3=By.xpath("//button[@class='driverAppPrevBtn']");
	By DL_Next=By.xpath("//button[@type='submit']");
	
// Commercial Driving and Equipment Experience
	By HaveCDL_DL1=By.xpath("//input[@value='yes']");  //if 'yes' WhatYear
	By HaveCDL_DL2=By.xpath("//input[@value='no']");
	By WhatYear=By.xpath("//input[@id='form.commercialDriverSince']");
	By CDLExp=By.xpath("//input[@id='form.commercialDriverExperience']");
	By EQP_Operated=By.xpath("//input[@value='Dry Van']");
	
	By Click_From=By.xpath("//input[@name='form.equipment.0.operatedFrom']");
	By Click_Year=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year2=By.xpath("//option[.='2014']");
	By ClickMonth2=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month2=By.xpath("//option[.='March']");
    By Select_Date2=By.xpath("(//div[.='11'])[3]");
	
	By Click_To=By.xpath("//input[@name='form.equipment.0.operatedTo']");
	By ClickYear2=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year3=By.xpath("//option[.='2020']");
	By ClickMonth3=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month3=By.xpath("//option[.='April']");
    By Select_Date3=By.xpath("(//div[.='13'])[3]");
	
    By TotalMiles=By.xpath("//input[@id='form.equipment.0.miles']");
    By EQP_Exp=By.xpath("//button[@type='submit']");
    
// Employment History 
   
    By HaveCommercialDrivingExpYes=By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]");  //if yes go to Employer1
    By HaveCommercialDrivingExpNo=By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]");   //elseif no go to Next
    
    // Employer1
    
    By EmpName=By.xpath("//input[@id='form.employmentRecord.0.employerName']");
    By AddressLine1=By.xpath("//input[@id='form.employmentRecord.0.previousEmployerAddress.address_1']");
    By AddressLine2=By.xpath("//input[@id='form.employmentRecord.0.previousEmployerAddress.address_2']");
    By City2=By.xpath("//input[@id='form.employmentRecord.0.previousEmployerAddress.city']");
    By ClickSate=By.xpath("//div[@id='mui-component-select-form.employmentRecord.0.previousEmployerAddress.state']");
                           
    By SelectState=By.xpath("//li[.='California']");
    By Zipcode=By.xpath("//input[@id='form.employmentRecord.0.previousEmployerAddress.zipcode']");
    By ReasonForLeaving=By.xpath("//textarea[@name='form.employmentRecord.0.leavingReason']");
    
    By ClickFromDate=By.xpath("//input[@name='form.employmentRecord.0.joiningDate']");
    
    By Click_Year1=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year4=By.xpath("//option[.='2014']");
	By ClickMonth4=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month4=By.xpath("//option[.='April']");
    By Select_Date4=By.xpath("(//div[.='11'])[3]");
    
    By ClickToDate=By.xpath("//input[@name='form.employmentRecord.0.releaseDate']");
    By ClickYear3=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year5=By.xpath("//option[.='2021']");
	By ClickMonth5=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month5=By.xpath("//option[.='April']");
    By Select_Date5=By.xpath("(//div[.='12'])[3]");
    
    //if only Above 3 years of Eperience 
    
    By DOT=By.xpath("//input[@id='form.employmentRecord.0.dot']");
    By PhoneNo=By.xpath("//input[@name='form.employmentRecord.0.employerPhone']");
    By EmplrEmail=By.xpath("//input[@name='form.employmentRecord.0.email']");
    By SubjectedToDOTDev=By.xpath("//div[@id='dotSubstanceCompliance']");
    By SubjectedToDOTBeta =By.xpath("(//div[@id='form.employmentRecord[0].dotSubstanceCompliance'])[1]"); //div[@id='form.employmentRecord[0].dotSubstanceCompliance']  //(//div[@id='form.employmentRecord[0].dotSubstanceCompliance'])[1]  //input[@name='form.employmentRecord.0.dotSubstanceCompliance']    // body > div:nth-child(3) > div:nth-child(3) > div:nth-child(5) > form:nth-child(9) > div:nth-child(10) > div:nth-child(1) > div:nth-child(3) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)  //div[@id='dotSubstanceCompliance']
    
    By SubjectedToDrugAlcohol_Yes=By.xpath(("//li[.='Yes']"));
    By SubjectedToDrugAlcohol_No=By.xpath(("//li[.='No']"));
    By I_confirmConsent=By.xpath("//input[@name='form.employmentRecord.0.iConsent']");
    
    //By AddEmployerInPast3Year=By.xpath("//span[.=' + Add Employer in the past 3 years ']");  
    
    //next
    //Additional Non-Driving Work Experience
    By AddtionalExpYes= By.xpath("(//input[@name='form.step5_q2'])[1]");
    By AddtionalExpNo= By.xpath("(//input[@name='form.step5_q2'])[2]");
    By EmplrHsrtyNext=By.xpath("//button[@type='submit']");
    
// Traffic Violations 
    By Traffic_voilationYes=By.xpath("//input[@name='form.step6_q1']");
    By Traffic_voilationNo=By.xpath("(//input[@name='form.step6_q1'])[2]");
    
    //if Traffic Violations is "Yes"
    By ClickSelectLoc=By.xpath("//div[@id='mui-component-select-form.trafficConvictions.0.location']");
    By SelectLocation=By.xpath("//li[.='California']");
    
    By ClickDate=By.xpath("//input[@name='form.trafficConvictions.0.date']");
    By Click_Year3=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year6=By.xpath("//option[.='2015']");
	By ClickMonth6=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month6=By.xpath("//option[.='May']");
    By Select_Date6=By.xpath("(//div[.='25'])[3]");
    
    By Charge=By.xpath("//input[@id='form.trafficConvictions.0.charge']");
    By Penalty=By.xpath("//input[@id='form.trafficConvictions.0.penalty']");
    By AddConvication=By.xpath("//span[.=' + Add Conviction ']");
    
    By TrafficViolation_Previous=By.xpath("//button[.='Previous']");
    
    By TrafficViolation_Next=By.xpath("//button[.='Next']");
    
// Adverse Licensing Actions     
    
    By Operate_motor_vehicle_ever_been_suspended_Yes=By.xpath("//input[@name='form.licenseSuspendedOrRevoked']");
    By Operate_motor_vehicle_ever_been_suspended_No=By.xpath("(//input[@name='form.licenseSuspendedOrRevoked'])[2]");
    //if Yes
    By When=By.xpath("//input[@id='form.licenseSuspendedOrRevokedDate']");
    By PleaseExplain=By.xpath("//textarea[@id='form.licenseSuspendedOrRevokedRemark']");
   
    By EverBeenDeniedLicense_yes=By.xpath("(//div[@class='radios_checkboxDiv__3WHHd'])[3]");//input[@name='form.licenseDenied']  //(//span[@class='css-hyxlzm'])[3]   //(//input[@type='radio'])[6]   //input[@name='form.licenseDenied']        (//input[@value='yes'])[2]
    
    
    By EverBeenDeniedLicense_No=By.xpath("(//input[@name='form.licenseDenied'])[2]");
    //if Yes
    By When2=By.xpath("//input[@name='form.licenseDeniedDate']");
    By Please_Explain=By.xpath("//textarea[@name='form.licenseDeniedRemark']");
    

    By Adverse_Licensing_Actions_Previous=By.xpath("//button[.='Previous']");
    By Adverse_Licensing_Actions_Next=By.xpath("//button[.='Next']");
    
// Accident History
    By InvolvedInAccidents_Yes=By.xpath("(//input[@name='form.step8_q1'])[1]");
    By InvolvedInAccidents_No=By.xpath("(//input[@name='form.step8_q1'])[2]");
    
    By Click_AccidentDate=By.xpath("//input[@name='form.accidents.0.dateOfAccident']");
    By Click_Year4=By.xpath("//select[@class='react-datepicker__year-select']");
	By Select_Year7=By.xpath("//option[.='2016']");
	By ClickMonth7=By.xpath("//select[@class='react-datepicker__month-select']");
	By Select_Month7=By.xpath("//option[.='March']");
    By Select_Date7=By.xpath("(//div[.='26'])[3]");
    
    By NatureOfAccident=By.xpath("//input[@name='form.accidents.0.natureOfAccidents']");
    By City3=By.xpath("//input[@name='form.accidents.0.city']");
    By Click_State=By.xpath("//div[@id='mui-component-select-form.accidents.0.state']");
    By Select_State=By.xpath("//li[.='Click_State']");
    
    By NoOfFatalities=By.xpath("//input[@name='form.accidents.0.numberOfFatalities']");
    By NoOfInjuries=By.xpath("//input[@name='form.accidents.0.numberOfInjuries']");
    
    By HazmatSpill_Yes=By.xpath("(//input[@name='form.accidents.0.hazmatSpill'])[1]");//(//input[@name='form.accidents.0.hazmatSpill'])[1]
    By HazmatSpill_No=By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @name='form.accidents.0.hazmatSpill' and @value='no']");	       //  (//input[@name='form.accidents.0.hazmatSpill'])[2]
    By AddEquipment=By.xpath("//span[.=' + Add Equipment ']");
    
    By Accident_History_Previous=By.xpath("//button[.='Previous']");
    By Accident_History_Next=By.xpath("//button[.='Next']");
    
    
// DOT Physical and Medical Certificate
    
    By UploadMedical_Certificate= By.xpath("//input[@name='medical_certificate_document_name']");   
    
    By MedicalC_issuedateClick=By.xpath("//input[@name='form.medicalCertificate.issueDate']");
    
    By Click_Year2=By.xpath("//select[@class='react-datepicker__year-select']");
   	By Select_Year8=By.xpath("//option[.='2014']");
   	By ClickMonth8=By.xpath("//select[@class='react-datepicker__month-select']");
   	By Select_Month8=By.xpath("//option[.='April']");
       By Select_Date8=By.xpath("(//div[.='11'])[3]");
    
    By MedicalC_ExpDateClick=By.xpath("//input[@name='form.medicalCertificate.expirationDate']");
    
    By Click_Year5=By.xpath("//select[@class='react-datepicker__year-select']");
   	By Select_Year9=By.xpath("//option[.='2014']");
   	By ClickMonth9=By.xpath("//select[@class='react-datepicker__month-select']");
   	By Select_Month9=By.xpath("//option[.='April']");
       By Select_Date9=By.xpath("(//div[.='11'])[3]");
    
    By NameOfExaminar=By.xpath("//input[@name='form.medicalCertificate.medical_examiner']");
    By Examiners_National_RegistoryNo=By.xpath("//input[@name='form.medicalCertificate.national_registry_number']");
    
    By GoodPhysicalConditionYes=By.xpath("(//input[@name='form.limitedPhysicalAbility'])[1]");
    By GoodPhysicalConditionNo=By.xpath("(//input[@name='form.limitedPhysicalAbility'])[2]"); 
    By PleaseExplain2=By.xpath("(//input[@id='form.physicalHistory.0.remark'])[1]"); //(//input[@id='form.physicalHistory.0.remark'])[1] //input[@name='form.physicalHistory.1.remark'] if Yes
    By UploadMedicalCertificate=By.xpath("(//input[@id='physical_condition_document'])[1]");
    
    By InPastDugAlcoholYes=By.xpath("(//input[@name='form.testedPositiveDOA'])[1]");
    By InPastDugAlcoholNo=By.xpath("(//input[@name='form.testedPositiveDOA'])[2]");
    By When_year=By.xpath("(//input[@id='form.physicalHistory.1.date'])[1]");//input[@name='form.physicalHistory.2.date']
    
    By Expain=By.xpath("(//input[@id='form.physicalHistory.1.remark'])[1]");//input[@name='form.physicalHistory.2.remark']
    By UploadReference_MedicalCertificate=By.xpath("(//input[@id='positive_tested_document'])[1]");	//input[@name='positive_tested_document_name']	
   // (//input[@id='physical_condition_document'])[1]
    By Past3YearsTestedPositiveYes=By.xpath("(//input[@name='form.testedPositiveDOA'])[1]"); //(//input[@name='form.testedPositiveDOA'])[1]  //(//input[@name='form.testedPositiveDOA'])[1]  //(//input[@name='form.refusedToTest'])[1]
    By Past3YearsTestedPositiveNo=By.xpath("(//input[@name='form.refusedToTest'])[2]");
    By WhenYear=By.xpath("(//input[@id='form.physicalHistory.2.date'])[1]"); //input[@name='form.physicalHistory.0.date'] // if Yes
    By PleaseExplain4=By.xpath("(//input[@id='form.physicalHistory.2.remark'])[1]");//(//input[@id='form.physicalHistory.0.remark'])[1]    input[@name='form.physicalHistory.0.remark']  (//input[@id='form.physicalHistory.2.remark'])[1]
    By UploadMedicalReferenceCertificate=By.xpath("(//input[@id='pre_employment_test_document'])[1]");  //input[@name='pre_employment_test_document_name']
    
    By have_you_tested_positive_RefusedToTest_YES=By.xpath("(//input[@name='form.refusedToTest'])[1]");
    By have_you_tested_positive_RefusedToTest_NO=By.xpath("(//input[@name='form.refusedToTest'])[2]");
    
    By DOT_Physical_and_Medical_Certificate_Previous=By.xpath("//button[.='Previous']");
    By DOT_Physical_and_Medical_Certificate_Next=By.xpath("(//button[normalize-space()='Next'])[1]");
    
    
// Consent Forms 
    By first_ConsentForm=By.xpath("//div[.='PRE-EMPLOYMENT DRUG/ALCOHOL TESTING NOTIFICATION & CONSENT']");
    By checkfirstform=By.xpath("//span[.='I hereby agree to submit to required Substance Abuse Testing (drug and/or alcohol)']");
    
    By second_ConsentForm=By.xpath("//p[.='DOT SUBSTANCE ABUSE POLICY EMPLOYEE ACKNOWLEDGEMENT FORM']");
    By checksecondform=By.xpath("//span[.='I understand and agree to the above terms and conditions of employment. I understand that the above in no way creates an obligation or contract of employment and that I, as well as the Company, have the right to end the employment relationship at any time.']");
    
    By third_ConsentForm=By.xpath("//p[.='CONSENT FOR QUERIES OF THE FMCSA DRUG AND ALCOHOL CLEARINGHOUSE']");
    By checkthirdform=By.xpath("(//span[.='I hereby give my Consent for the Above.'])[1]");
    
    By fourth_ConsentForm=By.xpath("//p[.='DOT SUBSTANCE ABUSE POLICY CHEMICAL SCREENING CONSENT & RELEASE FORM']");
    By checkfourthform=By.xpath("//span[.='I hereby consent and allow the Company or its designated representative to verify and/or confirm the above information with the prescribing physician listed above. I certify that if I have been furnished a specimen kit, the bottle in that kit was personally given to me by the collection site or laboratory personnel and contained a specimen of my urine. Further, I attest that the specimen was sealed in my presence.']");
    
    By fifth_ConsentForm=By.xpath("//p[.='CERTIFICATION OF COMPLIANCE WITH DRIVER LICENSE REQUIREMENTS']");
    By checkfifthform=By.xpath("//span[.='I certify that I have read and understood the above requirements.']");
    
    By sixth_ConsentForm=By.xpath("//p[.='FMCSA PRE-EMPLOYMENT SCREENING PROGRAM (PSP) AUTHORIZATION IMPORTANT DISCLOSURE REGARDING BACKGROUND REPORTS FROM THE PSP ONLINE SERVICE']");
    By checksixthform=By.xpath("//span[.='I have read the above Disclosure Regarding Background Reports provided to me by Prospective Employer and I understand that if I sign this Disclosure and Authorization, Prospective Employer may obtain a report of my crash and inspection history. I hereby authorize Prospective Employer and its employees, authorized agents, and/or affiliates to obtain the information authorized above.']");
    
    By seventh_ConsentForm=By.xpath("//p[.='FAIR CREDIT REPORTING ACT DISCLOSURE STATEMENT']");
    By checkseventhform=By.xpath("(//span[.='I hereby give my Consent for the Above.'])[2]");
    
    
    By ConsentForms_Previous=By.xpath("//button[.='Previous']");
    By ConsentForms_Next=By.xpath("//button[.='Next']");
    
// To Be Read and Signed By Applicant
    
    By To_Be_Read_and_Signed_By_Applicant_check=By.xpath("//span[.='This certifies that I completed this application, and that all entries on it and information in it are true and complete to the best of my knowledge. Note: A motor carrier nay require an applicant to provide more information than that required by the  Federal Motor Carrier Safety Regulations.']");
    By ToBeReadAndSignedByApplicant_submit=By.xpath("//button[@type='submit']");
    
//----------------------------------------    
    By DisplayDriverStatus=By.xpath("//div[@class='col-lg-6 col-md-12']");
    By viewDriverApplication=By.xpath("//button[.=' View Application']");
    By DownloadApplication=By.xpath("//button[.='Download']");
    
    
//-------------------------------------------------------------------------------------------------------------------------    
    
    ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/VS02SubmitDriverApplicationAllYes.html", true);

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
//--------------------------------------------Random_Data--------------------------------------------------------------	
	private String Address() 
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 10));
		System.err.print(uuid);
		return uuid;
	}
	
	private String RandomChar() 
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 5));
		System.err.print(uuid);
		return uuid;
	}
	
	public static String RndmZipcode() 
	{
	    
	    Random rnd = new Random();
	    int number = rnd.nextInt(99999);

	    // this will convert any number sequence into  character.
	    return String.format("%05d", number);
	}
	
	public static String DOT() 
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(2999999);

	    // this will convert any number sequence into  character.
	    return String.format("%07d", number);
	}
	
	public static String Phone() 
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%06d", number);
	}
	
	public static String SSN_No() 
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999999);

	    // this will convert any number sequence into 9 character.
	    return String.format("%09d", number);
	}
	
	public static String Random_ExaminarNationalRegNumber() 
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(1999999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%10d", number);
	}

	
//---------------------------------------------------------------------------------------------------------------------------------	
	
	
	
	String DriverDev="http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/apply";
	String DriverBeta="https://compliance.fleetsmartcarrierservices.com/apply";
	String DriverProd="https://app.fleetdrive360.com/apply";
    

//------------------------------------------------Test Stated---------------------------------------------------------------------
	
//Driver application Login	
	@Test(priority=1)
	public void Verify_Driver_login() throws InterruptedException
	{
		logger = extent.startTest("Driver Login Page");
		logger.log(LogStatus.INFO, "To verify that Driver is able to submit the Application");
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(DriverProd);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, DriverProd);
		driver.manage().window().maximize();
		logger.log(LogStatus.PASS, "Test Case1 Opened Driver Login Page and Maximized");
		
	}
	@Test(priority=2)
	public void Verify_DriverUN()
	{
		logger = extent.startTest("Enter Driver Username");
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		driver.findElement(DrUN).sendKeys("vnc1"); //=====================================================Username
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case2 verified Title and Username Status is passed");
	}
	@Test(priority=3)
	public void Verify_DriverPSWD()
	{
		logger = extent.startTest("Enter Driver Password");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(DrPSWD).sendKeys("NhVcx#7RHi");  //==================================================Password
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case3 verified Password Status is passed");
	}
	
	@Test(priority=4)
	public void Verify_ClickLoginButton()
	{
		logger = extent.startTest("Enter 'Login' Button");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(DrLoginButton).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case4 verified Login Button Status is passed");
	}

       // choose Option to fill Driver application Form
	
/*	@Test(priority=5)
	public void Verify_Choose_Option() throws InterruptedException 
	{
	    logger = extent.startTest("Choose Online Application Option");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(OnlineForm).click();
		//driver.findElement(PDF_Application).click();
		driver.findElement(Submit2).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case5 Online Application Option choosen Status is passed");
		Thread.sleep(2000);
	}  */


	// Form 1. Driver Information
	@Test(priority=6)
	public void Verify_FillDriverinfo()
	{
	logger = extent.startTest("Fill Driver Basic info");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(DrDOB).click();
		driver.findElement(SelectYear).click();
		driver.findElement(Year).click();
		
		driver.findElement(SelectMonth).click();
		driver.findElement(Month).click();
		
		driver.findElement(ClickOnDate).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case6 Filled Driver Basic info Status is passed");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
    }
	@Test(priority=7)
	public void Verify_SSN_Number()
	{
	logger = extent.startTest("Enter SSN Number");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(SSN_Number).sendKeys(SSN_No());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case7 Entered SSN Number Status is passed");
	}
	
	@Test(priority=8)
	public void Verify_Phone_Number()
	{
	logger = extent.startTest("Enter Driver Phone_Number");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(Phone_No).sendKeys("4042"+Phone());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case8 Entered Driver Phone_Number Status is passed");
	}
	
	@Test(priority=9)
	public void Verify_click_Next() throws InterruptedException
	{
	    logger = extent.startTest("Enter DriverInfo click 'Next' button");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(Next).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case9 click on 'Next' button Status is passed");
	}
	
	
//	Form 2. Driver Address History
	
	
	@Test(priority=10)
	public void Verify_Enter_Address_Line12()
	{
	logger = extent.startTest("Enter Enter_Address_Line1 click 'Next' button");
		String title1 = driver.getTitle();
		driver.findElement(Address_Line1).sendKeys("F2-Address_Line1"+Address());
		driver.findElement(Address_Line2).sendKeys("F2-Address_Line2"+Address());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case10 Entered_Address_Line1 Status is passed");
	}
	@Test(priority=11)
	public void Verify_EnterCity()
	{
	logger = extent.startTest("Enter DriverInfo click 'Next' button");
		String title1 = driver.getTitle();
		driver.findElement(City).sendKeys(RandomChar());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case11 Entered_City Status is passed");
	}
	@Test(priority=12)
	public void Verify_Select_State()
	{
	logger = extent.startTest("Select_State");
		String title1 = driver.getTitle();
		driver.findElement(State).click();
		driver.findElement(By.xpath("//li[.='California']")).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case12 Select_State Status is passed");
	}
	@Test(priority=13)
	public void Verify_Zipcode()
	{
	logger = extent.startTest("Enter Zipcode");
		String title1 = driver.getTitle();
		driver.findElement(Zip_Code).sendKeys(RndmZipcode());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case13 Entered Zipcode Status is passed");
	}
	@Test(priority=14)
	public void Verify_NoOfYrAtThisAddress()
	{
	logger = extent.startTest("Enter Number of year at this Address");
		String title1 = driver.getTitle();
		driver.findElement(No_ofYearsAtThisAddress).sendKeys("3");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case14 Entered Zipcode Status is passed");
		
	}	

	@Test(priority=15)
	public void Verify_AddressNext() throws InterruptedException
	{
	logger = extent.startTest("click on Address Next button");
		String title1 = driver.getTitle();
		driver.findElement(Address_Next).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case15 clicked on Address Next button Status is passed");
	}
	
	
// Form 3. Upload Front and Back of current Driver’s License / Permit here
	@Test(priority=16)
	public void DriverLicenseDetails() throws InterruptedException
	{
	logger = extent.startTest("Enter Driver license Details");
		String title1 = driver.getTitle();
		Thread.sleep(2000);
		//driver.findElement(ChooseDLFront).click();
		driver.findElement(ChooseDLFront).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\License.png");
		Thread.sleep(5000);
		//driver.findElement(ChooseDLBack).click();
		driver.findElement(ChooseDLBack).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\LicenseBackSide.png");
		Thread.sleep(5000);
		driver.findElement(DL_IssueState).click();
		driver.findElement(By.xpath("//li[.='California']")).click();
		driver.findElement(LicenseNumber).sendKeys("1");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case16 Entered Driver License Details Status is passed");
		
	}
	@Test(priority=17)
	public void CurrentDL_Class() throws InterruptedException
	{
	logger = extent.startTest("Select Non-CDL");
		String title1 = driver.getTitle();
		Thread.sleep(2000);
		driver.findElement(DL_Class).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[.='None (Non-CDL Driver)']")).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case17 selected 'Non-CDL' Status Status is passed");
	}  
	
/*	@Test(priority=18)
	public void CurrentDL_Class2() throws InterruptedException
	{
	logger = extent.startTest("Select CurrentDL_Class2");
		String title1 = driver.getTitle();
		driver.findElement(DL_Class).click();
		driver.findElement(Select_DLClass).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case19 selected 'Class A' Status is passed");
	}  */

	@Test(priority=19)
	public void IssueDate()
	{
	logger = extent.startTest("Enter DL Issue Date");
		String title1 = driver.getTitle();
		//driver.findElement(Select_DLClass).click();
	    
		
		driver.findElement(DL_IssueDate).click();
		driver.findElement(By.xpath("//option[.='2014']")).click();
		
		driver.findElement(ClickMonth).click();
		driver.findElement(By.xpath("//option[.='April']")).click();
		
		driver.findElement(By.xpath("//div[.='14']")).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case19 Entered IssueDate Details Status is passed");
	}
	
	@Test(priority=20)
	public void ExpDate()
	{
	logger = extent.startTest("Enter DL Exp Date");
		String title1 = driver.getTitle();
		driver.findElement(DL_ExpDate).click();
		
		driver.findElement(ClickYear1).click();
		driver.findElement(By.xpath("//option[.='2029']")).click();
		
		driver.findElement(ClickMonth1).click();
		driver.findElement(By.xpath("//Option[@value='1']")).click();
		
		driver.findElement(By.xpath("(//div[.='8'])[3]")).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case20 Entered ExpDate Status is passed");
			
	}
	
	@Test(priority=21)
	public void Restrictions()
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		driver.findElement(Restrictions).sendKeys("F3-Title"+RandomChar());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case21 Entered Restrictions Details Status is passed");
	}
	
	@Test(priority=22)
	public void Endorsements()
	{
	logger = extent.startTest("Enter Endorsements");
		String title1 = driver.getTitle();
		driver.findElement(Endorsements).sendKeys("Endorsements"+RandomChar());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Endorsements Details Status is passed");
	}
	@Test(priority=23)
	public void DLNextButton() throws InterruptedException
	{
	logger = extent.startTest("Click on DLNextButton");
		String title1 = driver.getTitle();
		driver.findElement(DL_Next).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case23 DL Next page Status is passed");
	}
	
// Form 4.Commercial Driving and Equipment Experience
	@Test(priority=24)
	public void CD_Experience() throws InterruptedException
	{
	logger = extent.startTest("Enter CD Experience");
		String title1 = driver.getTitle();
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(HaveCDL_DL1).click();  //if yes
		Thread.sleep(2000);
		driver.findElement(WhatYear).sendKeys("2014");
		Thread.sleep(2000);
		driver.findElement(CDLExp).sendKeys("5");
		driver.findElement(EQP_Operated).click();
		driver.findElement(By.xpath("//input[@value='Dry Van']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case24 Entered 'CD Experience Details' Status is passed");
		
	}
	@Test(priority=25)
	public void From_Date()
	{
	logger = extent.startTest("Enter From_Date");
		String title1 = driver.getTitle();
		driver.findElement(By.xpath("//input[@name='form.equipment.0.operatedFrom']")).click();
		driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();
		driver.findElement(By.xpath("//option[.='2014']")).click();
		driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")).click();
		driver.findElement(By.xpath("//option[.='March']")).click();
		driver.findElement(By.xpath("(//div[.='11'])[3]")).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case25 Entered From_Date Details Status is passed");
			
	}
	
	@Test(priority=26)
	public void ToDate()
	{
	logger = extent.startTest("Enter ToDate");
		String title1 = driver.getTitle();
		driver.findElement(By.xpath("//input[@name='form.equipment.0.operatedTo']")).click();
		driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();
		driver.findElement(By.xpath("//option[.='2020']")).click();
		driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")).click();
		driver.findElement(By.xpath("//option[.='April']")).click();
		driver.findElement(By.xpath("//div[.='14']")).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case26 Entered ToDate Details Status is passed");
	}
	
	@Test(priority=27)
	public void Approximate_Total_Miles()
	{
	logger = extent.startTest("Enter Approximate Total Miles");
		String title1 = driver.getTitle();
		driver.findElement(By.xpath("//input[@id='form.equipment.0.miles']")).sendKeys(Phone());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case27 Entered Approximate Total Miles Details Status is passed");
	}
	
	@Test(priority=28)
	public void EquipmentExperienceNextButton() throws InterruptedException
	{
	logger = extent.startTest("Enter Equipment Experience Next Button");
		String title1 = driver.getTitle();
		driver.findElement(EQP_Exp).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case28 Entered Restrictions Details Status is passed");
	}  
	
	
	
//	Form 5.Employment History
	
	@Test(priority=29)
	public void HaveCemmercialDrivingExpYes() throws InterruptedException
	{
	logger = extent.startTest("Enter Have Cemmercial Driving ExpYes");
		String title1 = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(HaveCommercialDrivingExpYes).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case29 Entered Have Cemmercial Driving ExpYes Details Status is passed");
	}  
	
/*	@Test(priority=30)
   public void HaveCemmercialDrivingExpNo()
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		driver.findElement(HaveCommercialDrivingExpNo).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case30 Entered Restrictions Details Status is passed");
	}  */

	@Test(priority=31)
	public void DriverEmplrInfo()
	{
	logger = extent.startTest("Enter DriverEmplrInfo");
		String title1 = driver.getTitle();
		driver.findElement(EmpName).sendKeys("DREmplyr1"+Address());
		
		driver.findElement(AddressLine1).sendKeys("Emplyr Address Line 1"+Address());
		driver.findElement(AddressLine2).sendKeys("Empyr Address Line 2"+Address());

		driver.findElement(City2).sendKeys("Emplyr City"+Address());

		driver.findElement(ClickSate).click();
		driver.findElement(By.xpath("//li[.='California']")).click();
		driver.findElement(Zipcode).sendKeys(RndmZipcode());
		driver.findElement(ReasonForLeaving).sendKeys(Address());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case31 Entered Driver Emplr Info  Details Status is passed");
	
	}
	
	@Test(priority=32)
	public void JoiningFromDate() throws InterruptedException
	{
		logger = extent.startTest("Enter Joining FromDate");
		String title1 = driver.getTitle();
		driver.findElement(ClickFromDate).click();
		driver.findElement(Click_Year1).click();
		driver.findElement(By.xpath("//option[.='2014']")).click();    //select Year
		driver.findElement(ClickMonth2).click();
		driver.findElement(By.xpath("//option[.='April']")).click();    //select month
		driver.findElement(By.xpath("(//div[.='11'])[3]")).click();     // select Date
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case32 Entered Joining FromDate Details Status is passed");
	}
	
	@Test(priority=33)
	public void ResignedDate() throws InterruptedException
	{
		logger = extent.startTest("Enter Resigned Date");
		String title1 = driver.getTitle();
		driver.findElement(ClickToDate).click();
		driver.findElement(ClickYear3).click();
		driver.findElement(By.xpath("//option[.='2021']")).click();  //select Year
		driver.findElement(ClickMonth5).click();
		driver.findElement(By.xpath("//option[.='April']")).click(); //select month
		driver.findElement(By.xpath("(//div[.='24'])")).click();   // select Date
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case33 Entered Resigned Date Details Status is passed");
	}
	
	//only if minimum 3 years on Experience 
	@Test(priority=34)
	public void MoreInfoOfEmplyr() throws InterruptedException
	{
		logger = extent.startTest("Enter More Info Of Emplyr");
		String title1 = driver.getTitle();
		driver.findElement(DOT).sendKeys(DOT());
		driver.findElement(PhoneNo).sendKeys("404"+Phone());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case34 Entered More Info Of Emplyr Details Status is passed");
	}
	@Test(priority=35)
	public void EmplrEmail() throws InterruptedException
	{
		logger = extent.startTest("Enter Emplr Email");
		String title1 = driver.getTitle();
		driver.findElement(EmplrEmail).sendKeys("Emplyr"+RandomChar()+"@innowyze.testinator.com");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case35 Entered Emplr Email Details Status is passed");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	} 
	
	@Test(priority=36)
	public void SubjectToDrugAlcohol() throws InterruptedException
	{
	logger = extent.startTest("Enter SubjectToDrugAlcohol");
		String title1 = driver.getTitle();
		driver.findElement(SubjectedToDOTBeta).click();
		//driver.findElement(SubjectedToDOT).click();
		driver.findElement(SubjectedToDrugAlcohol_Yes).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case36 Entered Subject To Drug Alcohol Details Status is passed");
	}
	
	@Test(priority=37)
	public void I_confirmConcentCheck() throws InterruptedException
	{
		logger = extent.startTest("Enter I_confirmConcentCheck");
		String title1 = driver.getTitle();
		String CheckBoxinfo=driver.findElement(By.xpath("(//h6)[5]")).getText();
		System.out.println(CheckBoxinfo);
		driver.findElement(I_confirmConsent).click();
		Thread.sleep(4000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case27 Entered I_confirmConcentCheck Details Status is passed");
	}
	
	@Test(priority=38)
	public void AdditionalNonDriveExp() throws InterruptedException
	{
		logger = extent.startTest("Enter Additional Non Drive Exp ");
		String title1 = driver.getTitle();
		driver.findElement(AddtionalExpNo).click();
		driver.findElement(AddtionalExpNo).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case38 Entered Additional NonDrive Exp 'NO' Details Status is passed");
	}
	
	
	@Test(priority=39)
    public void Employment_HistoryNext() throws InterruptedException
	{
	logger = extent.startTest("Enter Employment_History Next");
		String title1 = driver.getTitle();
		driver.findElement(EmplrHsrtyNext).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Employment_HistoryNext Details Status is passed");
		
	}  
	
	
// Form 6.Traffic Violations
	@Test(priority=40)
    public void TrafficViolationsYes()
    {
    logger = extent.startTest("Enter Traffic Violations 'Yes' ");
		String title1 = driver.getTitle();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    	driver.findElement(Traffic_voilationYes).click();
    	Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case40 Entered Traffic Violations 'Yes' Details Status is passed");  
    }  
 /*  public void Traffic_ViolationNo() throws InterruptedException
    {
    logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
    	Thread.sleep(3000);
    	driver.findElement(Traffic_voilationNo).click();
    	Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Restrictions Details Status is passed");
    }  */
	
	@Test(priority=41)
    public void TrafficViolations_Location()
    {
    logger = extent.startTest("Enter Traffic Violations_Location");
		String title1 = driver.getTitle();
    	driver.findElement(ClickSelectLoc).click();
    	driver.findElement(By.xpath("//li[.='California']")).click();
    	Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case41 Entered Traffic Violations_Location Details Status is passed");
    }
	@Test(priority=42)
    public void TrafficViolationDate() throws InterruptedException
    {
    logger = extent.startTest("Enter Traffic ViolationDate");
		String title1 = driver.getTitle();
    	driver.findElement(ClickDate).click();
    
    	driver.findElement(Click_Year3).click();
    	driver.findElement(By.xpath("//option[.='2015']")).click();
    	driver.findElement(ClickMonth6).click();
    	driver.findElement(By.xpath("//option[.='May']")).click();
        driver.findElement(By.xpath("(//div[@aria-label='Choose Saturday, May 23rd, 2015'])[1]")).click();   //Error
    	//driver.findElement(By.xpath("//*[@id='main-content']/form[2]/div[3]/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[7]"));
   Thread.sleep(1000);
   Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case42 Entered Traffic ViolationDate Details Status is passed");
    }
	
	@Test(priority=43)
	public void ChargeAndPenalty()
	{
	logger = extent.startTest("Enter Charge And Penalty");
		String title1 = driver.getTitle();
		driver.findElement(Charge).sendKeys("High Speed");
		driver.findElement(Penalty).sendKeys("$50");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case43 Entered Charge And Penalty Details Status is passed");
	}  
	
	@Test(priority=44)
	public void TrafficViolations_Next() throws InterruptedException
	{
	logger = extent.startTest("Enter TrafficViolations_Next");
		String title1 = driver.getTitle();
		driver.findElement(TrafficViolation_Next).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case44 Entered TrafficViolations_Next Details Status is passed");
	}  
 
	
// Form 7. Adverse Licensing Actions   
	@Test(priority=45)
	public void Operate_motor_vehicle_ever_been_suspended_yes() throws InterruptedException
	{
	logger = extent.startTest("Enter Operate_motor_vehicle_ever_been_suspended_yes");
		String title1 = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(Operate_motor_vehicle_ever_been_suspended_Yes).click();
		driver.findElement(When).sendKeys("2015");
		driver.findElement(PleaseExplain).sendKeys(Address());
		Thread.sleep(2000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case46 Entered Operate_motor_vehicle_ever_been_suspended_yes Details Status is passed");
	} 
	
	/*public void Operate_motor_vehicle_ever_been_suspended_No() throws InterruptedException
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		Thread.sleep(2000);
		driver.findElement(Operate_motor_vehicle_ever_been_suspended_No).click();
		Thread.sleep(2000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Restrictions Details Status is passed");
	}  */
	
	@Test(priority=47)
	public void EverBeenDeniedLicence_yes() throws InterruptedException
	{
	logger = extent.startTest("Enter Ever Been Denied Licence_yes");
		String title1 = driver.getTitle();
		Thread.sleep(2000);
		driver.findElement(EverBeenDeniedLicense_yes).click();
		driver.findElement(By.xpath("(//input[@name='form.licenseDenied'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(When2).sendKeys("2015");
		driver.findElement(Please_Explain).sendKeys(Address());
		Thread.sleep(2000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case47 Entered Ever BeenDenied Licence_yes Details Status is passed");
		
	}  
	
  /* public void EverBeenDeniedLicence_no() throws InterruptedException
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		Thread.sleep(2000);
		driver.findElement(EverBeenDeniedLicense_No);
	}  */
	
	@Test(priority=48)
	public void Adverse_Licensing_Actions_Next() throws InterruptedException
	{   
	    logger = extent.startTest("Enter Adverse_Licensing_Actions_Next");
		String title1 = driver.getTitle();
		driver.findElement(Adverse_Licensing_Actions_Next).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case48 Entered Adverse_Licensing_Actions_Next Details Status is passed");
	}  
	
	
	
//Form 8.Accident History
	@Test(priority=49)
	public void involvedInAccidents_yes() throws InterruptedException
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		driver.findElement(InvolvedInAccidents_Yes).click();
		driver.findElement(Click_AccidentDate).click();
		
		driver.findElement(Click_Year1).click();
		driver.findElement(By.xpath("//option[.='2016']")).click();
		driver.findElement(ClickMonth4).click();
		driver.findElement(By.xpath("//option[.='March']")).click();
		driver.findElement(By.xpath("//div[.='26']")).click();
		
		driver.findElement(NatureOfAccident).sendKeys("Weather related");
		driver.findElement(City3).sendKeys("LosAngeles");
		driver.findElement(Click_State).click();
		driver.findElement(By.xpath("//li[.='California']")).click();
		driver.findElement(NoOfFatalities).sendKeys("1");
		driver.findElement(NoOfInjuries).sendKeys("2");
		
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case49 Entered Restrictions Details Status is passed");

	} 
	@Test(priority=50)
	public void Hazmat_Spill_No() throws InterruptedException
	{
	logger = extent.startTest("Enter Hazmat_Spill_No");
		String title1 = driver.getTitle();
		Thread.sleep(3000);
		driver.findElement(HazmatSpill_No).click();
		driver.findElement(HazmatSpill_No).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case50 Entered Hazmat_Spill_No Details Status is passed");
	}  
	/*@Test(priority=51)
	public void AddEqipment()
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		driver.findElement(AddEquipment).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Restrictions Details Status is passed");
	}  */
/*	public void involvedInAccidents_no()
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		driver.findElement(InvolvedInAccidents_No).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Restrictions Details Status is passed");
	}  */
	
	@Test(priority=51)
     public void Accident_HistoryNext() throws InterruptedException
	{
	logger = extent.startTest("Enter Accident_HistoryNext");
		String title1 = driver.getTitle();
		driver.findElement(Accident_History_Next).click();
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case51 Entered Accident_HistoryNext Details Status is passed");
	} 
	
//	Form 9. DOT Physical and Medical Certificate
	@Test(priority=52)
	public void UploadMedicalCertificate() throws InterruptedException
	{
		Thread.sleep(2000);
	logger = extent.startTest("Enter Upload Medical Certificate");
		String title1 = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Thread.sleep(3000);
		driver.findElement(UploadMedical_Certificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\MedicalCertificates1.png");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case52 Entered Upload Medical Certificate Details Status is passed");
	}
	
	@Test(priority=53)
	public void MedicalCertificateIssueDate() throws InterruptedException
	{
		Thread.sleep(2000);
	logger = extent.startTest("Enter Medical Certificate IssueDate");
		String title1 = driver.getTitle();
		driver.findElement(MedicalC_issuedateClick).click();
		driver.findElement(Click_Year2).click();
		driver.findElement(By.xpath("//option[.='2014']")).click();
		driver.findElement(ClickMonth8).click();
		driver.findElement(By.xpath("//option[.='April']")).click();
		driver.findElement(By.xpath("(//div[.='11'])[3]")).click();Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case53 Entered Medical Certificate IssueDate Details Status is passed");
		
	}  
	@Test(priority=54)
	public void MedicalCertificateExpDate()
	{
	logger = extent.startTest("Enter Medical Certificate ExpDate");
		String title1 = driver.getTitle();
		driver.findElement(MedicalC_ExpDateClick).click();
		driver.findElement(Click_Year5).click();
		
		driver.findElement(By.xpath("//option[.='2030']")).click();
		
		driver.findElement(ClickMonth9).click();
	   	
		driver.findElement(By.xpath("//option[.='April']")).click();
	    
	   	driver.findElement(By.xpath("(//div[.='11'])[3]")).click();
	   	Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case54 Entered Medical Certificate ExpDate Details Status is passed");
	}
	@Test(priority=55)
	public void NameOfMedicalExaminer()
	{
	logger = extent.startTest("Enter Name Of Medical Examiner");
		String title1 = driver.getTitle();
		driver.findElement(NameOfExaminar).sendKeys(RandomChar());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case55 Entered Name Of Medical Examiner Details Status is passed");
	}
	@Test(priority=56)
	public void ExaminarNationalRegNumber()
	{
	logger = extent.startTest("Enter ExaminarNationalRegNumber");
		String title1 = driver.getTitle();
		driver.findElement(Examiners_National_RegistoryNo).sendKeys(Random_ExaminarNationalRegNumber());
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case56 Entered Examinar National RegNumber Details Status is passed");
	} 
	
	@Test(priority=57)
 	public void LimitAbilityToPerformYes() throws InterruptedException
	{
		Thread.sleep(2000);
	logger = extent.startTest("Enter Limit AbilityToPerformYes");
		String title1 = driver.getTitle();
		driver.findElement(GoodPhysicalConditionYes).click();
		driver.findElement(GoodPhysicalConditionYes).click();
		Thread.sleep(2000);
		driver.findElement(PleaseExplain2).sendKeys("Sleepy");
		Thread.sleep(2000);
		driver.findElement(UploadMedicalCertificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\Medical Certificate2.jfif");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case57 Entered Limit AbilityToPerformYes Details Status is passed");
	}  
	
/*	public void LimitAbilityToPerformNo()
	{
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		driver.findElement(GoodPhysicalConditionNo).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Restrictions Details Status is passed");
	}  */
	
	@Test(priority=58)
 	public void Past3YrsEverTestedPositiveYes() throws InterruptedException
	{
		Thread.sleep(2000);
	logger = extent.startTest("Enter Past3YrsEverTestedPositiveYes");
		String title1 = driver.getTitle();
		Thread.sleep(3000);
		driver.findElement(Past3YearsTestedPositiveYes).click();
		driver.findElement(Past3YearsTestedPositiveYes).click();
		Thread.sleep(2000);
		driver.findElement(When_year).sendKeys("2015");
		Thread.sleep(3000);
		driver.findElement(Expain).sendKeys("Some time");
		Thread.sleep(3000);
		driver.findElement(UploadReference_MedicalCertificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\ResetPasswordError.png");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case58 Entered Past3YrsEverTestedPositiveYes Details Status is passed");
		
	}   
	
/*	public void Past3YrsEverTestedPositiveNo()
	{
	Thread.sleep(2000);
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		driver.findElement(Past3YearsTestedPositiveNo);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Restrictions Details Status is passed"); 
	}  */
	
	@Test(priority=59)
    public void Refused_to_take_TestYes() throws InterruptedException
    {
		Thread.sleep(3000);
    logger = extent.startTest("Enter Refused_to_take_TestYes");
		String title1 = driver.getTitle();
		//driver.findElement(By.xpath("//input[@name='form.refusedToTest' and @value='yes']")).click();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		 WebElement Refuseddrug = driver.findElement(By.xpath("//input[@name='form.refusedToTest' and @value='yes']"));
	        j.executeScript("arguments[0].click();", Refuseddrug );
		
	    	//driver.findElement(Past3YearsTestedPositiveYes).click();
	    	//driver.findElement(Past3YearsTestedPositiveYes).click();
	    	driver.findElement(WhenYear).sendKeys("2016");
	    	driver.findElement(PleaseExplain4).sendKeys("i'm taken drug so");
	    	driver.findElement(UploadMedicalReferenceCertificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\meeting Photo.png");
    	Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case59 Entered Refused_to_take_TestYes Details Status is passed");
    } 
    
   /* public void Refused_to_take_TestNo()
    {
    logger = extent.startTest("Enter Refused_to_take_TestNo");
		String title1 = driver.getTitle();
    	driver.findElement(Past3YearsTestedPositiveYes).click();
    	Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Refused_to_take_TestNo Details Status is passed");
    }  */
	
	@Test(priority=60)
    public void DOT_Physical_and_Medical_Certificate_Next() throws InterruptedException
	{
		Thread.sleep(6000);
	logger = extent.startTest("Enter DOT_Physical_and_Medical_Certificate_Next");
		String title1 = driver.getTitle();
		driver.findElement(DOT_Physical_and_Medical_Certificate_Next).click();
		Thread.sleep(2000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case60 Entered DOT_Physical_and_Medical_Certificate_Next Details Status is passed");
	}  
	
// Form 10. Consent Forms	
	@Test(priority=61)
	public void Consent_Forms() throws InterruptedException
	{
		Thread.sleep(2000);
	logger = extent.startTest("Enter Consent_Forms");
		String title1 = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(first_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkfirstform).click();
		Thread.sleep(1000);
		driver.findElement(second_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checksecondform).click();
		Thread.sleep(1000);
		driver.findElement(third_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkthirdform).click();
		Thread.sleep(1000);
		driver.findElement(fourth_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkfourthform).click();
		Thread.sleep(1000);
		driver.findElement(fifth_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkfifthform).click();
		Thread.sleep(1000);
		driver.findElement(sixth_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checksixthform).click();
		Thread.sleep(1000);
		driver.findElement(seventh_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkseventhform).click();
		
		Thread.sleep(3000);
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case61 Entered Consent_Forms Details Status is passed");
	} 
	
	@Test(priority=62)
	public void signature() throws InterruptedException
	{
	logger = extent.startTest("Enter signature");
		String title1 = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement signatureele = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		Actions drawaction = act.moveToElement(signatureele, 50, 50);
		drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
		Thread.sleep(2000);  
		Assert.assertTrue(true);
		//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
		System.out.println("Driver consent form submitted successfully");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case62 Entered signature Details Status is passed");
	}
	
	@Test(priority=63)
	public void ConsentForms_Next() throws InterruptedException
	{
	logger = extent.startTest("Enter ConsentForms_Next");
		String title1 = driver.getTitle();
		Thread.sleep(3000);
		driver.findElement(ConsentForms_Next).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case63 Entered ConsentForms_Next Details Status is passed");
	}   
	
	
// Form 11.To Be Read and Signed By Applicant
	@Test(priority=64)
	public void ToBeReadAndSignedByApplicant() throws InterruptedException
	{
		logger = extent.startTest("Enter signature");
	logger = extent.startTest("Enter Restrictions");
		String title1 = driver.getTitle();
		Thread.sleep(3000);
		driver.findElement(To_Be_Read_and_Signed_By_Applicant_check).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case64 Entered To Be Read And Signed By Applicant Details Status is passed");
	} 
	
	
	@Test(priority=65)
	public void signature2() throws InterruptedException
	{
		logger = extent.startTest("Enter signature2");
		String title1 = driver.getTitle();
		 Thread.sleep(2000);
		    
		    WebElement signatureele1 = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
			Actions act1=new Actions(driver);
			Thread.sleep(3000);
			Actions drawaction1 = act1.moveToElement(signatureele1, 50, 50);
			Thread.sleep(3000);
			drawaction1.clickAndHold().moveByOffset(10, 30).release().perform();
			Thread.sleep(3000);
			Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
			logger.log(LogStatus.PASS, "Test Case65 Entered signature2 Details Status is passed");
	}
	
	@Test(priority=66)
	public void ToBeReadAndSignedByApplicant_submit()
	{
	logger = extent.startTest("Enter ToBeReadAndSignedByApplicant_submit");
		String title1 = driver.getTitle();
		driver.findElement(ToBeReadAndSignedByApplicant_submit).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case66 Entered ToBeReadAndSignedByApplicant_submit Details Status is passed");
	}  
	
	// ------------------------------------------------------------------------------
	@Test(priority=67)
	public void ApplicationStatus() {

		logger = extent.startTest("Enter Application Status");
		String title1 = driver.getTitle();
		String StatusOfDriverApplication = driver.findElement(DisplayDriverStatus).getText();
		// System.out.println(StatusOfDriverApplication);
		driver.findElement(viewDriverApplication).click();
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered Application Status Details Status is passed");
	}
	
	@Test(priority=68)
	public void downloadDriverApplication()
	{
	logger = extent.startTest("Enter download Driver Application");
		String title1 = driver.getTitle();
		driver.findElement(DownloadApplication).click();	
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Test Case22 Entered 'Download' Driver Application button Details Status is passed");
	}  

/*	public void failTest() 
	{

		logger = extent.startTest("failTest");
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "NoTitle");
		logger.log(LogStatus.FAIL, "Test Case (failTest) Status is passed");
	}

	public void skipTest() 
	{
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
*/

	

	
	
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
	
}	


package FD360POM;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class DriverApplicationLogin 
{
	private static final By Driver_Email = null;

	WebDriver driver;
	
	By DrUN=By.xpath("//*[@id='username']");
	By DrPSWD=By.xpath("//*[@id='password']");
	By DrLoginButton=By.xpath("//button[@type='submit']");
	
//Confirm DriverID and CompanyName
	By Driver_ID=By.xpath("(//div[@class='col-lg-3 col-md-12'])[1]");
	By CompanyName=By.xpath("(//div[@class='col-lg-3 col-md-12'])[2]");
	
	By OnlineForm=By.xpath("//input[@name='Online_Application']");
	By PDF_Application =By.xpath("//input[@name='PDF_Application']");
	By Submit2=By.xpath("(//button[@type='button'])[4]");

// form 1 Driver information
	By DrDOB=By.xpath("//input[@type='date']");

	By SelectYear=By.xpath("//select[@class='react-datepicker__year-select']");
	
	By Year=By.xpath("//Option[@value='1990']");
	
	By SelectMonth=By.xpath("//select[@class='react-datepicker__month-select']");
	
	By Month=By.xpath("//option[@value='3']");
	
	By ClickOnDate=By.xpath("//div[.='14']");
	
	By SSN_Number=By.xpath("//input[@name='form.ssnNumber']");
	By Phone_No=By.xpath("//input[@name='form.phone']");
	
	By Previous1=By.xpath("//button[@class='driverAppPrevBtn']");
	By Next=By.xpath("//button[@type='submit']");
	
// Driver Address History
	
	By Form_1_Name=By.xpath("//h3[@id='driver_title_header']");
	By Address_1= By.xpath("//h5[.='Address 1']");
	
	By Address_Line1=By.xpath("//input[@name='form.driverAddresses.0.address_1']");
	By Address_Line2=By.xpath("//input[@name='form.driverAddresses.0.address_2']");
	By City=By.xpath("//input[@name='form.driverAddresses.0.city']");
	By State=By.xpath("//div[@id='mui-component-select-form.driverAddresses.0.state']");
	//By Select_State=By.xpath("//li[.='California']");
	By Zip_Code=By.xpath("//input[@name='form.driverAddresses.0.zipCode']");
	By No_ofYearsAtThisAddress=By.xpath("//input[@name='form.driverAddresses.0.noOfYears']"); // if less than 3 use below
	
	By AddAddressA2=By.xpath("(//span[@class='MuiButton-label'])[1]");
	By Address_LineA21=By.xpath("//input[@name='form.driverAddresses.1.address_1']");
	By Address_LineA22=By.xpath("//input[@name='form.driverAddresses.1.address_2']");
	By CityA2=By.xpath("//input[@name='form.driverAddresses.1.city']");
	By State2=By.xpath("//div[@id='mui-component-select-form.driverAddresses.1.state']");
	//By Select_State=By.xpath("//li[.='California']");
	By Zip_CodeA2=By.xpath("//input[@name='form.driverAddresses.1.zipCode']");
	By No_ofYearsAtThisAddressA2=By.xpath("//input[@name='form.driverAddresses.1.noOfYears']"); 
	
	By Previous2=By.xpath("//button[@class='driverAppPrevBtn']");
	By Address_Next=By.xpath("//button[@type='submit']");
	
// 	Driver's License and Permit History
	
	By ChooseDLFront=By.xpath("//input[@id='driver_license_document']");
	
	By ChooseDLBack=By.xpath("//input[@id='driver_license_document_back']");
	By DL_IssueState=By.xpath("//div[@id='mui-component-select-form.license.0.issueState']");
	By ChooseState=By.xpath("//li[.='Alabama']");
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
			
	By DL_ExpDate=By.xpath("(//input[@name='form.license.0.expirationDate'])[1]");
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
    By SubjectedToDOT =By.xpath("//div[@id='form.employmentRecord[0].dotSubstanceCompliance']"); //input[@name='form.employmentRecord.0.dotSubstanceCompliance']    // body > div:nth-child(3) > div:nth-child(3) > div:nth-child(5) > form:nth-child(9) > div:nth-child(10) > div:nth-child(1) > div:nth-child(3) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)  //div[@id='dotSubstanceCompliance']
    
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
    
    
    By EverBeenDeniedLicense_No=By.xpath("(//input[@name='form.refusedToTest'])[2]");
                                          
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
    
    By HazmatSpill_Yes=By.xpath("(//input[@name='form.accidents.0.hazmatSpill'])[1]");
    By HazmatSpill_NoBeta=By.xpath("(//input[@name='form.accidents.0.hazmatSpill'])[2]");
    By HazmatSpill_No=By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @name='form.accidents.0.hazmatSpill' and @value='no']");	       //  (//input[@name='form.accidents.0.hazmatSpill'])[2]
    By AddEquipment=By.xpath("//span[.=' + Add Equipment ']");
    
    By Accident_History_Previous=By.xpath("//button[.='Previous']");
    By Accident_History_Next=By.xpath("//button[.='Next']");
    
    
// DOT Physical and Medical Certificate
    By ValidDOTMedical_Yes =By.xpath("(//input[@name='form.step9_q1'])[1]");
    By ValidDOTMedical_No =By.xpath("(//input[@name='form.step9_q1'])[2]");
    
    By WishToUploadMC_Yes=By.xpath("(//input[@name='form.step9_q2'])[1]");
    By WishToUploadMC_No=By.xpath("(//input[@name='form.step9_q2'])[2]");
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
    By GoodPhysicalConditionNoBeta=By.xpath("(//input[@name='form.limitedPhysicalAbility'])[2]");
    By PleaseExplain2=By.xpath("//input[@name='form.physicalHistory.1.remark']");  // if Yes
    By UploadMedicalCertificate=By.xpath("//input[@name='physical_condition_document_name']");
    
    By InPastDugAlcoholYes=By.xpath("(//input[@name='form.testedPositiveDOA'])[1]");
    By InPastDugAlcoholNo=By.xpath("(//input[@name='form.testedPositiveDOA'])[2]");
    By When_year=By.xpath("//input[@name='form.physicalHistory.2.date']");
    By Expain=By.xpath("//input[@name='form.physicalHistory.2.remark']");
    By UploadReference_MedicalCertificate=By.xpath("//input[@name='positive_tested_document_name']");		
    
    By Past3YearsTestedPositiveYes=By.xpath("(//input[@name='form.refusedToTest'])[1]");
    By Past3YearsTestedPositiveNo=By.xpath("(//input[@name='form.testedPositiveDOA'])[2]");
    By Past3YearsTestedPositiveNoBeta=By.xpath("(//input[@name='form.testedPositiveDOA'])[2]");
    By WhenYear=By.xpath("//input[@name='form.physicalHistory.0.date']"); // if Yes
    By PleaseExplain3=By.xpath("//input[@name='form.physicalHistory.0.remark']");
    By UploadMedicalReferenceCertificate=By.xpath("//input[@name='pre_employment_test_document_name']");
    
    By DOT_Physical_and_Medical_Certificate_Previous=By.xpath("//button[.='Previous']");
    By DOT_Physical_and_Medical_Certificate_Next=By.xpath("//button[.='Next']");
    
// MVR Consent form    
    By MVR_Form=By.xpath("//div[@id='consent1_header']//div[1]"); //div[@id='consent1_header']//div[1]
    By MVR_Consent_License=By.xpath("//input[@id='form_consentForm_license_number']");
    By MVR_Consent_L_State=By.xpath("//input[@id='form_consentForm_state']");
    By MVR_Consent_Check=By.xpath("//input[@value='consent1Check']");
    By MVR_Sig=By.xpath("//div[@id='step_10_first']//div//canvas");
    By MVR_Submit=By.xpath("//button[@type='submit']");
    
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
    
    
    
    
//Driver application Login	
	public DriverApplicationLogin(WebDriver d)
	{
		driver=d;
	}
	
	public void DriverUN(String UserName)
	{
		driver.findElement(DrUN).sendKeys(UserName);
	}
	public void DriverPSWD(String Password)
	{
		driver.findElement(DrPSWD).sendKeys(Password);
	}
	public void ClickLoginButton()
	{
		driver.findElement(DrLoginButton).click();
	}

       // choose Option to fill Driver application Form
	public void Choose_Option() 
	{
		driver.findElement(OnlineForm).click();
		//driver.findElement(PDF_Application).click();
		driver.findElement(Submit2).click();
	}

// Form 1. Driver Information	
	public void FillDriverinfo() throws AWTException
	{
		driver.findElement(DrDOB).click();
	/*	
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_9);
		rbt2.keyRelease(KeyEvent.VK_9);
		rbt2.keyPress(KeyEvent.VK_9);
		rbt2.keyRelease(KeyEvent.VK_9);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
	*/	
		driver.findElement(DrDOB).sendKeys("01041990");
	/*	driver.findElement(SelectYear).click();
		driver.findElement(Year).click();
		
		driver.findElement(SelectMonth).click();
		driver.findElement(Month).click();
		
		driver.findElement(ClickOnDate).click();  
		*/
    }
	public void SSN_Number(String SSN_No)
	{
		driver.findElement(SSN_Number).sendKeys(SSN_No);
	}
	
	public void Phone_Number()
	{
		driver.findElement(Phone_No).sendKeys("4042"+Phone());
	}
	
	public void Drivername()
	{
		WebElement textField = driver.findElement(By.xpath("//input[@id='firstName']"));

        // Get the text from the text field
        String DriverName = textField.getAttribute("value");

        // Use keyboard shortcuts (Ctrl+A for Windows/Linux, Command+A for Mac) to select all text
        textField.sendKeys(Keys.CONTROL + "a");

        // Use keyboard shortcuts (Ctrl+C for Windows/Linux, Command+C for Mac) to copy the selected text
        textField.sendKeys(Keys.CONTROL + "c");

        // You now have the text copied to your clipboard and can use it as needed
        System.out.println("Copied Text: " + DriverName);

		//driver.findElement(arg0)
	}
	
	public void click_Next() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(Next).click();
		Thread.sleep(3000);
	}
	
	
//	Form 2. Driver Address History
	
	
	
	public void Enter_Address_Line1()
	{
		driver.findElement(Address_Line1).sendKeys("7101 S CENTRAL AVE LOS ANGELES, CA 90001-9998");
		
	}
	public void EnterCity()
	{
		driver.findElement(City).sendKeys("LOS ANGELES");
	}
	public void Select_State()
	{
		driver.findElement(State).click();
		driver.findElement(By.xpath("//li[.='Delaware']")).click();
	}
	public void Zipcode(String zipcode)
	{
		driver.findElement(Zip_Code).sendKeys("90001");
	}
	public void NoOfYrAtThisAddress() throws InterruptedException
	{
		driver.findElement(No_ofYearsAtThisAddress).sendKeys("3");
		Thread.sleep(2000);
		
	}
/*	public void AllAddressDetailsinConsole()
	{
		WebElement AddresssDetails=driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4 formik_driver_form_container css-1tz8m30']"));
		System.out.println(AddresssDetails);
	}
*/	
	public void AddAddress2()
	{
		driver.findElement(AddAddressA2).click();
	}
	public void Enter_Address_Line2()
	{
		driver.findElement(AddAddressA2).sendKeys("680 DUFFIELD DEPOT");
		
	}
	public void EnterCity2()
	{
		driver.findElement(CityA2).sendKeys("DUFFIELD");
	}
	public void Select_State2()
	{
		driver.findElement(State2).click();
		driver.findElement(By.xpath("//li[.='Virginia']")).click();
	}
	public void Zipcode2()
	{
		driver.findElement(Zip_CodeA2).sendKeys("24244");
	}
	public void NoOfYrAtThisAddress2()
	{
		driver.findElement(No_ofYearsAtThisAddressA2).sendKeys("1");
		
	}

	public void AddressNext() throws InterruptedException
	{
		driver.findElement(Address_Next).click();
		Thread.sleep(1000);
	}
	
	
// Form 3. Upload Front and Back of current Driver’s License / Permit here
	
	public void DriverLicenseDetails() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.findElement(ChooseDLFront).click();
		driver.findElement(ChooseDLFront).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\DL Front.png");
		Thread.sleep(9000);
		//driver.findElement(ChooseDLBack).click();
		driver.findElement(ChooseDLBack).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\DL Back.png");
		Thread.sleep(9000);
		driver.findElement(DL_IssueState).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[.='Alabama']")).click();
		//driver.findElement(LicenseNumber).click();
		
	}
	
	public void CurrentDL_Class() throws InterruptedException
	{
		driver.findElement(DL_Class).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[.='None (Non-CDL Driver)']")).click();
		Thread.sleep(2000);
	}
	
	public void CurrentDL_Class2() throws InterruptedException
	{
		driver.findElement(DL_Class).click();
		Thread.sleep(1000);
		driver.findElement(Select_DLClass2).click();
		Thread.sleep(2000);
	}

	public void IssueDate() throws AWTException
	{

	    driver.findElement(DL_IssueDate).sendKeys(IssueDateBefore2Months());
	/*	driver.findElement(DL_IssueDate).click();
        Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_8);
		rbt2.keyRelease(KeyEvent.VK_8);
	*/
	}
	
	public void ExpDate() throws AWTException
	{
		driver.findElement(DL_ExpDate).sendKeys(ExpDatetomorrow());
	/*	driver.findElement(DL_ExpDate).click();
        Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_4);
		rbt2.keyRelease(KeyEvent.VK_4);
	*/
			
	}
	
	public void Restrictions()
	{
		driver.findElement(Restrictions).sendKeys("No Restrictions");
	}
	
	public void Endorsements()
	{
		driver.findElement(Endorsements).sendKeys("No Penalty");
	}
	
	public void DLNextButton()
	{
		driver.findElement(DL_Next).click();
	}
	
// Form 4.Commercial Driving and Equipment Experience
	
	public void CD_Experience() throws InterruptedException
	{
		driver.findElement(HaveCDL_DL1).click();  //if yes
	
		driver.findElement(WhatYear).sendKeys("2015");
		
		driver.findElement(CDLExp).sendKeys("5");
		driver.findElement(EQP_Operated).click();
		driver.findElement(By.xpath("//input[@value='Dry Van']")).click();
		Thread.sleep(1000);
		
	}
	
	public void From_Date() throws AWTException
	{
		driver.findElement(By.xpath("//input[@name='form.equipment.0.operatedFrom']")).sendKeys("01022016");
	/*	driver.findElement(By.xpath("//input[@name='form.equipment.0.operatedFrom']")).click();
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_6);
		rbt2.keyRelease(KeyEvent.VK_6);
	*/		
	}
	
	public void ToDate() throws AWTException
	{
		driver.findElement(By.xpath("//input[@name='form.equipment.0.operatedTo']")).sendKeys("01022021");
	/*	driver.findElement(By.xpath("//input[@name='form.equipment.0.operatedTo']")).click();
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
	*/	
	}
	
	public void Approximate_Total_Miles()
	{
		driver.findElement(By.xpath("//input[@id='form.equipment.0.miles']")).sendKeys("2345675");
	}
	
	public void EquipmentExperienceNextButton()
	{
		driver.findElement(EQP_Exp).click();
	}
	
//	Form 5.Employment History
	
	public void HaveCemmercialDrivingExpYes() throws InterruptedException
	{
		
		driver.findElement(HaveCommercialDrivingExpYes).click();
	}
	
	public void HaveCemmercialDrivingExpNo()
	{
		driver.findElement(HaveCommercialDrivingExpNo).click();
	}
	public void DriverEmplrInfo() throws InterruptedException
	{
		driver.findElement(EmpName).sendKeys("DEmployer");
		
		driver.findElement(AddressLine1).sendKeys("7101 S CENTRAL AVE LOS ANGELES, CA 90001-9998"+Address());

		driver.findElement(City2).sendKeys(Address());
		driver.findElement(ClickSate).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[.='California']")).click();
		driver.findElement(Zipcode).sendKeys(RndmZipcode());
		driver.findElement(ReasonForLeaving).sendKeys(Address());
	
	}
	
	public void JoiningFromDate() throws InterruptedException, AWTException
	{
		
		driver.findElement(ClickFromDate).sendKeys("01022015");
	/*	driver.findElement(ClickFromDate).click();
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_6);
		rbt2.keyRelease(KeyEvent.VK_6);
	*/	
	}
	
	public void ResignedDate() throws InterruptedException, AWTException
	{
		
	    driver.findElement(ClickToDate).sendKeys("10202022");
	/*	driver.findElement(ClickToDate).click();
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
	*/	
	}
	
	//only if minimum 3 years on Experience 
	public void MoreInfoOfEmplyr() throws InterruptedException
	{
		
		driver.findElement(DOT).sendKeys(DOT());
		//driver.findElement(PhoneNo).sendKeys("404"+Phone());
		
	}
	
	public void EmplrEmail() throws InterruptedException
	{
		
		driver.findElement(EmplrEmail).sendKeys("veereshtestit@gmail.com");
		
	} 
	
	public void EmpPhone()
	{
		driver.findElement(PhoneNo).sendKeys("4042"+Phone());
	}
	
	public void SubjectToDrugAlcohol() throws InterruptedException
	{
		Thread.sleep(2000);
		//driver.findElement(SubjectedToDOTDev).click();
		driver.findElement(SubjectedToDOT).click();
		driver.findElement(SubjectedToDrugAlcohol_No).click();
		
	}
	
	public void I_confirmConcentCheck() throws InterruptedException
	{
		
		String CheckBoxinfo=driver.findElement(By.xpath("(//h6)[5]")).getText();
		System.out.println(CheckBoxinfo);
		driver.findElement(I_confirmConsent).click();
		Thread.sleep(2000);
		
	}
	
	
	public void AdditionalNonDriveExp() throws InterruptedException
	{
		
		driver.findElement(AddtionalExpNo).click();
		driver.findElement(AddtionalExpNo).click();
	}
	
    public void Employment_HistoryNext() throws InterruptedException
	{

		driver.findElement(EmplrHsrtyNext).click();
	}
	
	
// Form 6.Traffic Violations
    public void TrafficViolationsYes()
    {
    	driver.findElement(Traffic_voilationYes).click();
    }
    public void Traffic_ViolationNo()
    {
    	driver.findElement(Traffic_voilationNo).click();
    }
    public void TrafficViolations_Location()
    {
    	driver.findElement(ClickSelectLoc).click();
    	driver.findElement(By.xpath("//li[.='California']")).click();
    	
    }
	
    public void TrafficViolationDate() throws InterruptedException
    {
    	driver.findElement(ClickDate).sendKeys("4042"+Phone());
    
    /*	driver.findElement(By.xpath("//option[.='2014']")).click();    //select Year
		driver.findElement(ClickMonth2).click();
		driver.findElement(By.xpath("//option[.='April']")).click();    //select month
		driver.findElement(By.xpath("(//div[.='11'])[3]")).click();     // select Date   //Error  */
    //	driver.findElement(By.xpath("//*[@id='main-content']/form[2]/div[3]/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[7]"));
   Thread.sleep(3000);
    }
	
	public void ChargeAndPenalty()
	{
		driver.findElement(Charge).sendKeys("High Speed");
		driver.findElement(Penalty).sendKeys("$50");
	}
	
	public void TrafficViolations_Next()
	{
		driver.findElement(TrafficViolation_Next).click();
	}
	public void TrafficViolations_Previous()
	{
		driver.findElement(TrafficViolation_Previous).click();
	}
	
// Form 7. Adverse Licensing Actions
	public void Operate_motor_vehicle_ever_been_suspended_yes() throws InterruptedException
	{
		driver.findElement(Operate_motor_vehicle_ever_been_suspended_Yes).click();
		driver.findElement(When).sendKeys("2016");
		driver.findElement(PleaseExplain).sendKeys("F7_Yes Please Explain"+Address());
		Thread.sleep(2000);
	}
	
	public void Operate_motor_vehicle_ever_been_suspended_No() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(Operate_motor_vehicle_ever_been_suspended_No).click();
		
	}
	
	
	public void EverBeenDeniedLicence_yes() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(EverBeenDeniedLicense_yes).click();
		Thread.sleep(1000);
		driver.findElement(When2).sendKeys("2015");
		driver.findElement(Please_Explain).sendKeys(Address());
		Thread.sleep(2000);
		
	}
	
	public void EverBeenDeniedLicence_no() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(EverBeenDeniedLicense_No).click();
	}
	
	public void Adverse_Licensing_Actions_Next()
	{
		driver.findElement(Adverse_Licensing_Actions_Next).click();
	}
	
	
//Form 8.Accident History
	public void involvedInAccidents_yes() throws InterruptedException
	{
		driver.findElement(InvolvedInAccidents_Yes).click();
		driver.findElement(Click_AccidentDate).sendKeys(IssueDateBefore2Months());
		
	/*	driver.findElement(Click_Year1).click();
		driver.findElement(By.xpath("//option[.='2016']")).click();
		driver.findElement(ClickMonth4).click();
		driver.findElement(By.xpath("//option[.='March']")).click();
		driver.findElement(By.xpath("//div[.='26']")).click();  */
		
		driver.findElement(NatureOfAccident).sendKeys("Weather related");
		driver.findElement(City3).sendKeys("LosAngeles");
		driver.findElement(Click_State).click();
		driver.findElement(By.xpath("//li[.='California']")).click();
		driver.findElement(NoOfFatalities).sendKeys("1");
		driver.findElement(NoOfInjuries).sendKeys("2");
		
		//driver.findElement(HazmatSpill_Yes).click();

	}
	public void Hazmat_SpillBeta_no()
	{
	     driver.findElement(HazmatSpill_NoBeta).click();
	}
	public void Hazmat_Spill_no() throws InterruptedException
	{
		
		driver.findElement(HazmatSpill_No).click();
	}
	public void AddEqipment()
	{
		driver.findElement(AddEquipment).click();
	}
	public void involvedInAccidents_no()
	{
		driver.findElement(InvolvedInAccidents_No).click();
	}
	
	public void Accident_HistoryNext()
	{
		driver.findElement(Accident_History_Next).click();
	}
	public void Accident_HistoryPrevious()
	{
		driver.findElement(Accident_History_Previous).click();
	}
	
//	Form 9. DOT Physical and Medical Certificate
	public void ValidDOTMC()
	{
		driver.findElement(ValidDOTMedical_Yes).click();
		//driver.findElement(ValidDOTMedical_No).click();
	}
	
	public void WishToUploadMC()
	{
		driver.findElement(WishToUploadMC_Yes).click();
		//driver.findElement(WishToUploadMC_No).click();
	}
	public void UploadMedicalCertificate()
	{
		driver.findElement(UploadMedical_Certificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\Medical Certificate.png"); 
	}
	
	public void MedicalCertificateIssueDate() throws Exception
	{
	    driver.findElement(MedicalC_issuedateClick).sendKeys(IssueDateBefore2Months());
	/*	driver.findElement(MedicalC_issuedateClick).click();
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_7);
		rbt2.keyRelease(KeyEvent.VK_7);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_3);
		rbt2.keyRelease(KeyEvent.VK_3);
	*/
	}
	public void MedicalCertificateExpDate() throws Exception
	{
		
		driver.findElement(MedicalC_ExpDateClick).sendKeys(ExpDatetomorrow());
	/*	driver.findElement(MedicalC_ExpDateClick).click();
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_1);
		rbt2.keyRelease(KeyEvent.VK_1);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_5);
		rbt2.keyRelease(KeyEvent.VK_5);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_0);
		rbt2.keyRelease(KeyEvent.VK_0);
		rbt2.keyPress(KeyEvent.VK_2);
		rbt2.keyRelease(KeyEvent.VK_2);
		rbt2.keyPress(KeyEvent.VK_4);
		rbt2.keyRelease(KeyEvent.VK_4);
	*/	  
	}
	public void NameOfMedicalExaminer()
	{
		driver.findElement(NameOfExaminar).sendKeys("Dr John");
	}
	public void ExaminarNationalRegNumber()
	{
		driver.findElement(Examiners_National_RegistoryNo).sendKeys("9"+NationalRegNo());
	}
	
	
	public void LimitAbilityToPerformYes()
	{
		driver.findElement(GoodPhysicalConditionYes).click();
		driver.findElement(GoodPhysicalConditionYes).click();
		driver.findElement(PleaseExplain2).sendKeys("Sleepy");
		driver.findElement(UploadMedicalCertificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\Medical Certificate2.jfif");
	}
	public void LimitAbilityToPerformNoBeta()
	{
		driver.findElement(GoodPhysicalConditionNoBeta).click();
		
	}
	public void LimitAbilityToPerformNo()
	{
		driver.findElement(GoodPhysicalConditionNo).click();
		driver.findElement(GoodPhysicalConditionNo).click();
	}
	
	public void Past3YrsEverTestedPositiveYes() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(Past3YearsTestedPositiveYes).click();
		driver.findElement(Past3YearsTestedPositiveYes).click();
		driver.findElement(When_year).sendKeys("2015");
		Thread.sleep(1000);
		driver.findElement(Expain).sendKeys("F9_Expain- Some time");
		Thread.sleep(2000);
		driver.findElement(UploadReference_MedicalCertificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\ResetPasswordError.png");
	}
	
	public void Past3YrsEverTestedPositiveNo()
	{
		driver.findElement(Past3YearsTestedPositiveNo).click();
		
	}
	public void Past3YrsEverTestedPositiveNoBeta()
	{
		driver.findElement(Past3YearsTestedPositiveNoBeta).click();
		
	}
	
	
    public void Refused_to_take_TestYes()
    {
    	driver.findElement(Past3YearsTestedPositiveYes).click();
    	driver.findElement(Past3YearsTestedPositiveYes).click();
    	driver.findElement(WhenYear).click();
    	driver.findElement(PleaseExplain3).click();
    	driver.findElement(UploadMedicalReferenceCertificate).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\meeting Photo.png");
    }
    
    public void Refused_to_take_TestNo()
    {
    	driver.findElement(EverBeenDeniedLicense_No).click();
    }
	public void DOT_Physical_and_Medical_Certificate_Next()
	{
		driver.findElement(DOT_Physical_and_Medical_Certificate_Next).click();
		driver.findElement(DOT_Physical_and_Medical_Certificate_Next).click();
	}
	
// Form 10. MVR Consent Forms
	
	public void MVR_Consent_form()
	{
	  driver.findElement(MVR_Form).click();
	  driver.findElement(MVR_Consent_License).sendKeys("CDLtest005");
	  driver.findElement(MVR_Consent_L_State).sendKeys("California");
	  driver.findElement(MVR_Consent_Check).click();
	}
	
	public void MVR_Sig() throws Exception
	{
		WebElement signatureele = driver.findElement(MVR_Sig);
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		Actions drawaction = act.moveToElement(signatureele, 50, 50);
		drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
		Thread.sleep(2000);  
		Assert.assertTrue(true);
		//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
		System.out.println("Driver consent form submitted successfully");
	}
	
	public void MVR_Next()
	{
		driver.findElement(MVR_Submit).click();
	}
	
// Form 11. Consent Forms		
	public void Consent_Forms() throws InterruptedException
	{
		driver.findElement(first_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkfirstform).click();
		Thread.sleep(2000);
		driver.findElement(second_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checksecondform).click();
		Thread.sleep(2000);
		driver.findElement(third_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkthirdform).click();
		Thread.sleep(2000);
		driver.findElement(fourth_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkfourthform).click();
		Thread.sleep(2000);
		driver.findElement(fifth_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkfifthform).click();
		Thread.sleep(2000);
		driver.findElement(sixth_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checksixthform).click();
		Thread.sleep(2000);
		driver.findElement(seventh_ConsentForm).click();
		Thread.sleep(1000);
		driver.findElement(checkseventhform).click();
		Thread.sleep(2000);
	}
	
	public void signature() throws InterruptedException
	{
		// scroll down by 500 pixels with Javascript Executor
	      JavascriptExecutor j = (JavascriptExecutor) driver;
	      j.executeScript("window.scrollBy(0,500)");
	      // identify element
	      WebElement m = driver.findElement(By.tagName("canvas"));
	      String s = m.getText();
	      System.out.println("Text obtained on scrolling down: "+ s);
	      // scroll down up 500 pixels with Javascript Executor
	      j.executeScript("window.scrollBy(0,-500)");
	      // identify element
		WebElement signatureele = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		Actions drawaction = act.moveToElement(signatureele, 50, 50);
		drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
		Thread.sleep(2000);  
		Assert.assertTrue(true);
		//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
		System.out.println("Driver consent form submitted successfully");
	}
	
	
	public void ConsentForms_Next()
	{
		driver.findElement(ConsentForms_Next).click();
	}
	
	public void ConsentForms_Previous()
	{
		driver.findElement(ConsentForms_Previous).click();
	}
	
	
// Form 12.To Be Read and Signed By Applicant
	public void ToBeReadAndSignedByApplicant()
	{
		driver.findElement(To_Be_Read_and_Signed_By_Applicant_check).click();
	}
	
	public void signature_2() throws InterruptedException
	{
		WebElement signatureele = driver.findElement(By.xpath("//canvas[@class='consentSignatureCanvasStyle']"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		Actions drawaction = act.moveToElement(signatureele, 50, 50);
		drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
		Thread.sleep(2000);  
		Assert.assertTrue(true);
		//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
		System.out.println("Driver consent form submitted successfully");
	}
	public void ToBeReadAndSignedByApplicant_submit()
	{
		driver.findElement(ToBeReadAndSignedByApplicant_submit).click();
	}
	
//------------------------------------------------------------------------------	
	public void ApplicationStatus()
	{
		String StatusOfDriverApplication=driver.findElement(DisplayDriverStatus).getText();
		//System.out.println(StatusOfDriverApplication);
		driver.findElement(viewDriverApplication).click();
	}
	
	public void downloadDriverApplication()
	{
		driver.findElement(DownloadApplication).click();	
	}
	
	
	
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
	    int number = rnd.nextInt(9999999);

	    // this will convert any number sequence into  character.
	    return String.format("%05d", number);
	}
	
	public static String Phone() 
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%06d", number);
	}
	
	public static String NationalRegNo() 
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999999);

	    // this will convert any number sequence into 9 character.
	    return String.format("%09d", number);
	}
	
	public String IssueDateBefore2Months()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.minusMonths(2);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;  	        
	}
	
	public String ExpDatetomorrow()
	{
	        LocalDate currentDate = LocalDate.now();

	        LocalDate nextDay = currentDate.plusDays(1);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        String formattedDate = nextDay.format(formatter);
			
	        return formattedDate;      	        
	}
}

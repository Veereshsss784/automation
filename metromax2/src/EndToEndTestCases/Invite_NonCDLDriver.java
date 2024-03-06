package EndToEndTestCases;

import sample.DataFromExcel;
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

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

//import io.github.bonigarcia.wdm.WebDriverManager;
import sample.ExtentReportsClass;

@Test
public class Invite_NonCDLDriver {



//------------ Login SVP------------------------------------	
	By Title=By.xpath("//img[@src='/fleetdrivelogo1.png']");
	By LoginAppLOGO=By.xpath("//a[@id='desktop_view_logo']//img");
	By Username=By.xpath("//input[@name='username_or_email']");
	By Password=By.xpath("//input[@name='password']");
	By Login=By.xpath("//button[@type='submit']");
	By ForgotPassword=By.xpath("//a[.='Forgot Password ?']");
	By DriverLoginLink=By.xpath("//a[.='Click Here']");
	
	
//-------------DashboardSVP---------------------------------
	By SVP_HomePageLOGO=By.xpath("(//img[@alt='logo'])[1]");
	By DashboardModule=By.xpath("//span[.='Dashboard']");
	
	By CompliantClientCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[1]");	
	By NonCompliantClientCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[2]");
	
	By CompliantDriverCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[3]");
	By NonCompliantDriverCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[4]");
	
	By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");  //div[@id='rbd-hidden-text-8-hidden-text-38']  //input[@id='mui-93707']
    
	By CarrierProfileIcon=By.xpath("//div[@class=' sb-avatar sb-avatar--text']");
    By FleetMyProfile=By.xpath("(//a[@class='dropdown-item'])[1]"); // for My Profile
    By FleetSettings=By.xpath("(//a[@class='dropdown-item'])[2]");// For Settings
    By ManageAccount=By.xpath("uncontrolled-tab-example-tab-ManageAccount");   //Tab
  //  By ChangePassword=
    By CurrentPassword=By.xpath("//input[@id='currentPasswordManageAccount']");  
   
    
    By NotificationBellIcon=By.xpath("//i[@class='icon-bell']");
 /*   Actions action = new Actions(driver);
    WebElement element = driver.findElement(By.id("elementId"));
    action.moveToElement(element).perform();  
 */
    By NotificationBody=By.xpath("//div[@id='notificationCardBody']");
    By FleetLogout=By.xpath("//i[@class='icon-power']");
	
    
//------------------- CompanyProfileModule_SVP --------------------
    By CompanyProfileModule_svp=By.xpath("//span[.='Company Profile']");
	By Company_info=By.xpath("//div[@class='row clearfix']");
	
	By Address_info1=By.xpath("(//div[@class='row clearfix'])[2]");
	By Address_info2=By.xpath("//input[@id='cityProfile']");
	By Address_info3=By.xpath("//input[@id='zipCodeProfile']");
	By Address_info4=By.xpath("//input[@id='faxProfile']");
	By Address_info5=By.xpath("//div[@id='unitAddVehicle']");
	By UsersAndRoles=By.xpath("//i[@class='fa fa5 fa-user-plus']");
	By UsersAndRolesRecord=By.xpath("//div[@id='sp-usertable']");
	
	By AddUser1=By.xpath("//button[.='Add User']");
	
	By Select_User=By.xpath("//div[@id='mui-component-select-selectedRole']");
	
	By Admin=By.xpath("//li[.='Admin']");
	
	By Admin_FN=By.xpath("//input[@id='firstNameAddUser']");
	By Admin_MN=By.xpath("//input[@id='middleNameAddUser']");
	By Admin_LN=By.xpath("//input[@id='lastNameAddUser']");
	By Phone_No=By.xpath("//input[@id='phoneAddUser']");
	By Admin_DOB=By.xpath("//input[@id='dobAddUser']");
    By Admin_Email=By.xpath("//input[@id='emailAddUser']");
    By Admin_UN=By.xpath("//input[@id='usernameAddUser']");
    By Admin_Pwd=By.xpath("//input[@id='passwordAddUser']");
    By Admin_ConfirmPwd=By.xpath("//input[@id='repeatPasswordAddUser']");
    By AdminPwd_see=By.xpath("//button[@value='isPasswordShown']");
    By Admin_AddUser=By.xpath("//button[.='Add User']");
    By Admin_Cancel=By.xpath("//button[@type='reset']");
    
    
    By Account_mngr=By.xpath("//li[.='Account Manager']");
   
    By Email_Host=By.xpath("//input[@id='emailHost']");
    By Email_User=By.xpath("//input[@id='emailUser']");
    By Email_Password=By.xpath("//input[@id='emailPassword']");
    By Email_Port=By.xpath("//input[@id='emailPort']");
    By Use_SSL=By.xpath("//input[@value='usessl']");

  //-------------------Manage Clients--------------------------------
  	By ManageClients=By.xpath("//span[.='Manage Clients']");
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
  	By Address11= By.xpath("//input[@name='address1']");
  	By Address21= By.xpath("//input[@name='address2']");
  	By City1=By.xpath("//input[@name='city']");
  	By Zipcode=By.xpath("//input[@name='zipCode']");
  	By State1=By.xpath("//div[@id='companyState']");
  	
  // Enter Owner Information	
  	By FirstName=By.xpath("//input[@name='firstName']");
  	By MiddleName=By.xpath("//input[@name='middleName']");
  	By LastName=By.xpath("//input[@name='lastName']");
  	By PhoneNumber=By.xpath("//input[@name='phone']");
  	By Emailaddrs=By.xpath("//input[@name='email']");
  	
  	
  // Enter General Information
  	By Sales_Person=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[2]");  
  	By Account_Manager=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[3]");
  	
//  	Please Choose Any one Option CDL Packages and Non Non CDL Packages 
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
  	
  	
 //------------------ Home Page Of FDMgr---------------------------------------------------
  	
  	By PopupQuestion=By.xpath("/html/body/div[3]/div/div/div[2]/form/h6");
	By Required_CDL_DL1=By.xpath("(//input[@name='hasCommercialDriver'])[1]");   // If Yes
	By Next1=By.xpath("//button[.='Next']");
	By Required_CDL_DL2=By.xpath("(//input[@name='hasCommercialDriver'])[2]");   //if No
	By Next2=By.xpath("//button[.='Next']");
	
	
	
	By PopupAssignLater=By.xpath("//button[.='Assign Later']");
	By PopupPrevious=By.xpath("//button[.='Previous']");
	By PopupNext=By.xpath("//button[.='Next']");
	
	By DANotification=By.xpath("/html/body/div[3]/div/div/div[2]/form/h6");
	By AgreeForNotification=By.xpath("/html/body/div[3]/div/div/div[2]/form/label");
	By CheckBox=By.xpath("(//input[@type='checkbox'])[4]");
	By submit=By.xpath("//button[.='Submit']");
	By Previous=By.xpath("//button[.='Previous']");
	
	
	By AllOptions=By.xpath("//div[@class='sidebar-scroll']");
	
	
	By Dashboard=By.xpath("//span[.='Dashboard']");
	By CompanyProfile=By.xpath("//span[.='Company Profile']");
	By driversAndDQ=By.xpath("//span[.='Drivers & DQ']");
	By DriverHistory=By.xpath("//span[.='Driver History']");
	By ClearingHouse=By.xpath("//span[.='Clearinghouse']");
	By Vehicles=By.xpath("//span[.='Vehicles']");
	By AccidentDetails=By.xpath("//span[.='Accident Details']");
	By DrugAndAlcohol=By.xpath("//span[.='Drug & Alcohol']");
	By Billing=By.xpath("//span[.='Billing']");
	By Documents=By.xpath("//span[.='Documents']");
	By Reports=By.xpath("//span[.='Reports']");
	By Resources=By.xpath("//span[.='Resources']");
	By HelpAndFeedback=By.xpath("//span[.='Help And Feedback']");
	
	//1 Dashboard
	By NoDrivers1=By.xpath("(//div[@class='ml-4 ml-6'])[1]");
	By NoDrivers2=By.xpath("//*[@id='main-content']/div[3]/div[1]/div/div/div/div[1]/h4");
	By ImmediateActionHeader=By.xpath("//thead[@class='MuiTableHead-root']");
	By ImmediateActionsDetails1=By.xpath("(//tr[@class='MuiTableRow-root'])[1]");//td[@class='MuiTableCell-root MuiTableCell-body']
	By ImmediateActionsDetails2=By.xpath("(//tr[@class='MuiTableRow-root'])[2]");
	By ImmediateActionsDetails3=By.xpath("(//tr[@class='MuiTableRow-root'])[3]");
	By ImmediateActionsDetails4=By.xpath("(//tr[@class='MuiTableRow-root'])[4]");
	
	
	//By ComplaintDrivers=By.xpath("(//div[@class='ml-4 ml-6'])[2]");  //old
	
	By ComplaintDrivers1=By.xpath("(//div[@class='ml-4 ml-6'])[2]");
	By ComplaintDrivers2=By.xpath("//*[@id='main-content']/div[3]/div[2]/div/div/div");
	
	//By NoVehicles=By.xpath("(//div[@class='ml-4 ml-6'])[3]");  
	By NoVehicles1=By.xpath("(//div[@class='ml-4 ml-6'])[3]");
	By NoVehicles2=By.xpath("//*[@id='main-content']/div[3]/div[3]/div/div/div/div[1]");
	
	//By PendingDrivers=By.xpath("(//div[@class='ml-4 ml-6'])[4]");
	By PendingDrivers1=By.xpath("(//div[@class='ml-4 ml-6'])[4]");
	By PendingDrivers2=By.xpath("//*[@id='main-content']/div[3]/div[4]/div/div/div/div[1]");
	
//2 Company profile
	//2.1 Profile
	
	//2.1.1  Company information
	By CompanyName=By.xpath("//input[@name='companyName']");
	By USDot=By.xpath("//input[@id='dotProfile']");
	By LegalName1=By.xpath("//input[@name='legalName']");
	By MemberSince=By.xpath("//input[@name='registrationDate']");
	By CompanyMail=By.xpath("//input[@id='companyEmail']");
	
	//1.2.2 Address information
	By Address1=By.xpath("//input[@id='updatedAddress1']");
	By Address2=By.xpath("//input[@id='updatedAddress2']");
	By City=By.xpath("//input[@id='cityProfile']");
	By ZipORPostalCode=By.xpath("//input[@id='zipCodeProfile']");
	By Fax=By.xpath("//input[@id='faxProfile']");
	By State=By.xpath("//*[@id='unitAddVehicle']");
	  By StateName=By.xpath("//li[.='Florida']"); 
	  By Submit=By.xpath("//button[.='Submit']");
	
	  //2.2 User And Roles
	
	  //2.2.1 User table
	  
	  By DownloadUserTableInXL=By.xpath("//i[@class='fa fa-solid fa-file-excel']");
	  By DownloadUserTableInPDF=By.xpath("//i[@class='fa fa-solid fa-file-pdf']");
	  By AssignDER=By.xpath("//button[.='Assign DER']");
	  By AddUser=By.xpath("//button[.='Add User']");
	  By EditUser=By.xpath("//button[.='edit']");
	   
	
	  
//3. Drivers&DQ
	//3.1 Overview
	  By DriverlicenseExpirationXL= By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[1]");
	  By DriverMVRExpirationXL= By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[1]");
	  By DriverMedicalExpirationXL= By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[1]");
	  
	//3.2 ManageDrivers
	  By ManageDrivers=By.xpath("//a[@class='form_wizard_tab form_wizard_width1 tabstyling1 nav-item nav-link']");
	     By AddExistingDrivers=By.xpath("//button[.='Add Existing Driver']");
	        By ReqCommDL_Yes=By.xpath("(//input[@name='hasCommercialDriver'])[1]");
	        By ReqCommDL_No=By.xpath("(//input[@name='hasCommercialDriver'])[2]");
	        By FN=By.xpath("//input[@id='firstName']");
	        By LN=By.xpath("//input[@id='lastName']");
	        By DOB=By.xpath("//input[@id='dateOfBirth']");
	        By Email=By.xpath("//input[@id='email']");
	        By PhoneNo=By.xpath("//input[@id='phoneAddDriver']");
	        By StatusDropDown=By.xpath("//div[@id='status']");
	          By Active=By.xpath("//li[.='Active']");
	          By Terminated=By.xpath("//li[.='Terminated']");
	        By HireDate=By.xpath("//input[@id='hireDate']");
	        By SSN=By.xpath("//input[@id='ssnNumber']");
	        By UpldDQFile=By.xpath("//input[@id='dqDocument']");
	        By DriverNotes=By.xpath("//textarea[@id='remark']");
	        
	        //Add license Details
	        By LicenseNo=By.xpath("//input[@id='licenseNumber']");
	        By LicenseClass=By.xpath("//div[@id='licenseClass']");
	            By Class1=By.xpath("//li[.='Class A']");
	            By Class2=By.xpath("//li[.='Class B']");
	            By Class3=By.xpath("//li[.='Class C']");
	            By Class4=By.xpath("//li[.='Class D']");
	            By NonCDLDriver=By.xpath("None (Non-CDL Driver)");
	        By IssueDate=By.xpath("//input[@id='licenseIssueDate']");    
	        By ExpDate=By.xpath("//input[@id='licenseExpirationDate']");
	        By IssueState=By.xpath("//div[@id='licenseIssueState']"); 
	           By state=By.xpath("//li[.='Florida']");
	           
	     //Upload Front and Back driver License   
	           
	       By UploadFrontDL=By.xpath("//input[@id='licenseDocumentFront']");
	       By UploadBackDL=By.xpath("//input[@id='licenseDocumentBack']");
	       
	     //Add MVR Details
	       By AddMVRDetails=By.xpath("//button[.='Add MVR Details']");
	         By IssueDate2=By.xpath("//input[@id='mvrIssueDate']");
	         By ExpDate2=By.xpath("//input[@id='mvrExpiryDate']");
	         By MVRIssueState=By.xpath("//div[@id='mvrState']");
	         By UploadDoc=By.xpath("//input[@id='mvrDocument']");
	     
	     // Add Medical Details
	       By IssueDate3 =By.xpath("//input[@id='medicalIssueDate']");
	       By ExpDate3 =By.xpath("//input[@id='medicalExpiryDate']");
	       By UploadDoc3=By.xpath("//input[@id='medicalDocument']");
	       By Submit2=By.xpath("//button[.='Add Driver']");
	       
	     By CloseForm=By.xpath("//button[@class='btn btn-outline-danger fa fa-remove float-right']");   
	     By ManagePendingDrivers=By.xpath("//button[.='Manage Pending Driver']");
	     By BulkUploadDrivers=By.xpath("//button[.='Bulk Upload Drivers']");

    //-------------------------------New Driver&DQ Page---------------------------------------------------
	     By EnterDriverName2= By.xpath("(//input[@aria-label='filter data by Driver Name'])[1]");
	     By DriverStaus=By.xpath("(//td[.='Active'])[1]");
	     By DriverStaus2=By.xpath("(//td[.='Pending'])[1]");
	     By DriverStaus3=By.xpath("(//td[.='Terminated'])[1]");
	     By DriverStaus4=By.xpath("(//td[.='Inactive'])[1]");
	     By DriverStaus5=By.xpath("(//td[.='Rejected'])[1]");
	     
	     By ValidDL=By.xpath("//span[normalize-space()='12/29/2022']");
	     
	     
	   // 3.3 HOS Violations
	   By HOS_Violation=By.xpath("(//a[contains(@data-rb-event-key,'hos_violations')])[1]");
	   By Select_ELD=By.xpath("//button[@class='Dropdown_button__13TpT Dropdown_active__2N6vG']");
	   By KeepTruckIn=By.xpath("//li[@class='Item_item__34h1P']");
	  
	   By User_Name=By.xpath("//input[@id='userNameAddHosCredentials']");
	   By Passworsd=By.xpath("//input[@id='passwordAddHosCredentials']");
	   By Show_Password=By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root']");
	   By Submit3=By.xpath("//button[.='Submit']");
	   By Reset=By.xpath("//button[.='Reset']");
	   By Athirize_from_keep_truckin=By.xpath("(//h6)[6]");
	     
	 //3.4 Invite New Drivers
	   By Invite_New_Driver=By.xpath("//a[@data-rb-event-key='invite']");
	   By Enter_DL_No= By.xpath("//input[@id='driverLicenseNumber']");
	   By Create_Driver_Application=By.xpath("//button[.='Create Driver Application']");
	   
	   By First_Name=By.xpath("//input[@name='firstName']");
	   By Middle_Name=By.xpath("//input[@name='middleName']");
	   By Last_Name=By.xpath("//input[@name='lastName']");
	   By Driver_DOB=By.xpath("//input[@name='dob']");
	   By Driver_Email=By.xpath("//input[@name='email']");
	   By Driver_PhoneNo=By.xpath("//input[@name='phone']");
	   By Driver_issue_state=By.xpath("//div[@id='driverLicenseIssueState']");
	   By Selected_State= By.xpath("//li[.='California']");  //-By Text or bellow process
	   By Class_type=By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]");
	   By Choose_Class_NonCDL=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[1]");  //For Non-CDL
	//   By Choose_Class_A=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[2]");  //For Class A
	//   By Choose_Class_B=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[3]");  //For Class B
	//   By Choose_Class_C=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[4]");  //For Class C
	//   By Choose_Class_D=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[5]");  //For Class D
	   
	   By License_issue_Date=By.xpath("//input[@name='driverLicenseIssueDate']");
	   By License_Exp_Date=By.xpath("//input[@name='driverLicenseExpiryDate']");
	   By Requiring_Commercial_DL_YES=By.xpath("(//input[@name='hasCommercialDriver'])[1]");
	   By Requiring_Commercial_DL_NO=By.xpath("(//input[@name='hasCommercialDriver'])[2]");
	   By SendDriverApplication=By.xpath("//button[.='Send Driver Application']");
	   
	//3.5 Driver Application
	   
	   By DriverApplicationTab=By.xpath("(//a[@data-rb-event-key='driver_applications'])[1]");
	   By DriverListPDF=By.xpath("(//i[@class='fa fa-solid fa-file-pdf'])[4]");
	   By DriverListXL=By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[4]");
	   
	   By EnterDriverName1=By.xpath("(//input[@aria-label='filter data by Driver'])[2]");
	   By DriverInfo=By.xpath("(//tr[@class='MuiTableRow-root'])[17]");
	   
	   By DownloadDLFront=By.xpath("(//button[@title='29102022-122243-91License.png'])[1]");
	   By DownloadDLBack=By.xpath("(//button[@title='29102022-122248-26LicenseBackSide.png'])[1]");
	   By DownloadCF=By.xpath("(//button[@title='31102022-155350-consent_form.pdf'])[1]");
	   By DownloadMC=By.xpath("(//button[@title='29102022-124945-0MedicalCertificates1.png'])[1]");
	   
	   By ApproveApplication=By.xpath("(//button[@title='Approve Application'])[1]");
	   By RejectApplication=By.xpath("(//button[@title='Reject Application'])[1]");
	   By ReturnForRvision=By.xpath("(//button[@title='Return for Revisions'])[1]");
	   
	   By PopupCancel=By.xpath("(//button[normalize-space()='Cancel'])[1]");
	   By PopupSubmit=By.xpath("(//button[@class='btn btn-outline-grey mb-2 mr-1 btnstyle2'][normalize-space()='Submit'])[1]");

//------------------------------------------------------------------------------------------------------------------------------------------------
	   
	   
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/VS01invite_NonCDLDriver.html", true);

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
	
	
//---------------------------------------Random Data----------------------------------------------------	

private String Names() 
{
	String uuid = UUID.randomUUID().toString();
	uuid = uuid.substring(0, Math.min(uuid.length(), 7));
	System.err.print(uuid);
	return uuid;
}
private String MNames() 
{
	String uuid = UUID.randomUUID().toString();
	uuid = uuid.substring(0, Math.min(uuid.length(), 2));
	System.err.print(uuid);
	return uuid;
}

public static String PhoneNo() 
{
    // It will generate 7 digit random Number.
    // from 0 to 9999999
    Random rnd = new Random();
    int number = rnd.nextInt(9999999);

    // this will convert any number sequence into 7 character.
    return String.format("%07d", number);
} 


//-------------------------------------------------------------------------------------------


String FleetDev="http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/";
String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
String FleetProd="https://app.fleetdrive360.com/login";

// for Chrome user
/*String key="webdriver.chrome.driver";
String value="./software/chromedriver.exe";
System.setProperty(key,value);
ChromeDriver driver =new ChromeDriver(); */

//---------------------------------Testing Started----------------------------------------------------	
	@SuppressWarnings("unused")
	@Test(priority=1)
	public void OpenedFleetLoginPage() throws InterruptedException, AWTException 
	{
		
		logger = extent.startTest("Fleet Login Page");
		logger.log(LogStatus.INFO, "To Verify that User able to Invite Drivers through selecting Carrier and Invite Drivers");
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.get(FleetProd);
		driver.manage().window().maximize();
		Robot robot = new Robot();
		Thread.sleep(2000);
		System.out.println("About to zoom out");
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, FleetProd);
		logger.log(LogStatus.PASS, "Test Case1 Opened Fleet Login Page Status is passed");
		
		
		//  Application classes
		
	}
	
	
	
	@Test(priority=2)
	public void printTitle() throws EncryptedDocumentException, IOException
	{
		DataFromExcel Testdata=new DataFromExcel();
		logger = extent.startTest("Print Title");
		
		String title1 = driver.getTitle();
		System.out.println(title1);
		String currentURL = driver.getCurrentUrl();
		
		driver.findElement(Username).sendKeys(Testdata.ProdSVPUN());  //Testdata.BetaSVPUN()-----------------------------------   Testdata.BetaUSCUsername()
		
		driver.findElement(Password).sendKeys(Testdata.ProdSVPPwd());  //Testdata.BetaSVPPwd()-----------------------------------   Testdata.BetaUSCPassword()
		
		driver.findElement(Login).click();
		
		//Assert.assertTrue(true);
		//test.log(LogStatus.PASS, "Driver EmploymentRecord form submitted successfully");
		//Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		//logger.log(LogStatus.PASS, "Test Case2 verified Title and Username and Password Status is passed");
		Assert.assertEquals(title1, "FleetDrive 360 - Smart Compliance Services");
		logger.log(LogStatus.PASS, "Title is : 'FleetDrive 360 - Smart Compliance Services' ");
		
	}
	
	@Test(priority=3)
	public void Dshbrd() throws InterruptedException
	{
		Thread.sleep(3000);
		logger = extent.startTest("Dshbrd");
		driver.findElement(DashboardModule).click();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Assert.assertEquals(DashboardModule, DashboardModule);
		logger.log(LogStatus.PASS, "Clicking on Dashboard module");
	}
	
	@Test(priority=4)
	public void C_ClientC()
	{
		logger = extent.startTest("CompliantClientCount");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(CompliantClientCount).getText();
		System.out.println("CompliantClient NO is - "+driver.findElement(CompliantClientCount).getText());
	//	driver.findElement(CompliantClientCount).click();
		logger.log(LogStatus.PASS, "displayed Compliant Client Count");
	}
	
	@Test(priority=5)
	public void NC_ClientC()
	{
		logger = extent.startTest("display NonCompliantClientCount");
		driver.findElement(NonCompliantClientCount).getText();
		System.out.println("NON CompliantClient NO is - "+driver.findElement(NonCompliantClientCount).getText());
	//	driver.findElement(NonCompliantClientCount).click();
		logger.log(LogStatus.PASS, "displayed Non-Compliant Client Count");
	}
	
	@Test(priority=6)
	public void C_DrC()
	{
		logger = extent.startTest("display Compliant driver count");
		driver.findElement(CompliantDriverCount).getText();
		System.out.println("CompliantDriverCount NO is - "+driver.findElement(CompliantDriverCount).getText());
	//	driver.findElement(CompliantClientCount).click();
		logger.log(LogStatus.PASS, "displayed Compliant Driver Count");
	}

	@Test(priority=7)
	public void NC_drC()
	{
		logger = extent.startTest("display Non-Compliant driver count");
		driver.findElement(NonCompliantDriverCount).getText();
		System.out.println("NON CompliantDriverCount No is -"+driver.findElement(NonCompliantDriverCount).getText());
	//	driver.findElement(NonCompliantClientCount).click();
		logger.log(LogStatus.PASS, "displayed Non-Compliant Driver Count");
	}  
	
	@Test(priority=8)
	public void Selecting_Carrier() throws AWTException, InterruptedException, EncryptedDocumentException, IOException 
	{
		DataFromExcel Testdata=new DataFromExcel();
		logger = extent.startTest("Selecting_Carrier");
		
		driver.findElement(SelectCarrier).click();

	     Robot rbt2 = new Robot();
	// Production Carrier	
		rbt2.keyPress(KeyEvent.VK_N);
		rbt2.keyRelease(KeyEvent.VK_N);
		
		rbt2.keyPress(KeyEvent.VK_I);
		rbt2.keyRelease(KeyEvent.VK_I);
		
		rbt2.keyPress(KeyEvent.VK_C);
		rbt2.keyRelease(KeyEvent.VK_C);  
	
	// Beta SVP Carrier	
	/*	rbt2.keyPress(KeyEvent.VK_A);
		rbt2.keyRelease(KeyEvent.VK_A);
		
		rbt2.keyPress(KeyEvent.VK_V);
		rbt2.keyRelease(KeyEvent.VK_V);
		
		rbt2.keyPress(KeyEvent.VK_E);
		rbt2.keyRelease(KeyEvent.VK_E);   */
	
	// Beta USC Carrier	
	/*	rbt2.keyPress(KeyEvent.VK_O);
		rbt2.keyRelease(KeyEvent.VK_O);
		
		rbt2.keyPress(KeyEvent.VK_N);
		rbt2.keyRelease(KeyEvent.VK_N);
		
		rbt2.keyPress(KeyEvent.VK_E);
		rbt2.keyRelease(KeyEvent.VK_E);  */
		
		rbt2.keyPress(KeyEvent.VK_ENTER);
		rbt2.keyRelease(KeyEvent.VK_ENTER); 
		
		logger.log(LogStatus.PASS, "Selected Carrier from dropdown");
	}
	
	@Test(priority=9)
	public void DriverAndDQ() throws InterruptedException
	{
		logger = extent.startTest("Clcik on DriverAndDQ module");
		Thread.sleep(2000);
		driver.findElement(driversAndDQ).click();	
		
		logger.log(LogStatus.PASS, "Click on Driver and DQ module");
	}
	
	@Test(priority=10)
	public void Invite_new_drivers()
	{
		logger = extent.startTest("Invite_new_drivers and Enter Driver DL Num and click on 'Create Driver Application'");
		driver.findElement(Invite_New_Driver).click();
		driver.findElement(Enter_DL_No).sendKeys("VSNonCDL"+PhoneNo());
		driver.findElement(Create_Driver_Application).click();
		
		logger.log(LogStatus.PASS, "Entered Driver_DL Num and Click on 'Create Driver Application'");
	}
	
	@Test(priority=11)
	public void Driver_Info()
	{
		logger = extent.startTest("Enter Driver_Info");
		driver.findElement(First_Name).sendKeys("VDriver"+MNames());
		driver.findElement(Middle_Name).sendKeys(MNames());
		driver.findElement(Last_Name).sendKeys("Salaga"+MNames());
		logger.log(LogStatus.PASS, "Entered Driver info");
	}
	
	@Test(priority=12)
	public void DrEmail()
	{
		logger = extent.startTest("DrEmail");
		driver.findElement(Driver_Email).sendKeys("Veereshtestit2@gmail.com");    //"VSDrEmail"+MNames()+"@innowyze.testinator.com"
		logger.log(LogStatus.PASS, "Entered DrEmail");
	}
	
	@Test(priority=13)
	public void DrPhone()
	{
		logger = extent.startTest("DrPhone");
        driver.findElement(Driver_PhoneNo).sendKeys("404"+PhoneNo());
        logger.log(LogStatus.PASS, "Entered DrPhone number");
	}
	
	@Test(priority=14)
	public void ReqCDL_No()
	{
		logger = extent.startTest("ReqCDL_No");
		driver.findElement(Requiring_Commercial_DL_NO).click();
		logger.log(LogStatus.PASS, "Choosed Driver req Non CDL");
	}   

	@Test(priority=15)
	public void Send_Driver_Application() throws InterruptedException
	{
		logger = extent.startTest("Click on 'Send Driver Application' ");
		driver.findElement(SendDriverApplication).click();
		Thread.sleep(1000);
		logger.log(LogStatus.PASS, "Send Driver Application");
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


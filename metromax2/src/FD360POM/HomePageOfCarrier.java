package FD360POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePageOfCarrier {
	

	public WebDriver driver;
	
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
	By DriverRecruitment=By.xpath("(//span[normalize-space()='Driver Recruitment'])[1]");  //*[@id="left-sidebar-nav"]/div/ul/li[4]/a/span
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
	By CompanyInfoEditButton=By.xpath("(//span[contains(text(),'Edit')])[1]");
	By CompanyIAddressEditButton=By.xpath("(//button[@value='update'])[2]");
	
	By CompanyName=By.xpath("//input[@name='companyName']");
	By USDot=By.xpath("//input[@id='dotProfile']");
	By LegalName=By.xpath("//input[@name='legalName']");
	By MemberSince=By.xpath("//input[@name='registrationDate']");
	By USMCNumber=By.xpath("(//input[@id='mcProfile'])[1]");
	By CompanyMail=By.xpath("(//input[@id='companyEmailProfile'])[1]");
	By CancelButon=By.xpath("(//button[normalize-space()='Cancel'])[1]");
	
	//1.2.2 Address information
	By Address1=By.xpath("(//input[@id='address1'])[1]");
	By Address2=By.xpath("//input[@id='updatedAddress2']");
	By City=By.xpath("(//input[@id='cityProfile'])[1]");
	By ZipORPostalCode=By.xpath("//input[@id='zipCodeProfile']");
	By PhoneC=By.xpath("//input[@id='phoneProfile']");
	By State=By.xpath("//div[@id='unitAddVehicle']");
	  By StateNameRS=By.xpath("//li[.='Select']");
	  By Submit=By.xpath("//button[.='Submit']");
	  
	  //2.2 User And Roles
	
	  //2.2.1 User table
	  
	  By DownloadUserTableInXL=By.xpath("//i[@class='fa fa-solid fa-file-excel']");
	  By DownloadUserTableInPDF=By.xpath("//i[@class='fa fa-solid fa-file-pdf']");
	  By AssignDER=By.xpath("//button[.='Assign DER']");
	  By AddUser=By.xpath("//button[.='Add User']");
	  By EditUser=By.xpath("//button[.='edit']");
	   
	
	  
//3. Driver Management
	//3.1 Overview
	  By DriverlicenseExpirationXL= By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[1]");
	  By DriverMVRExpirationXL= By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[1]");
	  By DriverMedicalExpirationXL= By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[1]");
	  
	//3.2 ManageDrivers
	  public By ManageDrivers=By.xpath("//span[normalize-space()='Driver Management']");
	  public By AddExistingDrivers=By.xpath("//button[.='Add Existing Driver']");
	  public By ReqCommDL_Yes=By.xpath("(//input[@name='hasCommercialDriver'])[1]");
	  public By ReqCommDL_No=By.xpath("(//input[@name='hasCommercialDriver'])[2]");
	  public By FN=By.xpath("//input[@id='firstName']");
	  public By LN=By.xpath("//input[@id='lastName']");
	  public By DOB=By.xpath("//input[@id='dateOfBirth']");
	  public By Email=By.xpath("//input[@id='email']");
	  public By PhoneNo=By.xpath("//input[@id='phoneAddDriver']");
	  public By StatusDropDown=By.xpath("//div[@id='status']");
	  public By Active=By.xpath("//li[.='Active']");
	  public By Terminated=By.xpath("//li[.='Terminated']");
	  public By HireDate=By.xpath("//input[@id='hireDate']");
	  public By SSN=By.xpath("//input[@id='ssnNumber']");
	  public By UpldDQFile=By.xpath("//input[@id='dqDocument']");
	  public By DriverNotes=By.xpath("//textarea[@id='remark']");
	  public By SearchDriverName=By.xpath("//input[@placeholder='Search']");  
	  public By SelectDriver=By.xpath("//a[normalize-space()='Nathan Miller']");
	        //Add license Details
	  public By LicenseNo=By.xpath("//input[@id='licenseNumber']");
	  public By LicenseClass=By.xpath("//div[@id='licenseClass']");
	  public By Class1=By.xpath("//li[.='Class A']");
	  public By Class2=By.xpath("//li[.='Class B']");
	  public By Class3=By.xpath("//li[.='Class C']");
	  public By Class4=By.xpath("//li[.='Class D']");
	  public By NonCDLDriver=By.xpath("None (Non-CDL Driver)");
	  public By IssueDate=By.xpath("//input[@id='licenseIssueDate']");    
	  public By ExpDate=By.xpath("//input[@id='licenseExpirationDate']");
	  public By IssueState=By.xpath("//div[@id='licenseIssueState']"); 
	  public By state=By.xpath("//li[.='Florida']");
	           
	     //Upload Front and Back driver License   
	           
	  public By UploadFrontDL=By.xpath("//input[@id='licenseDocumentFront']");
	  public By UploadBackDL=By.xpath("//input[@id='licenseDocumentBack']");
	       
	     //Add MVR Details
	  public By AddMVRDetails=By.xpath("//button[.='Add MVR Details']");
	  public By IssueDate2=By.xpath("//input[@id='mvrIssueDate']");
	  public By ExpDate2=By.xpath("//input[@id='mvrExpiryDate']");
	  public By MVRIssueState=By.xpath("//div[@id='mvrState']");
	  public By UploadDoc=By.xpath("//input[@id='mvrDocument']");
	     
	     // Add Medical Details
	  public By IssueDate3 =By.xpath("//input[@id='medicalIssueDate']");
	  public By ExpDate3 =By.xpath("//input[@id='medicalExpiryDate']");
	  public By UploadDoc3=By.xpath("//input[@id='medicalDocument']");
	  public By Submit2=By.xpath("//button[.='Add Driver']");
	       
	  public By CloseForm=By.xpath("//button[@class='btn btn-outline-danger fa fa-remove float-right']");   
	     //By ManagePendingDrivers=By.xpath("//button[.='Manage Pending Driver']");
	     public By ManagePendingDrivers= By.xpath("(//a[@data-rb-event-key='manage_pending_driver'])[1]");
	     public By BulkUploadDrivers=By.xpath("//button[.='Bulk Upload Drivers']");

	     
   //------------Driver Profile Page "Driver information" Section-----------------
	     
	    public By driverinformation=By.xpath("//a[@id='driverprofile.driverinformation']");
	    public By dqdocument=By.xpath("//a[@id='driverprofile.dqdocument']");
	    public By drugandalcohol=By.xpath("//a[@id='driverprofile.drugandalcohol']");
	    public By mvr=By.xpath("//a[@id='driverprofile.mvr']");
	    public By previousmedical=By.xpath("//a[@id='driverprofile.previousmedical']");
	    public By PreviousEmployerInquiry=By.xpath("//a[@id='driverprofile.backgroundcheck']");
	    public By DPDriverName=By.xpath("/html[1]/body[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/strong[1]");
	    public By EmploymentStatus=By.xpath("//div[@class='fade tab-pane active show']//strong[contains(text(),'Active')]");
	    
	    
	    public By updatelicense=By.xpath("//button[@id='driverprofile.driverinformation.updatelicense']");
	    public By updatemvr=By.xpath("//button[@id='driverprofile.driverinformation.updatemvr']");
	    public By updatemedical=By.xpath("//button[@id='driverprofile.driverinformation.updatemedical']");
	    public By updateaddress=By.xpath("//button[@id='driverprofile.driverinformation.updateaddress']");
	    public By updatemail=By.xpath("//button[@id='driverprofile.driverinformation.updatemail']");
	     
  //----------- Driver Profile Page "DQ Documents" Section ------------	   
	    
	     
	    //public By.xpath("//div[@class='fade tab-pane active show']//div[@class='col-lg-8 col-md-12']//div[@class='row clearfix']//div[@class='row clearfix']")
	    
	    public By MVRDocDownload= By.xpath("//button[@id='driverprofile.dqdocument.mvr']");	    
	    public By DLFrontDownload= By.xpath("//button[@id='driverprofile.dqdocument.licensefrontside']");
	    public By DLBackDownload=By.xpath("//button[@id='driverprofile.dqdocument.licensebackside']");
	    public By MedicalCertificate= By.xpath("//button[@id='driverprofile.dqdocument.medicalcertificate']");
	    public By NRCME_Download=By.xpath("//button[@id='driverprofile.dqdocument.nrcme']");
	    public By ConsentForm=By.xpath("//button[@id='driverprofile.dqdocument.consentform']");
	    public By DriverApplicationDownload=By.xpath("//button[@id='driverprofile.dqdocument.driverapplication']");
	    public By RTCDownload= By.xpath("//button[@id='driverprofile.dqdocument.roadtestceritficate']");
	    public By GenerateNewDQfile=By.xpath("//button[normalize-space()='Generate']");
	    public By DownloadDQfile=By.xpath("//button[@title='18092023-075408-merge_images_dq.pdf']");
	    
	    public By firstGeneratedDQFile=By.xpath("(//button[@title='18092023-111825-merge_images_dq.pdf'])[1]"); 
	    public By SecondGeneratedDQFile=By.xpath("(//button[@class='btn2'][normalize-space()='Download'])[1]"); 		
	    //(//button[@class='btn2'][normalize-space()='Download'])[3]
	    //	(//button[@class='btn2'][normalize-space()='Download'])[2]     
	    public By DownloadNewGeneratedDQFile=By.xpath("//button[@type='button'][normalize-space()='Download']");
	    
	    public By EnterEmailid_DQ=By.xpath("//input[@id='filled-required']");
	    public By AddEmailid2_DQ=By.xpath("//button[@name='emailList']");
	    public By EnterEmailid2_DQ=By.xpath("(//input[@name='emailList[0]'])[1]");
	    public By AddEmailid3_DQ=By.xpath("(//button[@class='btn fa fa-plus'])[1]");
	    public By EnterEmailid3_DQ=By.xpath("(//input[@name='emailList[1]'])[1]");
	     
	    public By SendDQfileToEmail=By.xpath("//button[normalize-space()='Send']");
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
//-------------------------------New Driver&DQ Page---------------------------------------------------
	     public By EnterDriverName2= By.xpath("(//input[@aria-label='filter data by Driver Name'])[1]");
	     public By DriverStaus=By.xpath("(//td[.='Active'])[1]");
	     public By DriverStaus2=By.xpath("(//td[.='Pending'])[1]");
	     public By DriverStaus3=By.xpath("(//td[.='Terminated'])[1]");
	     public By DriverStaus4=By.xpath("(//td[.='Inactive'])[1]");
	     public By DriverStaus5=By.xpath("(//td[.='Rejected'])[1]");
	     
	     public By ValidDL=By.xpath("//span[normalize-space()='12/29/2022']");
	     
	     
	   // 3.3 HOS Violations
	     public By HOS_Violation=By.xpath("(//a[contains(@data-rb-event-key,'hos_violations')])[1]");
	     public By Select_ELD=By.xpath("//button[@class='Dropdown_button__13TpT Dropdown_active__2N6vG']");
	     public By KeepTruckIn=By.xpath("//li[@class='Item_item__34h1P']");
	  
	     public By User_Name=By.xpath("//input[@id='userNameAddHosCredentials']");
	     public By Passworsd=By.xpath("//input[@id='passwordAddHosCredentials']");
	     public By Show_Password=By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root']");
	     public By Submit3=By.xpath("//button[.='Submit']");
	     public By Reset=By.xpath("//button[.='Reset']");
	     public By Athirize_from_keep_truckin=By.xpath("(//h6)[6]");
	     
	 //3.4 Invite New Drivers
	     public By Invite_New_Driver=By.xpath("//a[@data-rb-event-key='invite']");//input[@name='driverLicenseNumber']
	     public By Enter_DL_No= By.xpath("//input[@id='driverLicenseNumber']");
	     public By Create_Driver_Application=By.xpath("//button[.='Create Driver Application']");
	   
	     public By First_Name=By.xpath("(//input[@id='filled-required'])[1]");
	     public By Middle_Name=By.xpath("//input[@name='middleName']");
	     public By Last_Name=By.xpath("(//input[@id='filled-required'])[3]");
	     public By Driver_DOB=By.xpath("//input[@name='dob']");
	     public By Driver_Email=By.xpath("(//input[@id='filled-required'])[4]");
	     public By Driver_PhoneNo=By.xpath("(//input[@id='phoneInviteDriver'])[1]");
	     public By Driver_issue_state=By.xpath("//div[@id='driverLicenseIssueState']");
	     public By Selected_State= By.xpath("//li[.='California']");  //-By Text or bellow process
	     public By Class_type=By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]");
	     public By Choose_Class_NonCDL=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[1]");  //For Non-CDL
	//   By Choose_Class_A=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[2]");  //For Class A
	//   By Choose_Class_B=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[3]");  //For Class B
	//   By Choose_Class_C=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[4]");  //For Class C
	//   By Choose_Class_D=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[5]");  //For Class D
	   
	     public By License_issue_Date=By.xpath("//input[@name='driverLicenseIssueDate']");
	     public By License_Exp_Date=By.xpath("//input[@name='driverLicenseExpiryDate']");
	     public By Requiring_Commercial_DL_YES=By.xpath("(//input[@name='hasCommercialDriver'])[1]");
	     public By DriverIncludedConsortium_Yes= By.xpath("(//input[@name='inConsortium'])[1]");
	     public By DriverIncludedConsortium_No= By.xpath("(//input[@name='inConsortium'])[2]");
	     public By Requiring_Commercial_DL_NO=By.xpath("(//input[@name='hasCommercialDriver'])[2]");
	     public By SendDriverApplication=By.xpath("(//button[normalize-space()='Send Driver Application'])[1]");
	   
	//3.5 Driver Application
	   
	     public By DriverApplicationTab=By.xpath("(//a[@data-rb-event-key='driver_applications'])[1]");
	     public By DriverListPDF=By.xpath("(//i[@class='fa fa-solid fa-file-pdf'])[4]");
	     public By DriverListXL=By.xpath("(//i[@class='fa fa-solid fa-file-excel'])[4]");
	   
	     public By EnterDriverName1=By.xpath("//input[@placeholder='Search']");
	     public  By DriverInfo=By.xpath("(//table[@class='MuiTable-root'])[3]");   //(//tr[@class='MuiTableRow-root'])[17]
	   
	     public By DownloadDLFront=By.xpath("(//button[.='Download'])[1]");
	     public By DownloadDLBack=By.xpath("(//button[.='Download'])[2]");
	     public By DownloadCF=By.xpath("(//button[.='Download'])[3]");
	     public By DownloadMC=By.xpath("(//button[.='Download'])[4]");
	   
	     public By ViewApplication=By.xpath("//body[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[8]/button[1]");
	     public By DownloadApplication=By.xpath("(//button[normalize-space()='Download'])[1]");
	   
	     public By ApproveApplication=By.xpath("//button[@aria-label='Approve Application']//*[name()='svg']"); //(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit'])[11]
	   
	     public By SubmitNonCDL=By.xpath("//button[@type='submit']"); //button[@type='submit']
	     public By CancelNonCDL=By.xpath("(//button[.='Cancel'])[2]");
	   
	     public By SubmitCDL=By.xpath("(//button[normalize-space()='Proceed to checkout'])[1]");
	   
	     public By ApproveCDLYes=By.xpath("(//input[@value='yes'])[1]");
	     public By DrugTest=By.xpath("(//input[@name='DOT Drug Test'])[1]");
	     public By AlcoholTest=By.xpath("(//input[@name='DOT Alcohol Test'])[1]");
	     public  By DrugAlcoholTest=By.xpath("(//input[@name='Drug & Alcohol Test Combo'])[1]");
	     public By BackgroundCheck= By.xpath("(//input[@name='Background Check'])[1]");
	   
	     public By ApproveCDLNo=By.xpath("(//input[@value='no'])[1]");
	  
	     public By ProceedToCheckout=By.xpath("//div[@class='SubmitButton-IconContainer']"); 
	   
	     public By RejectApplication=By.xpath("(//button[@title='Reject Application'])[1]");
	     public By ReturnForRvision=By.xpath("(//button[@title='Return for Revisions'])[1]");
	   
	     public By PopupCancel=By.xpath("(//button[normalize-space()='Cancel'])[1]");
	     public By PopupSubmit=By.xpath("(//button[@class='btn btn-outline-grey mb-2 mr-1 btnstyle2'][normalize-space()='Submit'])[1]");
	   
    // 3.6 Manage pending drivers.  
	   public By SearchDriver=By.xpath("(//input[@placeholder='Search'])[1]");
	   public By ApproveDriver=By.xpath("//button[@aria-label='Approve Driver']");
	   public By ConfirmAproveDr=By.xpath("//button[normalize-space()='Approve']");
	   public By RejectDriver=By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root'])[4]");
	   public By ReplaceDriver=By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root'])[3]");
	   

//	5.0 Clearinghouse--------------------------------------------
	public By ClearinghouseMenu=By.xpath("//span[normalize-space()='Clearinghouse']");   
	  //5.0.1 Dashboard
	public By OpenConductAQuery= By.xpath("//div[@id='clearinghouse.dashboard.conductquery']//button[@type='submit'][normalize-space()='Conduct A Query']");
	public By SelectADriver_DropDown = By.xpath(
			"//div[contains(@name,'driver')]//button[contains(@title,'Open')]//span[contains(@class,'MuiIconButton-label')]//*[name()='svg']");
	public By SelectADriver_SendName = By.xpath("//input[@id='mui-69318']");
	public By ChooseLimitedQuery = By.xpath("//input[@value='Limited Query']");
	public By ChooseFullQuery = By.xpath("//input[@value='Full Query']");
	public By SubmitConductQuery = By.xpath("//button[normalize-space()='Conduct Query']");
	public By Cancelbutton = By.xpath("//button[normalize-space()='Cancel']");
	public By ClosePopupicon = By.xpath("//span[normalize-space()='×']");
	  //5.0.2 Query Details	
	public By ClickQueryDetailsSection = By.xpath("//a[@id='clearinghouse.querydetails']");
	public By SearchDriverName2 = By.xpath("//input[@placeholder='Search']");
	
// 6.0 Vehicles------------------------------------------------------
	
	By Title = By.xpath("//img[@src='/fleetdrivelogo1.png']");
	By Username = By.xpath("//input[@name='username_or_email']");
	By Password = By.xpath("//input[@name='password']");
	By Login = By.xpath("//button[@type='submit']");
	By ForgotPassword = By.xpath("//a[.='Forgot Password ?']");
	By DriverLoginLink = By.xpath("//a[.='Click Here']");
	By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");
	
	By VehiclesMenu=By.xpath("//span[normalize-space()='Vehicles']");
	By ManageVehicleSec=By.xpath("//a[@data-rb-event-key='VehicleManage']");
	By AddVehicle=By.xpath("//button[normalize-space()='Add Vehicle']");
	By BulkUploadV=By.xpath("//button[normalize-space()='Bulk Upload Vehicles']");
	By VehicleListPDF=By.xpath("(//i)[27]");
	By VehicleListExcel=By.xpath("(//i)[28]");
	By SearchVehicle=By.xpath("//input[@placeholder='Search']");
	By SelectRow=By.xpath("(//div[@id='mui-65251'])[1]");
	By SelectRow10=By.xpath("(//li[normalize-space()='10'])[1]");
	By SelectRow20=By.xpath("(//li[normalize-space()='20'])[1]");
	

	By Vin = By.xpath("//input[@id='vinAddVehicle']");
	By Unit = By.xpath("//div[@id='unitAddVehicle']");
	By SelectUnitType = By.xpath("//li[normalize-space()='Truck']");
	By UnitNum = By.xpath("//input[@id='unitNumber']");
	By Make = By.xpath("//input[@id='makeAddVehicle']");
	By Model = By.xpath("//input[@id='modelAddVehicle']");
	By ClickState = By.xpath("//div[@id='plateState']");
	By SelectState = By.xpath("//li[normalize-space()='California']");
	By PlateNum = By.xpath("//input[@id='plateNumberAddVehicle']");
	By TireSize = By.xpath("//input[@id='tyreSizeAddVehicle']");
	By Year = By.xpath("//input[@id='yearAddVehicle']");
	By Owner = By.xpath("//input[@value='O']");
	By AddRegForm = By.xpath("//button[normalize-space()='Add Registration Form']");
	By RegNum = By.xpath("//input[@id='registrationNumberAddVehicle']");
	By RegIssueDate = By.xpath("//input[@id='registrationDateAddVehicle']");
	By RegExpDate = By.xpath("//input[@id='registrationExpiryDateAddVehicle']");
	By UploadRegDoc = By.xpath("//input[@id='registrationDocumentAddVehicle']");
	By AddInspection = By.xpath("//button[normalize-space()='Add New Inspection']");
	By InspNum = By.xpath("//input[@id='inspectionNumberAddVehicle']");
	By InspIssueDate = By.xpath("//input[@id='inspectionDateAddVehicle']");
	By InspExpDate = By.xpath("//input[@id='inspectionExpiryDateAddVehicle']");
	By UploadInspDoc = By.xpath("//input[@id='inspectionDocumentAddVehicle']");
	By Submit1 = By.xpath("//button[normalize-space()='Submit']");
	By ClosePage=By.xpath("(//button[@type='button'])[7]");
	By NewRecord=By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft']");
	
	By Maintain_Vehicle=By.xpath("//a[@data-rb-event-key='vehicleMaintain']");
	By AddWorkOrder=By.xpath("//button[normalize-space()='Add Work Order']");
	By SearchWorkOrder=By.xpath("//input[@placeholder='Search']");
	By WorkOrderPDF=By.xpath("(//i)[27]");
	By WorkOrderExcel=By.xpath("(//i)[28]");
	By SelectOtherRow=By.xpath("//div[contains(text(),'5 rows')]");
	By WORow10=By.xpath("(//li[normalize-space()='10'])[1]");
	By WORow20=By.xpath("(//li[normalize-space()='20'])[1]");

// 7.0 Accident Details------------------------------
	
	
	   
// 10.0 Documents----------------------------------	   
	
  //10.1 Driver Docs

	By DocumentsMenu=By.xpath("//span[normalize-space()='Documents']");
	By DriverDocumentsSection=By.xpath("//a[@data-rb-event-key='DriverDocuments']");
	By UploadDriverDoc=By.xpath("(//i[@class='fa fa-upload'])[1]");
	By SelectDriver2=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[2]");//(//*[name()='svg'][@focusable='false'])[11]
	By ClickDocType=By.xpath("//div[@id='documentType']");
	By SelectDocTypeLicense=By.xpath("//li[normalize-space()='License Document']");
	By SelectDocTypeMVR=By.xpath("//li[normalize-space()='MVR Document']");
	By SelectDocTypeMC=By.xpath("//li[normalize-space()='Medical Document']");
	By SelectDocTypeMisc=By.xpath("//li[normalize-space()='Miscellaneous Document']");
	By SelectDocTypeROD=By.xpath("//li[normalize-space()='Record of Duty Document']");
	By SelectDocTypeRT=By.xpath("//li[normalize-space()='Road Test Document']");
	By SelectDocTypeED=By.xpath("//li[normalize-space()='Existing Driver Application']");
	By SelectDocTypeDriverTraining=By.xpath("//li[normalize-space()='Driver Training Document']");
	By SelectDocTypeAddPreviousDL=By.xpath("//li[normalize-space()='Add Previous License']");
	
	By ClickIssueState=By.xpath("//div[@id='issueState']");
	By SelectIssueState=By.xpath("//li[normalize-space()='California']");
	By ClickLicenseClass=By.xpath("//div[@id='licenseClass']");
	By SelectLicenseClass=By.xpath("//li[normalize-space()='None (Non-CDL Driver)']");
	By SelectDLClassA=By.xpath("//li[normalize-space()='Class A']");
	By SelectDLClassB=By.xpath("//li[normalize-space()='Class B']");
	By SelectDLClassC=By.xpath("//li[normalize-space()='Class C']");
	By SelectDLClassD=By.xpath("//li[normalize-space()='Class D']");
	By SelectDLClassE=By.xpath("//li[normalize-space()='Class E']");
	By LicenseNum=By.xpath("//input[@id='licenseNumber']");
	By DLIssueDate=By.xpath("//input[@id='issueDate']");
	By DLExpDate=By.xpath("//input[@id='expirationDate']");
	
	By UploadDLFront=By.xpath("(//input[@id='document'])[1]");
	By UploadDLBack=By.xpath("(//input[@id='licenseDocumentBack'])[1]");
	
	By MVR=By.xpath("//li[normalize-space()='MVR Document']");
	By MVRConsentDocUpload=By.xpath("(//input[@id='document'])[1]");
	By ExaminerNo=By.xpath("//input[@id='nationalRegistryNumber']");
	By DoctorName=By.xpath("//input[@id='medicalExaminerName']");
	By MCDocuUpload=By.xpath("(//input[@id='certificateDocument'])[1]");
	By NRCMEDocUpload=By.xpath("(//input[@id='nrcmeDocument'])[1]");		
	By MiscDocUpload=By.xpath("//input[@id='document']");
	By RoadTestDocUpload=By.xpath("(//input[@id='document'])[1]");
	
	
	By Submit4=By.xpath("//button[normalize-space()='Submit']");
	By Cancel=By.xpath("//button[normalize-space()='Cancel']");
	
	   // Update MVR
	   public By DriverManagement = By.xpath("(//a[@class='active'])[1]");
	   public By SearchButton= By.xpath("//button[@aria-label='Show/Hide search']");
	   public By EnterDriverName= By.xpath("(//input[@value='Driver0a'])[1]");
	   public By UpdateMVR=By.xpath("(//span[contains(text(),'Missing')])[1]");
	   public By IssueState1=By.xpath("(//div[@id='issueState'])[1]");
	   public By ChooseState=By.xpath("//li[.='California']");		   
	   public By IssueDate1=By.xpath("(//input[@id='issueDate'])[1]");
	   public By ExpDate1=By.xpath("(//input[@id='expirationDate'])[1]");
	   public By UploadDoc1=By.xpath("(//input[@id='document'])[1]");
	   public By SubmitMVR=By.xpath("(//button[@class='btn btn-outline-grey mb-2 mr-1 btnstyle2'][normalize-space()='Submit'])[1]");
	   
	   public By NRCME_Sig=By.xpath("(//canvas[@class='sigCanvas'])[1]");
	   
// 10.2 Update Vehicle Document-----------------  
	/*   By DocumentMenu=By.xpath("//span[normalize-space()='Documents']"));

	   By VehicleSection=By.xpath("//a[@id='filecabinets.vehicledocuments']"));
	   By UploadDocButton=By.xpath("//button[@id='documents.vehicledocuments.upload']//i[@class='fa fa-upload']"));
	   By DocType=By.xpath("//div[@id='documentType']"));
	   By Lease=By.xpath("//li[normalize-space()='Lease Document']"));
	   //By LeaseDocNum=By.xpath("//div[@role='dialog']"));
	   By LeaseDocNum=By.xpath("//input[@id='leaseNumber']"));
	   By LeaseCompanyName=By.xpath("//input[@id='ownerCompany']"));
	   By issueDate=By.xpath("//input[@id='issueDate']"));
	   By ExpirationDate=By.xpath("//input[@id='expirationDate']"));
	   By UploadLeaseDoc=By.xpath("//input[@id='document']"));
	   By UnitNumber=By.xpath("//input[@id='mui-54731']"));
	   By Submit5=By.xpath("//button[normalize-space()='Submit']"));

	   By Cancle=By.xpath("//button[normalize-space()='Cancel']"));
	   
	 */  
	 
	    
	   
       
	 
	
	public HomePageOfCarrier(WebDriver d)
	{
		driver=d;
	}
	// For the First Carrier User 
/*	public void PopUp() throws InterruptedException
	{
		driver.findElement(Dashboard).click();
		Thread.sleep(2000);
		
		driver.findElement(Required_CDL_DL1).click();
		String FleetPopUpQuestion1=driver.findElement(PopupQuestion).getText();
		System.out.println(FleetPopUpQuestion1+": Yes");
		driver.findElement(Next1).click();   
		
		driver.findElement(Required_CDL_DL2).click();
		String FleetPopUpQuestion2=driver.findElement(PopupQuestion).getText();
		Thread.sleep(3000);
		System.out.println(FleetPopUpQuestion2+": No");
		Thread.sleep(2000);
		driver.findElement(Next2).click();
		
		String DA_Notification=driver.findElement(DANotification).getText();
		System.out.println(DA_Notification);

		String ConsentToAgree=driver.findElement(AgreeForNotification).getText();
		System.out.println(ConsentToAgree);
		
		driver.findElement(CheckBox).click();
		
		driver.findElement(submit).click();
		
		//driver.findElement(Previous).click();
		
		
	}   */
	
	public String getRandomNumberString2() {
	    // It will generate 6 digit random Number.
	    // from 0 to 9999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%06d", number);
	}
	
	public void DrDashboard() throws InterruptedException
	{
		driver.findElement(Dashboard).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(NoDrivers1).getText());
		
		System.out.println(driver.findElement(ComplaintDrivers1).getText());
		
		System.out.println(driver.findElement(NoVehicles1).getText());
   		
		System.out.println(driver.findElement(PendingDrivers1).getText());
		
		//immidiate Actions
		System.out.println(driver.findElement(ImmediateActionHeader).getText());
		//System.out.println("Name  "+"Type  "+ "Details  "+ "Expiration Date  "+ "Status");  //*[@id='main-content']/div[3]/div[2]/div/div[2]/div[2]/div/div/div/table/thead/tr
		System.out.println(driver.findElement(ImmediateActionsDetails1).getText());
		System.out.println(driver.findElement(ImmediateActionsDetails2).getText());
		
	}
	
// 2 .0	Edit Carrier Company Profile info and adrress
	
	public void EditCompanyDetails() throws Exception
	{
		String CompanyNameR= RandomNameGenerator.generateRandomCompanyName();
		
		driver.findElement(CompanyProfile).click();
		driver.findElement(CompanyInfoEditButton).click();
		driver.findElement(CompanyName).clear();
		driver.findElement(CompanyName).sendKeys(CompanyNameR);
		driver.findElement(USDot).clear();
		driver.findElement(USDot).sendKeys(getRandomNumberString2());
		driver.findElement(LegalName).sendKeys(CompanyNameR);
		driver.findElement(MemberSince).click();
		
		WebElement CreatedDate =driver.findElement(MemberSince);
		CreatedDate.click();
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_CONTROL);
		rbt2.keyPress(KeyEvent.VK_A);
		rbt2.keyRelease(KeyEvent.VK_A);
		rbt2.keyRelease(KeyEvent.VK_CONTROL);
		
		rbt2.keyPress(KeyEvent.VK_CONTROL);
		rbt2.keyPress(KeyEvent.VK_C);
		rbt2.keyRelease(KeyEvent.VK_C);
		rbt2.keyRelease(KeyEvent.VK_CONTROL);
		
		//System.out.println("MemberSince: "+ CreatedDate);
		driver.findElement(USMCNumber).sendKeys("1236547");
		driver.findElement(CompanyMail).clear();
		driver.findElement(CompanyMail).sendKeys(CompanyNameR+"@innowyze.testinator");
		driver.findElement(CancelButon).click();
		
	}
	
	public void EditCompanyAddress() throws Exception
	{
	  driver.findElement(CompanyIAddressEditButton).click();
	  driver.findElement(Address1).clear();
	  //driver.findElement(Address2).clear();
	  Thread.sleep(2000);
	  driver.findElement(City).clear();
	  driver.findElement(ZipORPostalCode).clear();
	  driver.findElement(PhoneC).clear();
	  driver.findElement(State).click();
	  driver.findElement(StateNameRS).click();
	  
	}
  // 3.4.1 Invite_New_Driver From Driver & DQ
	public void DriverAndDQ() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(DriverRecruitment).click();	
	}
	
	public void Invite_new_drivers(String EnterDL_No)
	{
		driver.findElement(Invite_New_Driver).click();
		driver.findElement(Enter_DL_No).sendKeys(EnterDL_No);
		driver.findElement(Create_Driver_Application).click();
	}
	
	public void Driver_Info() throws IOException, Exception
	{
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("inviteDriver.properties");
		props.load(file);
		
		String randomName = RandomNameGenerator.generateRandomName();
		String EmailName=randomName;
        String randomSurname = RandomNameGenerator.generateRandomSurname();
        char randomCapitalLetter = generateRandomCapitalAlphabet();
        String CompanyName= RandomNameGenerator.generateRandomCompanyName();
        
		String fn = props.getProperty("FirstName");
		String mn = props.getProperty("MiddleName");
		String ln = props.getProperty("LastName");
		
		
		driver.findElement(First_Name).sendKeys(randomName);
		driver.findElement(Middle_Name).sendKeys(mn);
		driver.findElement(Last_Name).sendKeys(randomSurname);
		
		driver.findElement(First_Name).click();
		//driver.findElement(First_Name).getAttribute("value");
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        


	}
	
	private char generateRandomCapitalAlphabet() {
	        Random random = new Random();
	        int randomInt = random.nextInt(26); // Generate a random number between 0 and 25
	        char randomCapitalAlphabet = (char) ('A' + randomInt); // Convert the random number to a capital alphabet
	        return randomCapitalAlphabet;
	    
	}

	public void DOB(String DDOB)
	{
		driver.findElement(Driver_DOB).sendKeys(DDOB);
	}
	
	public void DrEmail() throws Throwable
	{
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("inviteDriver.properties");
		props.load(file);
		String randomName = RandomNameGenerator.generateRandomName();
		String fn = props.getProperty("FirstName");
		
		driver.findElement(Driver_Email).sendKeys(randomName+"@innowyze.testinator.com");
		//driver.findElement(Driver_Email).sendKeys(randomName+"@metrotms.testinator.com");
	}
	public void DrPhone()
	{
        driver.findElement(Driver_PhoneNo).sendKeys("4042"+PhoneNo());
	}

	private String PhoneNo() {
		 Random rnd = new Random();
		    int number = rnd.nextInt(999999);

		    // this will convert any number sequence into 6 character.
		    return String.format("%06d", number);	
	}

	public void DrDLIssue_State()
	{
		driver.findElement(Driver_issue_state).click();
		driver.findElement(Selected_State).click();
	}
	public void ClassType()
	{
		driver.findElement(Class_type).click();
		driver.findElement(Choose_Class_NonCDL).click();
	}
	public void DL_issueDate(String DLIssueDate)
	{
		driver.findElement(License_issue_Date).sendKeys(DLIssueDate);
	}
	public void DL_ExpDate(String DLExpDate)
	{
		driver.findElement(License_Exp_Date).sendKeys(DLExpDate);
	}
	public void ReqCDL_Yes()
	{
		driver.findElement(Requiring_Commercial_DL_YES).click();
		
	} 
	
	public void ConsortiumYes()
	{
		driver.findElement(DriverIncludedConsortium_Yes).click();
	}
	
	public void ConsortiumNo()
	{
		driver.findElement(DriverIncludedConsortium_No).click();
	}
	
	public void ReqCDL_No()
	{
		driver.findElement(Requiring_Commercial_DL_NO).click();
		
	}

	public void Send_Driver_Application()
	{
		driver.findElement(SendDriverApplication).click();
	}
	
//----------------Manage pending driver-------------
	public void Approve_Driver(String Dname) throws Exception
	{
		driver.findElement(ManagePendingDrivers).click();
		Thread.sleep(2000);
		driver.findElement(SearchDriver).sendKeys(Dname);
		Thread.sleep(2000);
		driver.findElement(ApproveDriver).click();
		Thread.sleep(2000);
		driver.findElement(ConfirmAproveDr).click();
		Thread.sleep(2000);
	}
	public void Reject_Driver()
	{
		driver.findElement(RejectDriver).click();
	}
	public void Replace_Driver()
	{
		driver.findElement(ReplaceDriver).click();
	}
//-----------------Upload Driver docs---------------
	String FleetDev="https://dev.fleetdrive360.com/login";//http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";
	 public void UpdateMVRDoc() throws AWTException, InterruptedException, EncryptedDocumentException, IOException 
		{
			String key="webdriver.chrome.driver";
			String value="./software/chromedriver.exe";
			System.setProperty(key,value);
			ChromeDriver driver =new ChromeDriver();
		
		//  Application classes
		    LoginSVP LoginFleet=new LoginSVP(driver);
			DashboardSVP SVPDB=new DashboardSVP(driver);
			CompanyProfileSVP SVPCompanyProfile= new CompanyProfileSVP(driver);
			ManageClients Manage_Clients=new ManageClients(driver);
			HomePageOfCarrier Carrier_Space=new HomePageOfCarrier(driver);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(FleetDev);
		
			// Login as Sevice Provider
			LoginFleet.printTitle();
			String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
	        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

	        for (int i = 0; i < usernames.length; i++) {
	        	LoginFleet.login(usernames[0], passwords[0]);
	        	
		Thread.sleep(2000);
	// Switching Carrier
		SVPDB.Selecting_CarrierDev("BRANDONs");
		driver.findElement(DriverManagement).click();
		driver.findElement(SearchButton).click();
		driver.findElement(EnterDriverName).sendKeys("Zoe");
		Thread.sleep(3000);
		driver.findElement(UpdateMVR).click();
		driver.findElement(IssueState1).click();
		driver.findElement(ChooseState).click();
		driver.findElement(IssueDate1).sendKeys("01102023");
		driver.findElement(ExpDate1).sendKeys("01092024");
		driver.findElement(UploadDoc1).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\MVR Doc.png");
		driver.findElement(SubmitMVR).click();
		}
		}
	 public void signature1() throws InterruptedException
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
	      
			WebElement signatureele = driver.findElement(By.xpath("//canvas[@class='sigCanvas']"));
			Actions act=new Actions(driver);
			Thread.sleep(2000);
			Actions drawaction = act.moveToElement(signatureele, 50, 50);
			drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
			Thread.sleep(2000);  
			Assert.assertTrue(true);
			//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
			System.out.println("Driver consent form submitted successfully");
		}	 
	 
	 public void NRCME_Sig() throws InterruptedException
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
	      WebElement n = driver.findElement(By.tagName("canvas"));
	      String r = n.getText();
	      System.out.println("Text obtained on scrolling up: "+ r);
	     
			WebElement signatureele = driver.findElement(By.xpath("(//canvas[@class='sigCanvas'])[1]"));
			Actions act=new Actions(driver);
			Thread.sleep(2000);
			Actions drawaction = act.moveToElement(signatureele, 50, 50);
			drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
			Thread.sleep(2000);  
			Assert.assertTrue(true);
			//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
			System.out.println("Driver NRCME form submitted successfully");
		}
	 
	 public void RTC_Sig() throws InterruptedException
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
	      WebElement n = driver.findElement(By.tagName("canvas"));
	      String r = n.getText();
	      System.out.println("Text obtained on scrolling up: "+ r);
	     
			WebElement signatureele = driver.findElement(By.xpath("(//canvas[@class='sigCanvas'])[1]"));
			Actions act=new Actions(driver);
			Thread.sleep(2000);
			Actions drawaction = act.moveToElement(signatureele, 50, 50);
			drawaction.clickAndHold().moveByOffset(10, 30).release().perform();
			Thread.sleep(2000);  
			Assert.assertTrue(true);
			//test.log(LogStatus.PASS, "Driver consent form submitted successfully");
			System.out.println("Driver RTC form submitted successfully");
		}
	 
//--------------------ApproveDriverAppliaction----------------------------	
	
	public void DriverAppliactionTab()
	{
		driver.findElement(DriverApplicationTab).click();
	}
	public void DownloadDriverlistPDF()
	{
		driver.findElement(DriverListPDF).click();
	}
	
	public void DownloadDriverlistXL()
	{
		driver.findElement(DriverListXL).click();
	}
	
	public void VerifyAndApproveDrApplication(String EnterDriverName)
	{
		driver.findElement(SearchButton).click();
		driver.findElement(EnterDriverName1).sendKeys(EnterDriverName);
	}
	
	public void EnteredDrInfo()
	{
		
		String DriverDetails=driver.findElement(DriverInfo).getText();
		System.out.println(DriverDetails);
	}
	
	public void DownloadDLFrontend()
	{
		
		driver.findElement(DownloadDLFront).click();
	}
	
	public void DownloadDLBackend()
	{
		
		driver.findElement(DownloadDLBack).click();
	}
	
	public void DownloadConcentForm() 
	{

		driver.findElement(DownloadCF).click();
	}
	
	public void DownloadMedicalCertificate()
	{
		driver.findElement(DownloadMC).click();
	}

	public void ViewApplicationAndDownload()
	{
		driver.findElement(ViewApplication).click(); 
		driver.findElement(DownloadApplication).click();
	}
	
	public void ApproveDrApplication() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(ApproveApplication).click();
	}
	
	public void CDLDrYesSubmit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(ApproveCDLYes).click();
		driver.findElement(DrugTest).click();
		driver.findElement(SubmitCDL).click();
	}
	
	public void NonCDLDrSubmit()
	{
		driver.findElement(SubmitNonCDL).click();
	}
	
	public void PopupCancel() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(PopupCancel).click();
		
	}
	
	public void PopupSubmit() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(PopupSubmit).click();
	}
	
	public void ProceedToCheckout()
	{
		driver.findElement(ProceedToCheckout).click();
	}
	
//------------------------------------ ConductACHQuery-------------------------------	
	
	public void ConductAQueryLimited()
	{
		driver.findElement(ClearinghouseMenu).click();
		driver.findElement(OpenConductAQuery).click();
	}
	
	public void SelectDriver(String DriverName) throws AWTException, InterruptedException 
	{
		driver.findElement(SelectADriver_DropDown).click();
		Robot robot = new Robot();

        // Wait for a moment before starting
        Thread.sleep(2000);

        String wordToType = DriverName;
        
        // Iterate through each character and simulate key presses
        for (char c : wordToType.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        // Simulate pressing Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);    	
	}
	public void ChoosQuerytype_Limited()
	{
		driver.findElement(ChooseLimitedQuery).click();
	}
	public void ChoosQuerytype_Full()
	{
		driver.findElement(ChooseFullQuery).click();
	}
	public void SubmitQuery()
	{
		driver.findElement(SubmitConductQuery).click();
	}
	public void ClickQueryDetails()
	{
		driver.findElement(ClickQueryDetailsSection).click();
	}
	public void SearchDriver(String DriverName)
	{
		driver.findElement(SearchDriverName2).sendKeys(DriverName);
	}
	public static class RandomNameGenerator {

	    private static final List<String> US_NAMES = Arrays.asList(
	        "John", "Jane", "Michael", "Emily", "William", "Olivia", "James", "Sophia", "Alexander", "Emma",
	        "Matthew", "Abigail", "Daniel", "Elizabeth", "Andrew", "Mia", "Joseph", "Ella", "Benjamin", "Avery",
	        "David", "Sofia", "Nicholas", "Chloe", "Christopher", "Scarlett", "Joshua", "Grace", "Ethan", "Victoria",
	        "Ryan", "Aria", "Samuel", "Aubrey", "Nathan", "Hannah", "Tyler", "Addison", "Jonathan", "Lily",
	        "Gabriel", "Natalie", "Christian", "Zoe", "Noah", "Brooklyn", "Dylan", "Riley", "Isaac", "Layla"
	        // Add more names as needed
	    );

	    private static final List<String> US_SURNAMES = Arrays.asList(
	        "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Martinez", "Wilson",
	        "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White", "Lopez",
	        "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hall", "Young",
	        "Allen", "Sanchez", "Wright", "King", "Scott", "Green", "Baker", "Adams", "Nelson", "Hill"
	        // Add more surnames as needed
	    );
	    
	    public static final List<String> TRUCKING_TERMS = Arrays.asList(
	    	    "Express", "Freight", "Logistics", "Transport", "Delivery",
	    	    "Hauling", "Cargo", "Truckers", "Transit", "Carriers",
	    	    "Trans", "Move", "Roadways", "Shippers", "Haulers",
	    	    "Transcontinental", "Transit", "Fleet", "Truckload",
	    	    "Carriage", "Conveyance", "Distribution", "Dispatch",
	    	    "Logistical", "Shipment", "Transfer", "Shipping",
	    	    "Logistic", "Trucking", "Haulage", "Convey", "Cargo",
	    	    "Transpo", "Freighter", "Conveyors", "Truckline",
	    	    "Carriage", "Carry", "Transfers", "Transporters",
	    	    "Freighters", "Trucks", "Movers", "Moverz", "MoveIt",
	    	    "OnTheMove", "DeliverIt", "SwiftShippers", "CargoKings",
	    	    "HaulItAll", "ExpressWheels", "SpeedyFreight", "FastLane",
	    	    "RoadRunners", "CargoMasters", "TransNation", "Shifters",
	    	    "TruckMasters", "QuickHaul", "RoadHauler", "SafeTrans",
	    	    "SwiftTransit", "PrimeHaulers", "FastFreighters", "CargoWays"
	    	);
	    
	    public static char generateRandomCapitalLetter() {
	        Random random = new Random();
	        int asciiValue = random.nextInt(26) + 65; // 65 is the ASCII value of 'A'
	        return (char) asciiValue;
	    }
	    
/*	private String Names() 
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 7));
		System.err.print(uuid);
		return uuid;
	}
	
	private char MNames() 
	{
		char MN = generateRandomCapitalAlphabet();
		return MN;
	}
*/	
	public static String PhoneNo() 
	{
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	
	public static String generateRandomName() {
        int randomIndex = (int) (Math.random() * US_NAMES.size());
        return US_NAMES.get(randomIndex);
    }
	
	public static char generateRandomCapitalAlphabet() {
        Random random = new Random();
        int randomInt = random.nextInt(26); // Generate a random number between 0 and 25
        char randomCapitalAlphabet = (char) ('A' + randomInt); // Convert the random number to a capital alphabet
        return randomCapitalAlphabet;
    }

    public static String generateRandomSurname() {
        int randomIndex = (int) (Math.random() * US_SURNAMES.size());
        return US_SURNAMES.get(randomIndex);
    }
    
    public static String generateRandomCompanyName() {
        int randomIndex = (int) (Math.random() * TRUCKING_TERMS.size());
        return TRUCKING_TERMS.get(randomIndex);
    }
    
    public String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 9999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%06d", number);
	}
/*	public void companyProfile()
	{
		driver.findElement(CompanyProfile).click();
	}
	
	public void clickDriverHistory()
	{
		driver.findElement(DriverHistory).click();
	}  
	
	
	*/
	
	}
}

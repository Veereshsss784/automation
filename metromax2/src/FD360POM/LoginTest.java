package FD360POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import metromax2.FD360POM;
public class LoginTest {
	
	

	@Test
  public void ServiceProvider() throws Throwable 
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
		driver.get("https://compliance.fleetsmartcarrierservices.com/login");
	
		
	// Login as Sevice Provider
		LoginFleet.printTitle();
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[0], passwords[0]);
			
	
 // Dashboard()
		SVPDB.Dshbrd();
		SVPDB.C_ClientC();
		SVPDB.NC_ClientC();
		SVPDB.C_DrC();
		SVPDB.NC_drC();
	Thread.sleep(3000);
// Switching Carrier
	SVPDB.Selecting_CarrierBeta("IMPRESS");	
		
	Thread.sleep(2000);	

	// Selected Carrier
	//Carrier_Space.PopUp();  

// Dashboard 
	Carrier_Space.DrDashboard();
	Thread.sleep(2000);

	Carrier_Space.DriverAndDQ();
	Carrier_Space.Invite_new_drivers("NonCDL784478");
	Thread.sleep(3000);
	Carrier_Space.Driver_Info();
	Carrier_Space.DrEmail();
	Carrier_Space.DrPhone();
	Carrier_Space.ReqCDL_Yes();
	Carrier_Space.Send_Driver_Application(); 
	
	
/*		
// Company Profile 
        
		SVPCompanyProfile.CompanyProfilesvp();
        SVPCompanyProfile.SelectUser();  

     // Add User as Admin
        SVPCompanyProfile.Admin_pesonal_Details();
        SVPCompanyProfile.Admin_DOB("02031987");

        SVPCompanyProfile.Admin_Email();
        SVPCompanyProfile.Admin_Username("Veeresh1_Admin");
        SVPCompanyProfile.Admin_Password("784784784@VeereshA");
        SVPCompanyProfile.Admin_Confirm_Password("784784784@VeereshA");
        SVPCompanyProfile.See_Admin_PWD();
        Thread.sleep(3000);
           SVPCompanyProfile.Add_AdminUser();
           //SVPCompanyProfile.Admin_Cancel();    
        
 /*    // Add User as Account Manager
        SVPCompanyProfile.AccountMgr_pesonal_Details();
        SVPCompanyProfile.AccountMgr_DOB("01021990");
        SVPCompanyProfile.AccountMgr_Email();
        SVPCompanyProfile.AccountMgr_Username("Veeresh1_AccountMgr");
        SVPCompanyProfile.AccountMgr_Password("784784784@VeereshAM");
        SVPCompanyProfile.AccountMgr_Confirm_Password("784784784@VeereshAM");
        SVPCompanyProfile.See_AccountMgr_PWD();
        // Add Email Configuration Details
        SVPCompanyProfile.AccountMgr_EmailHost("smtp.gmail.com");
        SVPCompanyProfile.AccountMgr_EmailUser("Veeresh1_AccountMgr"+"@innowyze.testinator.com");
        SVPCompanyProfile.AccountMgr_EmailPassword("784784784@VeereshAM");
        SVPCompanyProfile.AccountMgr_EmailPort("587");
        //SVPCompanyProfile.Add_AccountMgrUseSSL();
        
        Thread.sleep(3000);
        SVPCompanyProfile.Add_AccountMgrUser();
        //SVPCompanyProfile.AccountMgr_Cancel();  */
    
    
/*       // Add User as Sales Person
        SVPCompanyProfile.Sales_Person_pesonal_Details();
        SVPCompanyProfile.Sales_Person_DOB("01121991");
        SVPCompanyProfile.Sales_Person_Email();
        SVPCompanyProfile.Sales_Person_Username("Veeresh1_Sales_Person");
        SVPCompanyProfile.Sales_Person_Password("784784784@VeereshSP");
        SVPCompanyProfile.Sales_Person_Confirm_Password("784784784@VeereshSP");
        SVPCompanyProfile.See_Sales_Person_PWD();
        
        Thread.sleep(3000);
        SVPCompanyProfile.Add_Sales_PersonUser();
        //SVPCompanyProfile.Sales_Person_Cancel();    
        
        
        
        
        
// Manage Clients
        Manage_Clients.ManageClientsModule();
        
        Manage_Clients.Client_List();
        Manage_Clients.Setup_Client();
        
        Manage_Clients.EnterDOT_No("2774778");
        Manage_Clients.check_Dot_No();
        Manage_Clients.EnterCompanyName();
      //  Manage_Clients.Company_legalNametext();
        
        Manage_Clients.EnterCompanylegalName();
        Manage_Clients.EnterCompany_Email();
        Manage_Clients.Enter_MCNo();
        
    // Enter Address  Details
        Manage_Clients.Enter_Address1();
        Manage_Clients.Enter_Address2();
        Manage_Clients.city();
        Manage_Clients.zipcode();
        Manage_Clients.state();
        
    // Enter owner Details
        Manage_Clients.O_firstname("vee2");
        Manage_Clients.O_Middlename("a");
        Manage_Clients.O_Lastname("sal2");
        Manage_Clients.O_PhoneNum("4049875679");
        Manage_Clients.OwnerEmail();
       Thread.sleep(3000);  
        
      
   // Enter General Information      
        String select_sales_person = "Veeresh_Af2 sal56bd8";
   	    Manage_Clients.Select_SalesPerson(select_sales_person);  
      
	    String select_account_manager = "Veeresh_A5d sal7c575";
	    Manage_Clients.Select_AccountManager(select_account_manager);
   // Please Choose Any One Option
   
//Non - CDL Packages:
	    Manage_Clients.Select_NonCDL_FAP();
	    
	    
   // Please Choose Individual Products
	    
	   // Manage_Clients.Select_individual_pkg();
	   // Manage_Clients.SelectHeavyUseTaxProducts();
	    
   // Driver Count   
	    Thread.sleep(2000);
	    //Manage_Clients.Enter_DriverCount("0");
	    Manage_Clients.TotalAmount();
	    Thread.sleep(3000);
   // Proceed To Checkout
	    Manage_Clients.ProceedToCheckout();
	    Thread.sleep(4000);
   // Pay through Credit card
	    Manage_Clients.PaythroughCard();  
	  
	Thread.sleep(6000);     */
	
	 
     //driver.close();
	
	}   

		
	}	
}
	  
	



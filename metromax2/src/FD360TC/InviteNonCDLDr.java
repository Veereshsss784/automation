package FD360TC;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;
import metromax2.FD360POM;

public class InviteNonCDLDr {

	String FleetDev="https://dev.fleetdrive360.com/login";//http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";
	

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
		//driver.get(FleetDev);
		driver.get(FleetBeta);
		//driver.get(FleetProd);
		
		
	// Login as Sevice Provider
		//LoginFleet.printTitle();
		//System.out.println("Printed title");
		

        String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am"};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs"};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);
  

		System.out.println("Login successully done");
			
	Thread.sleep(4000);
	
// Switching Carrier
		SVPDB.Selecting_CarrierDev("VSTruckers");
  
        //SVPDB.Selecting_CarrierBeta("IMPRESS");
        
       //SVPDB.Selecting_CarrierProd("Nic Test Account 1");
   

	//SVPDB.Selecting_CarrierDevUSC("");
	//SVPDB.Selecting_CarrierDevUSC2("");
	
	//SVPDB.Selecting_CarrierBetaUSC("");
	
	
System.out.println("Carrier Switching done successfully");		
	Thread.sleep(8000);	

	// Selected Carrier
	//Carrier_Space.PopUp();  

// Dashboard 
	//Carrier_Space.DrDashboard();
	Carrier_Space.DriverAndDQ();
	System.out.println("selected 'Driver Recruitment' section");
	Thread.sleep(5000);

	Carrier_Space.Invite_new_drivers("NCDriverABC");
	System.out.println("Entered Driver License Number");
	Thread.sleep(3000);
	Carrier_Space.Driver_Info();
	Carrier_Space.DrEmail();
	Carrier_Space.DrPhone();
	Thread.sleep(1000);
	Carrier_Space.ReqCDL_No();
	//Carrier_Space.ConsortiumYes();  // for CDL
	//Carrier_Space.Send_Driver_Application();
	System.out.println("Driver invitation sent Successfully");
	Thread.sleep(6000);
	//driver.close();

}
	}
}

//   Check Email of - Driver
// for Dev SVP- Driver Email
// for Dev USC- Driver Email


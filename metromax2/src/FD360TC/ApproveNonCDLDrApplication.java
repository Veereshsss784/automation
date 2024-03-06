package FD360TC;
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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;
import metromax2.FD360POM;

public class ApproveNonCDLDrApplication {
	public By SearchButton= By.xpath("//button[@aria-label='Show/Hide search']");
	
	String FleetDev="https://dev.fleetdrive360.com/login";//http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";

	@Test
  public void ServiceProvider() throws AWTException, InterruptedException, EncryptedDocumentException, IOException 
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
		driver.get(FleetBeta);
		Robot robot = new Robot();
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	
		
	// Login as Sevice Provider
		LoginFleet.printTitle();
		System.out.println("Printed title");
		String[] usernames = {"oliver_1", "ellen", "nicholas_MCRD", "Zoe",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);
        	
		System.out.println("Login successfully done");
		
// Switching Carrier
	SVPDB.Selecting_CarrierDev("138856");	
	//System.out.println("Swithed Appropriate Carrier");
		
	Thread.sleep(5000);	 

// Dashboard 
	
	Carrier_Space.DriverAndDQ();
	System.out.println("Selected Driver Recruitment section");
	Thread.sleep(3000);
	Carrier_Space.DriverAppliactionTab();
	System.out.println("Selected Driver Application tab");
	Thread.sleep(4000);
	
	Carrier_Space.VerifyAndApproveDrApplication("Scarlett Lewis");
	
	System.out.println("Entered Driver name");
	Thread.sleep(2000);
	//Carrier_Space.EnteredDrInfo();
	Carrier_Space.DownloadDLFrontend();
	System.out.println("Downloaded DL Front");
	Thread.sleep(4000);
	Carrier_Space.DownloadDLBackend();
	System.out.println("Downloaded DL Back");
	Thread.sleep(6000);
	Carrier_Space.DownloadConcentForm();
	System.out.println("Downloaded consent form");
	Thread.sleep(4000);
	Carrier_Space.DownloadMedicalCertificate();
	System.out.println("Downloaded Medical Certificate form");
	Thread.sleep(4000);
	Carrier_Space.ApproveDrApplication();
	System.out.println("clicked on 'Approve Application' icon");
	Thread.sleep(3000);
	Carrier_Space.NonCDLDrSubmit();  
	System.out.println("Approved Driver Appliaction Successfully");
	Thread.sleep(2000);
	//Carrier_Space.PopupSubmit();
	//Carrier_Space.CDLDrApprove();
	//Carrier_Space.ProceedToCheckout();
	Thread.sleep(5000);
	driver.close();
	
	}
}    //   Check Email of - Owner, Admin, Fleet Manager
}
                   //for Dev SVP- Driver | Company Administrator, Fleet Manager | Account Manager  
                   //for Dev USC- Driver | Company Administrator, Fleet Manager | Account Manager

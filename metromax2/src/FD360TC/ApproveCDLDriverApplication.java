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

public class ApproveCDLDriverApplication {
	
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
		driver.get(FleetDev);
	
		
	// Login as Sevice Provider
		LoginFleet.printTitle();
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am","testspowner1"};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", "127wyv#o6u"};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]); 
			
// Switching Carrier
	SVPDB.Selecting_CarrierBeta("");	
		
	Thread.sleep(2000);	 

// Dashboard 
	Carrier_Space.DrDashboard();
	Thread.sleep(2000);

	Carrier_Space.DriverAndDQ();
	Thread.sleep(2000);
	Carrier_Space.DriverAppliactionTab();
	Thread.sleep(3000);
	Carrier_Space.VerifyAndApproveDrApplication("Zoe");
	Thread.sleep(5000);
	Carrier_Space.EnteredDrInfo();
	Carrier_Space.DownloadDLFrontend();
	Thread.sleep(5000);
	Carrier_Space.DownloadDLBackend();
	Thread.sleep(5000);
	Carrier_Space.DownloadConcentForm();
	Thread.sleep(5000);
	Carrier_Space.DownloadMedicalCertificate();
	Thread.sleep(5000);
	Carrier_Space.ApproveDrApplication();
	Carrier_Space.CDLDrYesSubmit();
	Thread.sleep(3000);
	//Carrier_Space.PopupSubmit();
	//Carrier_Space.CDLDrApprove();
	Carrier_Space.ProceedToCheckout();
	
	}
}
}


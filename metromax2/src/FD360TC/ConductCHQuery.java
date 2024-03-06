package FD360TC;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.DriverApplicationLogin;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;

public class ConductCHQuery {

	String FleetDev="https://dev.fleetdrive360.com/login"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";
	
	@Test
	public void CopyNRCMEAndSubmit() throws InterruptedException, AWTException {
    	
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
		DriverApplicationLogin DrApplnLogin=new DriverApplicationLogin(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(FleetBeta);
		
	// Login as Sevice Provider
		LoginFleet.printTitle();
		String[] usernames = {"oliver_1",    "ellen",     "nicholas_1", "Self",      "Selftwo",    "selfthree", "selfthree",    "svp1",   "testing"};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330", "7847848330", "7847848330", "7847848330", "tpw7@mr02ei", "umnkx96aep"};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);               // Driver40 : #e39ayrlnf  lara : 5NLM8n2A6e
			
	Thread.sleep(5000);
// Switching Carrier
	SVPDB.Selecting_CarrierProd("Rock");
	Thread.sleep(5000);
	Carrier_Space.ConductAQueryLimited();
	Carrier_Space.SelectDriver("Nathan Miller");
	Carrier_Space.ChoosQuerytype_Full();
	Carrier_Space.SubmitQuery();

	Thread.sleep(7000);
	Carrier_Space.ClickQueryDetails();
	Carrier_Space.SearchDriver("Nathan Miller");
	
	//Carrier_Space.ConductAQueryLimited("Nathan Miller");
}
}
}
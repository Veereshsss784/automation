package metromax;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.LoginTest;
import FD360POM.ManageClients;

public class Test_InviteDriverSVP {

	@Test
	public void ServiceProvider() throws AWTException, InterruptedException, Throwable 
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
		LoginTest SVPtestInviteDriver=new LoginTest();

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://compliance.fleetsmartcarrierservices.com/login");
		
   // Login as Sevice Provider
				LoginFleet.printTitle();
				String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
		        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

		        for (int i = 0; i < usernames.length; i++) {
		        	LoginFleet.login(usernames[1], passwords[1]);
					
	// Dashboard SVP
				SVPDB.Dshbrd();
				SVPDB.C_ClientC();
				SVPDB.NC_ClientC();
				SVPDB.C_DrC();
				SVPDB.NC_drC();
			Thread.sleep(3000);
           // Switching Carrier
			SVPDB.Selecting_CarrierBeta("IMPRESS");
		   
    // Dashboard Carrier 
			
			//Carrier_Space.DrDashboard();
			Thread.sleep(2000);
			
			Carrier_Space.DriverAndDQ();
			Carrier_Space.Invite_new_drivers("CDL774784");
			Carrier_Space.Driver_Info();
			//Carrier_Space.DOB("04141992");
			Carrier_Space.DrEmail();
			Carrier_Space.DrPhone();
			//Carrier_Space.DrDLIssue_State();
			//Carrier_Space.ClassType();
			//Carrier_Space.DL_issueDate("08122020");
			//Carrier_Space.DL_ExpDate("03062028");
			Carrier_Space.ReqCDL_No();
		//	Carrier_Space.Send_Driver_Application();
			
	}

}
}

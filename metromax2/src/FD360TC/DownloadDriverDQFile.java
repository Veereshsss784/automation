package FD360TC;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;

public class DownloadDriverDQFile {

	String FleetDev="https://dev.fleetdrive360.com/login";//http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";
	 
	@Test
  public void UpdateMVRdoc() throws AWTException, InterruptedException, EncryptedDocumentException, IOException 
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
	
		
	// Login as Sevice Provider
		LoginFleet.printTitle();
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);
		
	Thread.sleep(3000);
// Switching Carrier
	
	SVPDB.Selecting_CarrierBeta("Rock");
	Thread.sleep(4000);
	
	driver.findElement(Carrier_Space.ManageDrivers).click();
	Thread.sleep(2000);
	driver.findElement(Carrier_Space.SearchDriverName).sendKeys("Nathan Miller");
	Thread.sleep(4000);
	driver.findElement(Carrier_Space.SelectDriver).click();
	Thread.sleep(2000);
	String DPDrivername1=driver.findElement(Carrier_Space.DPDriverName).getText();
	String DPDriverStatus= driver.findElement(Carrier_Space.EmploymentStatus).getText();
	System.out.println("Driver Name: "+DPDrivername1);
	System.out.println("Employment Status: "+DPDriverStatus);
	Thread.sleep(2000);
	driver.findElement(Carrier_Space.dqdocument).click();
	Thread.sleep(2000);
	driver.findElement(Carrier_Space.DownloadDQfile).click();
	Thread.sleep(3000);
	driver.findElement(Carrier_Space.DownloadNewGeneratedDQFile).click();
	driver.findElement(Carrier_Space.EnterEmailid_DQ).sendKeys("Veereshtestit2@gmail.com");
	driver.findElement(Carrier_Space.SendDQfileToEmail).click();
	//driver.close();
	
}
	}
}

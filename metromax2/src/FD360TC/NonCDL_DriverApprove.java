package FD360TC;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.DriverApplicationLogin;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;

public class NonCDL_DriverApprove {

	By ManagePendingDrivers= By.xpath("(//a[@data-rb-event-key='manage_pending_driver'])[1]");
	By SearchDriver=By.xpath("(//input[@placeholder='Search'])[2]");
	
	By ApproveIcon=By.xpath("(//button[@title='Approve Driver'])[1]");
	By Approve=By.xpath("(//span[normalize-space()='Approve'])[1]");
	
	String FleetDev="https://dev.fleetdrive360.com/login"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";
	@Test
	public void ApproveNC_Driver() throws InterruptedException, AWTException {
    	
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
		String[] usernames = {"oliver_1", "ellen", "nicholas_MCRD", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);                // Driver40 : #e39ayrlnf  lara : 5NLM8n2A6e
			
	Thread.sleep(2000);
// Switching Carrier
	SVPDB.Selecting_CarrierDev("138856");	
		
	Thread.sleep(4000);	

	// Selected Carrier
	//Carrier_Space.PopUp();  

// Dashboard 
	Thread.sleep(2000);

	Carrier_Space.DriverAndDQ();
	driver.findElement(ManagePendingDrivers).click();
	Thread.sleep(6000);
	driver.findElement(SearchDriver).sendKeys("Scarlett Lewis");
	Thread.sleep(2000);
	
	driver.findElement(ApproveIcon).click();
	Thread.sleep(1000);
    driver.findElement(Approve).click();
    Thread.sleep(5000);
    driver.quit();
}
}
}

package FD360TC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class ApproveDriver 
{
	public By SearchButton= By.xpath("//button[@aria-label='Show/Hide search']");
	
	String FleetDev="https://dev.fleetdrive360.com/login"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
	String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
	String FleetProd="https://app.fleetdrive360.com/login";
	
	@Test
	public void Approve_Driver() throws Exception {
    	
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
		driver.get(FleetProd);
		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		// Login as Sevice Provider
				LoginFleet.printTitle();
				String[] usernames = {"oliver_1",    "ellen",     "nicholas_1", "Self",      "Selftwo",    "selfthree", "selfthree",    "svp1",   "testing"};
		        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330", "7847848330", "7847848330", "7847848330", "tpw7@mr02ei", "umnkx96aep"};

		        for (int i = 0; i < usernames.length; i++) {
		        	LoginFleet.login(usernames[2], passwords[2]);               // Driver40 : #e39ayrlnf  lara : 5NLM8n2A6e
					
			Thread.sleep(5000);
		// Switching Carrier
			SVPDB.Selecting_CarrierProd("Nic test");	
			
			// Selected Carrier
			//Carrier_Space.PopUp();  

		// Dashboard 
		
			Thread.sleep(3000);
			Carrier_Space.DriverAndDQ();
			Thread.sleep(1000);
			driver.findElement(Carrier_Space.ManagePendingDrivers).click();
			Thread.sleep(1000);
			driver.findElement(SearchButton).click();
			driver.findElement(Carrier_Space.SearchDriver).sendKeys("Isaac Smith");
			Thread.sleep(3000);
			driver.findElement(Carrier_Space.ApproveDriver).click();
			driver.findElement(Carrier_Space.ConfirmAproveDr).click();

			driver.findElement(LoginFleet.DriverLogout).click();
			
			try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		    driver.close();
			
}
}
}
	

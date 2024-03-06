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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;
import metromax2.FD360POM;
public class InviteCDLDr {
	
	String FleetDev="https://dev.fleetdrive360.com/login"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
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
		driver.get(FleetProd);
		
		
	// Login as Sevice Provider
		LoginFleet.printTitle();// 0           1              2          3              4              5           6              7         8         9         10      
		String[] usernames = {"oliver_1",    "ellen",     "nicholas_MCRD", "VeereshSelffive",      "Selftwo",    "selfthree", "chuck1",    "becks", "testing", "uscsales", "EmilyKing"};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330", "7847848330", "7847848330", "vlpo9n5e7d1u", "2@aq#go7", "umnkx96aep", "08xezws9cjr4", "6th15@jba#d"};

        for (int i = 0; i < usernames.length; i++)  {
        	LoginFleet.login(usernames[2], passwords[2]);                  // Driver40 : #e39ayrlnf  lara : 5NLM8n2A6e
			
        	//WebDriverWait wait = new WebDriverWait(driver, 10);
        	//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiFormControl-root']")));
// Switching Carrier
    Thread.sleep(5000);
	//SVPDB.Selecting_CarrierBeta("Nic test");	
		
	Thread.sleep(5000);	

	// Selected Carrier
	//Carrier_Space.PopUp();  

// Dashboard 
	
 
	Carrier_Space.DriverAndDQ();
	System.out.println("selected 'Driver Recruitment' section");
	Thread.sleep(3000);

	Carrier_Space.Invite_new_drivers("DrNCDL010");
	System.out.println("Entered Driver License Number");
	Thread.sleep(2000);
	Carrier_Space.Driver_Info();
	Carrier_Space.DrEmail();
	Carrier_Space.DrPhone();
	Thread.sleep(3000);
	Carrier_Space.ReqCDL_No();
	//Carrier_Space.ConsortiumYes();  // for CDL
	Carrier_Space.Send_Driver_Application();
	System.out.println("Driver invitation sent Successfully");
	Thread.sleep(4000);
	

}
}
}
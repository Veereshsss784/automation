package FD360TC;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;

public class CompanyProfileEdit {

	//Profile section
	
		String FleetDev="https://dev.fleetdrive360.com/login"; //http://compliance-ui-deployment-bucket.s3-website.us-east-2.amazonaws.com/login/
		String FleetBeta="https://compliance.fleetsmartcarrierservices.com/login";
		String FleetProd="https://app.fleetdrive360.com/login";

		@Test
		public void EditCompanyInfoAndAddress() throws Exception
	{
	  
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
			LoginFleet.printTitle();// 0           1              2          3              4              5           6              7         8         9               
			String[] usernames = {"oliver_1",    "ellen",     "nicholas_1", "Self",      "Selftwo",    "selfthree", "selfthree",    "svp1", "testing", "uscsales"};
	        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330", "7847848330", "7847848330", "7847848330", "tpw7@mr02ei", "umnkx96aep", "08xezws9cjr4"};

	        for (int i = 0; i < usernames.length; i++) {
	        	LoginFleet.login(usernames[1], passwords[1]);                  // Driver40 : #e39ayrlnf  lara : 5NLM8n2A6e
				
	        	//WebDriverWait wait = new WebDriverWait(driver, 10);
	        	//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiFormControl-root']")));
	// Switching Carrier
		SVPDB.Selecting_CarrierProd("ROCK");
        Thread.sleep(8000);
	    Carrier_Space.EditCompanyDetails();
	    Thread.sleep(5000);
	    Carrier_Space.EditCompanyAddress();
		Thread.sleep(5000);

		// Selected Carrier
		//Carrier_Space.PopUp();  

	// Dashboard 
		//Thread.sleep(20000);
	}
}
	}
}


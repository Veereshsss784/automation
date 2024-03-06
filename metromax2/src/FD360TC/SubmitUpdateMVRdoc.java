package FD360TC;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;

public class SubmitUpdateMVRdoc 
{
	WebDriver driver;
	   By ManagePendingDrivers= By.xpath("(//a[@data-rb-event-key='manage_pending_driver'])[1]");
	   public By SearchButton= By.xpath("//button[@aria-label='Show/Hide search']");
	   By SearchDriver=By.xpath("(//input[@placeholder='Search'])[1]");
	   By DriverManagement = By.xpath("(//span[normalize-space()='Driver Management'])[1]");
	   By UpdateMVR=By.xpath("(//span[contains(text(),'Missing')])[1]"); 
	   By UploadMVR=By.xpath("//input[@value='upload']");
	   By OrderMVR=By.xpath("//input[@value='order']");
	   
	   By IssueState1=By.xpath("//div[@id='mui-component-select-issueState']");
	   By ChooseState=By.xpath("//li[normalize-space()='California']");		   
	   By IssueDate1=By.xpath("//input[@id='issueDate']");
	   By ExpDate1=By.xpath("//input[@id='expirationDate']");
	   By UploadDoc1=By.xpath("(//input[@id='document'])[1]");
	   By SubmitMVR=By.xpath("//button[normalize-space()='Submit']");

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
		String[] usernames = {"oliver_1", "ellen", "nicholas_MCRD", "kinger",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);
		
	Thread.sleep(2000);
// Switching Carrier
	
	SVPDB.Selecting_CarrierProd("138856");
	Thread.sleep(3000);
	Carrier_Space.DriverAndDQ();
	Thread.sleep(2000);
	driver.findElement(ManagePendingDrivers).click();
	Thread.sleep(1000);
	driver.findElement(SearchButton).click();
	driver.findElement(SearchDriver).sendKeys("Scarlett Lewis");
	
	Thread.sleep(4000);
	driver.findElement(UpdateMVR).click();
	Thread.sleep(3000);
	driver.findElement(UploadMVR).click();
	Thread.sleep(3000);
	driver.findElement(IssueState1).click();
	Thread.sleep(1000);
	driver.findElement(ChooseState).click();
	driver.findElement(IssueDate1).sendKeys("01102023");
	driver.findElement(ExpDate1).sendKeys("11302023");
	driver.findElement(UploadDoc1).sendKeys("C:\\Users\\Veeresh Salagar\\Desktop\\MVR.png");
	Thread.sleep(2000);
	driver.findElement(SubmitMVR).click();
	Thread.sleep(5000);
	driver.close();
	}
	
}
}

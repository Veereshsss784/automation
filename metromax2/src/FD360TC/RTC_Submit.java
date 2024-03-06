package FD360TC;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import FD360POM.CompanyProfileSVP;
import FD360POM.DashboardSVP;
import FD360POM.DriverApplicationLogin;
import FD360POM.HomePageOfCarrier;
import FD360POM.LoginSVP;
import FD360POM.ManageClients;

public class RTC_Submit {
	
	
	By ManagePendingDrivers= By.xpath("(//a[@data-rb-event-key='manage_pending_driver'])[1]");
	public By SearchButton= By.xpath("//button[@aria-label='Show/Hide search']");
	By SearchDriver=By.xpath("(//input[@placeholder='Search'])[1]");
	
	By CopyNRCME=By.xpath("(//span[@title='Copy Link'])[1]");
 
	By VerifieBy=By.xpath("(//input[@id='printName'])[1]");
	By Date=By.xpath("(//input[@id='date'])[1]");
    By SubmitNRCME=By.xpath("(//button[normalize-space()='Submit'])[1]");
	
	By CopyRTC=By.xpath("(//span[@title='Copy Link'])[1]");
	By RTCState=By.xpath("(//div[@id='state'])[1]");
	By SelectState=By.xpath("(//li[normalize-space()='California'])[1]");
	By TypeOfUnit=By.xpath("(//input[@id='typeOfPowerUnit'])[1]");
	By TypeOfTrailer=By.xpath("(//input[@id='typeOfTrailer'])[1]");
	By TypeOfBus=By.xpath("(//input[@id='typeOfBus'])[1]");
	
	By Equipment_S=By.xpath("(//input[@value='yes1'])[1]");
	By Maneuvers_S=By.xpath("(//input[@value='yes2'])[1]");
	By Places_S=By.xpath("(//input[@value='yes3'])[1]");
	By Operates_S=By.xpath("(//input[@value='yes4'])[1]");
	By Turns_S=By.xpath("(//input[@value='yes5'])[1]");
	By Brakes_S=By.xpath("(//input[@value='yes6'])[1]");
	By Backs_S=By.xpath("(//input[@value='yes7'])[1]");
	By Uses_S=By.xpath("(//input[@value='yes8'])[1]");
	By RoadTestDate_S=By.xpath("(//input[@id='roadTestDate'])[1]");
	
	By Miles=By.xpath("(//input[@id='miles'])[1]");
	By Title_S=By.xpath("(//input[@id='title'])[1]");
	By Organization_S=By.xpath("(//textarea[@id='address'])[1]");
	By SubmitRTC=By.xpath("(//button[normalize-space()='Submit'])[1]");
	
	By ApproveIcon=By.xpath("(//button[@title='Approve Driver'])[1]");
	By Approve=By.xpath("(//span[normalize-space()='Approve'])[1]");
	
	
	
	
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
//		LoginFleet.EnterUserName("ellen");    // oliver_1 :AdhEJRXtN9   // alex: hwl7qxjes
//		LoginFleet.EnterPassword("eJroXF8jZ0");
		
		String[] usernames = {"oliver_1",   "ellen",      "nicholas_MCRD", "Self",       "Selftwo",   "selfthree",  "kinger"};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330", "7847848330", "7847848330", "7847848330"};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[1], passwords[1]);                // Driver40 : #e39ayrlnf  lara : 5NLM8n2A6e
			
	Thread.sleep(5000);
// Switching Carrier
	SVPDB.Selecting_CarrierProd("138856");	
	
		
	Thread.sleep(5000);	

	// Selected Carrier
	//Carrier_Space.PopUp();  

// Dashboard 
	Carrier_Space.DriverAndDQ();
	Thread.sleep(5000);
	driver.findElement(ManagePendingDrivers).click();
	Thread.sleep(6000);
	driver.findElement(SearchButton).click();
	driver.findElement(SearchDriver).sendKeys("Scarlett Lewis");
	Thread.sleep(5000);
    	driver.findElement(CopyRTC).click();
    	
    		//Open in new incognito window
    		Thread.sleep(2000);
    		Robot rbt2 = new Robot();
    		
    		rbt2.keyPress(KeyEvent.VK_CONTROL);
    	//	rbt2.keyPress(KeyEvent.VK_SHIFT);
    		rbt2.keyPress(KeyEvent.VK_T);
    		
    		rbt2.keyRelease(KeyEvent.VK_T);
    	//	rbt2.keyRelease(KeyEvent.VK_SHIFT);
            rbt2.keyRelease(KeyEvent.VK_CONTROL); 
            
            rbt2.keyPress(KeyEvent.VK_CONTROL);
    		rbt2.keyPress(KeyEvent.VK_V);
    		rbt2.keyRelease(KeyEvent.VK_V);
    		rbt2.keyRelease(KeyEvent.VK_CONTROL);
    		
    		rbt2.keyPress(KeyEvent.VK_ENTER);
    		rbt2.keyRelease(KeyEvent.VK_ENTER);  
    		
    		Thread.sleep(5000);
    		
    		String Parent_id = driver.getWindowHandle();
            System.out.println(Parent_id);
     
            // getWindowHandle method to get ID of new window (child window)one
            
            Set<String> Child_id = driver.getWindowHandles();
           
     
            // for each loop
            for (String a : Child_id) 
            {
                // it will print IDs of both window
                System.out.println(a);
     
                // condition to change the focus of selenium
                if (Parent_id.equals(a)) 
                {
                	
                }
               else 
                { 
                // to change focus on new window
                    driver.switchTo().window(a);
                    Thread.sleep(2000);
                    
                    driver.findElement(RTCState).click();
                    driver.findElement(SelectState).click();
                    driver.findElement(TypeOfUnit).sendKeys("4");
                    driver.findElement(TypeOfTrailer).sendKeys("5");
                    driver.findElement(TypeOfBus).sendKeys("Van");
                    
                    driver.findElement(Equipment_S).click();
                    driver.findElement(Maneuvers_S).click();
                    driver.findElement(Places_S).click();
                    driver.findElement(Operates_S).click();
                    driver.findElement(Turns_S).click();
                    driver.findElement(Brakes_S).click();
                    driver.findElement(Backs_S).click();
                    driver.findElement(Uses_S).click();
                    driver.findElement(RoadTestDate_S).sendKeys("01182023");
                    driver.findElement(Miles).sendKeys("7654321");
                    driver.findElement(Title_S).sendKeys("Title is ABC");
                    driver.findElement(Organization_S).sendKeys("Oranization is XYZ");
                    Carrier_Space.RTC_Sig(); 
                    Thread.sleep(2000);
                    driver.findElement(SubmitRTC).click();
                    Thread.sleep(3000);
                    
                  
    			
                }
                driver.close();
            }   
           
       /*     Thread.sleep(6000);
                driver.switchTo().window(Parent_id);
                
                    Thread.sleep(3000); 
                    driver.findElement(ApproveIcon).click();
                    Thread.sleep(3000); 
                    driver.findElement(Approve).click();
                    Thread.sleep(3000);
        */
            
           
    }

}
}


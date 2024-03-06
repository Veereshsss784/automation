package sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DashboardSVP {
	
WebDriver driver;
	
	By DashboardModule=By.xpath("//span[.='Dashboard']");
	
	By CompliantClientCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[1]");	
	By NonCompliantClientCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[2]");
	
	By CompliantDriverCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[3]");
	By NonCompliantDriverCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[4]");
	
	By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");  //div[@id='rbd-hidden-text-8-hidden-text-38']  //input[@id='mui-93707']
    
	By CarrierProfileIcon=By.xpath("//div[@class=' sb-avatar sb-avatar--text']");
    By FleetMyProfile=By.xpath("(//a[@class='dropdown-item'])[1]"); // for My Profile
    By FleetSettings=By.xpath("(//a[@class='dropdown-item'])[2]");// For Settings
    By ManageAccount=By.xpath("uncontrolled-tab-example-tab-ManageAccount");   //Tab
  //  By ChangePassword=
    By CurrentPassword=By.xpath("//input[@id='currentPasswordManageAccount']");  
   
    
    By NotificationBellIcon=By.xpath("//i[@class='icon-bell']");
 /*   Actions action = new Actions(driver);
    WebElement element = driver.findElement(By.id("elementId"));
    action.moveToElement(element).perform();  
 */
    By NotificationBody=By.xpath("//div[@id='notificationCardBody']");
    By FleetLogout=By.xpath("//i[@class='icon-power']");
    
	public DashboardSVP(WebDriver d)
	{
		driver=d;
	}
	
	public void Dshbrd() throws InterruptedException
	{
		driver.findElement(DashboardModule).click();
		Thread.sleep(3000);
	}
	
	public void C_ClientC()
	{
		driver.findElement(CompliantClientCount).getText();
		System.out.println("CompliantClient NO is - "+driver.findElement(CompliantClientCount).getText());
	//	driver.findElement(CompliantClientCount).click();
	}
	
	public void NC_ClientC()
	{
		driver.findElement(NonCompliantClientCount).getText();
		System.out.println("NON CompliantClient NO is - "+driver.findElement(NonCompliantClientCount).getText());
	//	driver.findElement(NonCompliantClientCount).click();
	}
	
	public void C_DrC()
	{
		driver.findElement(CompliantDriverCount).getText();
		System.out.println("CompliantDriverCount NO is - "+driver.findElement(CompliantDriverCount).getText());
	//	driver.findElement(CompliantClientCount).click();
	}

	public void NC_drC()
	{
		driver.findElement(NonCompliantDriverCount).getText();
		System.out.println("NON CompliantDriverCount No is -"+driver.findElement(NonCompliantDriverCount).getText());
	//	driver.findElement(NonCompliantClientCount).click();
	}
	
	public void Selecting_Carrier() throws AWTException 
	{
		driver.findElement(SelectCarrier).click();
		//driver.findElement(SelectCarrier).sendKeys("AVE");
		
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_L);
		rbt2.keyRelease(KeyEvent.VK_L);
		
		rbt2.keyPress(KeyEvent.VK_O);
		rbt2.keyRelease(KeyEvent.VK_O);
		
		rbt2.keyPress(KeyEvent.VK_X);
		rbt2.keyRelease(KeyEvent.VK_X);
		
		
  	/*	rbt2.keyPress(KeyEvent.VK_DOWN);
		rbt2.keyRelease(KeyEvent.VK_DOWN);
		
		rbt2.keyPress(KeyEvent.VK_DOWN);
		rbt2.keyRelease(KeyEvent.VK_DOWN);
		
		rbt2.keyPress(KeyEvent.VK_DOWN);
		rbt2.keyRelease(KeyEvent.VK_DOWN);  */
		
		rbt2.keyPress(KeyEvent.VK_ENTER);
		rbt2.keyRelease(KeyEvent.VK_ENTER);  
		
		
    //	driver.findElement(SelectCarrier).
    	
	}
	
	public void CarrierProfileIcon()
	{
		
	}
	
}

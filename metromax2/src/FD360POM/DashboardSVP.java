package FD360POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardSVP {
	
WebDriver driver;
	
	By DashboardModule=By.xpath("//span[.='Dashboard']");
	
	By CompliantClientCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[1]");	
	By NonCompliantClientCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[2]");
	
	By CompliantDriverCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[3]");
	By NonCompliantDriverCount=By.xpath("(//h2[@class='mb-0 font-weight-medium'])[4]");
	
	By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");  
    
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
		Thread.sleep(2000);
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
	
	public void Selecting_CarrierBeta(String BetaCarrier) throws AWTException, InterruptedException 
	{
		driver.findElement(SelectCarrier).click();
		Robot robot = new Robot();

        // Wait for a moment before starting
        Thread.sleep(2000);

        String wordToType = BetaCarrier;
        
        // Iterate through each character and simulate key presses
        for (char c : wordToType.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        // Simulate pressing Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
			
    	
	}
	public void Selecting_CarrierDev(String DevCarrier) throws AWTException, InterruptedException 
	{
		driver.findElement(SelectCarrier).click();
		Robot robot = new Robot();

        // Wait for a moment before starting
        Thread.sleep(2000);

        String wordToType = DevCarrier;
        
        // Iterate through each character and simulate key presses
        for (char c : wordToType.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        // Simulate pressing Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    	
	}
	public void Selecting_CarrierProd(String ProdCarrier) throws AWTException, InterruptedException 
	{
		driver.findElement(SelectCarrier).click();
		Robot robot = new Robot();

        // Wait for a moment before starting
        Thread.sleep(2000);

        String wordToType = ProdCarrier;
        
        // Iterate through each character and simulate key presses
        for (char c : wordToType.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        // Simulate pressing Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    	
	}
	
	public void Selecting_CarrierBetaUSC(String BetaUSCCarrier) throws AWTException, InterruptedException 
	{
		driver.findElement(SelectCarrier).click();
		Robot robot = new Robot();

        // Wait for a moment before starting
        Thread.sleep(2000);

        String wordToType = BetaUSCCarrier;
        
        // Iterate through each character and simulate key presses
        for (char c : wordToType.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        // Simulate pressing Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    	
	}
	
	public void Selecting_CarrierDevUSC(String DevUSCCarrier) throws AWTException, InterruptedException 
	{
		driver.findElement(SelectCarrier).click();
		Robot robot = new Robot();

        // Wait for a moment before starting
        Thread.sleep(2000);

        String wordToType = DevUSCCarrier;
        
        // Iterate through each character and simulate key presses
        for (char c : wordToType.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }

        // Simulate pressing Enter key
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    	
	}
	
	public void Selecting_CarrierDevUSC2() throws AWTException, InterruptedException 
	{
		driver.findElement(SelectCarrier).click();
		//driver.findElement(SelectCarrier).sendKeys("AVE");
		Thread.sleep(2000);
		Robot rbt2 = new Robot();
		
		rbt2.keyPress(KeyEvent.VK_U);
		rbt2.keyRelease(KeyEvent.VK_U);
		
		rbt2.keyPress(KeyEvent.VK_S);
		rbt2.keyRelease(KeyEvent.VK_S);
		
		rbt2.keyPress(KeyEvent.VK_C);
		rbt2.keyRelease(KeyEvent.VK_C); 
		
		rbt2.keyPress(KeyEvent.VK_ENTER);
		rbt2.keyRelease(KeyEvent.VK_ENTER);  
		
		
    //	driver.findElement(SelectCarrier).
    	
	}
	
	public void logoutSVP()
	{
		driver.findElement(FleetLogout).click();
	}
	
}

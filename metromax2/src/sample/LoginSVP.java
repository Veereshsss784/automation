package sample;
import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class LoginSVP {
		
		WebDriver driver;
		
		By Title=By.xpath("//img[@src='/fleetdrivelogo1.png']");
		By Username=By.xpath("//input[@name='username_or_email']");
		By Password=By.xpath("//input[@name='password']");
		By Login=By.xpath("//button[@type='submit']");
		By ForgotPassword=By.xpath("//a[.='Forgot Password ?']");
		By DriverLoginLink=By.xpath("//a[.='Click Here']");
		
		
		public LoginSVP(WebDriver d)
		{
			driver=d;
		}
		
		@Test(priority=1)
		  public void ServiceProvider() throws AWTException, InterruptedException, EncryptedDocumentException, IOException 
			{
				String key="webdriver.chrome.driver";
				String value="./software/chromedriver.exe";
				System.setProperty(key,value);
				ChromeDriver driver =new ChromeDriver();
				driver.get("https://dev.fleetdrive360.com/login");
			}
		@Test(priority=2)
		public String printTitle()
		{
			String title1 = driver.getTitle();
			System.out.println(title1);
			String title2 = driver.findElement(Title).getText();
			System.out.println(title2);
			return title2;
		}
		//@Test(priority=3)
		public void EnterCreadentials()
		{
			driver.findElement(Username).sendKeys("oliver_1");
		
			driver.findElement(Password).sendKeys("AdhEJRXtN9");
		}
		//@Test(priority=4)
		public void clickLogin()
		{
			driver.findElement(Login).click();
		}
		
		
		
	}
	


package FD360POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginSVP {
		
		public WebDriver driver;
		
		By Title=By.xpath("//img[@src='/fleetdrivelogo1.png']");
		By Username=By.xpath("//input[@name='username_or_email']"); //input[@id='emailLogin']
		By Password=By.xpath("//input[@name='password']");
		By Login=By.xpath("//button[@type='submit']");
		By ForgotPassword=By.xpath("//a[.='Forgot Password ?']");
		By DriverLoginLink=By.xpath("//a[.='Click Here']");
		public By DriverLogout=By.xpath("//i[@class='power']");
		
		public LoginSVP(WebDriver d)
		{
			driver=d;
		}
		
		public String printTitle()
		{
			String title1 = driver.getTitle();
			System.out.println(title1);
			String title2 = driver.findElement(Title).getText();
			System.out.println(title2);
			return title2;
		}
		
		public void login(String un, String pswd)
		{
			driver.findElement(Username).sendKeys(un);
			driver.findElement(Password).sendKeys(pswd);
			driver.findElement(Login).click();
		}
		
	}
	


package sample;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import FD360POM.LoginSVP;
//import LoginAsFleetMGR.LoginAsFDMgr;

public class CrossBrowsersTesting 
{
	public WebDriver driver;
	public com.relevantcodes.extentreports.ExtentReports extent;
	public com.relevantcodes.extentreports.ExtentTest test;
	public com.relevantcodes.extentreports.ExtentTest logger;

	@BeforeTest
	public void StartReport() {
		extent = new com.relevantcodes.extentreports.ExtentReports(
				System.getProperty("user.dir") + "/test-output/FDMSignUp.html", true);
		extent.addSystemInfo("Host name", "software testing material");
		extent.addSystemInfo("Environment name", "Automation testing");
		extent.addSystemInfo("User name", "Veeresh");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}    
	
	@Test
	
	@Parameters("browser")
	
	public void verifyPageTitle(String browserName) throws InterruptedException
	{ 
		LoginSVP LoginFleet = new LoginSVP(driver);
	if(browserName.equalsIgnoreCase("firefox"))
	{
		
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");	
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dev.fleetdrive360.com/login");
		
		LoginFleet.printTitle();
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[0], passwords[0]);
        	
		String HomeTitle = driver.getTitle();
		System.out.println(HomeTitle);
		driver.quit();
		
		
		
	}
	}
	
	else if(browserName.equalsIgnoreCase("msedge"))
	{
		System.setProperty("webdriver.edge.driver", "./software/msedgedriver.exe");	
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		LoginSVP loginmgr = new LoginSVP(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dev.fleetdrive360.com/login");
		
		loginmgr.printTitle();
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[0], passwords[0]);
        	
		String HomeTitle = driver.getTitle();
		System.out.println(HomeTitle);
		driver.quit();
	}
	}
	else if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		LoginSVP loginmgr = new LoginSVP(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dev.fleetdrive360.com/login");
		
		loginmgr.printTitle();
		String[] usernames = {"oliver_1", "ellen", "nicholas_1", "am",""};
        String[] passwords = {"AdhEJRXtN9", "eJroXF8jZ0", "ye3huxjqg", "7847848330@Vs", ""};

        for (int i = 0; i < usernames.length; i++) {
        	LoginFleet.login(usernames[0], passwords[0]);
        	
		String HomeTitle = driver.getTitle();
		System.out.println(HomeTitle);
		driver.quit();
		
	}   
	}
	}
	
}


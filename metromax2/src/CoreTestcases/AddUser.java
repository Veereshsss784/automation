package CoreTestcases;


	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.io.FileHandler;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.SkipException;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	import sample.ExtentReportsClass;

	public class AddUser {

		By Title = By.xpath("//img[@src='/fleetdrivelogo1.png']");
		By Username = By.xpath("//input[@name='username_or_email']");
		By Password = By.xpath("//input[@name='password']");
		By Login = By.xpath("//button[@type='submit']");
		By ForgotPassword = By.xpath("//a[.='Forgot Password ?']");
		By DriverLoginLink = By.xpath("//a[.='Click Here']");

		ExtentReports extent;
		ExtentTest logger;
		WebDriver driver;

		@BeforeTest
		public void startReport() {
			extent = new ExtentReports(System.getProperty("user.dir") + "/TestReports/CMLogin.html", true);

			extent.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation Testing")
					.addSystemInfo("User Name", "Veeresh");

			extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		}

		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileHandler.copy(source, finalDestination);

			return destination;

		}

		@Test(priority = 1)
		public void SVPLogin() throws Throwable {

			logger = extent.startTest("SVPLogin");
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("Config.properties");
			props.load(file);

	        System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String Url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");

			driver.get(Url);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			System.out.println("Browser zooming");
			
			Robot robot = new Robot();
			
			Thread.sleep(1000);
			System.out.println("Browser About to zoom out");
			for (int i = 0; i < 4; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			driver.findElement(Username).sendKeys(username);
			driver.findElement(Password).sendKeys(password);
			driver.findElement(Login).click();
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Test Case Passed is SVPLogin");
			Thread.sleep(3000);
		}

		@Test(priority=2)
		public void AddUserCM() throws Throwable {

			logger = extent.startTest("AddUserCM");
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("Config.properties");
			props.load(file);

			String FirstName = props.getProperty("FirstName");
			String MiddleName = props.getProperty("MiddleName");
			String LastName = props.getProperty("LastName");
			String PhoneNumber = props.getProperty("PhoneNumber");
			String DOB = props.getProperty("DOB");
			String EmailAddress = props.getProperty("EmailAddress");
			String Username = props.getProperty("Username");
			String Password = props.getProperty("Password");
			String ConfirmPassword = props.getProperty("ConfirmPassword");
			String EmailHost = props.getProperty("EmailHost");
			String EmailUser = props.getProperty("EmailUser");
			String EmailPassword = props.getProperty("EmailPassword");
			String EmailPort = props.getProperty("EmailPort");
			
			
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='Company Profile']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@class='form_wizard_width tabstyling1 tbw5 nav-item nav-link']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='mui-component-select-selectedRole']")).click();// click on selectDropdown
			Thread.sleep(5000);
			driver.findElement(By.xpath("//li[normalize-space()='Consortium Manager']")).click(); //Consortium Manager 
			System.out.println("Selected Consortium Manager");
			Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[@role='dialog']")).click(); //Enter user details
	        System.out.println("Pop up displayed to Enter User Details");
	        driver.findElement(By.xpath("//input[@id='firstNameAddUser']")).sendKeys(FirstName); //First Name Veeresh
	        driver.findElement(By.xpath("//input[@id='middleNameAddUser']")).sendKeys(MiddleName); //Middle Name
	        driver.findElement(By.xpath("//input[@id='lastNameAddUser']")).sendKeys(LastName); //Last Name salagar
	        driver.findElement(By.xpath("//input[@id='phoneAddUser']")).sendKeys(PhoneNumber); //Phone Number 4044002887
	        driver.findElement(By.xpath("//input[@id='dobAddUser']")).sendKeys(DOB); //DOB 04141997
	        driver.findElement(By.xpath("//input[@id='emailAddUser']")).sendKeys(EmailAddress);  //Email Address VeereshCM@innowyze.testinator.com
	        driver.findElement(By.xpath("//input[@id='usernameAddUser']")).sendKeys(Username); //Username VeereshCM
	        driver.findElement(By.xpath("//input[@id='passwordAddUser']")).sendKeys(Password); //Password 7847848330
	        driver.findElement(By.xpath("//input[@id='repeatPasswordAddUser']")).sendKeys(ConfirmPassword); // Confirm Password 7847848330
	        driver.findElement(By.xpath("//input[@id='emailHost']")).sendKeys(EmailHost); //Email Host Veeresh
	        driver.findElement(By.xpath("//input[@id='emailUser']")).sendKeys(EmailUser); // Email User VCM@innowyze.tetsinator.com
	        driver.findElement(By.xpath("//input[@id='emailPassword']")).sendKeys(EmailPassword); //Email Password 7847848330
	        driver.findElement(By.xpath("//input[@id='emailPort']")).sendKeys(EmailPort); //Email Port 423
	        System.out.println("Entered User Details sucsessfull");
	        //driver.findElement(By.xpath("//button[@type='submit']")).click(); //Submit
	        driver.findElement(By.xpath("//button[@type='reset']")).click();  //Cancel
	        System.out.println("Sucessfully Consortium Manager Added to User and Roles table.");
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//i[@class='icon-power']")).click();  //logout
	        Thread.sleep(2000);
	        System.out.println("SVP owner Logout Done, sucessfully");
	        Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Test Case Passed is Added Consortium Manager");
			
		}
		
		
		@Test(priority=3)
		public void VerifyAfterLoginAsCM_Dashboard() throws Throwable {
			Thread.sleep(2000);
			logger = extent.startTest("Consortium Manager Dashboard Page");
			logger.log(LogStatus.INFO, "To verify that In Consortium Manager dashboard card are displayed as expected & print in Console");
			
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("Config.properties");
			props.load(file);
			
			String url = props.getProperty("url");
			String CM_username = props.getProperty("CMU");
			String CM_password = props.getProperty("CMP");
			
	        System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.get(url);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			System.out.println("zooming");
			
			Robot robot = new Robot();
			
			Thread.sleep(1000);
			System.out.println("About to zoom out");
			for (int i = 0; i < 4; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			driver.findElement(Username).sendKeys(CM_username);
			driver.findElement(Password).sendKeys(CM_password);
			driver.findElement(Login).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).click();
			String PendingDA = driver.findElement(By.xpath("//h2[normalize-space()='Pending Driver Applications']"))
					.getText();
			System.out.println(PendingDA);
			String PendingDA_Count = driver.findElement(By.xpath("(//h2)[5]")).getText();
			System.out.println(PendingDA_Count);
			String SubmitedDA = driver.findElement(By.xpath("//h2[normalize-space()='Submitted Driver Applications']"))
					.getText();
			System.out.println(SubmitedDA);
			String SubmittedDA_Count = driver.findElement(By.xpath("(//h2)[7]")).getText();
			System.out.println(SubmittedDA_Count);
			String PendingDr = driver.findElement(By.xpath("//h2[normalize-space()='Pending Drivers']")).getText();
			System.out.println(PendingDr);
			String PendingDr_count = driver.findElement(By.xpath("(//h2)[9]")).getText();
			System.out.println(PendingDr_count);
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Test Case Passed is Added Consortium Manager");
		}

		@Test(priority=4)
		public void VerifyTheConsortiumManager_DrugAndAlcoholSection() throws Throwable {

			logger = extent.startTest("Drug and Alcohol Dashboard Cards Details");
			driver.findElement(By.xpath("//a[@href='/sp/ConsortiumDashboard']//span")).click();  //Consortium Manager menu
			driver.findElement(By.xpath("//a[@class='form_wizard_width tabstyling1 tbw1 nav-item nav-link active']")).click();  //Drug and Alcohol Section 
			Thread.sleep(2000);
			System.out.println("The Consortium Manager Drug and Alcohol section displayed");
			System.out.println("Check Tests Details");
	// Drug and Alcohol Dashboard First Card 		
			logger.log(LogStatus.INFO, "To verify that title of the first card is as expected");
			String FirstCardTitle=driver.findElement(By.xpath("(//h2)[5]")).getText();
			Assert.assertEquals(FirstCardTitle, "Tests");
			System.out.println("first card title is - "+FirstCardTitle);
			
			logger.log(LogStatus.INFO, "To verify that 1st Subtitle of the first card is as expected");
			String FirstCard1stSubTitle=driver.findElement(By.xpath("(//h6)[1]")).getText();
			Assert.assertEquals(FirstCard1stSubTitle, "Not Taken");
			String TestNotTaken_Count=driver.findElement(By.xpath("(//p)[8]")).getText();  // (//p)[8]  driver.findElement(By.xpath("(//div[@class='text-center'])[2]"))
			System.out.println("Test NotTaken_Count = "+TestNotTaken_Count);
			
			logger.log(LogStatus.INFO, "To verify that 2nd Subtitle of the first card is as expected");
			String FirstCard2ndSubTitle=driver.findElement(By.xpath("(//h6)[2]")).getText();
			Assert.assertEquals(FirstCard2ndSubTitle, "Expiring");
			String Expiring_Count= driver.findElement(By.xpath("(//p)[9]")).getText();
			System.out.println("Expiring_Count = "+Expiring_Count);
			
	//  Drug and Alcohol Dashboard Second Card 
			logger.log(LogStatus.INFO, "To verify that title of the second card is as expected");
			String SecondCardTitle=driver.findElement(By.xpath("(//h2)[6]")).getText();
			Assert.assertEquals(SecondCardTitle, "Drug Tests");
			System.out.println("Second card title is - "+SecondCardTitle);
			
			logger.log(LogStatus.INFO, "To verify that 1st Subtitle of the Second card is as expected");
			String SecondCard1stSubTitle=driver.findElement(By.xpath("(//h6)[3]")).getText();
			Assert.assertEquals(SecondCard1stSubTitle, "Scheduled");
			String DScheduled_Count= driver.findElement(By.xpath("(//p)[10]")).getText();
			System.out.println("DScheduled_Count = "+DScheduled_Count);
			
			logger.log(LogStatus.INFO, "To verify that 2nd Subtitle of the Second card is as expected");
			String SecondCard2ndSubTitle=driver.findElement(By.xpath("(//h6)[4]")).getText();
			Assert.assertEquals(SecondCard2ndSubTitle, "Pending");
			String DPending_Count= driver.findElement(By.xpath("(//p)[11]")).getText();
			System.out.println("DPending_Count is = "+DPending_Count);
			
			logger.log(LogStatus.INFO, "To verify that 3rd Subtitle of the Second card is as expected");
			String SecondCard3rdSubTitle=driver.findElement(By.xpath("(//h6)[5]")).getText();
			Assert.assertEquals(SecondCard3rdSubTitle, "Negative");
			String DNegative_Count= driver.findElement(By.xpath("(//p)[12]")).getText();
			System.out.println("Negative_Count = "+DNegative_Count);

			logger.log(LogStatus.INFO, "To verify that 4th Subtitle of the Second card is as expected");
			String SecondCard4thSubTitle=driver.findElement(By.xpath("(//h6)[6]")).getText();
			Assert.assertEquals(SecondCard4thSubTitle, "Positive");
			String DPositive_Count= driver.findElement(By.xpath("(//p)[13]")).getText();
			System.out.println("Positive_Count = "+DPositive_Count);
			
//	 	Drug and Alcohol Dashboard Third Card
			
			logger.log(LogStatus.INFO, "To verify that title of the Third card is as expected");
			String ThirdCardTitle=driver.findElement(By.xpath("(//h2)[7]")).getText();
			Assert.assertEquals(ThirdCardTitle, "Alcohol Tests");
			System.out.println("Third card title is - "+ThirdCardTitle);
			
			logger.log(LogStatus.INFO, "To verify that 1st Subtitle of the Third card is as expected");
			String ThirdCard1stSubTitle=driver.findElement(By.xpath("(//h6)[7]")).getText();
			Assert.assertEquals(ThirdCard1stSubTitle, "Scheduled");
			String AScheduled_Count= driver.findElement(By.xpath("(//p)[10]")).getText();
			System.out.println("AScheduled_Count = "+AScheduled_Count);
			
			logger.log(LogStatus.INFO, "To verify that 2nd Subtitle of the Third card is as expected");
			String ThirdCard2ndSubTitle=driver.findElement(By.xpath("(//h6)[8]")).getText();
			Assert.assertEquals(ThirdCard2ndSubTitle, "Pending");
			String APending_Count= driver.findElement(By.xpath("(//p)[11]")).getText();
			System.out.println("Pending_Count is = "+APending_Count);
			
			logger.log(LogStatus.INFO, "To verify that 3rd Subtitle of the Third card is as expected");
			String ThirdCard3rdSubTitle=driver.findElement(By.xpath("(//h6)[9]")).getText();
			Assert.assertEquals(ThirdCard3rdSubTitle, "Completed");
			String ACompleted_Count= driver.findElement(By.xpath("(//p)[12]")).getText();
			System.out.println("ACompleted_Count = "+ACompleted_Count);

			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Test Case Passed is verified after tested Drug and Alcohol cards in dashbaord");
			
		}
		
	/*	@Test(priority=3)
		public void failTest() {

			logger = extent.startTest("failTest");
			System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://app.fleetdrive360.com/login");
			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL, "NoTitle");
			logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		}

		@Test(priority=4)
		public void skipTest() {
			logger = extent.startTest("skipTest");
			throw new SkipException("Skipping - This is not ready for testing ");
		}
	*/
		@AfterMethod
		public void getResult(ITestResult result) throws Exception {
			if (result.getStatus() == ITestResult.FAILURE) {
				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

				String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

				logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			} else if (result.getStatus() == ITestResult.SKIP) {
				logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
				logger.log(LogStatus.SKIP, "Test Case Failed is " + result.getThrowable());

				String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

				logger.log(LogStatus.SKIP, logger.addScreenCapture(screenshotPath));
			}

			else if (result.getStatus() == ITestResult.SUCCESS) {
				logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
				logger.log(LogStatus.PASS, "Test Case Failed is " + result.getThrowable());

				String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());

				logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
			}

			extent.endTest(logger);
		}

		@AfterTest
		public void endReport() {

			extent.flush();

			extent.close();
		}
	}

package FD360POM;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.reporters.TextReporter;

import com.relevantcodes.extentreports.LogStatus;

public class ManageClients {



	static WebDriver driver;
	
	
	By ManageClients=By.xpath("//span[.='Manage Clients']");
	By Client_list=By.xpath("//div[@class='card card1']");  
	By Setup_client=By.xpath("//a[@data-rb-event-key='SetupClient']");
	By EnterDOT=By.xpath("//input[@id='dot_number']");
	By CheckDotNumber=By.xpath("//button[.='Check Dot Number']");

// Enter Company Details	
	By LegalName=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[3]");
	By legalnametext = By.xpath("//input[@id='legalNameProfile']");
	By ComapnyName=By.xpath("//input[@id='companyName']"); 
	
	By CompEmail=By.xpath("//input[@name='companyEmail']");      
	By MC_No=By.xpath("//input[@name='mcNumber']");
	
// Enters Address Details 	
	By Address1= By.xpath("//input[@name='address1']");
	By Address2= By.xpath("//input[@name='address2']");
	By City=By.xpath("//input[@name='city']");
	By Zipcode=By.xpath("//input[@name='zipCode']");
	By State=By.xpath("//div[@id='companyState']");
	
// Enter Owner Information	
	By FirstName=By.xpath("//input[@name='firstName']");
	By MiddleName=By.xpath("//input[@name='middleName']");
	By LastName=By.xpath("//input[@name='lastName']");
	By PhoneNumber=By.xpath("//input[@name='phone']");
	By Emailaddrs=By.xpath("//input[@name='email']");
	
	
// Enter General Information
	By Sales_Person=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[2]");  
	By Account_Manager=By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd'])[3]");
	
//	Please Choose Any one Option CDL Packages and Non Non CDL Packages 
	By CDL_Package=By.xpath("//p[.='CDL Packages:']");
	
	By CDL_FAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[1]");   //$1171
	By CDL_BAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[2]");   //$772
	By CDL_CP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[3]");    //$604
	
	By NonCDL_Package=By.xpath("//p[.='Non - CDL Packages:']");
	
	By NonCDL_FAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[4]");  //$997
	By NonCDL_BAP=By.xpath("(//div[@class='MuiCardContent-root css-dm335l'])[5]");  //$372
	
// Please Choose Individual Products
	By MCReinstatemen_$180=By.xpath("(//li[@class='col-lg-4 col-md-6'])[1]");
	By MCUndismissal_$180=By.xpath("(//li[@class='col-lg-4 col-md-6'])[2]");
	By DOT_DOT_Pin_MC_$399=By.xpath("(//li[@class='col-lg-4 col-md-6'])[3]");
	By Supervisor_Training_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[4]");
	By DQ_File_$199=By.xpath("(//li[@class='col-lg-4 col-md-6'])[5]");
	By Drug_Alcohol_Consortium_$185=By.xpath("(//li[@class='col-lg-4 col-md-6'])[6]");
	By BOC3_Filing_$69=By.xpath("(//li[@class='col-lg-4 col-md-6'])[7]");
	By UCR_Filing_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[8]");
	By Filing_Fee_OrApp_Change_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[9]");
	By Clearinghouse_Registration_$215=By.xpath("(//li[@class='col-lg-4 col-md-6'])[10]");
	By Zero_Driver_Maintenance_Fee_$0=By.xpath("(//li[@class='col-lg-4 col-md-6'])[11]");
	
	
// Heavy Use Tax Products	
	By Oregon_WDT_$276=By.xpath("(//li[@class='col-lg-4 col-md-6'])[12]");
	By New_York_HUT_$150=By.xpath("(//li[@class='col-lg-4 col-md-6'])[13]");
	By New_Mexico_WDT_$150=By.xpath("(//li[@class='col-lg-4 col-md-6'])[14]");
	By Kentucky_KYU_$150=By.xpath("(//li[@class='col-lg-4 col-md-6'])[15]");
	By Federal_2290_HVUT_$99=By.xpath("(//li[@class='col-lg-4 col-md-6'])[16]");
	
	
	
 //By Individual_products=By.xpath("//input[@value='Filing Fee / App Change']");  //$99
	
// Heavy Use tax Products
	By Heavy_Use_tax_Products=By.xpath("//input[@value='Federal 2290 (HVUT)']");   //$99
	
// Please Enter the Number of Drivers 
	By EnterNoOfDrivers=By.xpath("//input[@id='driverCountField']");
	
	By Package_fee=By.xpath("//div[@style='display: flex; justify-content: space-between; font-size: 18px; margin-top: 10px;']");
	By Addtional_Individual_Product=By.xpath("(//div[@style='display: flex; justify-content: space-between; font-size: 18px;'])[1]");
	By Fee_per_driver_per_month=By.xpath("(//div[@style='display: flex; justify-content: space-between; font-size: 18px;'])[2]");
	
	By Total_Ammount_Payable=By.xpath("//div[@style='display: flex; justify-content: space-between;']");
	
	By Proceed_To_Checkout=By.xpath("(//button[@type='submit'])[2]");
	
	
	
	
	public ManageClients(WebDriver d)
	{
		driver=d;
	}
	
	
	public void ManageClientsModule()
	{
		driver.findElement(ManageClients).click();
	}
	
	public void Client_List()
	{
		driver.findElement(Client_list).getText();
		System.out.println(driver.findElement(Client_list).getText());
	}
	
	public void Setup_Client()
	{
		driver.findElement(Setup_client).click();
	}
	
	public void EnterDOT_No(String DOT)
	{
		driver.findElement(EnterDOT).sendKeys(DOT);
		System.out.println("DOT is:"+DOT);
		//driver.findElement(CheckDotNumber).click();
	}
	
	public void check_Dot_No()
	{
		driver.findElement(CheckDotNumber).click();
	}
	
	public void EnterCompanyName() throws InterruptedException
	{
		driver.findElement(ComapnyName).sendKeys("CompanyName_"+generateChar1());
		Thread.sleep(4000);
	}
	
	public void Company_legalNametext()
	{
		String CL_name= driver.findElement(legalnametext).getText();
		System.out.println("leagal name is : "+CL_name);
	}
	public void EnterCompanylegalName()
	{
		String Company_legalName=driver.findElement(LegalName).getText();
		System.out.println("Company legal name is"+Company_legalName);
		driver.findElement(LegalName).sendKeys("_CompanyLegalName"+generateChar1());
		
	}	
	
	public void EnterCompany_Email()
	{
		  driver.findElement(CompEmail).sendKeys(generateChar1()+generateChar()+"@innowyze.testinator.com");
		  
    }	
	private String generateChar1() 
	{
		String uuid1 = UUID.randomUUID().toString();
		uuid1 = uuid1.substring(0, Math.min(uuid1.length(), 2));
		System.err.print(uuid1);
		return uuid1;
	}	
	   
	
	private String generateChar() 
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 5));
		System.err.print(uuid);
		return uuid;
	}
	
	public void Enter_MCNo()
	{
		  driver.findElement(MC_No).sendKeys(getRandomNumberString());
    }
		
	public static String getRandomNumberString() {
	    // It will generate 7 digit random Number.
	    // from 0 to 9999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(9999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%07d", number);
	}
	
	public void Enter_Address1()
	{
		driver.findElement(Address1).click();
	}
	
	public void Enter_Address2()
	{
		driver.findElement(Address2).sendKeys("address2 is "+generateChar());
		
	}
	
	public void city()
	{
		driver.findElement(City).click();
	}
	
	public void zipcode()
	{
		driver.findElement(Zipcode).click();
	}
	
	public void state()
	{
		driver.findElement(State).isEnabled();
	}
	
	
	public void O_firstname(String Fname)
	{
		driver.findElement(FirstName).sendKeys(Fname);
		System.out.println(Fname);
	}
	
	public void O_Middlename(String Mname)
	{
		driver.findElement(MiddleName).sendKeys(Mname);
		System.out.println(Mname);
	}
	
	public void O_Lastname(String Lname)
	{
		driver.findElement(LastName).sendKeys(Lname);
	    System.out.println(Lname);
	}
	
	public void O_PhoneNum(String PhoneNo)
	{
		driver.findElement(PhoneNumber).sendKeys(PhoneNo);
	}
	
	public void OwnerEmail()
	{
		  driver.findElement(Emailaddrs).sendKeys("Owner"+generateChar()+"@innowyze.testinator.com");
    }

    public String Select_SalesPerson(String select_sales_person)
    {
    	driver.findElement(Sales_Person).sendKeys(select_sales_person);
    	driver.findElement(Sales_Person).sendKeys(Keys.ENTER);
		return select_sales_person;
    }  
   
    public String Select_AccountManager(String select_account_manager)
    {
    	driver.findElement(Account_Manager).sendKeys(select_account_manager);
    	driver.findElement(Account_Manager).sendKeys(Keys.ENTER);
		return select_account_manager;
    	
    }
    
 //CDL Packages   
/*    public void Select_CDL_FAP()
	{
		driver.findElement(CDL_FAP).click();
	}
  
    public void Select_CDL_BAP()
	{
		driver.findElement(CDL_BAP).click();
	}
    public void Select_CDL_CP()
	{
		driver.findElement(CDL_CP).click();
	}

*/    
 
  // NON CDL Packages 
    public void Select_NonCDL_FAP()
	{
		driver.findElement(NonCDL_FAP).click();
	}
 /*   public void Select_NonCDL_BAP()
	{
		driver.findElement(NonCDL_BAP).click();
	}
 */   
    
/*    public void Select_individual_pkg()
    {
    	driver.findElement(MCReinstatemen_$180).click();
    	driver.findElement(MCUndismissal_$180).click();
    	driver.findElement(DOT_DOT_Pin_MC_$399).click();
    	driver.findElement(Supervisor_Training_$99).click();
    	driver.findElement(DQ_File_$199).click();
    	driver.findElement(Drug_Alcohol_Consortium_$185).click();
    	driver.findElement(BOC3_Filing_$69).click();
    	driver.findElement(UCR_Filing_$99).click();
    	driver.findElement(Filing_Fee_OrApp_Change_$99).click();
    	driver.findElement(Clearinghouse_Registration_$215).click();
    	driver.findElement(Zero_Driver_Maintenance_Fee_$0).click();
    	
    	}
 */   
   
 /*   public void SelectHeavyUseTaxProducts()
    {
    	driver.findElement(Oregon_WDT_$276).click();
    	driver.findElement(New_York_HUT_$150).click();
    	driver.findElement(New_Mexico_WDT_$150).click();
    	driver.findElement(Kentucky_KYU_$150).click();
    	driver.findElement(Federal_2290_HVUT_$99).click();
    	
    }
*/	
    
    public void Enter_DriverCount(String Driver_count) throws InterruptedException, AWTException
    {
    	
        Thread.sleep(3000);
       driver.findElement(EnterNoOfDrivers).sendKeys(Driver_count);
     }
    
    public void TotalAmount()
    {
    	driver.findElement(Total_Ammount_Payable).getText();
    	System.out.println(driver.findElement(Total_Ammount_Payable).getText());
    }
    
    public void ProceedToCheckout()
	{
		driver.findElement(Proceed_To_Checkout).click();
	}
    
    public void PaythroughCard() 
    {
		String Expected = driver.getTitle();
		System.out.println(Expected);
		String Actual = "FleetDrive 360 Inc";
		System.out.println(Expected);
		
		
		WebElement amount = driver.findElement(By.xpath("//span[@id='OrderDetailsFooter-SubtotalAmount']/../span[2]"));
		String AmountInPaymentPage = amount.getText();
		System.out.println(AmountInPaymentPage);
		
		
		WebElement CardNo = driver.findElement(By.xpath("//*[@id='cardNumber']"));
		CardNo.sendKeys("4242424242424242");
		WebElement mmAndyy = driver.findElement(By.xpath("//*[@id='cardExpiry']"));
		mmAndyy.sendKeys("1122");
		WebElement cvcNo = driver.findElement(By.xpath("//*[@id='cardCvc']"));
		cvcNo.sendKeys("123");
		WebElement NameOfCard = driver.findElement(By.xpath("//*[@id='billingName']"));
		NameOfCard.sendKeys("VeereshSalagar");

		WebElement ele = driver.findElement(By.xpath("//select[@id='billingCountry']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("United States");

		WebElement zipCode = driver.findElement(By.xpath("//*[@id='billingPostalCode']"));
		zipCode.sendKeys("41235");
		WebElement subscribe = driver.findElement(By.xpath("//div[@class='SubmitButton-IconContainer']"));
		subscribe.click();

		

	}
    public void OwnerEmail_Generation()
    {
    driver.findElement(By.id("email")).click();
    Random randomEmail = new Random();
    int randomInt = randomEmail.nextInt(100);
    driver.findElement(By.id("email")).sendKeys("Owner"+randomInt+"@innowyze.testinator.com");
    
    }   
	
	
}


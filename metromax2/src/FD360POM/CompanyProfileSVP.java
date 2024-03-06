package FD360POM;

import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyProfileSVP {

	WebDriver driver;
	
	public By CompanyProfileModule_svp=By.xpath("//span[.='Company Profile']");
	public By Company_info=By.xpath("//div[@class='row clearfix']");
	
	public By Address_info1=By.xpath("(//div[@class='row clearfix'])[2]");
	public By Address_info2=By.xpath("//input[@id='cityProfile']");
	public By Address_info3=By.xpath("//input[@id='zipCodeProfile']");
	public By Address_info4=By.xpath("//input[@id='faxProfile']");
	public By Address_info5=By.xpath("//div[@id='unitAddVehicle']");
	public By UsersAndRoles=By.xpath("//i[@class='fa fa5 fa-user-plus']");
	public By UsersAndRolesRecord=By.xpath("//div[@id='sp-usertable']");
	
	public By AddUser=By.xpath("//button[.='Add User']");
	
	public By Select_User=By.xpath("//div[@id='mui-component-select-selectedRole']");
	
	public By Admin=By.xpath("//li[.='Admin']");
	
	public By Admin_FN=By.xpath("//input[@id='firstNameAddUser']");
	public By Admin_MN=By.xpath("//input[@id='middleNameAddUser']");
	public By Admin_LN=By.xpath("//input[@id='lastNameAddUser']");
	public By Phone_No=By.xpath("//input[@id='phoneAddUser']");
	public By Admin_DOB=By.xpath("//input[@id='dobAddUser']");
	public By Admin_Email=By.xpath("//input[@id='emailAddUser']");
	public By Admin_UN=By.xpath("//input[@id='usernameAddUser']");
	public By Admin_Pwd=By.xpath("//input[@id='passwordAddUser']");
	public By Admin_ConfirmPwd=By.xpath("//input[@id='repeatPasswordAddUser']");
	public By AdminPwd_see=By.xpath("//button[@value='isPasswordShown']");
	public By Admin_AddUser=By.xpath("//button[.='Add User']");
	public By Admin_Cancel=By.xpath("//button[@type='reset']");
    
    
	public By Account_mngr=By.xpath("//li[.='Account Manager']");
   
	public By Email_Host=By.xpath("//input[@id='emailHost']");
	public By Email_User=By.xpath("//input[@id='emailUser']");
	public By Email_Password=By.xpath("//input[@id='emailPassword']");
	public By Email_Port=By.xpath("//input[@id='emailPort']");
	public By Use_SSL=By.xpath("//input[@value='usessl']");
  
  
  
  
    
    
	

	public By Sales_Person=By.xpath("//li[.='Agent/Sales Person']");
	
	
	public CompanyProfileSVP(WebDriver d)
	{
		driver=d;
	}
	
	public void CompanyProfilesvp()
	{
		driver.findElement(CompanyProfileModule_svp).click();
		
		driver.findElement(Company_info).getText();
		System.out.println(driver.findElement(Company_info).getText());
		driver.findElement(Address_info1).getText();
		System.out.println(driver.findElement(Address_info1).getText());
		
		driver.findElement(Address_info2).getText();
		System.out.println(driver.findElement(Address_info2).getText());
		driver.findElement(Address_info3).getText();
		System.out.println(driver.findElement(Address_info3).getText());
		driver.findElement(Address_info4).getText();
		System.out.println(driver.findElement(Address_info4).getText());
		driver.findElement(Address_info5).getText();
		System.out.println(driver.findElement(Address_info5).getText());
		
		driver.findElement(UsersAndRoles).click();
		driver.findElement(UsersAndRolesRecord).getText();
		System.out.println(driver.findElement(UsersAndRolesRecord).getText());
		
	}
	
	public void SelectUser()
	{
		driver.findElement(AddUser).click();
		driver.findElement(Select_User).click();
	//	driver.findElement(Admin).click();
	//	driver.findElement(Account_mngr).click();
	//	driver.findElement(Sales_Person).click();
	
	}

// Add_Admin_User	
	public void Admin_pesonal_Details()
	{
		driver.findElement(Admin_FN).sendKeys("Veeresh_A"+RandomChar2());
		driver.findElement(Admin_MN).sendKeys(AddDetalis_2());
		driver.findElement(Admin_LN).sendKeys("sal"+AddingDetails());
		driver.findElement(Phone_No).sendKeys("404"+PhoneNo());
	}
	
	public String Admin_DOB(String DOB)
	{
		driver.findElement(Admin_DOB).click();
		driver.findElement(Admin_DOB).sendKeys(DOB);
		return DOB;
	}
	
	public void Admin_Email()
	{
		driver.findElement(Admin_Email).sendKeys("Admin_"+AddingDetails()+"@innowyze.testinator.com");
	}
	
	public String Admin_Username(String UN)
	{
		driver.findElement(Admin_UN).sendKeys(UN);
		return UN;
	}
	
	public String Admin_Password(String PWD) 
	{
		driver.findElement(Admin_Pwd).sendKeys(PWD);
		return PWD;
	}
	public String Admin_Confirm_Password(String Confirm_PWD)
	{
		driver.findElement(Admin_ConfirmPwd).sendKeys(Confirm_PWD);
		return Confirm_PWD;
	}
	
	public void See_Admin_PWD()
	{
		driver.findElement(AdminPwd_see).click();
	}
	
	public void Add_AdminUser()
	{
		driver.findElement(Admin_AddUser).click();
	}
	public void Admin_Cancel()
	{
		//	driver.findElement(Admin_Cancel).click();
	}  
	
      
// Add_Account_Manager_User	
	
	public void AccountMgr_pesonal_Details()
	{
		driver.findElement(Admin_FN).sendKeys("Veeresh_A"+RandomChar2());
		driver.findElement(Admin_MN).sendKeys(AddDetalis_2());
		driver.findElement(Admin_LN).sendKeys("sal"+AddingDetails());
		driver.findElement(Phone_No).sendKeys("404"+PhoneNo());
	}
	
	public String AccountMgr_DOB(String DOB)
	{
		driver.findElement(Admin_DOB).click();
		driver.findElement(Admin_DOB).sendKeys(DOB);
		return DOB;
	}
	
	public void AccountMgr_Email()
	{
		driver.findElement(Admin_Email).sendKeys("AccountMgr_"+AddingDetails()+"@innowyze.testinator.com");
	}
	
	public String AccountMgr_Username(String UN)
	{
		driver.findElement(Admin_UN).sendKeys(UN);
		return UN;
	}
	
	public String AccountMgr_Password(String PWD) 
	{
		driver.findElement(Admin_Pwd).sendKeys(PWD);
		return PWD;
	}
	public String AccountMgr_Confirm_Password(String Confirm_PWD)
	{
		driver.findElement(Admin_ConfirmPwd).sendKeys(Confirm_PWD);
		return Confirm_PWD;
	}
	
	public void See_AccountMgr_PWD()
	{
		driver.findElement(AdminPwd_see).click();
	}
	
	//Add Email configuration Details
	
	public String AccountMgr_EmailHost(String AM_EmailHost)
	{
		driver.findElement(Email_Host).sendKeys(AM_EmailHost);
		return AM_EmailHost;
	}
	
	public String AccountMgr_EmailUser(String AM_EmailUser)
	{
		driver.findElement(Email_User).sendKeys(AM_EmailUser);
		return AM_EmailUser;
	}
	
	public String AccountMgr_EmailPassword(String AM_EmailPwd)
	{
		driver.findElement(Email_Password).sendKeys(AM_EmailPwd);
		return AM_EmailPwd;
	}
	
	public String AccountMgr_EmailPort(String AM_EmailPort)
	{
		driver.findElement(Email_Port).sendKeys(AM_EmailPort);
		return AM_EmailPort;
	}
	
	public void Add_AccountMgrUseSSL()
	{
		driver.findElement(Use_SSL).click();
	}
	
	
	public void Add_AccountMgrUser()
	{
		driver.findElement(Admin_AddUser).click();
	}
	public void AccountMgr_Cancel()
	{
		//	driver.findElement(Admin_Cancel).click();
	} 
	

// Add_Sales_Person_User	
	
		public void Sales_Person_pesonal_Details()
		{
			driver.findElement(Admin_FN).sendKeys("Veeresh_A"+RandomChar2());
			driver.findElement(Admin_MN).sendKeys(AddDetalis_2());
			driver.findElement(Admin_LN).sendKeys("sal"+AddingDetails());
			driver.findElement(Phone_No).sendKeys("404"+PhoneNo());
		}
		
		public String Sales_Person_DOB(String DOB)
		{
			driver.findElement(Admin_DOB).click();
			driver.findElement(Admin_DOB).sendKeys(DOB);
			return DOB;
		}
		
		public void Sales_Person_Email()
		{
			driver.findElement(Admin_Email).sendKeys("Sales_Person_"+AddingDetails()+"@innowyze.testinator.com");
		}
		
		public String Sales_Person_Username(String UN)
		{
			driver.findElement(Admin_UN).sendKeys(UN);
			return UN;
		}
		
		public String Sales_Person_Password(String PWD) 
		{
			driver.findElement(Admin_Pwd).sendKeys(PWD);
			return PWD;
		}
		public String Sales_Person_Confirm_Password(String Confirm_PWD)
		{
			driver.findElement(Admin_ConfirmPwd).sendKeys(Confirm_PWD);
			return Confirm_PWD;
		}
		
		public void See_Sales_Person_PWD()
		{
			driver.findElement(AdminPwd_see).click();
		}
		
		
		public void Add_Sales_PersonUser()
		{
		    	driver.findElement(Admin_AddUser).click();
		}
		public void Sales_Person_Cancel()
		{
			//	driver.findElement(Admin_Cancel).click();
		}
	
	
	
		
	private String AddingDetails() 
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 5));
		System.err.print(uuid);
		return uuid;
	}
	
	private String AddDetalis_2() 
	{
		String uuid1 = UUID.randomUUID().toString();
		uuid1 = uuid1.substring(0, Math.min(uuid1.length(), 2));
		System.err.print(uuid1);
		return uuid1;
	}
	
	public static String PhoneNo() 
	{
	    // It will generate 7 digit random Number.
	    // from 0 to 9999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(9999999);

	    // this will convert any number sequence into 7 character.
	    return String.format("%07d", number);
	}
	
	public static String DOB() 
	{
	    // It will generate 8 digit random Number.
	    // from 0 to 9999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(00002121);

	    // this will convert any number sequence into 7 character.
	    return String.format("%08d", number);
	}
	
	private String RandomChar2() 
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 2));
		System.err.print(uuid);
		return uuid;
	}  
	
	
}  

package FD360POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriversAndDQ {

	WebDriver driver;
	
	By Overview=By.xpath("//a[@class='form_wizard_tab form_wizard_width1 tabstyling1 nav-item nav-link']");
	By ManageDrivers=By.xpath("(//a[@class='form_wizard_tab form_wizard_width1 tabstyling1 nav-item nav-link'])[1]");
	By HosViolations=By.xpath("(//a[@class='form_wizard_tab form_wizard_width1 tabstyling1 nav-item nav-link'])[2]");
	By InviteNewDrivers=By.xpath("(//a[@class='form_wizard_tab form_wizard_width1 tabstyling1 nav-item nav-link'])[3]");
	By DriverApplications=By.xpath("(//a[@class='form_wizard_tab form_wizard_width1 tabstyling1 nav-item nav-link'])[4]");
	
	By driverApplicationsListHeader=By.xpath("(//tr[@class='MuiTableRow-root MuiTableRow-head'])[7]");
	By driverApplicationList=By.xpath("(//tr[@class='MuiTableRow-root'])[24]");
	By downloadDLFront=By.xpath("(//button[.='Download'])[1]");
	By driverDLBack=By.xpath("(//button[.='Download'])[2]");
	By medicalCertificate=By.xpath("(//button[.='Download'])[3]");
	
	By viewAppliaction=By.xpath("//button[@style='background-color: blue; color: white; border-radius: 20px; border-color: transparent; font-size: 0.65rem; white-space: nowrap;']");
	By viewAppDetails=By.xpath("//div[@id='formPrint']");
	
	By approveApplication=By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit'])[7]");
	   By DrugAndAlcoholTestRequiredYes=By.xpath("//input[@name='isTestRequired']");
	   By ComercialDLRequiredYes= By.xpath("//input[@name='hasCommercialDriver']");
	   By chargesOnDrugAlcoholTestCombo=By.xpath("//input[@name='Drug & Alcohol Test Combo']");
	   By nearestZipcodeOfDriver=By.xpath("//input[@name='zipcode']");
	By rejectApplication=By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit'])[8]");
	By resubmitApplication=By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit'])[9]");
	
	
    By status=By.xpath("(//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input'])[2]");
	By toApproved=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[1]");
	By toIncomplete=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[2]");
	By toSubmitted=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[3]");
	By toRejected=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[4]");
	By toCompleted=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[5]");

	
	
	
	public DriversAndDQ(WebDriver d)
	{
		driver=d;
	}
	
	public void DriverApplications()
	{
		driver.findElement(DriverApplications).click();
	}
	
	public void DriverApplicationsListHeader()
	{
		String DriversListHeader = driver.findElement(driverApplicationsListHeader).getText();
		System.out.println(DriversListHeader);
	}
	
	public void DriverApplicationList()
	{
		String DriversList=driver.findElement(driverApplicationList).getText();
		System.out.println(DriversList);
	}
	
	public void DriverDLFront()
	{
		driver.findElement(downloadDLFront).click();
	}
	
	public void DriverDLBack()
	{
		driver.findElement(driverDLBack).click();
	}
	
	public void MedicalCertifacate()
	{
		driver.findElement(medicalCertificate).click();
	}
	
	public void ViewApplication()
	{
		driver.findElement(viewAppliaction).click();
	}
	public void ViewAppDetailstext()
	{
		String viewAppText = driver.findElement(viewAppDetails).getText();
		System.out.println(viewAppText);
	}
	
	public void ChangeStatus()
	{
		driver.findElement(status).click();
	}
	
	public void ToApproved()
	{
		driver.findElement(toApproved).click();
	}
	public void ToIncomplete()
	{
		driver.findElement(toIncomplete).click();
	}
	public void ToSubmitted()
	{
		driver.findElement(toSubmitted).click();
	}
	public void ToRejected()
	{
		driver.findElement(toRejected).click();
	}
	public void ToCompleted()
	{
		driver.findElement(toCompleted).click();
	}
	
	public void ApproveApplication()
	{
		boolean displayed = driver.findElement(approveApplication).isDisplayed();
		System.out.println(displayed);
		driver.findElement(approveApplication).click();
	}
	
	public void DrugAndAlcoholTestRequiredYes()
	{
		driver.findElement(DrugAndAlcoholTestRequiredYes).click();
	}
	public void ChargesOnDrugAlcoholTestCombo()
	{
		driver.findElement(chargesOnDrugAlcoholTestCombo).click();
	}
	public void NearestZipcodeOfDriver(String Zipcode)
	{
		driver.findElement(nearestZipcodeOfDriver).sendKeys(Zipcode);
	}
}

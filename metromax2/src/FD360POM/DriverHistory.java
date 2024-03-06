package FD360POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverHistory {

	WebDriver driver;
	
	By privousEmployerEnquiry=By.xpath("(//a[@class='form_wizard_width tabstyling1 tbw1 nav-item nav-link'])[1]");
	By ManageMVR=By.xpath("(//a[@class='form_wizard_width tabstyling1 tbw1 nav-item nav-link'])[2]");
	By ManageMedical=By.xpath("(//a[@class='form_wizard_width tabstyling1 tbw1 nav-item nav-link'])[3]");
	
	By EmployerList=By.xpath("(//tr[@class='MuiTableRow-root'])[2]");
	
	By EmpRecListHeader=By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head']");
	By FullEmpList=By.xpath("//table[@class='MuiTable-root']");
	
	By preEmprStaus=By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']");
	By toFailed=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[1]");
	By toPending=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[2]");
	By toCompleted=By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[3]");
	
	By viewEmpRec=By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit']");
	
	public DriverHistory(WebDriver d)
	{
		driver=d;
	}
	
	public void clickPreviousEmployerInquiry()
	{
		driver.findElement(privousEmployerEnquiry).click();
	}
	
	public void showEmployerList()
	{
		String EmployerDetails = driver.findElement(EmployerList).getText();
		System.out.println(EmployerDetails);
	}
	
	public void allEmpRecords()
	{
		String allEmpRec = driver.findElement(FullEmpList).getText();
		System.out.println(allEmpRec);
	}
	
	public void EyeviewEmpRecord() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(viewEmpRec).click();
		Thread.sleep(2000);
	}
	
	public void empRecListHeader()
	{
		String EmpRecHeader = driver.findElement(EmpRecListHeader).getText();
		System.out.println(EmpRecHeader);
	}
	
	public void PreviousEmprStatus()
	{
		driver.findElement(preEmprStaus).click();
	}
	public void ToFailed()
	{
		driver.findElement(toFailed).click();
	}
	public void ToPending()
	{
		driver.findElement(toPending).click();
	}
	public void ToCompleted()
	{
		driver.findElement(toCompleted).click();
	}
	
	
}

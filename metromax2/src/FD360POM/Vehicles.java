package FD360POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Vehicles {
	WebDriver driver;
	By VehiclesMenu=By.xpath("//span[normalize-space()='Vehicles']");
	By ManageVehicleSec=By.xpath("//a[@data-rb-event-key='VehicleManage']");
	By AddVehicle=By.xpath("//a[@data-rb-event-key='VehicleManage']");
	By BulkUploadV=By.xpath("//a[@data-rb-event-key='VehicleManage']");
	By VehicleListPDF=By.xpath("(//i)[27]");
	By VehicleListExcel=By.xpath("(//i)[28]");
	By SearchVehicle=By.xpath("//input[@placeholder='Search']");
	By SelectRow=By.xpath("(//div[@id='mui-65251'])[1]");
	By SelectRow10=By.xpath("(//li[normalize-space()='10'])[1]");
	By SelectRow20=By.xpath("(//li[normalize-space()='20'])[1]");
	

	By Vin = By.xpath("//input[@id='vinAddVehicle']");
	By Unit = By.xpath("//div[@id='unitAddVehicle']");
	By SelectUnitType = By.xpath("//li[normalize-space()='Truck']");
	By UnitNum = By.xpath("//input[@id='unitNumber']");
	By Make = By.xpath("//input[@id='makeAddVehicle']");
	By Model = By.xpath("//input[@id='modelAddVehicle']");
	By ClickState = By.xpath("//div[@id='plateState']");
	By SelectState = By.xpath("//li[normalize-space()='California']");
	By PlateNum = By.xpath("//input[@id='plateNumberAddVehicle']");
	By TireSize = By.xpath("//input[@id='tyreSizeAddVehicle']");
	By Year = By.xpath("//input[@id='yearAddVehicle']");
	By Owner = By.xpath("//input[@value='O']");
	By AddRegForm = By.xpath("//button[normalize-space()='Add Registration Form']");
	By RegNum = By.xpath("//input[@id='registrationNumberAddVehicle']");
	By RegIssueDate = By.xpath("//input[@id='registrationDateAddVehicle']");
	By RegExpDate = By.xpath("//input[@id='registrationExpiryDateAddVehicle']");
	By UploadRegDoc = By.xpath("//input[@id='registrationDocumentAddVehicle']");
	By AddInspection = By.xpath("//button[normalize-space()='Add New Inspection']");
	By InspNum = By.xpath("//input[@id='inspectionNumberAddVehicle']");
	By InspIssueDate = By.xpath("//input[@id='inspectionDateAddVehicle']");
	By InspExpDate = By.xpath("//input[@id='inspectionExpiryDateAddVehicle']");
	By UploadInspDoc = By.xpath("//input[@id='inspectionDocumentAddVehicle']");
	By Submit = By.xpath("//button[normalize-space()='Submit']");
	By ClosePage=By.xpath("(//button[@type='button'])[7]");
	
	By Maintain_Vehicle=By.xpath("//a[@data-rb-event-key='vehicleMaintain']");
	By AddWorkOrder=By.xpath("//button[normalize-space()='Add Work Order']");
	By SearchWorkOrder=By.xpath("//input[@placeholder='Search']");
	By WorkOrderPDF=By.xpath("(//i)[27]");
	By WorkOrderExcel=By.xpath("(//i)[28]");
	By SelectOtherRow=By.xpath("//div[contains(text(),'5 rows')]");
	By WORow10=By.xpath("(//li[normalize-space()='10'])[1]");
	By WORow20=By.xpath("(//li[normalize-space()='20'])[1]");
	
	

	public void LocateVehicleMenu()
	{
		driver.findElement(VehiclesMenu).click();
	}
	public void NavigateManageVehiclesSection()
	{
		driver.findElement(ManageVehicleSec).click();
	}
	public void ClickAddVehicleButton()
	{
		driver.findElement(AddVehicle).click();
	}
	public void AddNewVehicleDetails() throws Throwable
	{
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(".properties");
		props.load(file);
		        String Vin=props.getProperty("Vin");
				String UnitNum=props.getProperty("UnitNum");
				String Make=props.getProperty("Make");
				String Model =props.getProperty("Model");
				String PlateNum =props.getProperty("PlateNum");
				String TireSize =props.getProperty("TireSize");
				String Year=props.getProperty("Year");
		
				String RegNum=props.getProperty("RegNum");
				String UploadRegDoc =props.getProperty("UploadRegDoc");
		
				String InspNum =props.getProperty("InspNum");
				String UploadInspDoc =props.getProperty("UploadInspDoc");
			
				
	}
	
}
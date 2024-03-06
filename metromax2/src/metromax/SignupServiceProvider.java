package metromax;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SignupServiceProvider {
	public WebDriver driver;

	@SuppressWarnings("unused")
	@Test(priority = 1)
	public void Opned_FleetDrive_360_Administration_clicked_OnboardSP_TC1() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://beta-api.fleetsmartcarrierservices.com/admin");

		WebElement un = driver.findElement(By.xpath("//input[@name='username']"));
		un.sendKeys("admin");
		WebElement pswd = driver.findElement(By.xpath("//input[@name='password']"));
		pswd.sendKeys("Innowyze123");
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();

		WebElement OnboardSP = driver.findElement(By.xpath("//a[.='Onboard SP']"));
		OnboardSP.click();
	}

	@Test(priority = 2)
	public void Opned_Django_administration_HomePage_FilledForm_TC2() {
		try {
			WebElement fn = driver.findElement(By.xpath("//input[@name='first_name']"));
			fn.sendKeys("Veeresh");
			WebElement mn = driver.findElement(By.xpath("//input[@name='middle_name']"));
			mn.sendKeys("A");
			WebElement ln = driver.findElement(By.xpath("//input[@name='last_name']"));
			ln.sendKeys("Salagar");
			WebElement No = driver.findElement(By.xpath("//input[@name='phone']"));
			No.sendKeys("+17847848330");
			WebElement email = driver.findElement(By.xpath("//input[@name='user_email']"));
			email.sendKeys(generateChar() + "@gmail.com");

			WebElement SPRegEmail = driver.findElement(By.xpath("//input[@name='email']"));
			SPRegEmail.sendKeys(generateChar() + "@gmail.com");
			WebElement SPname = driver.findElement(By.xpath("//input[@name='name']"));
			SPname.sendKeys(generateChar());
			WebElement SPLname = driver.findElement(By.xpath("//input[@name='legal_name']"));
			SPLname.sendKeys("AnandMetromax");
			WebElement SPdoi = driver.findElement(By.xpath("//input[@name='incorporation_date']"));
			SPdoi.sendKeys("07/04/2022");

			WebElement ele = driver.findElement(By.xpath("//select[@name='address_type']"));
			Select sel = new Select(ele);
			sel.selectByValue("B");
			List<WebElement> options = sel.getOptions();
			for (WebElement opt : options) {
				String text = opt.getText();
				System.out.println(text);

				WebElement addrs1 = driver.findElement(By.xpath("//input[@name='address_1']"));
				addrs1.sendKeys("chincholi H tq kalgi dist kalaburagi");
				WebElement addrs2 = driver.findElement(By.xpath("//input[@name='address_2']"));
				addrs2.sendKeys("chincholi H tq kalgi dist kalaburagi");
				WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
				city.sendKeys("kalaburgi");
				WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
				state.sendKeys("karnataka");
				WebElement zip = driver.findElement(By.xpath("//input[@name='zip_code']"));
				zip.sendKeys("58531");
				WebElement country = driver.findElement(By.xpath("//input[@name='country']"));
				country.sendKeys("india");
				WebElement faxNo = driver.findElement(By.xpath("//input[@name='fax']"));
				faxNo.sendKeys("+12125552368");
				WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
				submit.click();
			}
		}

		catch (StaleElementReferenceException e) {
			Reporter.log("Successfully handled StaleElementReferenceException");

		}

	}

	@Test(priority = 3)
	public void Submited_the_Form_TC3() {
		WebElement submit = driver.findElement(By.xpath("//input[@id='submit-sp-products-form']"));
		submit.click();
	}

	//@Test(priority = 4)
	public void Confirm_the_submition_TC4() {
		String text = driver.findElement(By.xpath("//li[.='Service provider has been created successfully']"))
				.getText();
		Reporter.log(text);
		System.out.println(text);
	}

	private String generateChar() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 10));
		System.err.print(uuid);
		return uuid;
	}

}


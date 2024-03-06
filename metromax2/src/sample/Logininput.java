package sample;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import FD360POM.LoginSVP;

public class Logininput {

	public static void main(String[] args) throws Exception {
        // Set the path to your ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        LoginSVP LoginFleet=new LoginSVP(driver);
        
        driver.get("https://compliance.fleetsmartcarrierservices.com/login");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login Page Opened successfully");

        // Get user input for a search query
        

        // Navigate to the desired website
        driver.get("https://compliance.fleetsmartcarrierservices.com/login");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String Enter_input = scanner.nextLine();
        System.out.print("Enter a password: ");
        String Enter_input2 = scanner.nextLine();
        

        // Find the search input field and enter the user's query
        WebElement username = driver.findElement(By.xpath("//input[@name='username_or_email']"));
        
        username.sendKeys(Enter_input);

        // Find and click the search button
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        
        password.sendKeys(Enter_input2);

        // Wait for search results (add explicit waits here if needed)

        // Perform other automation actions based on search results

        // Close the browser
        

        // Close the scanner
        scanner.close();
}
}

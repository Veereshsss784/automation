package sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ChromeZoomInZoomOut {
		@Test
		
		public void googleSearchTest() throws AWTException, InterruptedException{
		
			String key="webdriver.chrome.driver";
			String value="./software/chromedriver.exe";
			System.setProperty(key,value);
			ChromeDriver driver =new ChromeDriver();
            
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			System.out.println("zooming");
			
			Robot robot = new Robot();
		/*	System.out.println("About to zoom in");
			for (int i = 0; i < 3; i++) {			
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ADD);
				robot.keyRelease(KeyEvent.VK_ADD);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}  */
			
			Thread.sleep(2000);
			System.out.println("About to zoom out");
			for (int i = 0; i < 4; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			
			driver.close();
		}
	}


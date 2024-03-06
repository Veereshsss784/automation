package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FD360POM.DashboardSVP;
import FD360POM.LoginSVP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_Parallel {

	WebDriver driver;
	
	By Title=By.xpath("//img[@src='/fleetdrivelogo1.png']");
	static By Username=By.xpath("//input[@name='username_or_email']");
	static By Password=By.xpath("//input[@name='password']");
	static By Login=By.xpath("//button[@type='submit']");
	static By SelectCarrier=By.xpath("//div[@class='MuiFormControl-root']");
	

	public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");

        // Create a thread pool with three threads (to open three tabs)
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            int tabNumber = i;
            executorService.execute(() -> {
                WebDriver driver = new ChromeDriver();
                DashboardSVP SVPDB=new DashboardSVP(driver);
                // Perform actions in the corresponding tab
                switch (tabNumber) {
                    case 1:
                        driver.get("https://dev.fleetdrive360.com/login");
                        
                        driver.findElement(Username).sendKeys("oliver_1");
            			driver.findElement(Password).sendKeys("AdhEJRXtN9");
            			driver.findElement(Login).click();
            			
            			
            			
					Robot robot;
					try {
						
						Thread.sleep(3000);
						driver.findElement(SelectCarrier).click();
						robot = new Robot();
						Thread.sleep(6000);
						String wordToType = "LOX";
						Thread.sleep(6000);
            	        // Iterate through each character and simulate key presses
            	        for (char c : wordToType.toCharArray()) {
            	            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            	            robot.keyPress(keyCode);
            	            robot.keyRelease(keyCode);
            	        }

            	        // Simulate pressing Enter key
            	        robot.keyPress(KeyEvent.VK_ENTER);
            	        robot.keyRelease(KeyEvent.VK_ENTER);
            	        
            	        robot.keyPress(KeyEvent.VK_ENTER);
            	        robot.keyRelease(KeyEvent.VK_ENTER);
            	        
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

            	        // Wait for a moment before startin

            	        
                
            			
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                
                        break;
                        
                    case 2:
                    	driver.get("https://compliance.fleetsmartcarrierservices.com/login");
                    	
                        driver.findElement(Username).sendKeys("ellen");
                		
            			driver.findElement(Password).sendKeys("eJroXF8jZ0");
            			
            			driver.findElement(Login).click();
            			
            			Robot robot2;
    					try {
    						
    						Thread.sleep(3000);
    						driver.findElement(SelectCarrier).click();
    						robot2 = new Robot();
    						Thread.sleep(6000);
    						String wordToType = "Rock";
    						Thread.sleep(6000);
                	        // Iterate through each character and simulate key presses
                	        for (char c : wordToType.toCharArray()) {
                	            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                	            robot2.keyPress(keyCode);
                	            robot2.keyRelease(keyCode);
                	        }

                	        // Simulate pressing Enter key
                	        robot2.keyPress(KeyEvent.VK_ENTER);
                	        robot2.keyRelease(KeyEvent.VK_ENTER);
                	        
                	        
    					} catch (AWTException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					} catch (Exception e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}

                	        // Wait for a moment before startin

                	        
                    
                			
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    
                            break;
                    case 3:
                        driver.get("https://app.fleetdrive360.com/login");
                        
                        driver.findElement(Username).sendKeys("nicholas_1");
                		
            			driver.findElement(Password).sendKeys("ye3huxjqg");
            			
            			driver.findElement(Login).click();
                        
            			Robot robot3;
    					try {
    						
    						Thread.sleep(3000);
    						driver.findElement(SelectCarrier).click();
    						robot3 = new Robot();
    						Thread.sleep(6000);
    						String wordToType = "Nic";
    						Thread.sleep(6000);
                	        // Iterate through each character and simulate key presses
                	        for (char c : wordToType.toCharArray()) {
                	            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                	            robot3.keyPress(keyCode);
                	            robot3.keyRelease(keyCode);
                	        }

                	        // Simulate pressing Enter key
                	        robot3.keyPress(KeyEvent.VK_ENTER);
                	        robot3.keyRelease(KeyEvent.VK_ENTER);
                	        
                	        
    					} catch (AWTException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					} catch (Exception e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}

                	        // Wait for a moment before startin

                	        
                    
                			
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    
                            break;
                }

                // Close the tab when done
                //driver.quit();
            });
        }
    

        // Shutdown the thread pool after all tasks are completed
        executorService.shutdown();
    }
}
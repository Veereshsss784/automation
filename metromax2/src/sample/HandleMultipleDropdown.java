package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleDropdown {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
    ChromeDriver driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://opensouce-demo.orangehrmlive.com/");
    //getWindowHandle()
 /*   
   String windowID = driver.getWindowHandle();
   System.out.println("window id is : "+windowID);
   driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
   */
    
    //getWindowHandles()
    Set<String> windowIDs = driver.getWindowHandles();
    
   // first method -iterator 
 /*   Iterator<String> it = windowIDs.iterator();
    String parentWindowId = it.next();
    String childWindowId = it.next();
    System.out.println(parentWindowId);
    System.out.println(childWindowId);
   */
    
    //second method - using list/arrayList
    List<String> windowIdsList=new ArrayList(windowIDs);
    String parent = windowIdsList.get(0);
    String child = windowIdsList.get(0);
    System.out.println(parent);
    System.out.println(child);
    
    driver.switchTo().window(parent);
    System.out.println(driver.getTitle());
    driver.switchTo().window(child);
    System.out.println(driver.getTitle());
    
    
    
}
}

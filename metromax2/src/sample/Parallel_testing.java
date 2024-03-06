package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parallel_testing {

    public static void main(String[] args) {
        // Step 1: Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");

        // Step 2: Create an array to store WebDriver instances
        WebDriver[] drivers = new WebDriver[3];

        // Step 3: Launch two browser instances
        for (int i = 0; i < drivers.length; i++) {
            drivers[i] = new ChromeDriver();
        }

        // Step 4: Define the URLs to open in each tab
        String[] urls = {"https://dev.fleetdrive360.com/login", "https://compliance.fleetsmartcarrierservices.com/login", "https://app.fleetdrive360.com/login"};

        // Step 5: Perform actions on each tab concurrently using threads
        for (int i = 0; i < drivers.length; i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                WebDriver driver = drivers[index];

                // Step 6: Navigate to the URL in this tab
                driver.get(urls[index]);

                // Step 7: Perform actions in this tab, e.g., interact with elements
                WebElement searchBox = driver.findElement(By.xpath("//a[@id='desktop_view_logo']//img[@class='custom_card_logo']"));
                searchBox.click();

                // Step 8: Simulate a search action
                WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
                searchButton.click();

                // Step 9: Wait for a while to observe the actions (you can replace this with explicit waits)
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Step 10: Close the tab when done
                //driver.quit();
            });
            thread.start();
        }

        // Step 11: Wait for all threads to complete before exiting
        for (WebDriver driver : drivers) {
            try {
                ((Thread) driver).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



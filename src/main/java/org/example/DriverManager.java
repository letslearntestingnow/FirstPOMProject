package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager extends Utils
{
    public void openBrowser()
    {
        // Provide the location of the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe");
        // Instantiate driver object to Chrome Driver
        driver = new ChromeDriver();
        // Maximise the browser window
        driver.manage().window().maximize();
        // Open this URL
        driver.get("https://demo.nopcommerce.com/");
    }

    public void closeBrowser()
    {
        // Close the browser and any connections
        driver.quit();
    }
}

package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{
    // Create a driver manager object
    DriverManager driverManager = new DriverManager();

    // Things to do before every test case
    @BeforeMethod
    public void setup()
    {
        // Call the open browser method
        driverManager.openBrowser();
    }

    // things to do after every test case
    @AfterMethod
    public void tearDown()
    {
        // Call the close browser method
        driverManager.closeBrowser();
    }

}

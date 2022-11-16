package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class RegisterResultPage extends Utils
{
    // Assign locators to private variables
    private String _RegistrationSuccessfulMessage = "result";

    public void verifyUserHasBeenRegisteredSuccessfully()
    {
        // Wait for a maximum of 5 seconds for all elements to be visible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Retrieve the registration successful message
        String strMessage = driver.findElement(By.className(_RegistrationSuccessfulMessage)).getText();
        System.out.println(strMessage);

        // Ensure the retrieved message is the successful one
        Assert.assertEquals(strMessage, "Your registration completed", "Registration Failed");
    }
}


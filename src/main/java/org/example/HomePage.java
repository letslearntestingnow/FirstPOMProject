package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils
{
    // Assign locators to private variables
    private String _RegisterButton_ClassName = "ico-register";

    public void clickOnRegisterButton()
    {
        // Click on Register button
        clickOnElement(By.className(_RegisterButton_ClassName));
    }
}

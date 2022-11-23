package org.example;

import org.openqa.selenium.By;

public class ElectronicsPage extends Utils
{
    private By _CameraButton_LinKText = By.linkText("Camera & photo");

    public void clickOnCameraButton()
    {
        clickOnElement(_CameraButton_LinKText);
    }
}

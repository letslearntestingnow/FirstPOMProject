package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest
{
    // Create objects to be used for corresponding pages
    HomePage objHomePage = new HomePage();
    RegisterPage objRegisterPage = new RegisterPage();
    RegisterResultPage objRegisterResultPage = new RegisterResultPage();

    @Test
    public void toVerifyUserIsAbleToRegister()
    {
        // Click on Register button, present on the Homepage
        objHomePage.clickOnRegisterButton();

        // Confirm the driver navigated to the correct page
        objRegisterPage.verifyUserIsOnRegisterPage();

        // Input the Registration details in the web form
        objRegisterPage.enterRegistrationDetails();

        // Verify if the user has been registered successfully
        objRegisterResultPage.verifyUserHasBeenRegisteredSuccessfully();
    }
}

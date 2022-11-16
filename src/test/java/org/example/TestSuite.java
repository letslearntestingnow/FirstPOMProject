package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest
{
    // Create objects to be used for corresponding pages
    RegisterPage objRegisterPage = new RegisterPage();
    RegisterResultPage objRegisterResultPage = new RegisterResultPage();

    @Test
    public void toVerifyUserIsAbleToRegister()
    {
        // Click on Register button, present on the Homepage
        objRegisterPage.clickOnRegisterButton();

        // Confirm the Registration page URL is correct
        objRegisterPage.verifyUserIsOnRegisterPage();

        // Type/ select the Registration details in the web form
        objRegisterPage.enterRegistrationDetails();

        // Verify the user has been successfully registered
        objRegisterResultPage.verifyUserHasBeenRegisteredSuccessfully();
    }
}

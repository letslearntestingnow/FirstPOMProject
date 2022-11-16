package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends Utils
{
    // Assign locators to private variables
    private String _GenderMale_Id = "gender-male";
    private String _FirstName_Id = "FirstName";
    private String _LastName_Id = "LastName";
    private String _DOBDay_Id = "DateOfBirthDay";
    private String _DOBMonth_Id = "DateOfBirthMonth";
    private String _DOBYear_Id = "DateOfBirthYear";
    private String _EmailId_Id = "Email";
    private String _Company_Id = "Company";
    private String _Password_Id = "Password";
    private String _ConfirmPassword_Id = "ConfirmPassword";
    private String _RegisterButton_Id = "register-button";


    // Test Data
    private String strDataFirstName = "abcd";
    private String strDataLastName = "xyz";
    private String strDataDOBDay = "10";
    private String strDataDOBMonth = "1";
    private String strDataDOBYear = "2000";
    private String strDataEmailSuffix = "@mail.com";
    private String strDataCompanyName = "abc ltd";
    private String strDataPassword = "abc123";
    private String strDataConfirmPassword = "abc123";



    public void verifyUserIsOnRegisterPage()
    {
        // Ensure driver has navigated to the correct page
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/register?returnUrl=%2F",
                "This is not the Registration page.");
    }

    public void enterRegistrationDetails()
    {
        // Click the Male gender button
        clickOnElement(By.id(_GenderMale_Id));

        // Type the first name
        typeText(By.id(_FirstName_Id), strDataFirstName);

        // Type the last name
        typeText(By.id(_LastName_Id), strDataLastName);

        // Select day for DOB
        selectFromDropdownByValue(By.name(_DOBDay_Id), strDataDOBDay);

        // Select Month for DOB
        selectFromDropdownByValue(By.name(_DOBMonth_Id), strDataDOBMonth);

        // select Year for DOB
        selectFromDropdownByValue(By.name(_DOBYear_Id), strDataDOBYear);

        // Type the email
        String strTempEmail = strDataFirstName + getTimeStamp() + strDataEmailSuffix;
        System.out.println(strTempEmail);
        typeText(By.id(_EmailId_Id), strTempEmail);

        // Type the company name
        typeText(By.id(_Company_Id), strDataCompanyName);

        // Type Password
        typeText(By.id(_Password_Id), strDataPassword);

        // Type in confirm password
        typeText(By.id(_ConfirmPassword_Id), strDataConfirmPassword);

        // Click on Register button
        clickOnElement(By.id(_RegisterButton_Id));
    }

}

package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends Utils
{
    // Assign locators to private variables
    private By _GenderMale_Id = By.id("gender-male");
    private By _FirstName_Id = By.id("FirstName");
    private By _LastName_Id = By.id("LastName");
    private By _DOBDay_Name = By.name("DateOfBirthDay");
    private By _DOBMonth_Name = By.name("DateOfBirthMonth");
    private By _DOBYear_Name = By.name("DateOfBirthYear");
    private By _EmailId_Id = By.id("Email");
    private By _Company_Id = By.id("Company");
    private By _Password_Id = By.id("Password");
    private By _ConfirmPassword_Id = By.id("ConfirmPassword");
    private By _RegisterButton_Id = By.id("register-button");
    private By _ContinueButton_X = By.xpath("//a [@class='button-1 register-continue-button']");



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
        clickOnElement(_GenderMale_Id);

        // Type the first name
        typeText(_FirstName_Id, strDataFirstName);

        // Type the last name
        typeText(_LastName_Id, strDataLastName);

        // Select day for DOB
        selectFromDropdownByValue(_DOBDay_Name, strDataDOBDay);

        // Select Month for DOB
        selectFromDropdownByValue(_DOBMonth_Name, strDataDOBMonth);

        // select Year for DOB
        selectFromDropdownByValue(_DOBYear_Name, strDataDOBYear);

        // Type the email
        String strTempEmail = strDataFirstName + getTimeStamp() + strDataEmailSuffix;
        System.out.println(strTempEmail);
        typeText(_EmailId_Id, strTempEmail);

        // Type the company name
        typeText(_Company_Id, strDataCompanyName);

        // Type Password
        typeText(_Password_Id, strDataPassword);

        // Type in confirm password
        typeText(_ConfirmPassword_Id, strDataConfirmPassword);

        // Click on Register button
        clickOnElement(_RegisterButton_Id);
    }

    public void clickOnContinueButtonAfterSuccessfulRegistration()
    {
        clickOnElement(_ContinueButton_X);
    }

}
